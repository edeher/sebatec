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
                <form id="demo-form2" data-parsley-validate="" class="form-horizontal form-label-left" novalidate="">

                    <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="first-name">First Name <span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input type="text" id="first-name" required="required" class="form-control col-md-7 col-xs-12" data-parsley-id="4472"><ul class="parsley-errors-list" id="parsley-id-4472"></ul>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="last-name">Last Name <span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input type="text" id="last-name" name="last-name" required="required" class="form-control col-md-7 col-xs-12" data-parsley-id="4184"><ul class="parsley-errors-list" id="parsley-id-4184"></ul>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="middle-name" class="control-label col-md-3 col-sm-3 col-xs-12">Middle Name / Initial</label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input id="middle-name" class="form-control col-md-7 col-xs-12" type="text" name="middle-name" data-parsley-id="3290"><ul class="parsley-errors-list" id="parsley-id-3290"></ul>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12">Gender</label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <div id="gender" class="btn-group" data-toggle="buttons">
                                <label class="btn btn-default" data-toggle-class="btn-primary" data-toggle-passive-class="btn-default">
                                    <input type="radio" name="gender" value="male" data-parsley-multiple="gender" data-parsley-id="0443"> &nbsp; Male &nbsp;
                                </label><ul class="parsley-errors-list" id="parsley-id-multiple-gender"></ul>
                                <label class="btn btn-primary active" data-toggle-class="btn-primary" data-toggle-passive-class="btn-default">
                                    <input type="radio" name="gender" value="female" checked="" data-parsley-multiple="gender" data-parsley-id="0443"> Female
                                </label>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12">Date Of Birth <span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input id="birthday" class="date-picker form-control col-md-7 col-xs-12" required="required" type="text" data-parsley-id="4314"><ul class="parsley-errors-list" id="parsley-id-4314"></ul>
                        </div>
                    </div>
                    <div class="ln_solid"></div>
                    <div class="form-group">
                        <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
                            <button type="submit" class="btn btn-primary">Cancel</button>
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
});     
</script>