
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>

<head>
	<title>List Student</title>
	
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
            
            <input type="button" value="Add Student" 
                   onclick="window.location.href='showFormForAdd'; return false;"
                   class="add-button"/>
            
            <table>
                <tr>
                    <th>FirstName</th>
                    <th>LastName</th>
                    <th>Email</th>
                    <th>Action</th>
                </tr>
                
                <c:forEach var="tempStudent" items="${student}">
                    
                    <!-- Construct an update link with customer id-->
                    <c:url var="updateLink" value="/student/showFormForUpdate">
                        <c:param name="studentId" value="${tempStudent.id}"/>
                    </c:url>
                    
                    <!-- Construct an update link with customer id-->
                    <c:url var="deleteLink" value="/student/deleteStudent">
                        <c:param name="studentId" value="${tempStudent.id}"/>
                    </c:url>
                    
                    <c:url var="viewLink" value="/student/view">
                        <c:param name="studentId" value="${tempStudent.id}"/>
                    </c:url>
                    
                    <tr>
                        <td>${tempStudent.firstName}</td>
                        <td>${tempStudent.lastName}</td>
                        <td>${tempStudent.email}</td>
                        <td><a href="${updateLink}">Update</a>
                            |
                            <a href="${deleteLink}"
                               onclick="if (!(confirm('Are you sure you want to delete this course?'))) return false">Delete</a>
                            |
                            <a href="${viewLink}">View</a>
                        </td>                        
                    </tr>
                </c:forEach>
            </table>
            
            <p>
                <a href="${pageContext.request.contextPath}/instructor/list">Back to Home</a>
            </p>
        </div>
    </div>

</body>

</html>









