<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>File Upload Example</title>
</head>
<body>
	<h1>File Upload Example</h1>
	<form action="upload" method="post" enctype="multipart/form-data">
		<div>ETC <input type="text" name="etc"></div>
		<div>FILE <input type="file" name="file"></div>
		<div><button type="submit">Upload</button></div>
	</form>
</body>
</html>