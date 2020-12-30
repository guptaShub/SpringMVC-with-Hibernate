<%-- 
    Document   : add-course-student
    Created on : 27-Dec-2020, 23:59:08
    Author     : Shubham
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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
    <form:form action="addCourseToStudent?studentId=${studentId}" modelAttribute="course">
            
        Courses:<form:select path="id">  
        <c:forEach var="tempCourse" items="${courses}">
                
            
            <form:option value="${tempCourse.id}" label="${tempCourse.title}"></form:option>
         
                
            </c:forEach>
                
        </form:select>  
        
         <input type="submit" value="Submit"/>
        </form:form>
         <p>
                <a href="${pageContext.request.contextPath}/student/list">Back to List</a>
            </p>
         </div>
    </div>
    </body>
</html>
