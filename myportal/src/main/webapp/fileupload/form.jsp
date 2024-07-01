<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix=c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>파일 업로드</title>
</head>
<body>
<h1>파일 업로드</h1>
<form method="post" action="<c:url value="fileupload/upload" />" enctype="multipart/form-data">
    <label for="file">File:</label>
    <input type="file" id="file" name="file" />
    <br/>
    <input type="submit" value="Upload" />
</form>
</body>
</html>