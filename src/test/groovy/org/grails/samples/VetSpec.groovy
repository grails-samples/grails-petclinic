package org.grails.samples

import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(Vet)
class VetSpec extends Specification implements DomainDataFactory {
	
	Vet vet = validVet()
	
	
	def 'a valid Vet has no errors'() {
		when:
		vet.validate()
		
		then:
		!vet.hasErrors()
		!vet.specialities
	}
}
