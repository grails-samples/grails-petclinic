package org.grails.samples

import org.grails.samples.pages.AddOwnerPage
import org.grails.samples.pages.FindOwnersPage
import org.grails.samples.pages.OwnerSelectionPage
import org.grails.samples.pages.ShowOwnerPage

class FindOwnersSpec extends PetclinicSpecs {

	def setup() {
		to FindOwnersPage
	}
	
	def 'can add a new Owner'() {
		expect:
		addOwner.click()
		at AddOwnerPage
	}
	
	def 'can NOT find the specified Owners'() {
		given:
		lastName.value ''
		
		when:
		findOwners.click()
		
		then:
		at FindOwnersPage
		error
	}
	 
	def 'can find one specified Owner'() {
		given:
		lastName.value 'Bubinga'
		
		when:
		findOwners.click()
		
		then:
		at ShowOwnerPage 
	}
	 
	def 'can find multiple specified Owners'() {
		given:
		lastName.value 'Smith'
		
		when:
		findOwners.click()
		
		then:
		at OwnerSelectionPage
	}
 
}
