<html>
<head>
    <title>Employee List</title>
    <meta name="layout" content="main" />
     <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="d-flex flex-column justify-content-center align-items-center mt-5">
         <div class="d-flex justify-content-between w-75">
            <h1 class="text-center flex-grow-1">Employee List</h1>
            <div class="mt-2">
            <g:link controller="employee" action="create" class="btn btn-primary">
               Add Employee
           </g:link>
           </div>
         </div>
        <table class="table table-bordered table-striped w-75 shadow">
            <thead>
                <tr >
                    <th class="bg-primary text-white" >Employee Name</th>
                    <th class="bg-primary text-white">Employee Email</th>
                    <th class="bg-primary text-white">Employee Department</th>
                    <th class="bg-primary text-white">Employee Role</th>
                    <th class="bg-primary text-white">Actions</th>
                </tr>
            </thead>
            <tbody>
                <g:each in="${employeeList}" var="employee">
                    <tr>
                        <td>${employee.name}</td>
                        <td>${employee.email}</td>
                        <td>${employee.department}</td>
                        <td>${employee.role}</td>
                        <td>
                            <g:link controller="employee" action="edit" params="[id: employee.id]" class="btn bg-warning text-white">
                                Edit
                            </g:link>
                            <g:link controller="employee" action="delete" params="[id: employee.id]" class="btn bg-danger text-white">
                                                            Delete
                                                        </g:link>
                        </td>
                    </tr>
                </g:each>
            </tbody>
        </table>
    </div>
</body>
</html>
