<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


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
            <div id="datatable-responsive_wrapper" class="dataTables_wrapper form-inline dt-bootstrap no-footer">
                 <div class="row">
                    <div class="col-sm-6">
                        <div class="dataTables_length" id="datatable-responsive_length"><label>Mostrar <select name="datatable-responsive_length" aria-controls="datatable-responsive" class="form-control input-sm"><option value="10">10</option><option value="25">25</option><option value="50">50</option><option value="100">100</option></select> registros</label>
                        </div>
                    </div>
                    <div class="col-sm-6">
                        <div id="datatable-responsive_filter" class="dataTables_filter"><label>Buscar:<input type="search" class="form-control input-sm" placeholder="" aria-controls="datatable-responsive"></label>
                        </div>
                    </div>
                 </div>
                <div class="row">
                    <div class="col-sm-12">
                        <table id="datatable-responsive" class="table table-striped table-bordered dt-responsive nowrap dataTable no-footer dtr-inline" cellspacing="0" width="100%" role="grid" aria-describedby="datatable-responsive_info" style="width: 100%;">
                            <thead><tr role="row"><th class="sorting_asc" tabindex="0" aria-controls="datatable-responsive" rowspan="1" colspan="1" style="width: 78px;" aria-label="Codigo: Activar para ordenar la columna de manera descendente" aria-sort="ascending">Codigo</th><th class="sorting" tabindex="0" aria-controls="datatable-responsive" rowspan="1" colspan="1" style="width: 204px;" aria-label="Cliente: Activar para ordenar la columna de manera ascendente">Cliente</th><th class="sorting" tabindex="0" aria-controls="datatable-responsive" rowspan="1" colspan="1" style="width: 119px;" aria-label="Descripcion: Activar para ordenar la columna de manera ascendente">Descripcion</th><th class="sorting" tabindex="0" aria-controls="datatable-responsive" rowspan="1" colspan="1" style="width: 124px;" aria-label="Observacion: Activar para ordenar la columna de manera ascendente">Observacion</th><th class="sorting" tabindex="0" aria-controls="datatable-responsive" rowspan="1" colspan="1" style="width: 76px;" aria-label="Estado: Activar para ordenar la columna de manera ascendente">Estado</th><th class="text-center sorting_disabled" rowspan="1" colspan="1" style="width: 233px;" aria-label=""><a href="#"><i class="fa fa-plus"></i></a></th></tr></thead><tbody><tr role="row" class="odd"><td class="sorting_1" tabindex="0">1</td><td>Importaciones Volcan SAC</td><td>AAA</td><td>AAAA</td><td>rechazado</td><td class=" text-center"><button name="btnVerCliente"><a><i class="fa fa-user"></i></a></button> &nbsp;&nbsp; <button name="btnEditar"><a><i class="fa fa-pencil"></i></a></button> &nbsp;&nbsp; <button name="btnRechazar"><a><i class="fa fa-remove"></i></a></button> &nbsp;&nbsp; <button name="btnAsignar"><a><i class="fa fa-mail-forward"></i></a></button></td></tr><tr role="row" class="even"><td class="sorting_1" tabindex="0">2</td><td>dgdfg</td><td>aaa</td><td>aaaa</td><td>rechazado</td><td class=" text-center"><button name="btnVerCliente"><a><i class="fa fa-user"></i></a></button> &nbsp;&nbsp; <button name="btnEditar"><a><i class="fa fa-pencil"></i></a></button> &nbsp;&nbsp; <button name="btnRechazar"><a><i class="fa fa-remove"></i></a></button> &nbsp;&nbsp; <button name="btnAsignar"><a><i class="fa fa-mail-forward"></i></a></button></td></tr><tr role="row" class="odd"><td class="sorting_1" tabindex="0">3</td><td>dfgfdgdfgdfgdf</td><td>dfdfdfd</td><td>fdfdfdfdfd</td><td>rechazado</td><td class=" text-center"><button name="btnVerCliente"><a><i class="fa fa-user"></i></a></button> &nbsp;&nbsp; <button name="btnEditar"><a><i class="fa fa-pencil"></i></a></button> &nbsp;&nbsp; <button name="btnRechazar"><a><i class="fa fa-remove"></i></a></button> &nbsp;&nbsp; <button name="btnAsignar"><a><i class="fa fa-mail-forward"></i></a></button></td></tr><tr role="row" class="even"><td class="sorting_1" tabindex="0">4</td><td>gfdgdfg</td><td>aaaaaa</td><td>aaaaaaa</td><td>rechazado</td><td class=" text-center"><button name="btnVerCliente"><a><i class="fa fa-user"></i></a></button> &nbsp;&nbsp; <button name="btnEditar"><a><i class="fa fa-pencil"></i></a></button> &nbsp;&nbsp; <button name="btnRechazar"><a><i class="fa fa-remove"></i></a></button> &nbsp;&nbsp; <button name="btnAsignar"><a><i class="fa fa-mail-forward"></i></a></button></td></tr></tbody>
                        </table>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-5">
                        <div class="dataTables_info" id="datatable-responsive_info" role="status" aria-live="polite">Mostrando registros del 1 al 4 de un total de 4 registros
                        </div>                            
                    </div>
                    <div class="col-sm-7">
                        <div class="dataTables_paginate paging_simple_numbers" id="datatable-responsive_paginate"><ul class="pagination"><li class="paginate_button previous disabled" id="datatable-responsive_previous"><a href="#" aria-controls="datatable-responsive" data-dt-idx="0" tabindex="0">Anterior</a></li><li class="paginate_button active"><a href="#" aria-controls="datatable-responsive" data-dt-idx="1" tabindex="0">1</a></li><li class="paginate_button next disabled" id="datatable-responsive_next"><a href="#" aria-controls="datatable-responsive" data-dt-idx="2" tabindex="0">Siguiente</a></li></ul>
                        </div>
                    </div>
                </div>               
            </div>
        </div>
        <div class="clearfix">
        </div>
    </div>
</div>


