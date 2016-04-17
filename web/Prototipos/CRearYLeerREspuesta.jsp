<%-- 
    Document   : respuesta
    Created on : 13/04/2016, 02:45:42 PM
    Author     : Mi Laptop
--%>


<%@page import="com.sebatec.modelo.EstadoSo"%>
<%@page import="com.sebatec.modelo.Solicitud"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <%
        Solicitud Soli = new Solicitud();
        Soli = (Solicitud) request.getAttribute("Soli");
        System.out.println("solicitud:" + Soli.toString());
        int id = 0;
        String descripcion = "";
        String observacion = "";
        String estado = "";

        if (Soli != null) {
            id = Soli.getIdSolicitud();
            descripcion = Soli.getDescripcion();
            observacion = Soli.getObservacion();
            estado = Soli.getEstado().getNom();
        }
    %>
    <body>
        <table border="1">
            <thead>
                <tr>
                    <th>codigo</th>
                    <th>descripcion</th>
                    <th>observacion</th>
                    <th>estado</th>
                    
                    
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td><%=id %></td>
                    <td><%=descripcion %></td>
                    <td><%=observacion %></td>
                    <td><%=estado%></td>
                    
                    
                </tr>
                
            </tbody>
        </table>

    </body>
</html>
