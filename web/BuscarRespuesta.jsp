<%-- 
    Document   : respuesta2
    Created on : 13/04/2016, 04:50:47 PM
    Author     : Mi Laptop
--%>

<%@page import="com.sebatec.modelo.Solicitud"%>    
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script language="javaScript">
            function creaaa(f,codigo)
            {
                javascript:window.open('modificar.jsp?val=mod&codigo='+codigo, '', 'width=550,height=850,left=750,top=400,resizable=0,toolsbar=1,scrollbars=1');
               
            }
        </script>
    </head>
    <%
       Solicitud[] solv = (Solicitud[]) request.getAttribute("solv");
    %>
    <body>
        <form name="f" method="POST">
            <table border="1">
                <tr>
                    <td>codigo</td>
                    <td>descripcion</td>
                    <td>observacion</td>
                    <td>estado</td>
                </tr>
                <%                    
                    for (Solicitud solv1:solv) 
                    {
                        int codigo=solv1.getIdSolicitud();
                %>
                <tr>
                    <td><%=solv1.getIdSolicitud()%></td>
                    <td><%=solv1.getDescripcion()%> </td>
                    <td><%=solv1.getObservacion()%> </td>
                    <td><%=solv1.getEstado().getNom() %></td>
                    <td width="30">
                        <a href="javascript:creaaa(this.form,'<%=codigo%>')">
                              modi
                        </a> 
                    </td>
                </tr>
                <%}%>   
            </table>
        </form>
    </body>
</html>
