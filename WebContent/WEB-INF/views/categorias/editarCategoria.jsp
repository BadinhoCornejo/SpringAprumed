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
<title>Editar categoria</title>
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

		<!-- Contenido de la página -->
		<div class="content">
			<!-- Navbar -->
			<jsp:include page="../includes/navbar.jsp"></jsp:include>
			<!-- Navbar-end -->

			<!-- Colocar contenido de la pagina aqui -->
			<div class="main-content">
				<h1>Editar usuario</h1>

				<form action="${urlRoot}categorias/editCate" method="post">
					<div class="row">
						<div class="form-group row">
							<label for="cat_nombre">Nombre</label> <input type="text"
								class="form-control" id="cat_nombre" name="cat_nombre"
								placeholder="Nombre de la categoria" value="${cat.nombreCategoria}"
								required="required">
						</div>
					</div>
					<fieldset class="form-group">
						<div class="row">
							<label class="col-form-label">Estado</label>
							<div class="col-sm-4">
								<div class="form-check">
									<input class="form-check-input" type="radio" name="estado" id="activo"
										value="Activo" checked> <label
										class="form-check-label" for="gridRadios1"> Activo </label>
								</div>
								<div class="form-check">
									<input class="form-check-input" type="radio" name="estado" id="inactivo"
										value="Inactivo"> <label class="form-check-label"
										for="gridRadios2"> Inactivo </label>
								</div>
							</div>
						</div>
					</fieldset>
					<button type="submit" class="btn btn-primary">Guardar</button>
				</form>

			</div>

		</div>

	</div>

	<script type="text/javascript" src="${urlPublic}/js/editUsers.js"></script>
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