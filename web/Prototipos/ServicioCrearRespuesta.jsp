<%-- 
    Document   : ServicioCrearRespuesta
    Created on : 18/04/2016, 03:16:21 PM
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
    </head>
    <%
        Servicio Serv=new Servicio();
        Serv=(Servicio) request.getAttribute("Serv");
        int idServicio=0;
        int idSolicitud=0;
        int idTecnico=0;
        String Descripcion="";
        String observacion="";
        String estado="";
        
        String profesion="";
        String Especialidad="";
        String nombre="";
        String apeliido="";
        String dni="";
        String direccion="";
        String telefono="";
        String email="";
        
        String descripcion1="";
        Date fechaEmision=null ;
        Date fechaGestion=null;
        Double monto=0.0;
        String estado1="";
        
        if(Serv!=null)
        {
         idServicio=Serv.getIdServicio();
        idSolicitud=Serv.getSolicitud().getIdSolicitud();
        idTecnico=Serv.getTecnico().getIdTecnico();
        Descripcion=Serv.getSolicitud().getDescripcion();
         observacion=Serv.getSolicitud().getObservacion();
         estado=Serv.getSolicitud().getEstado().getNom();
        
         profesion=Serv.getTecnico().getProfesion();
        Especialidad=Serv.getTecnico().getEspecialidad();
        
        nombre=Serv.getTecnico().getNombre();
         apeliido=Serv.getTecnico().getApellido();
        dni=Serv.getTecnico().getDni();
         direccion=Serv.getTecnico().getDireccion();
        telefono=Serv.getTecnico().getTelefono();
        email=Serv.getTecnico().getEmail();
        
        descripcion1=Serv.getDescripcion();
        fechaEmision=Serv.getFechaEmimsion();
        fechaGestion=Serv.getFechaGestion();
         monto=Serv.getMonto();
        estado1=Serv.getEstado().getNom();
        
        }
      
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
                    </tr>
                </thead>
                <tbody>
                    
                    <tr>
                        <td><%=idServicio %></td>
                        <td><%=idSolicitud %></td>
                        <td><%=Descripcion %></td>
                        <td><%=observacion %></td>
                        <td><%=estado %></td>
                        <td><%=idTecnico %></td>
                        <td><%=profesion %></td>
                        <td><%=Especialidad %></td>
                         <td><%=nombre %></td>
                        <td><%=apeliido %></td>
                        <td><%=dni %></td>
                        <td><%=direccion %></td>
                        <td><%=telefono %></td>
                        <td><%=email %></td>
                        <td><%=descripcion1 %></td>
                        <td><%=fechaEmision %></td>
                        <td><%=fechaGestion %></td>
                        <td><%=monto %></td>
                        <td><%=estado1 %></td>
                    </tr>
                    
                </tbody>
            </table>

        </form>
    </body>
</html>
