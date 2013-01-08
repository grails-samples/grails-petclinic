grails.servlet.version = "2.5"
grails.project.work.dir = "target/$grailsVersion"
grails.project.target.level = 1.6
grails.project.source.level = 1.6

grails.project.dependency.resolution = {

	inherits "global"
	log "error"
	checksums true

	repositories {
		inherits true

		grailsPlugins()
		grailsHome()
		grailsCentral()
	}

	dependencies {}

	plugins {
		runtime ":hibernate:$grailsVersion"
		runtime ":jquery:1.8.0", ":jquery-ui:1.8.24"
		runtime ":resources:1.1.6"
		build ":tomcat:$grailsVersion"
	}
}
