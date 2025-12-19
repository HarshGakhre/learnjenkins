package harsh

import grails.testing.web.UrlMappingsUnitTest
import spock.lang.Specification

class UrlMappingsSpec extends Specification implements UrlMappingsUnitTest<UrlMappings> {

    void setup() {
        mockController(EmployeeController)
    }
    void "test forward mapping in http methods"(){
        when:"the http method is GET,/employee should map to EmployeeController.doGet()"
        request.method = "GET"
        assertForwardUrlMapping('/employee',controller:'employee',action:'doList')

        then:
        noExceptionThrown()
    }

    void "test forward mapping in http methods"(){
        when:"the http method is POST,/employee should map to EmployeeController.doPost()"
        request.method = "POST"
        assertForwardUrlMapping('/employee',controller: 'employee',action: 'doPost')

        then:
        noExceptionThrown()
    }

    void "test forward mapping in http methods"(){
        when:"the http method is POST,/employee should map to EmployeeController.doPost()"
        request.method = "GET"
        assertForwardUrlMapping('/employee/1',controller: 'employee',action: 'doGet'){
            id = "1"
        }

        then:
        noExceptionThrown()
    }

    void "test forward mapping in http methods"(){
        when:"the http method is DELETE,/employee/1,controller:'employee',action:'doDelete()"
        request.method = "DELETE"
        assertForwardUrlMapping('/employee/1',controller:'employee',action: 'doDelete'){
            id = "1"
        }
        then:
        noExceptionThrown()
    }

    void"test forward mapping in http methods"(){
        when:"the http method is PUT,/employee/1,controller:'employee',action:'doPut()'"
        request.method = "PUT"
        assertForwardUrlMapping('/employee/1',controller: 'employee',action: 'doPut'){
            id = "1"
        }
        then:
        noExceptionThrown()
    }

    void "test forward mapping in http methods"(){
        when:"the http method is PATCH,/employee/1,controller:'employee',action:'doPatch()'"
        request.method = "PATCH"
        assertForwardUrlMapping('/employee/1',controller: 'employee',action: 'doPatch'){
            id = "1"
        }
        then:
        noExceptionThrown()
    }

    void "test URL mapping"() {
        when:
        assertForwardUrlMapping('/', view:'/index')

        then:
        noExceptionThrown()
    }

    void "test for 500"(){
        when:
        assertForwardUrlMapping(500,view: '/error')

        then:
        noExceptionThrown()
    }

    void "test for 404"(){
        when:
        assertForwardUrlMapping(404,view: 'notFound')

        then:
        noExceptionThrown()
    }

    void "test for employee list"() {
        when:
        assertForwardUrlMapping('/employee/list', controller: 'employee', action: 'list')

        then:
        noExceptionThrown()
    }

    void "test for employee create"() {
        when:
        assertForwardUrlMapping('/employee/create', controller: 'employee', action: 'create')

        then:
        noExceptionThrown()
    }

    void "test for employee delete"(){
        when:
        assertForwardUrlMapping('/employee/delete/1',controller: 'employee',action: 'delete'){
            id = "1"
        }

        then:
        noExceptionThrown()
    }

    void "test for employee edit"(){
        when:
        assertForwardUrlMapping("/employee/edit/1", controller: "employee" ,action: "edit"){
            id = "1"
        }

        then:
        noExceptionThrown()
    }

    void "test for employee save"(){
        when:
        assertForwardUrlMapping("/employee/save", controller: "employee" ,action: "save")

        then:
        noExceptionThrown()
    }

    void "test for employee update"(){
        when:
        assertForwardUrlMapping("/employee/update", controller: "employee" ,action: "update")

        then:
        noExceptionThrown()
    }
}