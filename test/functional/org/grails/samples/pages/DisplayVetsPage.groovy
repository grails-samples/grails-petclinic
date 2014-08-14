package org.grails.samples.pages

import geb.Page

class DisplayVetsPage extends PageWithFooter {

	static url = '/petclinic/clinic/vets'
	
	static at = {
		title == 'Veterinarians'
	}
	
	static content = {
		table { $('table', 0)}
		headers() { table.find('thead').find('tr').find('th') }
		vets { table.find('tbody').find('tr') }
	}
	
}
