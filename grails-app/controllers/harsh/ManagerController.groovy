package harsh

import grails.converters.JSON

class ManagerController {
    ManagerService managerService
    def doPost(){
        def jsondata = request.JSON
        def manager = new Manager(name: jsondata.name,email:jsondata.email,department: jsondata.department,designation: jsondata.designation)
        def dbmanager = managerService.doPost(manager)
        if(dbmanager){
            render(dbmanager as JSON)
        }else{
            render(status:500,text:"internal server error")
        }
    }

    def doList(){
        List<Manager> managerList = managerService.doList();
        render (managerList as JSON)
    }

    def doGet(){
        def getid = params.id as long

        def getmng=  managerService.doGet(getid)

        if(getmng){
            render (getmng as JSON)
        }else{
            render(status: 500,text: "internal server error")
        }
    }

    def doDelete(){
        def delid = params.id as long
        if(managerService.doDelete(delid)){
            render(status:200,text: "manager is deleted")
        }else{
            render(status:500,text:"internal server error")
        }
    }

    def doPut(){
        def upjsondata = request.JSON
        def upid = params.id as long
        def updatedmng = managerService.doPut(upjsondata,upid)
        if(updatedmng){
            render(updatedmng as JSON)
        }else{
            render(status: 500)
        }
    }

    def doPatch(){
        def upjsondata = request.JSON
        def upid = params.id as long
        def updatedmng = myempService.doPut(upjsondata,upid)
        if(updatedmng){
            render(updatedmng as JSON)
        }else{
            render(status: 500)
        }
    }

}
