package org.grails.samples

class ViewSourceController {
	def grailsApplication

    def controller(String id) {
		def idAsPath = id.replace('.' as char, '/' as char)
		def content = getFileContent("grails-app/controllers/${idAsPath}.groovy")
		render view: "show", model: [sourceCode: content, lang: "groovy", viewName: "show"]
	}

	/**
	 *
	 */
    def view(String id) {
		// Get the GSP file for the given path.
		def idAsPath = id.replace(':' as char, '/' as char)
		def content = getFileContent("grails-app/views/${idAsPath}.gsp")
		render view: "show", model: [sourceCode: content, lang: "html", viewName: "show"]
	}

	def getFileContent(String path) {
		return new File(path).getText("UTF-8")
	}
}
