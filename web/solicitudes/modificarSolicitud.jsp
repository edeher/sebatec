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
            <h4 class="modal-title" id="myModalLabel">Editar Solicitud N° <%=soli.getIdSolicitud()%> </h4>

        </div>
        <div class="modal-body">     

            <form class="form-horizontal form-label-left input_mask" id="modificaform" enctype="multipart/form-data">

                <input type="hidden" name="idSolicitud" value="<%=soli.getIdSolicitud()%>" />



                <div class="col-md-12 col-sm-12 col-xs-12 form-group has-feedback">
                    <input type="text" class="form-control has-feedback-left" readonly="readonly" value="<%=soli.getCliente().getNombre()%> <%=soli.getCliente().getApellido()%>">
                    <span class="fa fa-user form-control-feedback left" aria-hidden="true"></span>
                </div>                               

                <div class="form-group">
                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Descripcion</label>
                    <div class="col-md-9 col-sm-9 col-xs-12">
                        <input name="descripcion" type="text" class="form-control" value="<%=soli.getDescripcion()%>">
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Observacion</label>
                    <div class="col-md-9 col-sm-9 col-xs-12">
                        <input name="observacion" type="text" class="form-control" value="<%=soli.getObservacion()%>">
                    </div>
                </div>
                <div class="ln_solid"></div>
            </form>                          
        </div>
      <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
          <button type="button" class="btn btn-primary" id="btnguardar" >Guardar Cambios</button>
      </div>
    </body>
    <!--LIBRERIAS NECESARIAS PARA EL SCRIPT*-->
    <script src="${context}/js/jquery.min.js" type="text/javascript"></script>
    <script src="${context}/js/bootstrap.min.js" type="text/javascript"></script>
    <!-------------------------------------------------------------------->
    <script type="text/javascript">
        $(document).ready( function (){   
            
        });

        $('#btnguardar').click(function(){        
            var formdata=new FormData($("#modificaform")[0]);
            $.ajax({
                url:"${context}/solicitudes?accion=modificarSolicitud",
                type:"post",
                contentType:false,
                data:formdata,
                processData:false,
                cache:false})
            .always(function(){
                actualizar();
                ocultarmodal();
                alerta("Solicitud modificada",true);
            });  
        });
    </script>
    
</html>

        

