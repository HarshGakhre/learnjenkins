package harsh

import grails.converters.JSON
import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_EMPLOYEE'])
class EmployeeController {

    EmployeeService employeeService;
    def doPost(){
        def jsondata = request.JSON
        def employee = new Employee(name: jsondata.name,email:jsondata.email,department: jsondata.department,role:jsondata.role)
        def dbemployee = employeeService.doPost(employee)
        if(dbemployee){
            render(dbemployee as JSON)
        }else{
            render(status:500,text:"internal server error")
        }
    }


    def doGet(){
        def getid = params.id as long

        def getemp=  employeeService.doGet(getid)

        if(getemp){
            render (getemp as JSON)
        }else{
            render(status: 500,text: "internal server error")
        }
    }

    def doDelete(){
        def delid = params.id as long
        if(employeeService.doDelete(delid)){
            render(status:200,text: (["message": "employee is deleted"] as JSON))
        }else{
            render(status:500,text:"internal server error")
        }
    }

    def doPut(){
        def upjsondata = request.JSON
        def upid = params.id as long
        def updatedemp = employeeService.doPut(upjsondata,upid)
        if(updatedemp){
            render(updatedemp as JSON)
        }else{
            render(status: 500)
        }
    }

    def doList(){
        List<Employee> employeeList = employeeService.doList();
        render (employeeList as JSON)
    }

    def doPatch(){
        def upjsondata = request.JSON
        def upid = params.id as long
        def updatedemp = employeeService.doPatch(upjsondata,upid)
        if(updatedemp){
            render(updatedemp as JSON)
        }else{
            render(status: 500)
        }
    }

    def list() {
        List<Employee> employeeList = employeeService.doList();
        [employeeList: employeeList]
    }

    def show(Long id) {
        Employee employee = employeeService.doGet(id);
        if (employee) {
            [employee: employee]
        } else {
            flash.message = "Employee not found"
            redirect(action: "list")
        }
    }

    def create() {
//        render(view: 'create')
    }

    def save() {
        def jsondata = params
        def newEmp = new Employee(name: jsondata.name, email: jsondata.email, department: jsondata.department, role: jsondata.role)
        def savedEmp = employeeService.doPost(newEmp)
        if (savedEmp) {
            flash.message = "Employee created successfully"
            redirect(action: "list")
        } else {
            flash.message = "Error creating employee"
            render(view: "create")
        }
    }

    def edit(Long id) {
        Employee employee = employeeService.doGet(id);
        if (employee) {
            [employee: employee]
        } else {
            flash.message = "Employee not found"
            redirect(action: "list")
        }
    }

    def update() {
        def jsondata = params
        def id = jsondata.id.toLong()
        def updatedEmp = employeeService.doPut(jsondata, id)
        if (updatedEmp) {
            flash.message = "Employee updated successfully"
            redirect(action: "list")
        } else {
            flash.message = "Error updating employee"
            redirect(action: "edit", id: id)
        }
    }

    def delete(Long id) {
        if (employeeService.doDelete(id)) {
            flash.message = "Employee deleted successfully"
        } else {
            flash.message = "Error deleting employee"
        }
        redirect(action: "list")
    }
}
