<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="context" value="${pageContext.request.contextPath}" />
<link href="${context}/js/datatables/jquery.dataTables.min.css" rel="stylesheet" type="text/css">
<div class="page-title">
    <div class="title_left">
        <h3>
            Solicitudes
            <small>
                
            </small>
        </h3>
    </div>    
</div>
<div class="clearfix"></div>
<div class="row">
    <div class="col-md-12 col-sm-12 col-xs-12">
        <div class="x_panel">            
            <div class="x_content">  
                <table id="datatable-responsive" class="table table-striped table-bordered">
                </table>
            </div>
        </div>        
    </div>
</div>  
<!-- Modal -->
<div class="modal fade bs-example-modal-lg" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
        </div> <!-- /.modal-content -->
    </div> <!-- /.modal-dialog -->
</div>
<!-- /.modal -->
<script type="text/javascript">
    $(document).ready(function(){ 
        $('#menuSol').addClass("current-page");
        var table;
        table =$('#datatable-responsive').DataTable({
            "language": {"url": "${context}/css/datatables/Spanish.json"},
            "columns": [{ "title": "Cod" },
                        { "title": "Cliente" },
                        { "title": "Razon Social" },
                        { "title": "Fecha" }, 
                        { "title": "Estado" }, 
                        { "title": "<a href='${context}/Solicitudes?accion=nuevo'><button name=''><i class='fa fa-plus'></i></button></a>" }],
            "columnDefs": [                         
               {"targets": [ 5 ],
                "orderable": false,
                "className": 'text-center'},
               {"targets": -1,
                "data": null,
                "defaultContent":  '<button name="btnVerInfo"><a><i class="fa fa-user"></i></a></button> &nbsp&nbsp \n\
                                    <button name="btnEditar"><a><i class="fa fa-pencil"></i></a></button> &nbsp&nbsp \n\
                                    <button name="btnRechazar"><a><i class="fa fa-remove"></i></a></button> &nbsp&nbsp \n\
                                    <button name="btnAsignar"><a><i class="fa fa-mail-forward"></i></a></button>'}
            ],
            "ajax": "${context}/Solicitudes?accion=listaJson",
            "initComplete": function() {

            }
        });
        
        function actualizar(){     
            table.ajax.reload(function(){table.columns.adjust().draw();},false);              
        }
        
        function mostrarModal(url){
            $('#myModal .modal-content').load(url,function (){                    
                $('#myModal').modal('show'); 
            });
        }        
          
        $('#datatable-responsive tbody').on( 'click', 'button', function (){
            var nombre = $(this).attr('name');
            var data = table.row( $(this).parents('tr') ).data();
            if(nombre==='btnEditar'){
                mostrarModal('${context}/solicitudes/modificarSolicitud.jsp?codigo='+data[0]);
            }
            if(nombre==='btnVerInfo'){
                mostrarModal('${context}/Solicitudes?accion=info');
            } 
            if(nombre==='btnAsignar'){
                alert( "modal ASIGNAR con codigo: "+ data[ 0 ] ); 
            }            
            if(nombre==='btnRechazar'){
               if(confirm("seguro que desea eliminar Miembro")===true){
                    $.ajax({url:"${context}/solicitudes?accion=rechazarSolicitud&idSolicitud="+data[0]})                            
                    .always(function(){
                        actualizar();
                        alerta("Solicitud modificada",true);
                        });  
                }
            }
        }); 
        
    }); 
    
    
</script>