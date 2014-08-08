package org.grails.samples

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

@TestFor(Speciality)
class SpecialitySpec extends Specification implements DomainDataFactory {

	Speciality speciality = validSpeciality()
	
	def setup() {
		mockForConstraintsTests Speciality
	}
	
	def 'a valid Speciality has no errors'() {
		when:
		speciality.validate()
		
		then:
		!speciality.hasErrors()
	}
	
	@Unroll
	def 'name with value #value validation error is #error'() {
		given:
		mockForConstraintsTests Speciality, [validSpeciality(), speciality]
		speciality.name = value
		speciality.validate()
		
		expect:
		speciality.errors.name == error
		
		where:
		value                   || error
		' '                     || 'blank'
		'dentistry'             || 'unique'
		'do'                    || 'minSize'
		'fr'.padRight(21, '_')  || 'maxSize'
		'su'.padRight(20, '_')  || null
	}
}
