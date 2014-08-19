package org.grails.samples

import org.grails.samples.pages.DisplayVetsPage

class DisplayVetsSpec extends PetclinicSpecs {
	
	def setup() {
		to DisplayVetsPage
	}
	 
	def 'can display a list of Veterinarians'() {
		expect:
		at DisplayVetsPage
		table
		headers[0].text() == 'Name'
		headers[1].text() == 'Specialties'
		!headers[2]
		vets.size() == 6
	}
}
