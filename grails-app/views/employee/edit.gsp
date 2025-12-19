<html>
<head>
    <title>Edit Employee</title>
    <meta name="layout" content="main" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h1>Edit Employee</h1>
      <g:link controller="employee" action="list" class="btn btn-secondary btn-sm mb-4">
           ← Back to List
         </g:link>
    <div class="row justify-content-center">
 <div class="col-md-6">
             <g:form controller="employee" action="update" method="post">
               <input type="hidden" name="id" value="${employee.id}" />
        <div class="mb-3">
            <label for="name">Employee Name :</label>
            <g:textField name="name" class="form-control" value="${employee.name}" required="true" />
        </div>
        <div class="mb-3">
            <label for="email">Employee Email :</label>
            <g:textField name="email" class="form-control" value="${employee.email}" required="true" />
        </div>
        <div class="mb-3">
            <label for="department">Employee Department :</label>
            <g:textField name="department" class="form-control" value="${employee.department}" required="true" />
        </div>
        <div class="mb-3">
            <label for="role">Employee Role :</label>
            <g:textField name="role" class="form-control" value="${employee.role}" required="true" />
        </div>
         <div class="text-center d-grid gap-2 col-6 mx-auto">
             <g:submitButton name="create" value="Edit Employee" class="btn btn-warning" />
           </div>
    </g:form>
</body>
</html>
