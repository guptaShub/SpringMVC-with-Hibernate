<%-- 
    Document   : view-course
    Created on : 27-Dec-2020, 16:31:56
    Author     : Shubham
--%>



<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>

<head>
	<title>View Course</title>
	
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
            
            <table>
                <tr>
                    <th>Title</th>
                    <th>Instructor</th>
                    <th>Review</th>
                    <th>Action</th>
                </tr>
                
                <!-- Construct an update link with customer id-->
                        <c:url var="addLink" value="/course/showFormForReview">
                            <c:param name="courseId" value="${course.id}"/>
                        </c:url>
                
                <tr>
                    <td>${course.title}</td>
                    
                    <td>${instructor.firstName}</td>
                    
                    <td>
                    <c:forEach var="tempReview" items="${review}">
                        
                        <p>${tempReview.comment}</p>    
                        
                    </c:forEach>
                    </td>
                    
                    <td>
                        <a href="${addLink}">Add Review</a>
                    </td>
                </tr>
            </table>
                    
                    <p>
                <a href="${pageContext.request.contextPath}/course/list">Back to List</a>
            </p>
        </div>
    </div>

</body>

</html>
