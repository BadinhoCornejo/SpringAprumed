<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- Copiar esto en todos los jsp -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!-- ----------------------------- -->
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ventas</title>
<!-- Copiar esto en todos los jsp -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<script src="https://kit.fontawesome.com/e1143320de.js"></script>

<spring:url value="/resources" var="urlPublic" />

<spring:url value="/" var="urlRoot"></spring:url>
<link rel="stylesheet" href="${urlPublic}/css/util.css">
<!-- ----------------------------- -->
</head>
<body>

	<div class="wrapper">

		<!-- Menu lateral -->
		<jsp:include page="../includes/sidebar.jsp"></jsp:include>
		<!-- Menu lateral-end -->

		<!-- Contenido de la p�gina -->
		<div class="content">
			<!-- Navbar -->
			<jsp:include page="../includes/navbar.jsp"></jsp:include>
			<!-- Navbar-end -->

			<!-- Colocar contenido de la pagina aqui -->
			<div class="main-content">
				<h1>
					Ventas works!<i class="fas fa-rocket"></i>
				</h1>

				<table class="table table-striped table bordered table-hover">
					<thead>
						<tr>
							<th scope="col">ID</th>
							<th scope="col">Estado</th>
							<th scope="col">Fecha</th>
							<th scope="col">Hora</th>
							<th scope="col">Dni</th>
							<th scope="col">Apellido</th>
							<th scope="col">Nombre</th>

						</tr>
					</thead>
					<tbody>
						<c:forEach items="${Vventas}" var="venta">
							<tr>
								<td>${venta.ventaID}</td>
								<td><c:choose>
										<c:when test="${venta.estado=='Activo'}">
											<span class="badge badge-pill badge-primary">${venta.estado}</span>
										</c:when>
										<c:when test="${venta.estado=='Realizada'}">
											<span class="badge badge-pill badge-success">${venta.estado}</span>
										</c:when>
										<c:otherwise>
											<span class="badge badge-pill badge-danger">${venta.estado}</span>
										</c:otherwise>
									</c:choose></td>
								<td>${venta.fechaVenta}</td>
								<td>${venta.horaVenta}</td>
								<td>${venta.usuario.dni}</td>
								<td>${venta.usuario.apellido}</td>
								<td>${venta.usuario.nombre}</td>

								<td class="options">
									<div class="col">
										<a href="">Nimi</a>
									</div>
									<div class="col mt-2">
										<a href="">Nimi</a>
									</div>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

			</div>

		</div>

	</div>

	<!-- Copiar esto en todos los jsp -->
	<script type="text/javascript" src="${urlPublic}/js/util.js"></script>

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
	<!-- ----------------------------- -->
</body>
</html>