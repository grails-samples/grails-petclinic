package org.grails.samples

class ViewSourceFilters {

	def grailsApplication

	def filters = {
		all(controller:'*', action:'*') {
			after = { Map model ->
				def controllerClass = grailsApplication.getArtefactByLogicalPropertyName("Controller", controllerName)
				model.controllerClass = controllerClass.clazz.name
				model.viewPath = "$controllerName:${model.viewName ?: actionName}"
			}
		}
	}
}
