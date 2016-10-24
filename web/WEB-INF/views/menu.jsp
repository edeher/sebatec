<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:set var="context" value="${pageContext.request.contextPath}" />

<!-- nombre y logo -->
<div class="navbar nav_title" style="border: 0;">
    <a href="" class="site_title"><i class="fa fa-laptop"></i> <span>SEBATEC</span></a>
</div>
<div class="clearfix"></div>
<!-- /nombre y logo -->

<!-- foto y msj de bienvenida -->
<div class="profile">
    <div class="profile_pic">
        <img src="${context}/images/img.jpg" alt="..." class="img-circle profile_img">
    </div>
    <div class="profile_info">
        <span>Bienvenido,</span>
        <h2>Edeher Ponce</h2>
    </div>
</div>
<!-- /foto y msj de bienvenida -->

<br />

<!-- sidebar menu -->
<div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
    <div class="menu_section">
        <h3>ADMIN</h3>
        <ul class="nav side-menu">
            <li><a href="<%=request.getContextPath()%>/Tiles"><i class="fa fa-file"></i> Solicitudes </a></li>
            <li><a><i class="fa fa-wrench"></i> Servicios </a></li>
            <li><a><i class="fa fa-group"></i> Tecnicos </a></li>
            <li><a><i class="fa fa-group"></i> Clientes </a></li>
            <li><a><i class="fa fa-gears"></i> Tipo de Servicios </a></li>                    
        </ul>
    </div>
</div>
<!-- /sidebar menu -->
    