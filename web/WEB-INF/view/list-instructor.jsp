
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>

<head>
	<title>List Instructor</title>
	
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
            
            <input type="button" value="Add Instructor" 
                   onclick="window.location.href='showFormForAdd'; return false;"
                   class="add-button"/>
            
            <table>
                <tr>
                    <th>FirstName</th>
                    <th>LastName</th>
                    <th>Email</th>
                    <th>Action</th>
                </tr>
                
                <c:forEach var="tempInstructor" items="${instructor}">
                    
                    <!-- Construct an update link with customer id-->
                    <c:url var="updateLink" value="/instructor/showFormForUpdate">
                        <c:param name="instructorId" value="${tempInstructor.id}"/>
                    </c:url>
                    
                    <!-- Construct an update link with customer id-->
                    <c:url var="deleteLink" value="/instructor/deleteInstructor">
                        <c:param name="instructorId" value="${tempInstructor.id}"/>
                    </c:url>
                    
                    <c:url var="viewLink" value="/instructor/view">
                        <c:param name="instructorId" value="${tempInstructor.id}"/>
                    </c:url>
                    
                    <c:url var="courseLink" value="/course/list">
                    </c:url>
                    
                    <c:url var="studentLink" value="/student/list">
                    </c:url>
                    <tr>
                        <td>${tempInstructor.firstName}</td>
                        <td>${tempInstructor.lastName}</td>
                        <td>${tempInstructor.email}</td>
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
            
            
            <br>
            <a href="${courseLink}">Courses</a>
            <br>
            <a href="${studentLink}">Students</a>
        </div>
    </div>

</body>

</html>









