package org.grails.samples.pages

class WelcomePage extends PageWithFooter {
	
	static url = '/petclinic'
	
	static at = {
		title == 'Welcome'
	}
	
	static content = {
		findOwner { $('a', text: 'Find owner') }
		displayAllVets { $('a', text: 'Display all veterinarians') }
		tutorial { $('a', text: 'Tutorial') }
	}
}
