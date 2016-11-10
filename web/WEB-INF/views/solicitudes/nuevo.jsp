<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="context" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Meta, title, CSS, favicons, etc. -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- Bootstrap core CSS -->
        <link href="${context}/css/bootstrap.min.css" rel="stylesheet">
        <link href="${context}/fonts/css/font-awesome.min.css" rel="stylesheet">
        <link href="${context}/css/animate.min.css" rel="stylesheet">
        <!-- Custom styling plus plugins -->
        <link href="${context}/css/custom.css" rel="stylesheet">
        <link href="${context}/css/icheck/flat/green.css" rel="stylesheet">
        <script src="${context}/js/jquery.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>   
    <body>
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span>
            </button>
            <h4 class="modal-title" id="myModalLabel">Nueva Solicitud de Servicio </h4>
        </div>  
        <div class="modal-body">            
                      
        </div>  
        <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
        </div>

    </body>
    <!-- LIBRERIAS NECESARIAS PARA QUE SE EJECUTE EL JQUERY-->
    <script src="${context}/js/jquery.min.js" type="text/javascript"></script>
    <script src="${context}/js/bootstrap.min.js" type="text/javascript"></script>

</html>

