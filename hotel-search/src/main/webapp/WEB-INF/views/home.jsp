<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hotels</title>
</head>
<body>
	<div class="container">
		<div>
			<h3>Search for your favorite hotel !!</h3>
		</div>
		<div>
			<form action="/home.html" method="POST">
				<input list="filteredhotels" name="hotel_name" placeholder="Search your Hotels here!">
				<datalist id="filteredhotels">
					 <c:forEach items="${filteredhotels}" var="hotels">
				        <option value="${hotels}">
				     </c:forEach>
				</datalist>
			<input type="submit" value="Go">
			</form>
		</div>
	</div>

</body>
</html>