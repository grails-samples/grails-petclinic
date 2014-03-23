package org.grails.samples

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import org.junit.Before
import spock.lang.Ignore
import spock.lang.Specification

@TestFor(OwnerController)
@Mock(Owner)
class OwnerControllerSpec extends Specification{

	void setup() {
		controller.petclinicService = new PetclinicService()
	}

	void 'can add with the get method'() {
        when:
        controller.request.method = 'GET'
        def model = controller.add()

		then:
        model.ownerBean instanceof Owner
	}

	void 'fails on invalid owner'() {
		when:
        controller.request.method = 'POST'
        def model = controller.add()

        then:
        model.ownerBean?.hasErrors()
        !view
	}

	void 'can add a valid owner'() {
        given:
		controller.params.owner = [
			firstName: 'fred',
			lastName:  'flintstone',
			address:   'rocky street',
			city:      'dinoville',
			telephone: '347239873']

        when:
		controller.add()

        then:
		controller.response.redirectUrl =~ '/owner/show/\\d+'
	}

	void 'finds no owners when there are none'() {
		when:
        controller.request.method = 'POST'
		def model = controller.find()

        then:
        model?.message == 'owners.not.found'
	}

	void 'can find a specific owner'() {
		given:
        Owner owner = createOwner(lastName: 'flintstone')

        when:
        boolean validated = owner.validate()
        Owner saved = owner.save()

        then:
        validated
        saved

        when:
        controller.request.method = 'POST'
		controller.params.lastName = 'flintstone'
		controller.find()

        then:
        controller.response.redirectUrl == '/owner/show/' + owner.id
	}

	void 'can find several owners'() {
		given:
        createOwner(lastName: 'flintstone').save()
		createOwner(lastName: 'flintstone').save()

		when:
        controller.request.method = 'POST'
		controller.params.lastName = 'flintstone'
		controller.find()

		then:
        view == '/owner/selection'
        model?.owners?.size() == 2
	}

	private Owner createOwner(Map data) {
		def owner = new Owner(address: 'the address', city: 'the city', telephone: '1234567890',
		                      firstName: 'first', lastName: 'last')
		owner.properties = data
		owner
	}
}
