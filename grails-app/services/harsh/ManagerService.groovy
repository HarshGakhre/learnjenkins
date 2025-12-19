package harsh

import grails.gorm.transactions.Transactional

@Transactional
class ManagerService {

    def doPost(Manager manager) {
        def dbmanager = manager.save(flush: true)
        return dbmanager
    }

    def doDelete(Long id) {
        try {
            Manager manager = Manager.get(id)
            manager.delete(flush: true)
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    def doList() {
        Manager.list()
    }

    def doGet(long id) {
        def dbmng = Manager.get(id)
        return dbmng;
    }

    def doPut(Map jsondata, long id) {
        def dbmng = Manager.get(id)
        if (dbmng) {
            jsondata.each({ key, value ->
                if (dbmng.hasProperty(key)) {
                    dbmng[key] = value
                }
            })
            def upmng = dbmng.save(flush: true)
            return upmng
        } else {
            Manager manager = new Manager(name: jsondata.name, email: jsondata.email, department: jsondata.department, designation: jsondata.designation)
            def upmng = doPost(manager)
            return upmng
        }
    }

    def doPatch(Map jsondata, long id) {
        def dbmng = Manager.get(id)
        if (dbmng) {
            jsondata.each({ key, value ->
                if (dbmng.hasProperty(key)) {
                    dbmng[key] = value
                }
            })
            def upmng = dbemp.save(flush: true)
            return upmng
        } else {
            return 0
        }
    }
}
