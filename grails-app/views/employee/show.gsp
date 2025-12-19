<html>
<head>
    <title>Employee Details</title>
    <meta name="layout" content="main" />
</head>
<body>
    <h1>Employee Details</h1>

    <p><strong>Name:</strong> ${employee.name}</p>
    <p><strong>Email:</strong> ${employee.email}</p>
    <p><strong>Department:</strong> ${employee.department}</p>
    <p><strong>Role:</strong> ${employee.role}</p>

    <br/>
    <g:link controller="employee" action="list">Back to List</g:link>
</body>
</html>
