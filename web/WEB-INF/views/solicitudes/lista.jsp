<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="context" value="${pageContext.request.contextPath}" />

<div class="col-md-12 col-sm-12 col-xs-12">
    <div class="dashboard_graph">
        <div class="row x_title">
            <div class="col-md-6">
                <h3>Solicitudes <small></small></h3>
            </div>
            <div id="div-alerta" style="padding: 1px;display:none " class=" alert alert-success pull-right">

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
<script type="text/javascript">
    $(document).ready(function(){ 
    var table;
    table =$('#datatable-responsive').DataTable({
                "language": {"url": "${context}/css/datatables/Spanish.json"},
                "columns": [{ "title": "Cod" },
                            { "title": "Cliente" },
                            { "title": "Descripcion" },
                            { "title": "Observacion" }, 
                            { "title": "Estado" }, 
                            { "title": "<button id='btnNuevo'><a href='${context}/Solicitudes?action=nuevo'><i class='fa fa-plus'></i></a></button>" }],
                "columnDefs": [                         
                   {"targets": [ 5 ],
                    "orderable": false,
                    "className": 'text-center'},
                   {"targets": -1,
                    "data": null,
                    "defaultContent":   '<button name="btnVerCliente"><a><i class="fa fa-user"></i></a></button> &nbsp&nbsp \n\
                                        <button name="btnEditar"><a><i class="fa fa-pencil"></i></a></button> &nbsp&nbsp \n\
                                        <button name="btnRechazar"><a><i class="fa fa-remove"></i></a></button> &nbsp&nbsp \n\
                                        <button name="btnAsignar"><a><i class="fa fa-mail-forward"></i></a></button>'}
                ],
                "ajax": "",
                "initComplete": function() {
                    
                }
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
            if(nombre=='btnAsignar'){
                alert( "modal ASIGNAR con codigo: "+ data[ 0 ] ); 
            }            
            if(nombre=='btnRechazar'){
               if(confirm("seguro que desea eliminar Miembro")==true){
                        $.ajax({url:"${context}/solicitudes?accion=rechazarSolicitud&idSolicitud="+data[0],})                            
                        .always(function(){
                            actualizar();
                            alerta("Solicitud modificada",true);
                            });  
                }
            }
                           
        });   
    }); 
    
    
</script>