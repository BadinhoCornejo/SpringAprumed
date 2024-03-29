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
<title>Libros</title>
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

<style type="text/css">
.btn:focus {
	box-shadow: unset;
}

.btn-primary-outline.dropdown-toggle:after {
	content: none
}

a:hover {
	cursor: pointer;
}
</style>
</head>
<body>

	<div class="wrapper">

		<!-- Menu lateral -->
		<jsp:include page="../includes/sidebar.jsp"></jsp:include>
		<!-- Menu lateral-end -->

		<!-- Contenido de la página -->
		<div class="content">
			<!-- Navbar -->
			<jsp:include page="../includes/navbar.jsp"></jsp:include>
			<!-- Navbar-end -->

			<!-- Colocar contenido de la pagina aqui -->
			<div class="main-content">
				<h1>Libros</h1>

				<table class="table table-striped table bordered table-hover">
					<thead>
						<tr>
							<th scope="col">ID</th>
							<th scope="col">Titulo</th>
							<th scope="col">Autor</th>
							<th scope="col">Categoria</th>
							<th scope="col">Fecha de publicación</th>
							<th scope="col">Precio</th>
							<th scope="col">Stock</th>
							<th scope="col">Isbn</th>
							<th scope="col">Estado</th>
							<th scope="col"></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${VLibros}" var="libro">
							<tr>
								<td>${libro.libroID}</td>
								<td>${libro.titulo}</td>
								<td>${libro.autor}</td>
								<td>${libro.categoria.nombreCategoria}</td>
								<td>${libro.fechaPublicacion}</td>
								<td>${libro.precio}</td>
								<td>${libro.stock}</td>
								<td>${libro.isbn}</td>
								<td><c:choose>
										<c:when test="${libro.estado=='Activo'}">
											<span class="badge badge-pill badge-primary">${libro.estado}</span>
										</c:when>
										<c:otherwise>
											<span class="badge badge-pill badge-danger">${libro.estado}</span>
										</c:otherwise>
									</c:choose></td>
								<td><div class="btn-group">
										<button class="btn btn-primary-outline dropdown-toggle"
											data-toggle="dropdown" aria-haspopup="true"
											aria-expanded="false">
											<i class="fas fa-ellipsis-h"></i>
										</button>
										<div class="dropdown-menu dropdown-menu-right">
											<a href="libros/delete?id=${libro.libroID}" class="dropdown-item">Eliminar</a> 
											<a href="libros/update?id=${libro.libroID}" class="dropdown-item">Editar</a> 
												<a href="libros/addEjemplar?id=${libro.libroID}" class="dropdown-item">Agregar ejemplar</a>
										</div>
									</div></td>
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