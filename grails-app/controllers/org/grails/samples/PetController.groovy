package org.grails.samples

class PetController {

	def petclinicService

	def add() {
		if (request.method == 'GET') {
			[pet: new Pet(owner: Owner.get(params['owner']?.id)), types: PetType.list()]
		}
		else {
			def pet = petclinicService.createPet(params.pet?.name, params.pet?.birthDate,
				(params.pet?.type?.id ?: 0) as Long, (params.pet?.owner?.id ?: 0) as Long)
			if (!pet.hasErrors()) {
				redirect controller: 'owner', action: 'show', id: pet.owner.id
				return
			}

			[pet: pet, types: PetType.list()]
		}
	}

	def edit() {
		if (request.method == 'GET') {
			render view: 'add', model: [pet: Pet.get(params.id), types: PetType.list()]
		}
		else {
			def pet = Pet.get(params.id)
			petclinicService.updatePet(pet, params.pet?.name, params.pet?.birthDate,
				(params.pet?.type?.id ?: 0) as Long, (params.pet?.owner?.id ?: 0) as Long)
			if (pet.hasErrors()) {
				render view: 'add', model: [pet: pet, types: PetType.list()]
			}
			else {
				redirect controller: 'owner', action: 'show', id: pet.owner.id
			}
		}
	}

	def addVisit() {
		if (request.method == 'GET') {
			[visit: new Visit(pet: Pet.get(params.id))]
		}
		else {
			def visit = petclinicService.createVisit((params.visit?.pet?.id ?: 0) as Long, params.visit?.description, params.visit?.date)
			if (!visit.hasErrors()) {
				redirect controller: 'owner', action: 'show', id: visit.pet.owner.id
				return
			}

			[visit: visit]
		}
	}
}
