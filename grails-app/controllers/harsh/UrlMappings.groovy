package harsh

class UrlMappings {

    static mappings = {
        "/login"(controller:"login",action:"login",method:"POST")
        "/employee"(controller:"employee"){
            action = [POST:"doPost", GET: "doList"]
        }
        "/employee/$id"(controller:"employee"){
            action = [GET: "doGet", DELETE: "doDelete", PUT: "doPut", PATCH: "doPatch"]
        }
        "/employee/list"(controller:"employee", action:"list")
        "/employee/create"(controller:"employee", action:"create")
        "/employee/edit/$id"(controller:"employee", action:"edit")
        "/employee/save"(controller:"employee", action:"save")
        "/employee/update"(controller:"employee", action:"update")
        "/employee/delete/$id"(controller:"employee", action:"delete")

        "/manager"(controller:"manager"){
            action = [POST:"doPost", GET: "doList"]
        }
        "/manager/$id"(controller:"manager"){
            action = [GET: "doGet", DELETE: "doDelete", PUT: "doPut", PATCH: "doPatch"]
        }

        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(view:"/index")
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
