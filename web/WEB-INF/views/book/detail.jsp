<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="context" value="${pageContext.request.contextPath}" />

<h2>Detalle de libro</h2>
<b>Titulo:</b>&nbsp;${book.title}<br>
<b>Autor:</b>&nbsp;${book.author}<br>
<b>Descripción:</b><br>
<div style="width:450px;">${book.description}</div><br>
<b>isbn:</b>&nbsp;${book.isbn}<br>
<b>Paginas:</b>&nbsp;${book.pages}<br>
<b>Formato:</b>&nbsp;${book.format}<br>
<b>Año:</b>&nbsp;${book.year}<br>
<b>Precio:</b>&nbsp;${book.price}<br>
<p>
<a href="${context}/book?action=edit&id=${book.bookId}">Editar</a> | <a href="${context}/book?action=delete&id=${book.bookId}" onclick="return confirmRequest('Desea eliminar realmente este registro?');">Eliminar</a> 

<script type="text/javascript">
	function confirmRequest( mensaje )
	{
	    var is_confirmed = confirm( mensaje );
	    return is_confirmed;
	
	}
</script>
