package harsh

import grails.gorm.transactions.Transactional

class EmployeeService {
    @Transactional
    def doPost(Employee myemp) {
        def dbemployee = myemp.save(flush: true)
        return dbemployee
    }

    @Transactional
    def doDelete(Long id) {
        try {
            Employee employee = Employee.get(id)
            employee.delete(flush: true)
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    def doList() {
        Employee.list()
    }

    def doGet(long id) {
        def dbemp = Employee.get(id)
        return dbemp;
    }

    @Transactional
    def doPut(Map jsondata, long id) {
        def dbemp = Employee.get(id)
        if (dbemp) {
            jsondata.each { key, value ->
                if (key != "id" && dbemp.hasProperty(key)) {
                    dbemp[key] = value
                }
            }
            return dbemp.save(flush: true)
        } else {
            Employee employee = new Employee(
                    name: jsondata.name,
                    email: jsondata.email,
                    department: jsondata.department,
                    role: jsondata.role
            )
            return doPost(employee)
        }
    }

    @Transactional
    def doPatch(Map jsondata, long id) {
        def dbemp = Employee.get(id)
        if (dbemp) {
            jsondata.each { key, value ->
                if (key != "id" && dbemp.hasProperty(key)) {
                    dbemp[key] = value
                }
            }
            return dbemp.save(flush: true)
        } else {
            return 0
        }
    }
}
