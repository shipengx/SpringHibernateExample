<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>

 
<spring:url value="/resources/core/css/hello.css" var="coreCss" />
<spring:url value="/resources/core/css/bootstrap.min.css" var="bootstrapCss" />
<link href="${bootstrapCss}" rel="stylesheet" />
<link href="${coreCss}" rel="stylesheet" />
</head>
 
<nav class="navbar navbar-inverse navbar-fixed-top">
  <div class="container">
	<div class="navbar-header">
		<a class="navbar-brand" href="#">Shipeng's project</a>
	</div>
  </div>
</nav>
 
<div class="jumbotron">
  <div class="container">
	<h1>${title}</h1>
	<p>
		<c:if test="${not empty name}">
			Hello ${name}
		</c:if>
 
		<c:if test="${empty name}">
			Welcome Welcome!
		</c:if>
    </p>
  </div>
</div>
 
<div class="container">
 
 <h2>Contact Information</h2>
  <form:form method="POST"  modelAttribute="contactForm"  commandName="contactForm"   action="/narvar-1.0-SNAPSHOT/addContact">
    <table border="0">
      <tr>
        <td><form:label path="name">Name</form:label></td>
        <td><form:input path="name" /></td>
      </tr>
      <tr>
        <td><form:label path="email">Email</form:label></td>
        <td><form:input path="email" /></td>
      </tr>
      <tr>
        <td><form:label path="profession">Profession</form:label></td>
        <td><form:input path="profession" /></td>
      </tr>
      <tr>
        <td colspan="2">
          <input type="submit" value="Submit"/>
        </td>
      </tr>
    </table>  
  </form:form>

</div>


<spring:url value="/resources/core/css/hello.js" var="coreJs" />
<spring:url value="/resources/core/css/bootstrap.min.js" var="bootstrapJs" />
 
<script src="${coreJs}"></script>
<script src="${bootstrapJs}"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
 
</body>
</html>

