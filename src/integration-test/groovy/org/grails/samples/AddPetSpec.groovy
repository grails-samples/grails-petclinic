package org.grails.samples

import org.grails.samples.pages.AddPetPage
import org.grails.samples.pages.AddOwnerPage
import org.grails.samples.pages.ShowOwnerPage
import spock.lang.Shared

class AddPetSpec extends PetclinicSpecs {

  @Shared
  def ownerId
  
  def setupSpec() {
    addOwner()
  }

  def setup() {
    to AddPetPage, "?owner.id=${ownerId}"
  }

  def 'can NOT add an invalid Pet'() {
    when:
    addPet.click()
    
    then:
    at AddPetPage
    errors.size() == 3
  }
  
  def 'can add a valid Pet'() {
    given:
    name.value 'Fido'
    id.value ownerId
    
    when:
    addPet.click()
    
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
}
