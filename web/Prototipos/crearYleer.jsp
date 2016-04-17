<%-- 
    Document   : prueba
    Created on : 12/04/2016, 04:31:48 PM
    Author     : Mi Laptop
--%>

<%@page import="com.sebatec.modelo.Cliente"%>
<%@page import="com.sebatec.dao.ClienteDAO"%>
<%@page import="com.sebatec.dao.ClienteDAOFactory"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>prueba</title>
        <script language="javaScript" >
           function verificar(f)
            {
             
                var falta="";
                if(f.nombres.value=="")
                {
                    falta+="\tnombre\n";
                }
                 if(f.apellidos.value=="")
                {
                    falta+="\tapellidos\n";
                }
                 if(f.dni.value=="")
                {
                    falta+="\tdni\n";
                }
                 if(f.razonsocial.value == "")
               {
               falta += "\tRazon social\n";
               }
               if (f.ruc.value == "")
               {
               falta += "\truc\n";
               }
               if (f.direccion.value == "")
               {
               falta += "\tdireccion\n";
               }
               if (f.telefono.value == "")
               {
               falta += "\ttelefono\n";
               }
               if (f.email.value == "")
               {
               falta += "\temail\n";
               }
               if (f.descripcion.value == "")
               {
               falta += "\tdescripcion\n";
               }
               if (falta != "")
               {
               alert("Ingrese :\n " + falta + " : de Cliente");
                       return false;
               }
               else
               {
               f.action = "../SolicitudController?accion=crearSolicitudConCliente";
                       f.target = "cuerpito";
                       f.submit();
                       f.reset();
                       return true;
               }
           
       }   
        </script>
    </head>
    
    <body ><center>
        <form name="f" method="POST">
            
            <table border="1">
               
                <tr>
                    <td>nombres</td>
                    <td><input type="text" name="nombres" value="" /></td>
                </tr>
                <tr>
                    <td>apellidos</td>
                    <td><input type="text" name="apellidos" value="" /></td>
                </tr>
                <tr>
                    <td>dni</td>
                    <td><input type="text" name="dni" value="" /></td>
                </tr>
                <tr>
                    <td>RAzon social</td>
                    <td><input type="text" name="razonsocial" value="" /></td>
                </tr>
                <tr>
                    <td>ruc</td>
                    <td><input type="text" name="ruc" value="" /></td>
                </tr>
                <tr>
                    <td>direccion</td>
                    <td><input type="text" name="direccion" value="" /></td>
                </tr>
                <tr>
                    <td>telefono</td>
                    <td><input type="text" name="telefono" value="" /></td>
                </tr>
                <tr>
                    <td>email</td>
                    <td><input type="text" name="email" value="" /></td>
                </tr>
               
                <tr>
                    <td>descripcion</td>
                    <td><input type="text" name="descripcion" value="" /></td>
                </tr>
                <tr>
                    <td><input type="reset" value="limpiar" name="limpiar" /></td>
                    <td><input type="button" value="Grabar " onclick="verificar(this.form)"/></td>
                </tr>
            </table>

        </form>
    </center></body>
</html>
