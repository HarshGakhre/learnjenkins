package harsh

import grails.testing.gorm.DomainUnitTest
import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification

class EmployeeUnitTestSpec extends Specification implements ControllerUnitTest<EmployeeController>, DomainUnitTest<Employee> {

    def setup(){
        controller.employeeService = new EmployeeService()
    }

    def cleanup(){
    }

    void "test for list method"(){
        given:
       new Employee(name: "demo",email: "demo@email.com",department: "software",role: "dev").save(flush:true)
        new Employee(name: "demo",email: "demo@email.com",department: "software",role: "dev").save(flush:true)
        request.method = "GET"

        when:
        controller.doList()

        then:
        response.json.size() == 2

    }

    void "test for get method"(){
        given:
         def employee = new Employee(name: "demo",email: "demo@email.com",department: "software",role: "dev").save(flush:true)
        params.id = employee.id
        request.method = "GET"

        when:
        controller.doGet()

        then:
        response.json.name == "demo"

    }

    void "testing for Post method"(){
        given:
        request.method = "POST"
        request.json = [
                "name":"abc",
                "email":"abc@email.com",
                "department":"marketing",
                "role":"marketing specialist"
        ]
        when:
        controller.doPost()

        then:
        response.json.name == "abc"

        Employee employeedb = Employee.get(response.json.id)
        assert employeedb.name == "abc"
    }

    void "testing for Put method"(){
        given:
        def employee = new Employee(name: "abc",email: "abc@email.com",department: "hr",role: "sr hr").save(flush: true)
        params.id = employee.id
        request.method = "PUT"
        request.json = [name: "demo"]
        when:
        controller.doPut()

        then:
        response.json.name == "demo"
    }

    void "testing for Patch method"(){
        given:
        def employee = new Employee(name: "abc",email: "abc@email.com",department: "hr",role: "sr hr").save(flush: true)
        params.id = employee.id
        request.method = "PATCH"
        request.json = [name: "demo"]
        when:
        controller.doPatch()

        then:
        response.json.name == "demo"
    }

    void "testing for Delete method"(){
        given:
        def employee = new Employee(name: "abc",email: "abc@email.com",department: "hr",role: "sr hr").save(flush: true)
        params.id = employee.id
        request.method = "DELETE"

        when:
        controller.doDelete()

        then:
        response.status == 200
    }
}
