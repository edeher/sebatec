<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="context" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>    
    <head>        
        <!-- Meta, title, CSS, favicons, etc. -->        
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>SEBATEC! | </title>
        <!-- Bootstrap core CSS -->
        <link href="${context}/css/bootstrap.min.css" rel="stylesheet">
        <link href="${context}/fonts/css/font-awesome.min.css" rel="stylesheet">
        <link href="${context}/css/animate.min.css" rel="stylesheet">
        <!-- Custom styling plus plugins -->
        <link href="${context}/css/custom.css" rel="stylesheet">
        <link href="${context}/css/icheck/flat/green.css" rel="stylesheet">
        <!-- DataTables -->
        <link href="${context}/js/datatables/jquery.dataTables.min.css" rel="stylesheet" type="text/css" />
        <link href="${context}/js/datatables/buttons.bootstrap.min.css" rel="stylesheet" type="text/css" />
        <link href="${context}/js/datatables/fixedHeader.bootstrap.min.css" rel="stylesheet" type="text/css" />
        <link href="${context}/js/datatables/responsive.bootstrap.min.css" rel="stylesheet" type="text/css" />
        <link href="${context}/js/datatables/scroller.bootstrap.min.css" rel="stylesheet" type="text/css" />
    </head>
    <body class="nav-md">
        <div class="container body">
            <div class="main_container">
                    <!-- menu lateral -->
                    <%@include file="../menu.jspf" %>
                    <!-- /menu lateral -->
                    <!-- page content -->
                    <div class="right_col" role="main">
                        <div class="row">
                            <div class="col-md-12 col-sm-12 col-xs-12">
                                <div class="dashboard_graph">
                                    <div class="row x_title">
                                        <div class="col-md-6">
                                            <h3>Solicitudes <small></small></h3>
                                        </div>
                                        <div id="div-alerta" style="padding: 1px;display:none " class=" alert alert-success pull-right"  >

                                        </div>
                                    </div>
                                    <div class="x_content">
                                        <p class="text-muted font-13 m-b-30">

                                        </p>
                                        <table id="datatable-responsive" class="table table-striped table-bordered dt-responsive nowrap" cellspacing="0" width="100%">
                                        </table>
                                    </div>
                                    <div class="clearfix">
                                    </div>
                                </div>
                            </div>
                        </div>
                        <br />
                        <!-- footer content -->
                        <footer>
                            <div class="copyright-info">
                                <p class="pull-right">SEBATEC - Sistema desarrollado por  <a href="https://twitter.com/vanDiego">vanDiego</a>	
                                    y Edeher Ponce
                                </p>
                            </div>
                            <div class="clearfix "></div>
                        </footer>
                        <!-- /footer content -->
                    </div>
                    <!-- /page content -->

                    <div id="miModal" class="modal fade" tabindex="-1" role="dialog" aria-hidden="true">
                      <div class="modal-dialog modal-lg">
                        <div class="modal-content">



                        </div>
                      </div>
                    </div>

            </div>
        </div>	        
        <!-- /footer content -->        
    </body>
    
    <script src="${context}/js/jquery.min.js"></script>	
    <script src="${context}/js/bootstrap.min.js"></script>
    <!-- bootstrap progress js -->
    <script src="${context}/js/progressbar/bootstrap-progressbar.min.js"></script>
    <script src="${context}/js/nicescroll/jquery.nicescroll.min.js"></script>
    <!-- icheck -->
    <script src="${context}/js/icheck/icheck.min.js"></script>
    <!-- custom-->
    <script src="${context}/js/custom.js"></script>
    <!-- Datatables-->
    <script src="${context}/js/datatables/jquery.dataTables.min.js"></script>
    <script src="${context}/js/datatables/dataTables.bootstrap.js"></script>
    <script src="${context}/js/datatables/dataTables.buttons.min.js"></script>
    <script src="${context}/js/datatables/buttons.bootstrap.min.js"></script>
    <script src="${context}/js/datatables/jszip.min.js"></script>
    <script src="${context}/js/datatables/pdfmake.min.js"></script>
    <script src="${context}/js/datatables/vfs_fonts.js"></script>
    <script src="${context}/js/datatables/buttons.html5.min.js"></script>
    <script src="${context}/js/datatables/buttons.print.min.js"></script>
    <script src="${context}/js/datatables/dataTables.fixedHeader.min.js"></script>
    <script src="${context}/js/datatables/dataTables.keyTable.min.js"></script>
    <script src="${context}/js/datatables/dataTables.responsive.min.js"></script>
    <script src="${context}/js/datatables/responsive.bootstrap.min.js"></script>
    <script src="${context}/js/datatables/dataTables.scroller.min.js"></script>    

    <script type="text/javascript">
    var table,band,msj;
    /*funciones que se ejecutan CUANDO CORRE EL ARCHIVO  DOCUMENT.READY*/
    $(document).ready(function(){            
        table =$('#datatable-responsive').DataTable(
                 {
                    "language": {"url": "${context}/css/datatables/Spanish.json"},
                    "columns": [{ "title": "Codigo" },
                                { "title": "Cliente" },

                                { "title": "Descripcion" },
                                { "title": "Observacion" }, 
                                { "title": "Estado" }, 
                                { "title": "<a href='#'><i class='fa fa-plus'></i></a>" }],
                    "columnDefs": [                         
                       {"targets": [ 5 ],
                        "orderable": false,
                        "className": 'text-center'},
                       {"targets": -1,
                        "data": null,
                        "defaultContent": '<button name="btnVerCliente"><a><i class="fa fa-user"></i></a></button> &nbsp&nbsp <button name="btnEditar"><a><i class="fa fa-pencil"></i></a></button> &nbsp&nbsp <button name="btnRechazar"><a><i class="fa fa-remove"></i></a></button> &nbsp&nbsp <button name="btnAsignar"><a><i class="fa fa-mail-forward"></i></a></button>'}
                    ],
                    "ajax": "${context}/solicitudes?accion=obtenerTodasSolicitudesJson",
                    "initComplete": function() {}
                 });  
        /* INCIALIZA LOS BOTONES AL CORRER EL ARCHIVO DENTRO DEL dUCMENT.READY*/
        $('#datatable-responsive tbody').on( 'click', 'button', function (){
            var nombre = $(this).attr('name');
            var data = table.row( $(this).parents('tr') ).data();
            if(nombre=='btnEditar'){
                mostrarModal('${context}/solicitudes/modificarSolicitud.jsp?codigo='+data[0]);
            }
            if(nombre=='btnVerCliente'){
                mostrarModal('${context}/solicitudes/verDatosCliente.jsp?codigo='+data[0]);
            } 
            if(nombre=='btnRechazar'){
               if(confirm("seguro que desea eliminar Miembro")==true){
                        $.ajax(
                               {
                                    url:"${context}/solicitudes?accion=rechazarSolicitud&idSolicitud="+data[0],
                                }
                               )
                            /* .fail(function(){alert("aca si 2")})
                              .done(function(){alert("aca si 1")})*/

                        .always(function()
                            {
                                actualizar();
                                alerta("Solicitud modificada",true);
                            });  
                }
            }
            if(nombre=='btnAsignar')
                alert( "modal ASIGNAR con codigo: "+ data[ 0 ] );                
        });
    });        
     /*-------------------------------------------------------------*/


     /*funcion independiete que MUESTRA EL MODAL*/
     function mostrarModal(url)
     {     
            $('#miModal .modal-content').load(url, function(){                        
               $('#miModal').modal('show');
            });
     }
     /*-------------------------------------------------------------*/


     /*funcion independiete que ACTUALIZA LA TABLA*/
      function actualizar()
      {     
        table.ajax.reload(function(){
            table.columns.adjust().draw();                  
        },false);              
      }
      /*-------------------------------------------------------------*/


      /*funcion independiete que OCULTA EL MODAL*/
      function ocultarmodal()
      {
          $('#miModal').modal('hide');
      }

      /*-------------------------------------------------------------*/

      /*funcion independiete que ENVIA EL MENSAJE DE CONFIRMACION*/
      function alerta(msj,band){
          $("#div-alerta").fadeOut(0,function() {
                band===true ? 
                    $("#div-alerta").removeClass("alert-danger").addClass("alert-success") : 
                    $("#div-alerta").removeClass("alert-success").addClass("alert-danger");                
                $("#div-alerta").html("<h5 style='margin: 6px;'>"+
                    "<strong>"+msj+"</strong>"+
                    "</h5>");                
                $("#div-alerta").fadeIn();                    
            }); 
      }
      /*-------------------------------------------------------------*/
    </script>
    
</html>
