<%-- 
    Document   : ServicioTodos
    Created on : 19/04/2016, 08:57:32 AM
    Author     : Mi Laptop
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
<script language="javaScript">
        function validartec(f)
        {
            var falta="";
            if(f.idTecnico.value=="")
            {
                falta+="\tcodigo\n";
            }
            if(falta!="")
            {
                 alert("Ingrese :\n "+ falta + " : del Tecnico que tiene Servicios");
                    return false;
            }
            else
            {
                 f.action="../ServicioController?accion=obtenerServiciosPorTecnico";
                        f.target="cuerpito";
                        f.submit();
                        f.reset();
                        return true;
            }
        }
         function validarser(f)
        {
            var falta="";
            if(f.idServicio.value=="")
            {
                falta+="\tcodigo\n";
            }
            if(falta!="")
            {
                 alert("Ingrese :\n "+ falta + " : del servicio");
                    return false;
            }
            else
            {
                 f.action="../ServicioController?accion=obtenerServicio";
                        f.target="cuerpito";
                        f.submit();
                        f.reset();
                        return true;
            }
        }
        function vertodo()
        {
            f.action="../ServicioController?accion=obtenerTodasServicios";
                        f.target="cuerpito";
                        f.submit();
                        f.reset();
                        return true;
            
        }
        
    </script>
    </head>
    <body>
        <form name="f" method="POST">
            <table border="1">
                
                    <tr>
                        <td>buscar por codigo de Tecnico</td>
                        <td><input type="text" name="idTecnico" value="" /></td>
                        <td><input type="button" value="Buscar" onclick="validartec(this.form)"/></td>
                    </tr>
                    <tr>
                        <td>buscar por codigo de Servicio</td>
                        <td><input type="text" name="idServicio" value="" /></td>
                        <td><input type="button" value="Buscar" onclick="validarser(this.form)"/></td>
                    </tr>
                    <tr>
                        <td>buscar todos los servicios</td>
                        <td><input type="button" value="todos" onclick="vertodo(this.form)"/></td>
                    </tr>
                
            </table>

        </form>
    </body>
</html>
