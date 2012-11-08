package org.grails.samples

class OwnerController {

	def petclinicService

	def add() {
		if (request.method == 'GET') {
			[ownerBean: new Owner()]
		}
		else {
			def owner = petclinicService.createOwner(params.owner?.firstName, params.owner?.lastName,
				params.owner?.address, params.owner?.city, params.owner?.telephone)
			if (!owner.hasErrors()) {
				redirect action: 'show', id: owner.id
				return
			}

			[ownerBean: owner]
		}
	}

	def show() {
		def owner = Owner.get(params.id)
		if (owner) {
			[ownerBean: owner]
		}
		else {
			response.sendError 404
		}
	}

	def edit() {
		def owner = Owner.get(params.id)
		if (request.method == 'GET') {
			render view: 'add', model: [ownerBean: owner]
		}
		else {
			petclinicService.updateOwner(Owner.get(params.id), params.owner?.firstName, params.owner?.lastName,
				params.owner?.address, params.owner?.city, params.owner?.telephone)
			if (!owner.hasErrors()) {
				redirect action: 'show', id: owner.id
				return
			}

			render view: 'add', model: [ownerBean: owner]
		}
	}

	def find() {
		if (request.method == 'POST') {
			def owners = Owner.findAllByLastName(params.lastName)
			if (owners) {
				if (owners.size() > 1) {
					render view: 'selection', model: [owners: owners]
				}
				else {
					redirect action: 'show', id: owners[0].id
				}
			}
			else {
				[message: 'owners.not.found']
			}
		}
	}
}
