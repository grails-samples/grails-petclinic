package org.grails.samples

class ViewSourceController {

	def grailsApplication

	def controller(String id) {
		renderFile id, "controllers", "groovy"
	}

	def view(String id) {
		// Get the GSP file for the given path.
		renderFile id, "views", "gsp"
	}

	def domain(String id) {
		renderFile id, "domain", "groovy"
	}

	def service(String id) {
		renderFile id, "service", "groovy"
	}

	def filter(String id) {
		renderFile id, "conf", "groovy"
	}

	def mappings() {
		renderFile "UrlMappings", "conf", "groovy"
	}

	def dataSource() {
		renderFile "DataSource", "conf", "groovy"
	}

	def config() {
		renderFile "Config", "conf", "groovy"
	}

	def save(String sourceCode, String filePath, String controllerName, String actionName, String id) {
		new File(filePath).text = sourceCode
		redirect controller: controllerName, action: actionName, id: id
	}

	private renderFile(String id, String folder, String ext) {
		boolean isView = ext == "gsp"
		char separatorChar = isView ? ':' : '.'

		def idAsPath = id.replace(separatorChar, '/' as char)
		def path = "grails-app/${folder}/${idAsPath}.${ext}"
		def content = getFileContent(path, isView ? 2 : 4)

		render view: "show", model: [
				sourceCode: content,
				lang: isView ? "text/html" : "groovy",
				viewName: "show",
				path: path,
				controller: controllerName,
				action: actionName,
				id: id]
	}

	private getFileContent(String path, int spacesForIndent) {
		def content = new File(path).getText("UTF-8")
		return content.replace('\t', ' ' * spacesForIndent)
	}
}
