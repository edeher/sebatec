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
                <h3>Nueva solicitud <small></small></h3>
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
    $('#menuSol').addClass("current-page");
});     
</script>