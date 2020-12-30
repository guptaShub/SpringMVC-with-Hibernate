
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>

<head>
	<title>List Courses</title>
	
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
            
            <input type="button" value="Add Course" 
                   onclick="window.location.href='showFormForAdd'; return false;"
                   class="add-button"/>
            
            <table>
                <tr>
                    <th>Title</th>
                    <th>Action</th>
                </tr>
                
                <c:forEach var="tempCourse" items="${course}">
                    
                    <!-- Construct an update link with customer id-->
                    <c:url var="updateLink" value="/course/showFormForUpdate">
                        <c:param name="courseId" value="${tempCourse.id}"/>
                    </c:url>
                    
                    <!-- Construct an update link with customer id-->
                    <c:url var="deleteLink" value="/course/deleteCourse">
                        <c:param name="courseId" value="${tempCourse.id}"/>
                    </c:url>
                    
                    <c:url var="viewLink" value="/course/view">
                        <c:param name="courseId" value="${tempCourse.id}"/>
                    </c:url>
                    
                    <tr>
                        <td>${tempCourse.title}</td>
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









