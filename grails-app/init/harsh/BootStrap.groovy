package harsh

import grails.gorm.transactions.Transactional

class BootStrap {

    def init = {
        addTestUser()
    }
    @Transactional
    void addTestUser(){

        def employeeRole = new Role(authority: 'ROLE_EMPLOYEE').save(flush: true)
        def employeeUser = new User(username: 'employee',password: 'employee123').save(flush: true)
        UserRole.create employeeUser,employeeRole

    }

    def destroy = {
    }

}
