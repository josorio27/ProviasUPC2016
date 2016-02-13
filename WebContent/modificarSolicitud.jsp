<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s"  uri="/struts-tags"%>   


<!DOCTYPE html>
<html lang="en">
	<head>
		<title>Provias</title>
		<meta charset="utf-8">
			<link rel="stylesheet" href="css/reset.css" type="text/css" media="screen">
			<link rel="stylesheet" href="css/style.css" type="text/css" media="screen">
			<link rel="stylesheet" href="css/grid.css" type="text/css" media="screen">
			<script src="js/jquery-1.6.3.min.js" type="text/javascript"></script>
			<script src="js/cufon-yui.js" type="text/javascript"></script>
			<script src="js/cufon-replace.js" type="text/javascript"></script>
			<script src="js/Mate_400.font.js" type="text/javascript"></script>
			<script src="js/FF-cash.js" type="text/javascript"></script>
			<script src="js/tms-0.3.js" type="text/javascript"></script>
			<script src="js/tms_presets.js" type="text/javascript"></script>
			<script src="js/jquery.easing.1.3.js" type="text/javascript"></script>
			
  	<script type="text/javascript">
            
             function inicializar(){ 
                 document.getElementById("nroSolicitud").focus(); 
                 var dni = document.getElementById("dni").value;
                 var direcc = document.getElementById("direccion").value;
                 var tel = document.getElementById("telefono").value;
                 var correo = document.getElementById("correoElectronico").value;
                 var matri = document.getElementById("matricula").value;
                 var peso = document.getElementById("peso").value;
                 var lon = document.getElementById("longitud").value;
                 var alt = document.getElementById("altura").value;
                document.getElementById("dniOculto").value = dni;
                document.getElementById("direccionOculto").value = direcc;
                document.getElementById("telefonoOculto").value =tel;
                document.getElementById("correoElectronicoOculto").value = correo;
                document.getElementById("matriculaOculto").value = matri;
                document.getElementById("pesoOculto").value = peso;
                document.getElementById("longitudOculto").value = lon;
                document.getElementById("alturaOculto").value = alt;
             } 
             
             
        	</script>
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
						 
						 
								<s:url id="idiomaEn" action="idiomaModificar">
									<s:param name="request_locale">en</s:param>
								</s:url>	
								<s:url id="idiomaFr" action="idiomaModificar">
									<s:param name="request_locale">fr</s:param>
								</s:url>
								<s:url id="idiomaEs" action="idiomaModificar">
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
				<s:form action="modificarSolicitud"  method="post" enctype="multipart/form-data">
						<table>
								
								<tr><td><s:textfield key="Idioma.NumerodeSolicitud"  maxlength="4" name="solicitud.nroSolicitud" id="nroSolicitud"></s:textfield></td></tr>
								<tr><td><b><s:submit value="%{getText('Idioma.Consultar')}" action="consultarSolicitudFullxNro"></s:submit></b> </td></tr>
								<tr>
								<td><b><s:text name="Idioma.DatosdelSolicitante"></s:text></b> </td>
								<tr><td><s:textfield key="Idioma.DNI"  maxlength="8" name="solicitud.dni" id="dni"  readonly="true"></s:textfield></td></tr>
								<tr><td><s:textfield key="Idioma.Nombre" name="solicitud.solicitante.nombre" readonly="true" id="nombre"></s:textfield></td></tr>
								<tr><td><s:textfield key="Idioma.ApellidoPaterno" name="solicitud.solicitante.apellidoPaterno" readonly="true" id="apellidoPaterno" size="30"></s:textfield></td></tr>
								<tr><td><s:textfield key="Idioma.ApellidoMaterno" name="solicitud.solicitante.apellidoMaterno" readonly="true" id="apellidoMaterno" size="30"></s:textfield></td></tr>
								<tr><td><s:textfield key="Idioma.FechadeNacimiento" name="solicitud.solicitante.fechaNacimiento" readonly="true" id="fechaNacimiento"></s:textfield></td></tr>
								<tr><td><s:textfield key="Idioma.Sexo" name="solicitud.solicitante.sexo" readonly="true" id="sexo"></s:textfield></td></tr>
								<tr><td><s:textfield key="Idioma.Direccion" name="solicitud.solicitante.direccion" id="direccion" size="30"></s:textfield></td></tr>
								<tr><td><s:textfield key="Idioma.Telefono" name="solicitud.solicitante.telefono" id="telefono"></s:textfield></td></tr>
								<tr><td><s:textfield key="Idioma.CorreoElectronico" name="solicitud.solicitante.correoElectronico" id="correoElectronico" size="30"></s:textfield></td></tr>
								<tr><th colspan="2"><HR width=100% align="left"></th></tr>
								<tr><td><b><s:text name="Idioma.DatosdelVehiculodecarga"></s:text></b></td></tr>
								<tr><td><s:textfield key="Idioma.Matricula" maxlength="15" name="solicitud.matricula" id="matricula" readonly="true"></s:textfield></td></tr>
								<tr><td><s:textfield key="Idioma.TitulardelVehiculo" name="solicitud.vehiculo.titular"  readonly="true" id="titular" size="30"></s:textfield></td></tr>
								<tr><td><s:textfield key="Idioma.Modelo" name="solicitud.vehiculo.modelo" id="modelo"></s:textfield></td></tr>
								<tr><td><s:file key="Idioma.AdjuntarCertificadodeRevisionTecnica" name="solicitud.revisionTecnica" id="revisionTecnica" size="70" ></s:file></td></tr>
								<tr><th colspan="2"><HR width=100% align="left"></th></tr>
								<tr><td><b><s:text name="Idioma.Dimensiones"></s:text></b></td></tr>
								<tr><td><s:textfield key="Idioma.Peso" name="solicitud.vehiculo.peso" id="peso"></s:textfield></td></tr>
								<tr><td><s:textfield key="Idioma.Longitud" name="solicitud.vehiculo.longitud" id="longitud"></s:textfield></td></tr>
								<tr><td><s:textfield key="Idioma.Altura" name="solicitud.vehiculo.altura"  id="altura"></s:textfield></td></tr>
								
								<s:hidden name="solicitante.dni" id="dniOculto"></s:hidden>
								<s:hidden name="solicitante.telefono" id="telefonoOculto"></s:hidden>
								<s:hidden name="solicitante.correoElectronico" id="correoElectronicoOculto"></s:hidden>
								<s:hidden name="solicitante.direccion" id="direccionOculto"></s:hidden>
								
								<s:hidden name="vehiculo.matricula" id="matriculaOculto"></s:hidden>
								<s:hidden name="vehiculo.altura" id="alturaOculto"></s:hidden>
								<s:hidden name="vehiculo.longitud" id="longitudOculto"></s:hidden>
								<s:hidden name="vehiculo.peso" id="pesoOculto"></s:hidden>
								
								<tr><th colspan="2"><s:submit value="%{getText('Idioma.Modificar')}"/></th></tr>
								<s:if test="hasActionMessages()" >
								 <div class="msg">
									<s:actionmessage/>
									<script type="text/javascript">
									 document.getElementById("nroSolicitud").value=""; 
									 document.getElementById("dni").value="";
					            	 document.getElementById("nombre").value="";
					            	 document.getElementById("apellidoPaterno").value="";
					            	 document.getElementById("apellidoMaterno").value="";
					            	 document.getElementById("fechaNacimiento").value="";
					            	 document.getElementById("sexo").value="";
					            	 document.getElementById("direccion").value="";
					            	 document.getElementById("telefono").value="";
					            	 document.getElementById("correoElectronico").value="";
					            	 document.getElementById("matricula").value="";
					            	 document.getElementById("titular").value="";
					            	 document.getElementById("modelo").value="";
					            	 document.getElementById("revisionTecnica").value="";
					            	 document.getElementById("peso").value="";
					            	 document.getElementById("longitud").value="";
					            	 document.getElementById("altura").value="";
					            	 document.getElementById("nroSolicitud").focus(); 
					            	 </script>
   								 </div>
   								 </s:if>
   								 <s:if test="hasActionErrors()" >
								 <div class="msg">
									<s:actionerror />
   								 </div>
   								 </s:if>
					</table>							
					</s:form>
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