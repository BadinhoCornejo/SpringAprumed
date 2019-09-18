<nav class="navbar navbar-expand-lg navbar-light bg-light">

	<i id="sidebarCollapse" class="fas fa-align-left"></i>

	<form action="../ventas/buscarLibro" method="post"
		class="form-inline mt-1">
		<input class="form-control mr-sm-2" type="search"
			placeholder="Buscar libros" aria-label="Search" name="parameter">
		<button class="btn btn-outline-primary my-2 my-sm-0" type="submit">
			<i class="fas fa-search"></i>
		</button>
	</form>

	<div class="collapse navbar-collapse justify-content-end"
		id="navbarSupportedContent">
		<ul class="navbar-nav">
			<li class="nav-item active"><a class="nav-link"
				href="/SpringAprumed/dashboard/">Inicio <span class="sr-only">(current)</span>
			</a></li>
			<div class="vr">&nbsp</div>
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
				role="button" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false"> <i class="fas fa-user mr-2"></i> Perfil<i
					class="fas fa-chevron-down"></i>
			</a>
				<div class="dropdown-menu dropdown-menu-right"
					aria-labelledby="navbarDropdown">
					<a class="dropdown-item" href="#">Action</a> <a
						class="dropdown-item" href="#">Another action</a>
					<div class="dropdown-divider"></div>
					<a class="dropdown-item" href="#">Something else here</a>
				</div></li>
		</ul>

	</div>

</nav>