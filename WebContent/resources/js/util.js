const collapse = document.getElementById("sidebarCollapse");
const sidebar = document.getElementById("sidebar");

//Cuando se hace click en el boton
collapse.addEventListener("click",()=>{
		
	if(sidebar.classList.contains("active")){
		sidebar.classList.remove("active");
		sidebar.classList.remove("hover");
	}
	else if(sidebar.classList.contains("hover"))
	{
		sidebar.classList.remove("active");
		sidebar.classList.remove("hover");
	}
	else
	{
		sidebar.classList.add("active");
		sidebar.classList.remove("hover");
	}
		
})

//Cuando se enfoca a la barra
sidebar.addEventListener("mouseenter",()=>{
	if(sidebar.classList.contains("active")){
		sidebar.classList.remove("active");
		sidebar.classList.add("hover");
	}
},false)


sidebar.addEventListener("mouseleave",()=>{
	if(sidebar.classList.contains("hover")){
	sidebar.classList.remove("hover");
	sidebar.classList.add("active");
	}
},false)


//Cuando cambia de tamaño la pantalla
window.addEventListener("resize", ()=>{
   if(window.innerWidth < 768){
	   if(!sidebar.classList.contains("active")){
			sidebar.classList.add("active");
		}
   }
});