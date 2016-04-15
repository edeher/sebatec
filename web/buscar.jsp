<%-- 
    Document   : prueba3
    Created on : 13/04/2016, 04:46:16 PM
    Author     : Mi Laptop
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <script language="javaScript">
        function validar(f)
        {
            var falta="";
            if(f.idSolicitud.value=="")
            {
                falta+="\tcodigo\n";
            }
            if(falta!="")
            {
                 alert("Ingrese :\n "+ falta + " : de la solicitud");
                    return false;
            }
            else
            {
                 f.action="SolicitudController?accion=obtenerSolicitud";
                        f.target="cuerpito";
                        f.submit();
                        f.reset();
                        return true;
            }
        }
        function vertodo()
        {
            f.action="SolicitudController?accion=obtenerTodasSolicitudes";
                        f.target="cuerpito";
                        f.submit();
                        f.reset();
                        return true;
            
        }
        
    </script>
    <body>
        <form name="f" method="POST">
            <table border="1">

            <tr>
                <td><input type="text" name="idSolicitud" value="" /></td>
                <td><input type="button" value="buscar" onclick="validar(this.form)"/></td>
            </tr>
            <tr>
           

                <td colspan="2" ><input type="button" value="todos" onclick="vertodo(this.form)"/></td>
           
        </tr>

    </table>
           
        </form>

</body>
</html>
