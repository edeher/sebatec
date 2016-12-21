<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="context" value="${pageContext.request.contextPath}" />
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
    <div class="col-md-8 col-sm-8 col-xs-8">
        <div class="x_panel"> 
            <div class="x_title">
                <h2>${titulo} <small> </small></h2>                
                <div class="clearfix"></div>
            </div>
            <div class="x_content">                
                <form id="formSolicitud" method="post" action="${context}/Solicitudes" class="form-horizontal form-label-left" novalidate="" >
                    <div class="form-group">
                        <label for="DNI" class="control-label col-md-2 col-sm-2 col-xs-12">DNI</label>
                        <div class="col-md-3 col-sm-3 col-xs-12">
                            <input id="dni" class="form-control col-md-7 col-xs-12" type="text" name="param_dni" data-parsley-id="3290"><ul class="parsley-errors-list" id="parsley-id-3290"></ul>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="nombre" class="control-label col-md-2 col-sm-2 col-xs-12">Nombres</label>
                        <div class="col-md-4 col-sm-4 col-xs-12">
                            <input id="nombre" class="form-control col-md-7 col-xs-12" type="text" name="param_nombre" data-parsley-id="3290"><ul class="parsley-errors-list" id="parsley-id-3290"></ul>
                        </div>
                        <label for="apellidos" class="control-label col-md-2 col-sm-2 col-xs-12">Apellidos</label>
                        <div class="col-md-4 col-sm-4 col-xs-12">
                            <input id="apellidos" class="form-control col-md-7 col-xs-12" type="text" name="param_apellido" data-parsley-id="3290"><ul class="parsley-errors-list" id="parsley-id-3290"></ul>
                        </div>
                    </div>                        
                    <div class="form-group">
                        <label for="telefono" class="control-label col-md-2 col-sm-2 col-xs-12">Telefono</label>
                        <div class="col-md-4 col-sm-4 col-xs-12">
                            <input id="telefono" class="form-control col-md-7 col-xs-12" type="text" name="param_telefono" data-parsley-id="3290"><ul class="parsley-errors-list" id="parsley-id-3290"></ul>
                        </div>
                        <label for="email" class="control-label col-md-2 col-sm-2 col-xs-12">E-mail <span class="required">*</span></label>
                        <div class="col-md-4 col-sm-4 col-xs-12">
                            <input id="email" class="form-control col-md-7 col-xs-12" type="text" name="param_email" data-parsley-id="3290"><ul class="parsley-errors-list" id="parsley-id-3290"></ul>
                        </div>
                    </div> 
                    <div class="form-group">
                        <label class="control-label col-md-2 col-sm-2 col-xs-12">Descripción </label>
                        <div class="col-md-10 col-sm-10 col-xs-12">
                            <textarea id="descripcion" required="required" class="form-control" name="param_descripcion" data-parsley-trigger="keyup" data-parsley-minlength="20" data-parsley-maxlength="100" data-parsley-minlength-message=""
                             data-parsley-validation-threshold="10"></textarea>
                        </div>
                    </div>                    
                    <div class="form-group emp">
                        <label class="control-label col-md-2 col-sm-2 col-xs-12" for="last-name">RUC <span class="required">*</span></label>
                        <div class="col-md-4 col-sm-4 col-xs-12">
                            <input type="text" id="last-name" name="param_ruc" class="form-control col-md-7 col-xs-12" data-parsley-id="4184"><ul class="parsley-errors-list" id="parsley-id-4184"></ul>
                        </div>
                    </div>
                    <div class="form-group emp">
                        <label class="control-label col-md-2 col-sm-2 col-xs-12" for="razon-social">Razon Social <span class="required">*</span></label>
                        <div class="col-md-8 col-sm-8 col-xs-12">
                            <input type="text" id="first-name" name="param_razonsocial" class="form-control col-md-7 col-xs-12" data-parsley-id="4472"><ul class="parsley-errors-list" id="parsley-id-4472"></ul>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-md-2 col-sm-2 col-xs-12">Direccion</label>
                        <div class="col-md-8 col-sm-8 col-xs-12">
                            <input id="direccion" name="param_direccion" class="date-picker form-control col-md-7 col-xs-12" required="required" type="text" data-parsley-id="4314"><ul class="parsley-errors-list" id="parsley-id-4314"></ul>
                        </div>
                    </div>
                    <input type="hidden" name="accion" value="${accion}"/>
                    <div class="ln_solid"></div>
                    <div class="form-group">
                        <div class="col-md-12 col-sm-12 col-xs-12 text-right">
                            <label class="control-label col-md-2 col-sm-2 col-xs-12"> Opcional *</label>
                            <input type="reset"class="btn btn-primary" value="Reset" />
                            <input type="submit" class="btn btn-success" value="Guardar" />
                        </div>
                    </div>                    
                </form>
            </div>
        </div>        
    </div>
</div> 
<script type="text/javascript">
$(document).ready(function(){ 
    $('#menuSol').addClass("current-page");
    /*
    $('input').on('ifChecked', function(event){        
        $('.emp').fadeToggle( "fast", function() {});
    });
    */    
});
/*
$('#btnGuardar').click(function () {
    var formdata = new FormData($("#formSolicitud")[0]);
    $.ajax({
        url: "${context}/Solicitudes?accion=crear",
        type: "post",
        contentType: false,
        data: formdata,
        processData: false,
        cache: false})
    .done(function (contador) {
        
    });
});
*/

</script>