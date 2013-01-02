package org.grails.samples

class ViewSourceFilters {

	def grailsApplication

	def filters = {
		// This set of filters applies to requests that are handled by any
		// controller action.
		all(controller:'*', action:'*') {
			// This handler is called before the controller action is executed.
			// If it returns false, the request is effective blocked as the
			// controller action is *not* invoked.
			before = {
			}

			// This handler is called after the controller action has executed
			// but before the associated view has been rendered. You can use
			// it to add extra attributes to the view's model for example.
			after = { Map model ->
				// The 'model' argument is null in the case of redirects and direct
				// rendering of content to the response, e.g. with render("some string").
				if (model == null) {
					// Skip the insertion of model data.
					return
				}

				// This is a call to the Grails API to get the associated
				// metadata for the current controller ('controllerName' is
				// a dynamic property).
				def controllerClass = grailsApplication.getArtefactByLogicalPropertyName("Controller", controllerName)

				// The 'View Source for' sidebar requires the class name of
				// the current controller and the path to the GPS view that's
				// being used for the current page.
				model["controllerClass"] = controllerClass.clazz.name
				model["viewPath"] = "$controllerName:${model['viewName'] ?: actionName}"
				// Return the model for use by the view.
				return model
			}

			// This handler is called after the view has been rendered or content
			// has been written direct to the stream. It is also called when an
			// exception is thrown by the action or view. This allows you to add
			// extra processing in the case of errors.
			afterView = { Exception e ->
//TODO: >>>>>>> Handle null model in 'after' filter.
			}
		}
	}
}
