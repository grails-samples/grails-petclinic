package org.grails.samples.pages

import geb.Page

class TutorialPage extends PageWithFooter {

	static url = '/petclinic/clinic/tutorial'
	
	static at = {
		title == 'The Grails PetClinic Application'
	}
}
