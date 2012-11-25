package org.grails.samples

class ViewSourceController {

	def grailsApplication

	def controller(String id) {
		String idAsPath = id.replace('.' as char, '/' as char)
		String content = getFileContent("grails-app/controllers/${idAsPath}.groovy")
		render view: "show", model: [sourceCode: content, lang: "groovy", viewName: "show"]
	}

	def view(String id) {
		// Get the GSP file for the given path.
		String idAsPath = id.replace(':' as char, '/' as char)
		String content = getFileContent("grails-app/views/${idAsPath}.gsp")
		render view: "show", model: [sourceCode: content, lang: "html", viewName: "show"]
	}

	protected String getFileContent(String path) {
		new File(path).getText("UTF-8")
	}
}
