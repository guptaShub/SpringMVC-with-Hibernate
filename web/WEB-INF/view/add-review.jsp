<%-- 
    Document   : customer-form
    Created on : 04-Oct-2020, 00:02:52
    Author     : Shubham
--%>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Save Review</title>
    </head>
    
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"/>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/add-customer-style.css"/>
    
    <body>
        
        <div id="wrapper">
        <div id="header">
            <h2>CRM - Customer Relationship Manager</h2> 
        </div>
        </div>
        
        <div id="container">
            <h3>Save Review</h3>
            
            <form:form action="addReview" modelAttribute="review" method="POST">
                
                <!-- need to associate data with customer id-->
                
                <form:hidden path="id"/>
                
                <table>
                    <tbody>
                        <tr>
                            <td><label>Comment:</label></td>
                            <td><form:input path="comment" /></td>
                        </tr>
                        <tr>
                            <td><label></label></td>
                            <td><input type="submit" value="Save" class="save" /></td>
                        </tr>
                    </tbody>
                </table>
            </form:form>
            
            <p>
                <a href="${pageContext.request.contextPath}/course/list">Back to List</a>
            </p>
            
        </div>
             
    </body>
</html>

