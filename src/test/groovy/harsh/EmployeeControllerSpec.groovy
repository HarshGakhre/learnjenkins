package harsh

import grails.testing.gorm.DomainUnitTest
import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification

class EmployeeControllerSpec extends Specification implements ControllerUnitTest<EmployeeController>, DomainUnitTest<Employee> {

    EmployeeService mockEmployeeService
   def setup(){
       mockDomain(Employee)
       mockEmployeeService = Mock(EmployeeService)
       controller.employeeService = mockEmployeeService
   }

    def cleanup(){
    }

    // Test case for POST Method

    void "test for post method in success"(){
        given:
        request.method = "POST"
        request.json = [
                "name":"abc",
                "email":"abc@email.com",
                "department":"marketing",
                "role":"marketing specialist"
        ]
        def dbdummyemployee = new Employee(name: "amit",email: "amit@email.com",department: "software",role: "developer")
        mockEmployeeService.doPost(_) >> dbdummyemployee

        when:
        controller.doPost()

        then:
        response.json.name == "amit"

    }

    void "testing for Post in failure"(){
        given:
        request.method = "POST"
        request.json = [
                "name":"def",
                "email":"def@email.com",
                "department":"marketing",
                "role":"marketing specialist"
        ]
        def dbdummyemployee = new Employee(name: "ghi",email :"ghi@email.com",department: "software",role: "dev")
        mockEmployeeService.doPost(_) >> null

        when:
        controller.doPost()

        then:
        response.status == 500
        response.text == "internal server error"
    }

    // Test case for PUT Method

    void "testing for Put in success"(){
        given:
        request.method = "PUT"
        params.id = 1
        request.json = [
                "name":"abc",
                "email":"abc@email.com",
                "department": "marketing",
                "role": "marketing specialist"
        ]
        def updateddummyemployee= new Employee(name: "demo",email:"demo@email.com",department: "software",role: "dev" )
        mockEmployeeService.doPut(_,1) >> updateddummyemployee

        when:
        controller.doPut()

        then:
        response.json.name == "demo"
    }

    void "testing for put in failure"(){
        given:
        request.method = "PUT"
        params.id = 1
        request.json = [
                "name":"abc",
                "email":"abc@email.com",
                "department":"marketing",
                "role":"marketing specialist"
        ]
        def dummyupdatedemployee = new Employee(name: "def",email: "def@email.com",department: "software",role: "dev")
        mockEmployeeService.doPut(_,1) >> null

        when:
        controller.doPut()

        then:
        response.status == 500

    }

    // Test case for PATCH Method

    void "testing for patch in success"(){
        given:
        request.method = "PATCH"
        params.id = 2
        request.json = [
                "name":"harsh"
        ]
        def dummyupdatedemployee = new Employee(name: "demo",email: "demo@email.com",department: "software",role: "dev")
        mockEmployeeService.doPatch(_,2)  >> dummyupdatedemployee

        when:
        controller.doPatch()

        then:
        response.json.name == "demo"
    }

    void "testing for patch in failure"(){
        given:
        request.method = "PATCH"
        params.id = 2
        request.json = [
                "name":"harsh"
        ]
        def dummyupdatedemployee = new Employee(name: "demo",email: "demo@email.com",department: "hr",role: "hr")
        mockEmployeeService.doPatch(_,2) >> null

        when:
        controller.doPatch()

        then:
        response.status == 500
    }

    // Test case for delete method

    void "testing for delete in success"(){
        given:
        request.method = "DELETE"
        params.id = 1

        def dummydeleteemployee = new Employee(name: "demo",email: "demo@email.com",department: "marketing",role: "senior marketing")
        mockEmployeeService.doDelete(1) >> dummydeleteemployee

        when:
        controller.doDelete()

        then:
        response.status == 200
        response.text == "employee is deleted"
    }

    void "testing for delete in failure"(){
        request.method = "DELETE"
        params.id = 1

        def dummydeleteemployee = new Employee(name: "demo",email: "demo@email.com",department: "hr",role: "hr")
        mockEmployeeService.doDelete(1) >> null

        when:
        controller.doDelete()

        then:
        response.status == 500
        response.text == "internal server error"
    }

    // Test case for Get Method
    void"testing for get in success"(){
        request.method = "GET"
        params.id = 1

        def dummygetemployee = new Employee(name: "demo",email: "demo@email.com",department: "software",role: "dev")
        mockEmployeeService.doGet(1) >> dummygetemployee

        when:
        controller.doGet()

        then:
        response.json.name == "demo"
        response.json.email == "demo@email.com"
        response.json.department == "software"
        response.json.role == "dev"
    }

    void "testing for get in failure"(){
        request.method = "GET"
        params.id = 1

        def dummygetemployee = new Employee(name: "demo",email: "demo@email.com",department: "hr",role: "hr")
        mockEmployeeService.doGet(1) >> null

        when:
        controller.doGet()

        then:
        response.status == 500
        response.text == "internal server error"
    }

    // Test case for List (GETALL) Method

    void "testing for list in success"(){
        request.method = "GET"
        List<Employee> employeeList = List.of(
                new Employee(name: "abc",email: "abc@email.com",department: "marketing",role: "sr marketing"),
                new Employee(name: "def",email: "def@email.com",department: "hr",role: "HR")

        )
        mockEmployeeService.doList() >> employeeList

        when:
        controller.doList()

        then:
        response.json.length() ==2
    }

}