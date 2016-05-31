<%@page import="com.sebatec.modelo.Solicitud"%>
<%@page import="com.sebatec.dao.SolicitudDAO"%>
<%@page import="com.sebatec.dao.SolicitudDAOFactory"%>
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
    <%  
      
    
    SolicitudDAOFactory fabricate=new SolicitudDAOFactory();
        SolicitudDAO daote=fabricate.metodoDAO();
        int codigo=Integer.parseInt(request.getParameter("codigo") );
        Solicitud soli=daote.leerxid(codigo);
    %>
    <body>
        
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span>
            </button>
            <h4 class="modal-title" id="myModalLabel">CODIGO DE CLIENTE N° <%=soli.getCliente().getIdCliente() %> </h4>

        </div>  
        
        <div class="modal-body">            
            <form class="form-horizontal form-label-left input_mask">
                <div class="col-md-6 col-sm-6 col-xs-12 form-group has-feedback">
                    <input type="text" class="form-control has-feedback-left" readonly="readonly" id="inputSuccess2" placeholder=<%=soli.getCliente().getNombre() %>>
                    <span class="fa fa-user form-control-feedback left" aria-hidden="true"></span>
                </div>
                <div class="col-md-6 col-sm-6 col-xs-12 form-group has-feedback">
                    <input type="text" class="form-control" id="inputSuccess3" readonly="readonly" placeholder=<%=soli.getCliente().getDni() %>>
                    <span class="fa fa-indent form-control-feedback right" aria-hidden="true"></span>
                </div>
                <div class="col-md-6 col-sm-6 col-xs-12 form-group has-feedback">
                    <input type="text" class="form-control has-feedback-left" readonly="readonly" id="inputSuccess4" placeholder=<%=soli.getCliente().getRazonSocial() %>>
                    <span class="fa fa-institution form-control-feedback left" aria-hidden="true"></span>
                </div>
                <div class="col-md-6 col-sm-6 col-xs-12 form-group has-feedback">
                    <input type="text" class="form-control" id="inputSuccess5" readonly="readonly" placeholder=<%=soli.getCliente().getRuc() %>>
                    <span class="fa fa-barcode form-control-feedback right" aria-hidden="true"></span>
                </div>
                <div class="col-md-6 col-sm-6 col-xs-12 form-group has-feedback">
                    <input type="text" class="form-control has-feedback-left" readonly="readonly" id="inputSuccess2" placeholder=<%=soli.getCliente().getDireccion() %>>
                    <span class="fa fa-taxi form-control-feedback left" aria-hidden="true"></span>
                </div>
                <div class="col-md-6 col-sm-6 col-xs-12 form-group has-feedback">
                    <input type="text" class="form-control" id="inputSuccess3" readonly="readonly" placeholder=<%=soli.getCliente().getTelefono() %>>
                    <span class="fa fa-phone form-control-feedback right" aria-hidden="true"></span>
                </div>
                <div class="col-md-6 col-sm-6 col-xs-12 form-group has-feedback">
                    <input type="text" class="form-control has-feedback-left" readonly="readonly" id="inputSuccess4" placeholder=<%=soli.getCliente().getEmail() %>>
                    <span class="fa fa-envelope form-control-feedback left" aria-hidden="true"></span>
                </div>
            </form>            
        </div>  
        
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
        </div>
        
    </body>
    <!-- LIBRERIAS NECESARIAS PARA QUE SE EJECUTE EL JQUERY-->
    <script src="${context}/js/jquery.min.js" type="text/javascript"></script>
    <script src="${context}/js/bootstrap.min.js" type="text/javascript"></script>
    
</html>
