class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }
		
		"/$controller/xml/$action?" {
			format="xml"
		}
		
		"/$controller/json/$action?" {
			format="json"
		}

        "/"(view:"/index")
        "500"(view:'/error')
	}
}
