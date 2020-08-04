<%@page import="br.com.moduloweb.model.Modulo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
	integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
	integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
	crossorigin="anonymous"></script>
<title>Modulos</title>
</head>
<body>

	<br>
	<div class="container">
		<h1>Modulos RD</h1>
		<br>
		<nav class="navbar navbar-light bg-light">
		<button class="btn btn-info my-2 my-sm-0" type="submit">Novo Registro</button>
			<form class="form-inline" action = "${pageContext.request.contextPath}/modulos" method = "post" accept-charset="UTF-8" >
				<input class="form-control mr-sm-2" type="search"
					placeholder="Insira um nome" aria-label="Pesquisar" aria-describedby="btn-pesquisa" name="NOME">
				<button class="btn btn-outline-success my-2 my-sm-0" type="submit" id="btn-pesquisa">Pesquisar</button>
			</form>
		</nav>
		
		<br>
		<table class="table table-striped">
			<thead class="thead-dark">
				<tr>
					<th scope="col">Nome</th>
					<th scope="col">Instrutor Titular</th>
					<th scope="col">Instrutor Auxiliar</th>
					<th scope="col">Data Inicio</th>
					<th scope="col">Ações</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="modulo" items="${modulos}">
					<tr>
						<td><c:out value="${modulo.getDs_nome()}"></c:out></td>
						<td><c:out value="${modulo.getDs_instrutor_titular()}"></c:out></td>
						<td><c:out value="${modulo.getDs_instrutor_auxiliar()}"></c:out></td>
						<td><fmt:formatDate value="${modulo.getDt_inicio()}" pattern="dd/MM/yyyy"/> </td>
						<td><button type="button" class="btn btn-outline-secondary">Editar</button>&nbsp
                             <button id="btn-form-search" class="btn btn-outline-danger" type="submit" data-toggle="modal" data-target="#exampleModal">Excluir<i class="fas fa-times"></i></button>                                        
                        </td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	 <%-- <table>
		<th>
			<td>Nome</td>
			<td>Instrutor Titular</td>
			<td>Instrutor Auxiliar</td>
			<td>Data Inicio</td>
		</th>
	
 		<%
		List<Modulo> modulos = new ArrayList<Modulo>();
 		modulos = (List)request.getAttribute("modulos");
		for(Modulo modulo : modulos){
			%>
			<tr>
				<td><%out.println(modulo.getDs_nome()); %></td>
				<td><%out.println(modulo.getDs_instrutor_titular()); %></td>
				<td><%out.println(modulo.getDs_instrutor_auxiliar()); %></td>
				<td><%out.println(modulo.getDt_inicio()); %></td>
			</tr>
			<%
		}
	%> 

	</table> --%>

	

</body>
</html>