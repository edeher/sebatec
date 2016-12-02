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
    <div class="col-md-9 col-sm-9 col-xs-9">
        <div class="x_panel"> 
            <div class="x_title">
                <h2>Nuevo registro <small> </small></h2>                
                <div class="clearfix"></div>
            </div>
            <div class="x_content">                
                <form id="formSolicitud" data-parsley-validate="" class="form-horizontal form-label-left" novalidate="">
                    <div class="form-group">   
                        <label class="control-label col-md-2 col-sm-2 col-xs-12" for="">  </label>
                        <div class="col-md-6 col-sm-6 col-xs-12"> 
                            <label for="empresa">   Empresa </label>
                            <input type="radio" class="flat" name="tipoCliente" id="tipoEmpresa" value="empresa" checked="" required />                               
                            <label for="empresa">   Persona Natural  </label>                              
                            <input type="radio" class="flat" name="tipoCliente" id="tipoPersona" value="persona" /> 
                        </div>                        
                    </div>
                    <div class="form-group emp">
                        <label class="control-label col-md-2 col-sm-2 col-xs-12" for="razon-social">Razon Social <span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input type="text" id="first-name" required="required" class="form-control col-md-7 col-xs-12" data-parsley-id="4472"><ul class="parsley-errors-list" id="parsley-id-4472"></ul>
                        </div>
                    </div>
                    <div class="form-group emp">
                        <label class="control-label col-md-2 col-sm-2 col-xs-12" for="last-name">RUC <span class="required">*</span>
                        </label>
                        <div class="col-md-4 col-sm-4 col-xs-12">
                            <input type="text" id="last-name" name="ruc" required="required" class="form-control col-md-7 col-xs-12" data-parsley-id="4184"><ul class="parsley-errors-list" id="parsley-id-4184"></ul>
                        </div>
                    </div>
                    <div class="form-group emp">   
                        <label class="control-label col-md-2 col-sm-2 col-xs-12" for="">  </label>
                        <div class="col-md-6 col-sm-6 col-xs-12"> 
                            <label class="control-label" for="empresa">Datos de Representante</label>                            
                        </div>                        
                    </div>
                    <div class="form-group">
                        <label for="nombre" class="control-label col-md-2 col-sm-2 col-xs-12">Nombres</label>
                        <div class="col-md-4 col-sm-4 col-xs-12">
                            <input id="nombre" class="form-control col-md-7 col-xs-12" type="text" name="nombre" data-parsley-id="3290"><ul class="parsley-errors-list" id="parsley-id-3290"></ul>
                        </div>
                        <label for="apellidos" class="control-label col-md-1 col-sm-1 col-xs-12">Apellidos</label>
                        <div class="col-md-4 col-sm-4 col-xs-12">
                            <input id="apellidos" class="form-control col-md-7 col-xs-12" type="text" name="apellidos" data-parsley-id="3290"><ul class="parsley-errors-list" id="parsley-id-3290"></ul>
                        </div>
                    </div>                    
                    <div class="form-group">
                        <label for="DNI" class="control-label col-md-2 col-sm-2 col-xs-12">DNI<span class="required">*</span></label>
                        <div class="col-md-4 col-sm-4 col-xs-12">
                            <input id="dni" class="form-control col-md-7 col-xs-12" type="text" name="dni" data-parsley-id="3290"><ul class="parsley-errors-list" id="parsley-id-3290"></ul>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-md-2 col-sm-2 col-xs-12">Direccion <span class="required">*</span>
                        </label>
                        <div class="col-md-5 col-sm-5 col-xs-12">
                            <input id="direccion" class="date-picker form-control col-md-7 col-xs-12" required="required" type="text" data-parsley-id="4314"><ul class="parsley-errors-list" id="parsley-id-4314"></ul>
                        </div>
                    </div>   
                    <div class="form-group">
                        <label for="telefono" class="control-label col-md-2 col-sm-2 col-xs-12">Telefono</label>
                        <div class="col-md-4 col-sm-4 col-xs-12">
                            <input id="telefono" class="form-control col-md-7 col-xs-12" type="text" name="telefono" data-parsley-id="3290"><ul class="parsley-errors-list" id="parsley-id-3290"></ul>
                        </div>
                        <label for="email" class="control-label col-md-1 col-sm-1 col-xs-12">E-mail</label>
                        <div class="col-md-4 col-sm-4 col-xs-12">
                            <input id="email" class="form-control col-md-7 col-xs-12" type="text" name="email" data-parsley-id="3290"><ul class="parsley-errors-list" id="parsley-id-3290"></ul>
                        </div>
                    </div> 
                    <div class="form-group">
                        <label class="control-label col-md-2 col-sm-2 col-xs-12">Descripción <span class="required">*</span>
                        </label>
                        <div class="col-md-9 col-sm-9 col-xs-12">
                            <textarea id="descripcion" required="required" class="form-control" name="descripcion" data-parsley-trigger="keyup" data-parsley-minlength="20" data-parsley-maxlength="100" data-parsley-minlength-message=""
                             data-parsley-validation-threshold="10"></textarea>
                        </div>
                    </div>
                    <div class="ln_solid"></div>
                    <div class="form-group">
                        <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
                            <button class="btn btn-primary">Cancel</button>
                            <button type="submit" class="btn btn-success">Submit</button>
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
    $('input').on('ifChecked', function(event){        
        $('.emp').fadeToggle( "fast", function() {});
    });
});     
</script>