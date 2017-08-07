<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">
  <head>
    <title>CloudStreetMarket - The amazing Social Stock Exchange Platform</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="CloudStreetMarket, the amazing Social Stock Exchange Platform">
    <meta name="author" content="Alex Bretet">
  </head>

  <body>
  	<h1>
  		Well done ! 
  	</h1>
  	<h3>You've completed the first chapter :)</h3>
  	
  	<form action="info/upload.action" method="post" enctype="multipart/form-data">    
		<input type="file" name="file" />   
		<input type="submit" value="Submit" />  
	</form>  
	<img src="file/getImage.action"  alt="上海鲜花港 - 郁金香" />
  </body>
</html>
