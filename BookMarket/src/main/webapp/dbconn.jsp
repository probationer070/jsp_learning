<%@ page import="java.sql.*" pageEncoding="utf-8"%>
<%
	Connection conn = null;

	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "ecom6";
	String password = "1234";

	Class.forName("oracle.jdbc.OracleDriver");
	conn = DriverManager.getConnection(url, user, password);
%>