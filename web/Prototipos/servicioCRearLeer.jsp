<%-- 
    Document   : servicioCRearLeer
    Created on : 18/04/2016, 02:00:57 PM
    Author     : Mi Laptop
--%>

<%@page import="com.sebatec.modelo.Tecnico"%>
<%@page import="com.sebatec.dao.TecnicoDAO"%>
<%@page import="com.sebatec.dao.TecnicoDAOFactory"%>
<%@page import="com.sebatec.modelo.Solicitud"%>
<%@page import="com.sebatec.dao.SolicitudDAO"%>
<%@page import="com.sebatec.dao.SolicitudDAOFactory"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <script language="javaScript" >
           function verificar(f)
            {
             
                var falta="";
                if(f.solicitud.value=="--")
                {
                    falta+="\tsolicitud\n";
                }
                 if(f.tecnico.value=="--")
                {
                    falta+="\ttecnico\n";
                }
                 if(f.descripcion.value=="")
                {
                    falta+="\tdescripcion\n";
                }
               
               if (falta != "")
               {
               alert("Ingrese :\n " + falta + " : del servicio");
                       return false;
               }
               else
               {
               f.action = "../ServicioController?accion=crearServicio";
                       f.target = "cuerpito";
                       f.submit();
                       f.reset();
                       return true;
               }
           
       }   
        </script>
    </head>
    <%
            SolicitudDAOFactory fabricate = new SolicitudDAOFactory();
        SolicitudDAO daote = fabricate.metodoDAO();
        Solicitud[] soli = daote.leertodo();
        
         TecnicoDAOFactory fabricate1 = new TecnicoDAOFactory();
        TecnicoDAO daote1 = fabricate1.metodoDAO();
        Tecnico[] tec = daote1.leertodo();
        
    
    
    
    %>
    <body>
        <form name="f" method="POST">
            <table border="1">
                
                    <tr>
                        <td>Solicitud </td>
                    <td><select name="solicitud" >
                            <option value="--">--</option>
                             <%for (Solicitud soli1: soli) {
                                
                        %>
                            <option value="<%=soli1.getIdSolicitud() %>"><%=soli1.getCliente().getNombre() %></option>
                             <%}%>
                        </select></td>
                    </tr>
                    <tr>
                        <td>Tecnico </td>
                    <td><select name="tecnico" >
                            <option value="--">--</option>
                             <%for (Tecnico tec1: tec) {
                                
                        %>
                            <option value="<%=tec1.getIdTecnico() %>"><%=tec1.getNombre() %></option>
                             <%}%>
                        </select></td>
                    </tr>
                    <tr>
                        <td>descripcion</td>
                        <td><input type="text" name="descripcion" value="" /></td>
                    </tr>
                    <tr>
                        <td><input type="reset" value="limpiar" /></td>
                        <td><input type="button" value="Grabar" name="grabar" onclick="verificar(this.form)"/></td>
                    </tr>
                
            </table>

        </form>
    </body>
</html>
