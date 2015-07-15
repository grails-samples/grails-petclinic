package org.grails.samples

import org.grails.samples.pages.AddOwnerPage
import org.grails.samples.pages.ShowOwnerPage

class AddOwnerSpec extends PetclinicSpecs {
	
	def setup() {
		to AddOwnerPage
	}
	
	def 'can NOT add an invalid Owner'() {
		when:
		addOwner.click()
		
		then:
		at AddOwnerPage
		errors.size() == 5
	}
	
	def 'can add a valid Owner'() {
		given:
		firstName.value 'Sally'
		lastName.value 'Jones'
		address.value '987 State St.'
		city.value 'MSN'
		telephone.value '1234567890'
		
		when:
		addOwner.click()
		
		then:
		at ShowOwnerPage
	}
}
