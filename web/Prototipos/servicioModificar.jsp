<%-- 
    Document   : servicioModificar
    Created on : 19/04/2016, 11:40:10 AM
    Author     : Mi Laptop
--%>

<%@page import="com.sebatec.modelo.EstadoSev"%>
<%@page import="com.sebatec.dao.ServicioDAO"%>
<%@page import="com.sebatec.dao.ServicioDAOFactory"%>
<%@page import="com.sebatec.modelo.Servicio"%>
<%@page import="com.sebatec.modelo.Tecnico"%>
<%@page import="com.sebatec.modelo.Solicitud"%>
<%@page import="com.sebatec.dao.TecnicoDAO"%>
<%@page import="com.sebatec.dao.SolicitudDAO"%>
<%@page import="com.sebatec.dao.TecnicoDAOFactory"%>
<%@page import="com.sebatec.dao.SolicitudDAOFactory"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <%
        String descripcion="";
        Double monto=0.0;
        
        ServicioDAOFactory fabricate2 = new ServicioDAOFactory();
        ServicioDAO daote2 = fabricate2.metodoDAO();
        
        TecnicoDAOFactory fabricate1 = new TecnicoDAOFactory();
        TecnicoDAO daote1 = fabricate1.metodoDAO();
        Tecnico[] tec = daote1.leertodo();
        
        
        int idServicio=Integer.parseInt(request.getParameter("codigo"));
    Servicio Serv =daote2.leerxid(idServicio);
    if(Serv!=null)
    {
    descripcion=Serv.getDescripcion();
    monto=Serv.getMonto();
    }
    %>
    <body>
        <form name="f" method="POST">
            <table border="1">
                
                    
                    <tr>
                        <td>Tecnico </td>
                    <td><select name="tecnico" >
                            <option value="--">--</option>
                             <%for (Tecnico tec1: tec) {
                                
                        %>
                            <option value="<%=tec1.getIdTecnico() %>" 
                                     <%if(Serv.getTecnico().getIdTecnico()==tec1.getIdTecnico())
                                            
                                            out.print("selected");
                                     %>>
                                
                                
                                
                                <%=tec1.getNombre() %></option>
                             <%}%>
                        </select></td>
                    </tr>
                <tr>
                        <td>Descripcion</td>
                        <td><input type="text" name="descripcion" value="<%=descripcion%>" /></td>
                    </tr>
                    <tr>
                        <td>monto</td>
                        <td><input type="text" name="monto" value="<%=monto%>" /></td>
                    </tr>
                    <tr>
                        <td>estado</td>
                        <td><select name="estado">
                                <option value="--">--</option>
                                <option value=""> </option>
                               
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td><input type="reset" value="limpiar" /></td>
                        <td><input type="button" value="grabar" /></td>
                    </tr>
                    
            </table>

        </form>
    </body>
</html>
