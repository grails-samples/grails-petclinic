grails.project.groupId = appName
grails.mime.file.extensions = true
grails.mime.use.accept.header = false
grails.mime.types = [
	all:           '*/*',
	atom:          'application/atom+xml',
	css:           'text/css',
	csv:           'text/csv',
	form:          'application/x-www-form-urlencoded',
	html:          ['text/html','application/xhtml+xml'],
	js:            'text/javascript',
	json:          ['application/json', 'text/json'],
	multipartForm: 'multipart/form-data',
	rss:           'application/rss+xml',
	text:          'text/plain',
	xml:           ['text/xml', 'application/xml']
]

grails.resources.adhoc.patterns = ['/images/*', '/css/*', '/js/*', '/plugins/*']
grails.views.default.codec = "html"
grails.views.gsp.encoding = "UTF-8"
grails.converters.encoding = "UTF-8"
grails.views.gsp.sitemesh.preprocess = true
grails.scaffolding.templates.domainSuffix = 'Instance'
grails.json.legacy.builder = false
grails.enable.native2ascii = true
grails.spring.bean.packages = []
grails.web.disable.multipart=false
grails.exceptionresolver.params.exclude = ['password']
grails.hibernate.cache.queries = false

environments {
	development {
		grails.logging.jul.usebridge = true
	}
	production {
		grails.logging.jul.usebridge = false
	}
}

log4j = {
	error 'org.codehaus.groovy.grails',
	      'org.springframework',
	      'org.hibernate',
	      'net.sf.ehcache.hibernate'
}

// Uncomment and edit the following lines to start using Grails encoding & escaping improvements

/* remove this line 
// GSP settings
grails {
    views {
        gsp {
            encoding = 'UTF-8'
            htmlcodec = 'xml' // use xml escaping instead of HTML4 escaping
            codecs {
                expression = 'html' // escapes values inside null
                scriptlet = 'none' // escapes output from scriptlets in GSPs
                taglib = 'none' // escapes output from taglibs
                staticparts = 'none' // escapes output from static template parts
            }
        }
        // escapes all not-encoded output at final stage of outputting
        filteringCodecForContentType {
            //'text/html' = 'html'
        }
    }
}
remove this line */
