package org.grails.samples

/**
 * Models a {@link Vet Vet's} specialty (for example, dentistry).
 *
 * @author Graeme Rocher
 */
class Speciality {
	
	String name
	
	static constraints = {
		name blank: false, minSize: 3, maxSize: 20, unique: true
	}
}
