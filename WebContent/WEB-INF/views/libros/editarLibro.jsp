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
<title>Editar libro</title>
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
<link rel="stylesheet"
	href="${urlPublic}/Datepicker/dist/css/bootstrap-datepicker.min.css">
<style type="text/css">
.fa-calendar-week {
	font-size: 1.5em;
	padding: 4px 4px 4px 4px;
}

.fa-calendar-week:hover {
	cursor: pointer;
	color: #5D78FF;
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
				<h1>Editar libro</h1>

				<form action="${urlRoot}libros/editLibro" method="post">
					<div class="row">
						<div class="form-group col-md-5">
							<label for="lbr_autor">Autor</label> <input type="text"
								class="form-control" id="lbr_autor" name="lbr_autor"
								placeholder="Autor" required="required" value="${libro.autor}">
						</div>

					</div>

					<div class="row">
						<div class="form-group col-md-5">
							<label for="lbr_titulo">Titulo</label> <input type="text"
								class="form-control" id="lbr_titulo" name="lbr_titulo"
								placeholder="Titulo" required="required" value="${libro.titulo}">
						</div>

					</div>

					<div class="form-row">
						<div class="form-group col-md-2">
							<label for="lbr_isbn">ISBN</label> <input type="text"
								pattern="\d*" maxlength="13" class="form-control" id="lbr_isbn"
								name="lbr_isbn" required="required" value="${libro.isbn}">
						</div>
						<div class="form-group col-md-3">
							<label for="lbr_date">Fecha de publicación</label>
							<div id="sandbox-container">
								<div class="input-group date">
									<input size="16" type="text" class="form-control" id="lbr_date"
										name="lbr_date" required="required" readonly="readonly"
										value="${libro.fechaPublicacion}"> <span
										class="input-group-addon"><i
										class="fas fa-calendar-week"></i></span>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group col-md-4">
							<label for="lbr_cat">Categoria</label> <select id="lbr_cat"
								name="lbr_cat" class="form-control" required="required">
								<c:forEach items="${VCategorias}" var="item">
									<option value="${item.nombreCategoria}">${item.nombreCategoria}</option>
								</c:forEach>
							</select>
						</div>
						<div class="form-group col-sm-1">
							<label for="lbr_titulo">Precio</label> <input type="number"
								step="any" class="form-control" id="lbr_precio"
								name="lbr_precio" placeholder="S/." required="required"
								value="${libro.precio}">
						</div>
					</div>

					<fieldset class="form-group">
						<div class="row">
							<label class="col-form-label">Estado</label>
							<div class="col-sm-4">
								<div class="form-check">
									<input class="form-check-input" type="radio" name="estado"
										id="activo" value="Activo" checked> <label
										class="form-check-label" for="gridRadios1"> Activo </label>
								</div>
								<div class="form-check">
									<input class="form-check-input" type="radio" name="estado"
										id="inactivo" value="Inactivo"> <label
										class="form-check-label" for="gridRadios2"> Inactivo </label>
								</div>
							</div>
						</div>
					</fieldset>

					<input type="hidden" name="id" value="${libro.libroID}">

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
	<script type="text/javascript"
		src="${urlPublic}/Datepicker/dist/js/bootstrap-datepicker.min.js"></script>

	<script type="text/javascript">
		$('#sandbox-container .input-group.date').datepicker({
			format : "yyyy-mm-dd"
		});
	</script>
</body>
</html>