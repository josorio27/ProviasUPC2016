<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s"  uri="/struts-tags"%>    
<!DOCTYPE html>
<html lang="en">
	<head>
		<title>Provias</title>
		<meta charset="utf-8">
			<link rel="stylesheet" href="css/reset.css" type="text/css" media="screen">
			<link rel="stylesheet" href="css/style.css" type="text/css" media="screen">
			<link rel="stylesheet" href="css/grid.css" type="text/css" media="screen">
			<link href="css/estilos.css" type=text/css rel=stylesheet>
			<script src="js/jquery-1.6.3.min.js" type="text/javascript"></script>
			<script src="js/cufon-yui.js" type="text/javascript"></script>
			<script src="js/cufon-replace.js" type="text/javascript"></script>
			<script src="js/Mate_400.font.js" type="text/javascript"></script>
			<script src="js/FF-cash.js" type="text/javascript"></script>
			<script src="js/tms-0.3.js" type="text/javascript"></script>
			<script src="js/tms_presets.js" type="text/javascript"></script>
			<script src="js/jquery.easing.1.3.js" type="text/javascript"></script>
			<style type="text/css">
		
					.msg {
						background-color:#FFCCCC;
						border:1px solid #CC0000;
						width:400px;
						margin-bottom:8px;
						
						}
					.msg li{ 
						list-style: none; 
						}
					</style>
  	  	 <script type="text/javascript">
  	  	 
            
             function inicializar(){ 
                 document.getElementById("nroSolicitud").focus(); 
                
             } 
         </script>
	</head>
	<body onload="inicializar();">
		<div class="extra">
			<div class="main">
<!--==============================header=================================-->
				<header>
					<div class="wrapper p4">
						<h1><a href="index.jsp">Software</a></h1>
						<s:url action="cerrarSesion" var="vcerrarSesion"/>
						 <p align="right"><s:a href="%{vcerrarSesion}" ><s:text name="Idioma.CerrarSesion"></s:text></s:a>
<!-- 						 <table align="right"> -->
<!-- 						 <tr> -->
<%-- 						 <td><b><s:text name="Idioma.Usuario"></s:text>:</b>  <s:text name="usuario.username"></s:text></td> --%>
<!-- 						 </tr> -->
<!-- 						 <tr> -->
<%-- 						 <td><b><s:text name="Idioma.Perfil"></s:text>:</b>  <s:text name="usuario.descripcion"></s:text></td> --%>
<!-- 						 </tr> -->
<!-- 						 </table> -->
								<s:url id="idiomaEn" action="idiomaActualizar">
									<s:param name="request_locale">en</s:param>
								</s:url>	
								<s:url id="idiomaFr" action="idiomaActualizar">
									<s:param name="request_locale">fr</s:param>
								</s:url>
								<s:url id="idiomaEs" action="idiomaActualizar">
									<s:param name="request_locale">es</s:param>
								</s:url>							

						<ul class="list-services">
							<li><s:a href="%{idiomaEn}"><img src="images/Gran-Bretana.gif" width="40" height="28"></s:a></li>
							<li><s:a href="%{idiomaFr}"><img src="images/Francia.gif" width="40" height="28"></s:a></li>
							<li><s:a href="%{idiomaEs}"><img src="images/Peru.gif" width="40" height="28"></s:a></li>
							
						</ul>
					</div>
				
					<nav>
						<ul class="menu">
								<li class="active">
								<s:url action="menuInicio"	var="vmenuInicio"/>
								<s:url action="menuRegistrar"	var="vmenuRegistrar"/>
								<s:url action="menuConsultar"	var="vmenuConsultar"/> 
								<s:url action="menuActualizar"	var="vmenuActualizar"/> 
								<s:url action="menuModificar"	var="vmenuModificar"/>
								<s:url action="menuMantenimiento"	var="vmenuMantenimiento"/>    
								
								<li><s:a href="%{vmenuInicio}"><s:text name="Idioma.Inicio"/></s:a></li>
								<li><s:a href="%{vmenuRegistrar}"><s:text name="Idioma.RegistrarSolicitud"/></s:a></li>
								<li><s:a href="%{vmenuConsultar}"><s:text name="Idioma.Consultar"/></s:a></li>
								<li><s:a href="%{vmenuActualizar}"><s:text name="Idioma.Actualizar"/></s:a></li>
								<li><s:a href="%{vmenuModificar}"><s:text name="Idioma.Modificar"/></s:a></li>
								<li><s:a href="%{vmenuMantenimiento}"><s:text name="Idioma.Mantenimiento"/></s:a></li>
						</ul>
					</nav>
				</header>
								
<!--==============================content=================================-->				
	<div class="wrapper">
		<div class="extra-wrap">
			<div class="indent">	
	<b><s:text name="Idioma.MantenimientoUsuario"></s:text></b>
	<p>
<s:form action="buscarUsuarios">

	<s:textfield name="usuario.nombres" key="Idioma.nombres"/>
	<s:submit value="Buscar"/>
	
	<s:if test="hasActionErrors()" >
	<div class="msg">
	<s:actionerror />
   	</div>
   	</s:if>
</s:form>

<!-- link para registro -->

<s:url action="nuevoUsuario" var="vnuevo"/> 

<s:a href="%{vnuevo}"><img src="images/nuevo.png"></s:a>


<!-- listado -->
<s:if test="usuarios.size>0">
	<table class="tabla">
		<thead>
			<tr>
				<th>User Name</th>
				<th>Nombres</th>
				<th>Apellidos</th>
				<th>Actualizar</th>
				<th>Eliminar</th>
				<th>Ver Detalle</th>
			</tr>
		</thead>
		<s:iterator value="usuarios">	
			<tr>
			 <td><s:property value="username"/>	</td>
			 <td><s:property value="nombres"/>	</td>
			 <td><s:property value="apellidos"/>	</td>

			 <td>
			 		<s:url action="cargarUsuario"
			 			   id="actualizarUsuario">
			 			<s:param name="dni">
			 				<s:property value="dni"/>
			 			</s:param>
			 		</s:url>
			 		<s:a href="%{actualizarUsuario}"><div align="center"><img src="images/editar.png"></div></s:a>
			 </td>
			 <td>	
			 		<s:url action="eliminarUsuario"
			 			   id="eliminarUsuario">
			 			<s:param name="dni">
			 				<s:property value="dni"/>
			 			</s:param>
			 		</s:url>
			 		<s:a href="%{eliminarUsuario}"><div align="center"><img src="images/cancelar.png"></div></s:a>
			 </td>
			 <td>	
			 		<s:url action="verDetalleUsuario"
			 			   id="verDetalle">
			 			<s:param name="dni">
			 				<s:property value="dni"/>
			 			</s:param>
			 		</s:url>
			 		<s:a href="%{verDetalle}" >Detalle</s:a> 
			 </td>
			</tr>
		</s:iterator>
	</table>
</s:if>
					<p class="img-indent-bot">&nbsp;</p>
			</div>
		 </div>
	</div>
<!--==============================footer=================================-->
		<footer>
			<div class="main">
				<div class="inner">
					<p>Cibertec - <s:text name="Idioma.Todoslosderechosreservados"></s:text> &copy; 2013 </p>
				</div>
			</div>
		</footer>
		<script type="text/javascript"> Cufon.now(); </script>
		<script type="text/javascript">
			$(window).load(function() {
				$('.slider')._TMS({
					duration:800,
					easing:'easeOutQuad',
					preset:'simpleFade',
					slideshow:7000,
					banners:false,
					pauseOnHover:true,
					pagination:false,
					nextBu:'.next',
					prevBu:'.prev'
				});
			});
		</script>			
		</div>
	</div>
	</body>
</html>