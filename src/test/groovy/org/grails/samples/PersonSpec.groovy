package org.grails.samples

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

@TestFor(Person)
class PersonSpec extends Specification implements DomainDataFactory {

	Person person = validPerson()
	

	def 'a valid Person has no errors'() {
		when:
		person.validate()
		
		then:
		!person.hasErrors()
	}
	
	@Unroll
	def 'firstName with value #value validation error is #error'() {
		given:
		person.firstName = value
		person.validate()
		
		expect:
		person.errors['firstName']?.code == error
		
		where:
		value  || error
		null   || 'nullable'
		' '    || 'blank'
		'jeff' || null
	}
	
	@Unroll
	def 'lastName with value #value validation error is #error'() {
		given:
		person.lastName = value
		person.validate()
		
		expect:
		person.errors['lastName']?.code == error
		
		where:
		value   || error
		''      || 'blank'
		'brown' || null
	}
}
