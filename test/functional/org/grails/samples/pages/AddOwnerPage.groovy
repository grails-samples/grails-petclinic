package org.grails.samples.pages

class AddOwnerPage extends PageWithFooter {

	static url = '/petclinic/owner/add'

	static at = {
		title == 'Add Owner'
	}
	
	static content = {
		firstName { $('#owner_firstName') }
		lastName { $('#owner_lastName') }
		address { $('#owner_address') }
		city { $('#owner_city') }
		telephone { $('#owner_telephone') }
		addOwner { $('input', type: 'submit') }
		errors(required: false) { $('.errors') }
	}
}
