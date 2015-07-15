package org.grails.samples

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll;

@TestFor(Visit)
class VisitSpec extends Specification implements DomainDataFactory {
	
	Visit visit = validVisit()
		
	def 'a valid Visit has no errors'() {
		when:
		visit.validate()
		
		then:
		!visit.hasErrors()
	}
	
	@Unroll
	def 'description with value #value validation error is #error'() {
		given:
		visit.description = value
		visit.validate()
		
		expect:
		visit.errors['description']?.code == error
		
		where:
		value    || error
		' '      || 'blank'
		'baylee' || null
	}
}
