package org.grails.samples

class PetclinicService {

	// PetController

	Pet createPet(String name, Date birthDate, long petTypeId, long ownerId) {
		def pet = new Pet(name: name, birthDate: birthDate, type: PetType.load(petTypeId), owner: Owner.load(ownerId))
		pet.save()
		pet
	}

	void updatePet(Pet pet, String name, Date birthDate, long petTypeId, long ownerId) {
		pet.name = name
		pet.birthDate = birthDate
		pet.type = PetType.load(petTypeId)
		pet.owner = Owner.load(ownerId)
		pet.save()
	}

	Visit createVisit(long petId, String description, Date date) {
		def visit = new Visit(pet: Pet.load(petId), description: description, date: date)
		visit.save()
		visit
	}

	// OwnerController

	Owner createOwner(String firstName, String lastName, String address, String city, String telephone) {
		def owner = new Owner(firstName: firstName, lastName: lastName, address: address, city: city, telephone: telephone)
		owner.save()
		owner
	}

	void updateOwner(Owner owner, String firstName, String lastName, String address, String city, String telephone) {
		owner.firstName = firstName
		owner.lastName = lastName
		owner.address = address
		owner.city = city
		owner.telephone = telephone
		owner.save()
	}
}
