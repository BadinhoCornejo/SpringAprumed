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
<title>Editar usuario</title>
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
.hide {
	display: none;
}

form {
	display: flex;
	flex-direction: column;
	align-items: center;
	justify-content: center;
	align-items: center;
}

form div {
	width: 200px;
	height: 100px;
}

form label {
	margin-right: 10px;
	display: flex !important;
}

.form-check {
	height: 20px !important;
	width: 20px !important;
}

.row {
	width: 20em;
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
				<h1>Editar usuario</h1>

				<div class="card text-center">
					<div class="card-header">
						<ul class="nav nav-tabs card-header-tabs">
							<li class="nav-item"><a class="nav-link active"
								id="userLink" href="#">Usuario</a></li>
							<li class="nav-item"><a class="nav-link" id="accLink"
								href="#">Cuenta</a></li>
						</ul>
					</div>
					<div class="card-body" id="editUser">
						<h5 class="card-title">Editar usuario</h5>
						<form action="${urlRoot}/usuarios/editUser" method="post">
							<div class="row">
								<div class="form-group row">
									<label for="usr_apellido">Apellido</label> <input type="text"
										class="form-control" id="usr_apellido" name="usr_apellido"
										placeholder="Apellido" value="${user.apellido}"
										required="required">
								</div>
							</div>

							<div class="row">
								<div class="form-group row">
									<label for="usr_nombre">Nombre</label> <input type="text"
										class="form-control" id="usr_nombre" name="usr_nombre"
										placeholder="Nombre" value="${user.nombre}"
										required="required">
								</div>
							</div>

							<div class="row">
								<div class="form-group row">
									<label for="usr_phone">Teléfono</label> <input type="text"
										pattern="\d*" maxlength="9" class="form-control"
										id="usr_phone" name="usr_phone" value="${user.telefono}"
										required="required">
								</div>

							</div>
							<div class="row">
								<div class="form-group row">
									<label for="usr_dni">DNI</label> <input type="text"
										pattern="\d*" maxlength="8" class="form-control" id="usr_dni"
										name="usr_dni" value="${user.dni}" required="required">
								</div>
							</div>
							<div class="row">
								<div class="form-group row">
									<label for="tipo_usr">Tipo de usuario</label> <select
										id="tipo_usr" name="tipo_usr" class="form-control"
										required="required">
										<c:forEach items="${VTipoUsrs}" var="item">
											<option value="${item.nombreTipoUsuario}">${item.nombreTipoUsuario}</option>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="row ml-2">
								<fieldset class="form-group">

									<label class="col-form-label" style="margin-left: -11px;">Sexo</label>
									<div class="col-sm-4">
										<div class="form-check">
											<input class="form-check-input" type="radio" name="sex"
												id="m" value="Masculino" checked> <label
												class="form-check-label" for="gridRadios1"> Masulino
											</label>
										</div>
										<div class="form-check">
											<input class="form-check-input" type="radio" name="sex"
												id="f" value="Femenino"> <label
												class="form-check-label" for="gridRadios2"> Femenino
											</label>
										</div>

									</div>
								</fieldset>
							</div>
							<button type="submit" class="btn btn-primary">Guardar</button>
						</form>
					</div>
					<div class="card-body hide" id="editAcc">
						<h5 class="card-title">Editar cuenta</h5>
						<form action="${urlRoot}/usuarios/editAccount" method="post">
							<div class="row">
								<div class="form-group col-12">
									<label for="acc_email">Email</label> <input type="email"
										class="form-control" id="acc_email" name="acc_email"
										placeholder="Email" value="${acc.email}" required="required">
								</div>
							</div>
							<div class="row">
								<div class="form-group col-12">
									<label for="acc_password">Contraseña</label> <input
										type="password" class="form-control" id="acc_password"
										name="acc_password" value="${acc.usrPassword}"
										placeholder="password" required="required">
								</div>
							</div>
							<div class="row ml-4">
								<fieldset class="form-group">

									<label class="col-form-label">Estado</label>
									<div class="col-sm-4">
										<div class="form-check">
											<input class="form-check-input" type="radio" name="estado"
												id="a" value="Activo" checked> <label
												class="form-check-label" for="estatus"> Activo </label>
										</div>
										<div class="form-check">
											<input class="form-check-input" type="radio" name="estado"
												id="i" value="Inactivo"> <label
												class="form-check-label" for="estatus"> Inactivo </label>
										</div>
									</div>

								</fieldset>
							</div>
							<input type="hidden" name="usr_dni" value="${user.dni}">

							<button type="submit" class="btn btn-primary">Guardar</button>
						</form>
					</div>
				</div>

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