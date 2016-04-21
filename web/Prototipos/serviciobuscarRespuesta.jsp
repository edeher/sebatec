<%-- 
    Document   : serviciobuscarRespuesta
    Created on : 19/04/2016, 09:26:13 AM
    Author     : Mi Laptop
--%>

<%@page import="java.util.Date"%>
<%@page import="com.sebatec.modelo.Servicio"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script language="javaScript">
             function creaaa(f,codigo)
            {
                javascript:window.open('Prototipos/servicioModificar.jsp?val=mod&codigo='+codigo, '', 'width=400,height=300,left=550,top=200,resizable=0,toolsbar=1,scrollbars=1');
               
            }
                        
        </script>
    </head>
    <%
       
       Servicio[] Serv = (Servicio[]) request.getAttribute("Serv");
    
      
    %>
    <body>
        <form name="f" method="POST">
            <table border="1">
                <thead>
                    <tr>
                        <th>idServicio</th>
                        <th>idSolicitud</th>
                        <th>descripcion</th>
                        <th>observacion</th>
                         <th>estado</th>
                        <th>idTecnico</th>
                        <th>profesion</th>
                        <th>especialidad</th>
                         <th>nombre </th>
                        <th>apellido</th>
                        <th>dni</th>
                        <th>direccion</th>
                        <th>telefono</th>
                         <th>email</th>
                          <th>descripcion</th>
                           <th>fecha emision</th>
                            <th>fecha de gestion</th>
                             <th>monto</th>
                             <th>estado</th>
                             <th>opcion</th>
                    </tr>
                </thead>
                <tbody>
                    <%                    
                    for (Servicio Serv1:Serv) 
                    {
                        int codigo=Serv1.getIdServicio();
                %>
                    <tr>
                        <td><%=Serv1.getIdServicio() %></td>
                        <td><%=Serv1.getSolicitud().getIdSolicitud()%></td>
                        <td><%=Serv1.getSolicitud().getDescripcion()%></td>
                        <td><%=Serv1.getSolicitud().getObservacion()%></td>
                        <td><%=Serv1.getSolicitud().getEstado().getNom()%></td>
                        <td><%=Serv1.getTecnico().getIdTecnico() %></td>
                        <td><%=Serv1.getTecnico().getProfesion() %></td>
                        <td><%=Serv1.getTecnico().getEspecialidad() %></td>
                         <td><%=Serv1.getTecnico().getNombre()%></td>
                        <td><%=Serv1.getTecnico().getApellido()%></td>
                        <td><%=Serv1.getTecnico().getDni()%></td>
                        <td><%=Serv1.getTecnico().getDireccion() %></td>
                        <td><%=Serv1.getTecnico().getTelefono()%></td>
                        <td><%=Serv1.getTecnico().getEmail() %></td>
                        <td><%=Serv1.getDescripcion()%></td>
                        <td><%=Serv1.getFechaEmimsion()%></td>
                        <td><%=Serv1.getFechaGestion()%></td>
                        <td><%=Serv1.getMonto() %></td>
                        <td><%=Serv1.getEstado().getNom() %></td>
                        <td >
                        <a href="javascript:creaaa(this.form,'<%=codigo%>')">
                              modi
                        </a> 
                    </td>
                    </tr>
                    <%}%>
                </tbody>
            </table>

        </form>
    </body>
</html>
