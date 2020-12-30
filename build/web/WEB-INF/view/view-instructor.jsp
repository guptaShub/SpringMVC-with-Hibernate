<%-- 
    Document   : view-course
    Created on : 27-Dec-2020, 16:31:56
    Author     : Shubham
--%>



<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>

<head>
	<title>View Instructor</title>
	
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
            
            <h1>${instructor.firstName} ${instructor.lastName}</h1>
            
            <h4>Email: ${instructor.email}</h4>
            
            <h4>Youtube Channel: ${instructorDetail.youtubeChannel}</h4>
            
            <h4>Hobby : ${instructorDetail.hobby}</h4>
            
            <h4>Course : 
            <c:forEach var="tempCourse" items="${courses}">
                
                ${tempCourse.title}
                
            </c:forEach>
            </h4>
             
            <!-- Construct an update link with customer id-->
                    <c:url var="updateLink" value="/instructor/showFormForUpdateInstructorDetail">
                        <c:param name="instructorId" value="${instructor.id}"/>
                    </c:url>
            <p>
            <a href="${updateLink}">Update Profile</a>
            </p>
            <br>
            
             <input type="button" value="Add Course" 
                   onclick="window.location.href='showFormForAddCourse?instructorId=${instructor.id}'; return false;"
                   class="add-button"/>
             
             <p>
                <a href="${pageContext.request.contextPath}/instructor/list">Back to List</a>
            </p>
        </div>
    </div>

</body>

</html>
