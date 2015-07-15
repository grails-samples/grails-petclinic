package org.grails.samples.pages

import geb.Page

class FindOwnersPage extends PageWithFooter {

	static url = '/owner/find'
	
	static at = {
		title == 'Find Owners'
	}
	
	static content = {
		addOwner { $('a', text: 'Add Owner') }
		lastName { $('#lastName') }
		findOwners { $('input', type: 'submit') }
		error(required: false) { $('.errors').text() }
	}
}
