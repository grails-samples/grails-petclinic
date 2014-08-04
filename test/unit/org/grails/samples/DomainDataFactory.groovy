package org.grails.samples

trait DomainDataFactory {

	Owner validOwner() {
		new Owner(
			firstName: 'Graeme', lastName: 'Rocher',
			address: '14 GR8 Rd.', city: 'Minneapolis', telephone: '9876543210'
		)
	}
	
	Person validPerson() {
		new Person(firstName: 'Graeme', lastName: 'Rocher')
	}
	
	Pet validPet() {
		new Pet(name: 'pete', birthDate: new Date(), type: new PetType(name: 'cat'), owner: validOwner())
	}
	
	PetType validPetType() {
		new PetType(name: 'cat')
	}
	
	Speciality validSpeciality() {
		new Speciality(name: 'dentistry')
	}
	
	Vet validVet() {
		new Vet(firstName: 'Lisa', lastName: 'GoodOne')
	}
	
	Visit validVisit() {
		new Visit(description: 'rabies shot', pet: validPet())
	}
}
