package org.grails.samples

class ViewSourceController {

    def grailsApplication

    def controllerAndView(String controllerClass, String viewPath) {
        renderFiles ([
            [id:controllerClass, path:"controllers", ext:"groovy"],
            [id:viewPath, path:"views", ext:"gsp"]
        ])
    }

    def domain(String id) {
        renderFile id, "domain", "groovy"
    }

    def service(String id) {
        renderFile id, "service", "groovy"
    }

    def filter(String id) {
        renderFile id, "conf", "groovy"
    }

    def mappings() {
        renderFile "UrlMappings", "conf", "groovy"
    }

    def dataSource() {
        renderFile "DataSource", "conf", "groovy"
    }

    def config() {
        renderFile "Config", "conf", "groovy"
    }

    def save(String sourceCode, String filePath, String controllerName, String actionName, String id) {
        new File(filePath).text = sourceCode
        redirect controller: controllerName, action: actionName, id: id
    }
        
    def renderFiles(args) {
        def model = []
        args.each { fileArgs ->
            model << createModel(fileArgs.id,fileArgs.path,fileArgs.ext)
        }
        render view:'show', model: [files:model]
    }
    /**
     *  method to fetch the source and render it with codemirror
     *  in a text editor
     *  
     **/
    private createModel(String id, String folder, String ext) {
        boolean isView = ext == "gsp"
        char separatorChar = isView ? ':' : '.'

        def idAsPath = id.replace(separatorChar, '/' as char)
        def path = "grails-app/${folder}/${idAsPath}.${ext}"
        def content = getFileContent(path, isView ? 2 : 4)
        
          [
                sourceCode: content,
                lang: isView ? "text/html" : "groovy",
                elementId: isView ? "viewEdit" : "controllerEdit",
                viewName: "show",
                path: path,
                controller: params.controllerName,
                action: params.viewName,
                id: id
            ]
        
    }

    private getFileContent(String path, int spacesForIndent) {
        def content = new File(path).getText("UTF-8")
        return content.replace('\t', ' ' * spacesForIndent)
    }
}
