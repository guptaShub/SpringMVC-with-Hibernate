<%-- 
    Document   : view-course
    Created on : 27-Dec-2020, 16:31:56
    Author     : Shubham
--%>



<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>

<head>
	<title>View Student</title>
	
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"/>
</head>

<body>
    
    <div id="wrapper">
        <div id="header">
            <h2>CRM - Customer Relationship Manager</h2> 
        </div>
    </div>
    
    <div id="container">
        <div id="content">
            
            <h1>${student.firstName} ${student.lastName}</h1>
            
            <h4>Email: ${student.email}</h4>
            
            <h4>Course : 
            <c:forEach var="tempCourse" items="${courses}">
                
                ${tempCourse.title}
                
            </c:forEach>
            </h4>
            
             <input type="button" value="Add Course" 
                    onclick="window.location.href='showFormForAddCourse?studentId=${student.id}'; return false;"
                   class="add-button"/>
             
             <p>
                <a href="${pageContext.request.contextPath}/student/list">Back to List</a>
            </p>
        </div>
    </div>

</body>

</html>
