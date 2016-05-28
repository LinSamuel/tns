<%@ page import="java.io.*,java.util.*" %>
<%
   // New location to be redirected
   String site = new String("/tns/IndexServlet");
   response.setStatus(response.SC_MOVED_TEMPORARILY);
   response.setHeader("Location", site); 
%>