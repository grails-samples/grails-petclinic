package org.grails.samples

import org.junit.Before

import grails.test.mixin.Mock
import grails.test.mixin.TestFor

@TestFor(OwnerController)
@Mock(Owner)
class OwnerControllerTests {

	@Before
	void setUp() {
		controller.petclinicService = new PetclinicService()
	}

	void testAddGET() {
		controller.request.method = 'GET'
		def model = controller.add()

		assert model.ownerBean instanceof Owner
	}

	void testAddInvalidOwner() {
		controller.request.method = 'POST'

		def model = controller.add()

		assert model.ownerBean?.hasErrors()

		assert null == view
	}

	void testValidOwner() {
		controller.params.owner = [
			firstName: 'fred',
			lastName:  'flintstone',
			address:   'rocky street',
			city:      'dinoville',
			telephone: '347239873']

		controller.add()

		assert controller.response.redirectUrl =~ '/owner/show/\\d+'
	}

	void testFindNoResults() {
		controller.request.method = 'POST'

		def model = controller.find()
		assert 'owners.not.found' == model?.message
	}

	void testFindOneResult() {
		def owner = createOwner(lastName: 'flintstone')
		assert owner.save()

		controller.request.method = 'POST'
		controller.params.lastName = 'flintstone'
		controller.find()

		assert '/owner/show/' + owner.id == controller.response.redirectUrl
	}

	void testFindManyResults() {
		createOwner(lastName: 'flintstone').save()
		createOwner(lastName: 'flintstone').save()

		controller.request.method = 'POST'
		controller.params.lastName = 'flintstone'
		controller.find()

		assert '/owner/selection' == view
		assert 2 == model?.owners?.size()
	}

	private Owner createOwner(Map data) {
		def owner = new Owner(address: 'the address', city: 'the city', telephone: '1234567890',
		                      firstName: 'first', lastName: 'last')
		owner.properties = data
		owner
	}
}
