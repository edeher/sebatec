<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:set var="context" value="${pageContext.request.contextPath}" />

<div class="category-title">
<table cellpadding="0" cellspacing="0" border="0" style="width:100%">
	<tbody>
		<tr>
			<td>
				<span class="a-color-state a-text-bold">${objCategory.categoryName}</span>		      
		   </td>
		</tr>
	</tbody>
</table>
</div>

<a href="${context}/book?action=new">Nuevo</a>

<c:if test="${empty listBook}">
     <div id="mensaje" class="${tipomensaje}">${mensaje}</div>
</c:if>
<c:if test="${!empty listBook}">
<% int i = 1; %>
<table class="table bookstore-table">
  <tbody>
   	<c:forEach items="${listBook}" var="book">
	<tr>
  		<td width="10px;"><% out.println(i++); %></td>
  		<td><a href="${context}/book?action=detail&id=${book.bookId}"><img width="100" height="130" src="files/${book.picture}" /></a></td>
  		<td>
  			<div class="book-detail">
  				<div class="table book-detail-title"><a href="${context}/book?action=detail&id=${book.bookId}">${book.title}</a> Por <span>${book.author}</span> <span>(${book.year})</span></div>
  				<table class="table table-hover">
  					<thead>
  						<tr>
  							<th><span class="book-detail-format">Formato</span></th>
  							<th width="20px"><span class="book-detail-font">Precio</span></th>
  							<th></th>
  							<th></th>  							
  						</tr>
  					</thead>
  					<tbody>
  						<tr>
  							<td><a href="${context}/book?action=detail&id=${book.bookId}">${book.format}</a></td>
  							<td align="right"><span class="book-detail-price">$${book.price}</span></td>
  							<td></td>
  							<td></td>
  						</tr>  						  						
  					</tbody>
  				</table>
  			</div>
  		</td>
  	</tr>  		
  	</c:forEach>
  </tbody>
</table>  	          
</c:if>

