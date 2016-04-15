<%-- 
    Document   : prueba2
    Created on : 13/04/2016, 04:27:45 PM
    Author     : Mi Laptop
--%>

<%@page import="com.sebatec.dao.ClienteDAO"%>
<%@page import="com.sebatec.dao.ClienteDAOFactory"%>
<%@page import="com.sebatec.modelo.Cliente"%>
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
                if(f.cliente.value=="--")
                {
                    falta+="\tcliente\n";
                }
                 
                 if(f.descripcion.value=="")
                {
                    falta+="\tdescripcion\n";
                }
                if(falta!="")
                {
                   alert("Ingrese :\n "+ falta + " : de la solicitud");
                    return false;
                }
                else
                {
                       f.action="SolicitudController?accion=crearSolicitudConCliente";
                        f.target="";
                        f.submit();
                        f.reset();
                        return true;
                }
            }
            
        </script>
    </head>
    <%
        ClienteDAOFactory fabricate = new ClienteDAOFactory();
        ClienteDAO daote = fabricate.metodoDAO();
        Cliente[] cliA = daote.leertodo();
        for (Cliente cliA1: cliA) {
            System.out.println(" " + cliA1.toString());
        }
    %>
    <body>
        <form name="f" method="POST">
             <table border="1">
          
                <tr>
                    <td>cliente </td>
                    <td><select name="cliente" >
                            <option value="--">--</option>
                             <%for (Cliente cliA1: cliA) {
                                
                        %>
                            <option value="<%=cliA1.getIdPersona() %>"><%=cliA1.getNombre()%></option>
                             <%}%>
                        </select></td>
                </tr>
                <tr>
                    <td>descripcion</td>
                    <td><input type="text" name="descripcion" value="" /></td>
                </tr>
            <tr>
                <td><input type="reset" value="limpiar" /></td>
                <td><input type="button" value="grabar" onclick="verificar(this.form)" /></td>
                </tr>
        </table>
        </form>

    </body>
</html>
