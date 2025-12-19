package harsh

class Employee {
    String name
    String email
    String department
    String role

    static constraints = {
        name blank : false
        email blank:false
        department blank:false
        role blank : false

    }

}
