package harsh

import grails.testing.gorm.DomainUnitTest
import spock.lang.Shared
import spock.lang.Specification

class EmployeeSpec extends Specification implements DomainUnitTest<Employee> {
    @Shared int id
    void "test employee"(){
        setup:
        new Employee(name: "abc",email: "abc@email.com",department: "Marketing",role: "marketing specialist").save()
        new Employee(name: "def",email: "def@email.com",department: "hr",role: "sr. hr").save()

        expect:
        Employee.count()==2
    }

    void "test domain instance id"(){
        setup:
        id = System.identityHashCode(domain)

        expect:
        domain != null
        domain.hashCode() == id

        when:
        domain.name = "abc"

        then:
        domain.name == "abc"
    }

    void "changing domain instance"(){
        setup:
        def emp = new Employee(name: "old", email: "test@email.com", department: "IT", role: "dev")

        when:
        emp.name = 'demo'
        emp.email= 'demo@email.com'
        emp.department = 'manager'
        emp.role    = 'sr. manager'

        then:
        emp.name == 'demo'
        emp.email=='demo@email.com'
        emp.department == 'manager'
        emp.role == 'sr. manager'

    }

    void "test constraints"() {
        when:
        def emp = new Employee(name: "", email: null, department: null, role: "")

        then:
        !emp.validate()
        emp.errors['name']
        emp.errors['email']
        emp.errors['department']
        emp.errors['role']
    }
}
