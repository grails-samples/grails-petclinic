package org.grails.samples

class OwnerController {

	def petclinicService

	def add() {
		if (request.method == 'GET') {
			return [ownerBean: new Owner()]
		}

		def owner = petclinicService.createOwner(params.owner?.firstName, params.owner?.lastName,
			params.owner?.address, params.owner?.city, params.owner?.telephone)

		if (owner.hasErrors()) {
			return [ownerBean: owner]
		}

		redirect action: 'show', id: owner.id
	}

	def show() {
		def owner = Owner.get(params.id)
		if (!owner) {
			response.sendError 404
			return
		}

		[ownerBean: owner]
	}

	def edit() {
		def owner = Owner.get(params.id)
		if (request.method == 'GET') {
			render view: 'add', model: [ownerBean: owner]
			return
		}

		petclinicService.updateOwner(Owner.get(params.id), params.owner?.firstName, params.owner?.lastName,
			params.owner?.address, params.owner?.city, params.owner?.telephone)

		if (owner.hasErrors()) {
			render view: 'add', model: [ownerBean: owner]
			return
		}

		redirect action: 'show', id: owner.id
	}

	def find() {
		if (!request.post) {
			return
		}

		def owners = Owner.findAllByLastName(params.lastName)
		if (!owners) {
			return [message: 'owners.not.found']
		}

		if (owners.size() > 1) {
			render view: 'selection', model: [owners: owners]
		}
		else {
			redirect action: 'show', id: owners[0].id
		}
	}
}
