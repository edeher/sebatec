<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:set var="context" value="${pageContext.request.contextPath}" />
<fmt:setLocale value="es" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <!-- Meta, title, CSS, favicons, etc. -->        
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>SEBATEC! | </title>
    <!-- Bootstrap core CSS -->
    <link href="${context}/css/bootstrap.min.css" rel="stylesheet">
    <link href="${context}/fonts/css/font-awesome.min.css" rel="stylesheet">
    <link href="${context}/css/animate.min.css" rel="stylesheet">
    <!-- Custom styling plus plugins -->
    <link href="${context}/css/custom.css" rel="stylesheet">
    <link href="${context}/css/icheck/flat/green.css" rel="stylesheet">
    <!-- DataTables -->
    <link href="${context}/js/datatables/jquery.dataTables.min.css" rel="stylesheet" type="text/css" />
    <link href="${context}/js/datatables/buttons.bootstrap.min.css" rel="stylesheet" type="text/css" />
    <link href="${context}/js/datatables/fixedHeader.bootstrap.min.css" rel="stylesheet" type="text/css" />
    <link href="${context}/js/datatables/responsive.bootstrap.min.css" rel="stylesheet" type="text/css" />
    <link href="${context}/js/datatables/scroller.bootstrap.min.css" rel="stylesheet" type="text/css" />
</head>
<body class="nav-md">
    <div class="container body">
        <div class="main_container">
            
            <div class="col-md-3 left_col">
                <div class="left_col scroll-view">            
                    <tiles:insertAttribute name="menu" />
                </div>
            </div>
                
            <div class="right_col" role="main">  
                <div class="row">
                    <tiles:insertAttribute name="body"/>
                </div>
                <br>
                <footer>
                    <tiles:insertAttribute name="footer" />
                </footer>
            </div>            
            
            
        </div>
    <div>     
</body>
</html>