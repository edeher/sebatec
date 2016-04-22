<%-- 
    Document   : crearSolicitud
    Created on : 21/04/2016, 11:46:47 PM
    Author     : Mi Laptop
--%>

<%@page import="com.sebatec.modelo.Solicitud"%>
<%@page import="com.sebatec.dao.SolicitudDAO"%>
<%@page import="com.sebatec.dao.SolicitudDAOFactory"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
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
                        <h4 class="modal-title" id="myModalLabel">Modal title</h4>
                      </div>
                      <div class="modal-body">
                        <h4>modificando jsp</h4>
                         <table border="1">           
                             <tr>
                                 <td>codigo</td>
                                 <td><%=soli.getIdSolicitud()%></td>
                             </tr>
                             <tr>
                                 <td>cliente</td>
                                 <td><%=soli.getCliente().getNombre()%></td>
                             </tr>
                             <tr>
                                 <td>dni</td>
                                 <td><%=soli.getCliente().getDni()%></td>
                             </tr>
                             <tr>
                                 <td>descripcion</td>
                                 <td><%=soli.getDescripcion()%></td>
                             </tr>
                             <tr>
                                 <td>telefono</td>
                                 <td><%=soli.getCliente().getTelefono()%></td>
                             </tr>

                         </table>
                      </div>
                      <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        <button type="button" class="btn btn-primary">Save changes</button>
                      </div>
        
        

    </body>
</html>


