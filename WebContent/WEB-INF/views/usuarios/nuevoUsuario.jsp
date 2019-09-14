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
<title>Nuevo usuario</title>
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
input[type=number]::-webkit-inner-spin-button, input[type=number]::-webkit-outer-spin-button
	{
	-webkit-appearance: none;
	margin: 0;
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
				<h1>Nuevo usuario</h1>

				<form action="${urlForm}crear" method="post">
					<div class="form-row">
						<div class="form-group col-md-5">
							<label for="usr_apellido">Apellido</label> <input type="text"
								class="form-control" id="usr_apellido" name="usr_apellido" placeholder="Apellido" required="required">
						</div>
						<div class="form-group col-md-5">
							<label for="usr_nombre">Nombre</label> <input type="text"
								class="form-control" id="usr_nombre" name="usr_nombre" placeholder="Nombre" required="required">
						</div>
					</div>

					<div class="form-row">
						<div class="form-group col-md-2">
							<label for="usr_phone">Teléfono</label> <input type="text"
								pattern="\d*" maxlength="9" class="form-control" id="usr_phone" name="usr_phone"
								style="" required="required">
						</div>
						<div class="form-group col-md-2">
							<label for="usr_dni">DNI</label> <input type="text" pattern="\d*"
								maxlength="8" class="form-control" id="usr_dni" name="usr_dni" required="required">
						</div>
					</div>
					<div class="row">
						<div class="form-group col-md-4">
							<label for="tipo_usr">Tipo de usuario</label> <select
								id="tipo_usr" name="tipo_usr" class="form-control" required="required">
								<c:forEach items="${VTipoUsrs}" var="item">
									<option value="${item.nombreTipoUsuario}">${item.nombreTipoUsuario}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<fieldset class="form-group">
						<div class="row">
							<legend class="col-form-label col-sm-2 pt-0">Sexo</legend>
							<div class="col-sm-10">
								<div class="form-check">
									<input class="form-check-input" type="radio" name="sex" id="m"
										value="Masculino" checked> <label
										class="form-check-label" for="gridRadios1"> Masulino </label>
								</div>
								<div class="form-check">
									<input class="form-check-input" type="radio" name="sex" id="f"
										value="Femenino"> <label class="form-check-label"
										for="gridRadios2"> Femenino </label>
								</div>
							</div>
						</div>
					</fieldset>
					<button type="submit" class="btn btn-primary">Guardar</button>
				</form>

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