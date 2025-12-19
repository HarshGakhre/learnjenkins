package harsh

import grails.testing.gorm.DomainUnitTest
import grails.testing.services.ServiceUnitTest
import spock.lang.Specification

class EmployeeServiceSpec extends Specification implements ServiceUnitTest<EmployeeService>, DomainUnitTest<Employee>{
    EmployeeService employeeService
    def setup() {
        employeeService = new EmployeeService()
    }
    def cleanup() {
    }

    void "testing for post method"(){
        given:"creating employee instance"
        Employee employee = new Employee(name: "demo",email: "demo@email.com",department: "marketing",role: "sr marketing")

        when:
        Employee dummyemployee = employeeService.doPost(employee)

        then:
        dummyemployee.id != null
        dummyemployee.name == "demo"
    }

    void "testing for list method"(){
        given:"get all employee detail"
        new Employee(name: "abc",email: "abc@email.com",department:"hr",role: "sr hr").save(flush:true)
        new Employee(name: "def",email: "def@email.com",department: "marketing",role: "marketing specialist").save(flush:true)
        when:
        List<Employee> employeeList = employeeService.doList()

        then:
        employeeList.size() == 2
        employeeList[0].name == "abc"
        employeeList[0].email == "abc@email.com"
        employeeList[1].name == "def"
        employeeList[1].email == "def@email.com"
    }

    void "testing for get method"(){
        given:"get employee detail"
        Employee employee = new Employee(name: "demo",email: "demo@email.com",department: "demo",role: "demo").save(flush: true)

        when:
        Employee dummyemployee = employeeService.doGet(employee.id)

        then:
        dummyemployee.name == "demo"
    }

    void "testing for get method"(){
        given:"get employee detail"
        Employee employee = new Employee(name: "demo",email: "demo@email.com",department: "demo",role: "demo").save(flush: true)

        when:
        def dummyemployee = employeeService.doGet(10)

        then:
        dummyemployee == null
    }

    void "testing for delete method"() {
        given: "an existing employee"
        def employee = new Employee(name: "demo", email: "demo@email.com", department: "hr", role: "sr hr").save(flush: true)

        when:
        def delemployee = employeeService.doDelete(employee.id)

        then:
        delemployee == 1
    }

    void "testing for delete method"() {
        given: "non existing employee"
        def nonexistemployee = 1

        when:
        def delemployee = employeeService.doDelete(nonexistemployee)

        then:
        delemployee == 0
    }

    void "testing for put of existing employee"(){
      given:"updating employee details"
        def existemployee = new Employee(name: "abc",email: "abc@email.com",department: "hr",role: "sr hr").save(flush: true)
        Map jsondata = [
                name: "def",
        ]
        when:
        def updatedemployee = employeeService.doPut(jsondata,existemployee.id)

        then:
        updatedemployee.name == "def"
    }

    void "testing for put method of non-exist employee"(){
        given:"updating employee details"
        Map jsondata = [
                name: "abc",
                email: "abc@email.com",
                department: "hr",
                role: "sr hr"
        ]
        when:
        def updatedemployee = employeeService.doPut(jsondata,2)

        then:
        updatedemployee.name == "abc"
    }

    void"testing for patch method in exist employee"(){
        given:"updating employee "
        def existemployee = new Employee(name: "demo",email: "demo@email.com",department: "hr",role: "sr hr").save(flush: true)
        Map jsondata = [
                name: "abc"
        ]
        when:
        def updatedemployee = employeeService.doPatch(jsondata,existemployee.id)

        then:
        updatedemployee.name == "abc"
    }

    void "testing for patch method in non exist employee"(){
        given:"updating employee"
        Map jsondata = [
                name: "def",
                email: "def@email.com",
                department: "hr",
                role: "sr hr"
        ]
        when:
        def updatedemployee = employeeService.doPatch(jsondata,2)

        then:
        updatedemployee == 0
    }
}
