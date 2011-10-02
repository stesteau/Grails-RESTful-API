class UrlMappings {

    static mappings = {
	"/$controller/$action?/$id?"{
            constraints {
                // apply constraints here
            }
        }

        "/team"(controller:"team") {
            action = [POST:"save"]
        }

	"/"(view:"/index")
	"500"(view:'/error')
    }
}
