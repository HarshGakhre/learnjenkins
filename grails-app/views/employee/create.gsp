<html>
<head>
    <title>Create Employee</title>
    <meta name="layout" content="main" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>
<div class="container mt-5">
    <h1>Add Employee</h1>
    <g:link controller="employee" action="list" class="btn btn-secondary btn-sm mb-4">
       ← Back to List
    </g:link>
    <div class="row justify-content-center">
        <div class="col-md-6">
           <g:form controller="employee" action="save">
               <div class="mb-3">
                  <label class="form-label" for="name">Employee Name :</label>
                  <g:textField name="name" class="form-control" placeholder="demo" required="true" />
               </div>
               <div class="mb-3">
                  <label class="form-label" for="email">Employee Email :</label>
                  <g:textField name="email" class="form-control" placeholder="demo@email.com" required="true" />
               </div>
               <div class="mb-3">
                  <label class="form-label" for="department">Employee Department :</label>
                  <g:textField name="department" class="form-control" placeholder="Hr" required="true" />
               </div>
               <div class="mb-3">
                  <label class="form-label" for="role">Employee Role :</label>
                  <g:textField name="role" class="form-control" placeholder="Consultant" required="true" />
               </div>
               <div class="text-center d-grid gap-2 col-6 mx-auto">
                  <g:submitButton name="create" value="Add Employee" class="btn btn-primary" />
              </div>
               </g:form>
        </div>
    </div>

</div>

</body>
</html>