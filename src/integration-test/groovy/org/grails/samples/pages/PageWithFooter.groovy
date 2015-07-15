package org.grails.samples.pages

import geb.Page

class PageWithFooter extends Page {
	
	static content = {
		home { $('a', text: 'Home') }
	}
}
