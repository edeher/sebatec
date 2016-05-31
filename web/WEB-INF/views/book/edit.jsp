<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="context" value="${pageContext.request.contextPath}" />

<c:if test="${not empty message}">
	<div id="message" class="${message.type}">${message.message}</div>
</c:if>

<h2>${title} libro</h2>
<form name="frmLibro" method="post" id="frmLibro" action="${context}/book">
	<table border="0" cellpadding="10" cellspacing="10">
		<tr>
			<td><b>Id:</b></td>
			<td><input type="text" name="id" size="20" value="${book.bookId == NULL ? 'Autogenerado':book.bookId}" disabled="true"/>
			    <input type="hidden" name="param_id" value="${book.bookId}" /></td>
		</tr>
		<tr>
			<td><b>Titulo:</b></td>
			<td><input type="text" name="param_title" size="50" maxlength="60" value="${book.title}"/></td>		
		</tr>
		<tr>
			<td><b>Autor:</b></td>
			<td><input type="text" name="param_author" size="20" maxlength="30" value="${book.author}"/></td>		
		</tr>
		<tr>
			<td><b>ISBN:</b></td>
			<td><input type="text" name="param_isbn" size="13" maxlength="13" value="${book.isbn}"/></td>		
		</tr>
		<tr>
			<td><b>Descripcion:</b></td>
			<td><textarea rows="4" cols="60" name="param_description">${book.description}</textarea></td>		
		</tr>
		<tr>
			<td><b>Año:</b></td>
			<td><input type="text" name="param_year" size="13" maxlength="13" value="${book.year}"/></td>		
		</tr>
		<tr>
			<td><b>Páginas:</b></td>
			<td><input type="text" name="param_pages" size="13" maxlength="13" value="${book.pages}"/></td>		
		</tr>
		<tr>
			<td><b>Precio:</b></td>
			<td><input type="text" name="param_price" size="13" maxlength="13" value="${book.price}"/></td>		
		</tr>
		<tr>
			<td><b>Imagen:</b></td>
			<td><input type="text" name="param_picture" size="13" maxlength="13" value="${book.picture}"/></td>		
		</tr>
		<tr>
			<td><b>Formato:</b></td>
			<td><select name="param_format">
	                <option value="">[Seleccionar]</option>
	                <option value="Hardcover"  <c:if test="${book.format == 'Hardcover'}"> selected </c:if> >Hardcover</option>
	                <option value="ebook"  <c:if test="${book.format == 'ebook'}"> selected </c:if> >ebook</option>              
	            </select></td>		
		</tr>
		<tr>
			<td><b>Categoría:</b></td>
			<td><select name="param_category">
	               <option value="">[Seleccionar]</option>
	               <c:forEach items="${listCategory}" var="category">
	                    <option value="${category.categoryId}"  <c:if test="${category.categoryId == book.category.categoryId}"> selected </c:if> >${category.categoryName}</option>
	               </c:forEach>
	            </select></td>		
		</tr>
		<tr>
			<td><input type="submit" name="btnEnviar" value="${title}"/></td>
			<td><input type="reset" name="btnLimpiar" value="Limpiar"/></td></td>		
		</tr>			
	</table>
	<input type="hidden" name="action" value="${action}"/>
</form>
