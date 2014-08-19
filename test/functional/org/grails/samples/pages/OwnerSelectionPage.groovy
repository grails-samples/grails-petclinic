package org.grails.samples.pages

import geb.Page

class OwnerSelectionPage extends Page {

	static url = '/petclinic/owner/find'
	
	static at = {
		title == 'Select Owner'
	}
}
