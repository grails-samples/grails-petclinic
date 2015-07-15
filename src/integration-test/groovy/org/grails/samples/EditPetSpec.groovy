package org.grails.samples

import org.grails.samples.pages.AddOwnerPage
import org.grails.samples.pages.AddPetPage
import org.grails.samples.pages.EditPetPage
import org.grails.samples.pages.ShowOwnerPage
import spock.lang.Shared

class EditPetSpec extends PetclinicSpecs {
  
  @Shared
  def ownerId

  def setupSpec() {
    addOwner()
    addPetToOwner(ownerId)
  }

  def setup() {
    to EditPetPage, 1
  }

  def 'can NOT edit an invalid Pet'() {
    when:
    name.value ''
    editPet.click()
    
    then:
    at EditPetPage
    errors.size() == 3
  }
  
  def 'can edit a valid Pet'() {
    given:
    name.value 'Fido'
    id.value ownerId
    
    when:
    editPet.click()
    
    then:
    at ShowOwnerPage
  }

  protected void addOwner() {
    to AddOwnerPage
    firstName.value 'Sally'
    lastName.value 'Jones'
    address.value '987 State St.'
    city.value 'MSN'
    telephone.value '1234567890'
    addOwner.click()
    ownerId = $("form").find("input", name: "owner.id").value()
  }

  protected void addPetToOwner(ownerId) {
    to AddPetPage, "?owner.id=${ownerId}"
    name.value 'Fido'
    id.value ownerId
    addPet.click()
  }
}
