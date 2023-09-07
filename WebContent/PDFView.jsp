<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="org.apache.commons.codec.binary.Base64" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View </title>
</head>
<body>
<%
byte[] pdfdata=(byte[])request.getAttribute("pdfData");
if(pdfdata!=null && pdfdata.length>0){
    String pdfDataString = new String(org.apache.commons.codec.binary.Base64.encodeBase64(pdfdata));
%>
<iframe src="data:application/pdf;base64,<%= pdfDataString %>" width="100%" height="800px" frameborder="0">
        </iframe>
<%
}
%>
</body>
</html>