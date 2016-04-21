<%-- 
    Document   : modificar
    Created on : 14/04/2016, 07:25:47 PM
    Author     : Mi Laptop
--%>

<%@page import="com.sebatec.dao.SolicitudDAO"%>
<%@page import="com.sebatec.dao.SolicitudDAOFactory"%>
<%@page import="com.sebatec.modelo.Solicitud"%>
<%@page import="com.sebatec.dao.ClienteDAO"%>
<%@page import="com.sebatec.modelo.Cliente"%>
<%@page import="com.sebatec.dao.ClienteDAOFactory"%>
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
                if(f.idCliente.value=="--")
                {
                    falta+="\tcliente\n";
                }
                if(f.descripcion.value=="")
                {
                    falta+="\tdescripcion\n";
                }
                 if(f.observacion.value=="")
                {
                    falta+="\tobservacion\n";
                }
                if(falta!="")
                {
                   alert("Ingrese :\n "+ falta + " : de la solicitud");
                    return false;
                }
                else
                {
                       f.action="../SolicitudController?accion=modificarSolicitud";
                        f.target="cuerpito";
                        f.submit();
                        f.reset();
                        return true;
                }
            }
             function cerrarse()
            {
                window.close();
            } 
            
        </script>
    </head>
    <%
        SolicitudDAOFactory fabricate1 =new SolicitudDAOFactory();
        SolicitudDAO daote1=fabricate1.metodoDAO();
        
        ClienteDAOFactory fabricate = new ClienteDAOFactory();
        ClienteDAO daote = fabricate.metodoDAO();
        Cliente[] cliA = daote.leertodo();
        
    int idSolicitud=Integer.parseInt(request.getParameter("codigo"));
    Solicitud soli1=daote1.leerxid(idSolicitud);
         
    
    
    %>
    <body>
        <form name="f" method="POST">
            <table border="1">

                <tr>
                    <td>codigo</td>
                    
                    <td><input type="text" name="idSolicitud1" value="<%=idSolicitud%>" disabled="disabled" /></td>
                    <td><input type="hidden" name="idSolicitud" value="<%=idSolicitud%>" /></td>
                </tr>
                <tr>
                    <td>cliente </td>
                    <td><select name="idCliente" >
                           
                            
                            <%for (Cliente cliA1 : cliA) {

                            %>
                            <option value="<%=cliA1.getIdCliente() %>"
                                     <%if(soli1.getCliente().getIdCliente()==cliA1.getIdCliente())
                                            
                                            out.print("selected");
                                     %>>
                                
                                <%=cliA1.getNombre() %></option>
                            <%}%>
                        </select></td>
                </tr>
                <tr>
                    <td>descripcion</td>
                    <td><input type="text" name="descripcion" value="" /></td>
                </tr>
                <tr>
                    <td>observacion</td>
                    <td><input type="text" name="observacion" value="" /></td>
                </tr>


                <tr>
                    <td><input type="reset" value="limpiar" name="limpiar" /></td>
                    
                    <td><input type="button" value="Grabar " onclick="verificar(this.form)"/></td>
                    <td colspan="2"><input type="button" value="CERRAR" onclick="cerrarse()"/></td>
                </tr>
            </table>

        </form>
    </body>
</html>
