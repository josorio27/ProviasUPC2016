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
       	 
                 document.getElementById("dni").focus(); 
                 var a = document.getElementById("dni").value;
                 var b = document.getElementById("matricula").value;
                document.getElementById("dniOculto").value = a;
                document.getElementById("matriculaOculto").value = b;
                
             } 
             
// -            function ValidarDni(target, e) { 
//             	var tecla = (document.all) ? e.keyCode : e.which; 
//            	 	var dni=document.getElementById("dni").value ; 
//                		if(dni.length==0 || dni.length < 8 ){
//                        	document.getElementById("dni").focus();
//                 			document.getElementById("mensajeError").innerHTML='<p style="color: red; font-weight: bold">Ingrese el número de DNI correctamente</p>'; 
//                 			return false;                		
// 	        		}else{ 
//          				document.getElementById("mensajeError").innerHTML='<p class="subtitle"> </p>';
//         				document.getElementById("matricula").focus(); 
//             			}    
				 
//            	tecla=String.fromCharCode(tecla); 
//                 if (/^([0-9])*$/.test(tecla)){ 
//               	return true; 
//                  }else return false; 
//          	}      
            
              
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
<!-- 						 <div align="right"><table > -->
<!-- 						 <tr> -->
<%-- 						 <td><b><s:text name="Idioma.Usuario"></s:text>:</b>  <s:text name="usuario.username"></s:text></td> --%>
<!-- 						 </tr> -->
<!-- 						 <tr> -->
<%-- 						 <td><b><s:text name="Idioma.Perfil"></s:text>:</b>  <s:text name="usuario.descripcion"></s:text></td> --%>
<!-- 						 </tr> -->
<!-- 						 </table> -->
<!-- 						 </div> -->
						 
								<s:url id="idiomaEn" action="idiomaRegistrar">
									<s:param name="request_locale">en</s:param>
								</s:url>	
								<s:url id="idiomaFr" action="idiomaRegistrar">
									<s:param name="request_locale">fr</s:param>
								</s:url>
								<s:url id="idiomaEs" action="idiomaRegistrar">
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
				<s:form action="registrarSolicitud"  method="post" enctype="multipart/form-data">
						<table>
								<tr>
								<td><b><s:text name="Idioma.DatosdelSolicitante"></s:text></b> </td>
<%-- 								<tr><td><s:textfield key="Idioma.NumerodeSolicitud" name="numSolicitud" ></s:textfield></td></tr> --%>
								<tr><td><s:textfield key="Idioma.DNI"  maxlength="8" name="solicitante.dni" id="dni" ></s:textfield></td></tr>
								<tr><td><b><s:submit value="%{getText('Idioma.ConsultarDni')}" action="consultarSolicitante"></s:submit></b> </td></tr>
								<tr><td><s:textfield key="Idioma.Nombre" name="solicitante.nombre" readonly="true" id="nombre"></s:textfield></td></tr>
								<tr><td><s:textfield key="Idioma.ApellidoPaterno" name="solicitante.apellidoPaterno" readonly="true" id="apellidoPaterno" size="30"></s:textfield></td></tr>
								<tr><td><s:textfield key="Idioma.ApellidoMaterno" name="solicitante.apellidoMaterno" readonly="true" id="apellidoMaterno" size="30"></s:textfield></td></tr>
								<tr><td><s:textfield key="Idioma.FechadeNacimiento" name="solicitante.fechaNacimiento" readonly="true" id="fechaNacimiento" ></s:textfield></td></tr>
								<tr><td><s:textfield key="Idioma.Sexo" name="solicitante.sexo" readonly="true" id="sexo" ></s:textfield></td></tr>
								
								<tr><td><s:textfield key="Idioma.Direccion" name="solicitante.direccion" id="direccion" size="30"></s:textfield></td></tr>
								<tr><td><s:textfield key="Idioma.Telefono" name="solicitante.telefono" id="telefono"></s:textfield></td></tr>
								<tr><td><s:textfield key="Idioma.CorreoElectronico" name="solicitante.correoElectronico" id="correoElectronico" size="30"></s:textfield></td></tr>
								<tr><th colspan="2"><HR width=100% align="left"></th></tr>
								<tr><td><b><s:text name="Idioma.DatosdelVehiculodecarga"></s:text></b></td></tr>
								<tr><td><s:textfield key="Idioma.Matricula" maxlength="15" name="vehiculo.matricula" id="matricula" ></s:textfield></td></tr>
								<tr><td><b><s:submit value="%{getText('Idioma.ConsultarMatricula')}" action="consultarVehiculo"></s:submit></b> </td></tr>
								<tr><td><s:textfield key="Idioma.TitulardelVehiculo" name="vehiculo.titular"  readonly="true" id="titular" size="30"></s:textfield></td></tr>
								<tr><td><s:textfield key="Idioma.Modelo" name="vehiculo.modelo" readonly="true" id="modelo"></s:textfield></td></tr>
								<tr><td><s:file key="Idioma.AdjuntarCertificadodeRevisionTecnica" name="solicitud.revisionTecnica" id="revisionTecnica" size="70" ></s:file></td></tr>
								<tr><th colspan="2"><HR width=100% align="left"></th></tr>
								<tr><td><b><s:text name="Idioma.Dimensiones"></s:text></b></td></tr>
								<tr><td><s:textfield key="Idioma.Peso" name="vehiculo.peso" readonly="true" id="peso"></s:textfield></td></tr>
								<tr><td><s:textfield key="Idioma.Longitud" name="vehiculo.longitud"  readonly="true" id="longitud"></s:textfield></td></tr>
								<tr><td><s:textfield key="Idioma.Altura" name="vehiculo.altura"  readonly="true" id="altura"></s:textfield></td></tr>
								
								<s:hidden name="solicitud.dni" id="dniOculto"></s:hidden>
								<s:hidden name="solicitud.matricula" id="matriculaOculto"></s:hidden>
<%-- 								<s:hidden name="solicitante.direccion" id="direccionOculto"></s:hidden> --%>
<%-- 								<s:hidden name="solicitante.telefono" id="telefonoOculto"></s:hidden> --%>
<%-- 								<s:hidden name="solicitante.correoElectronico" id="correoElectronicoOculto"></s:hidden> --%>
								<tr><th colspan="2"><s:submit value="%{getText('Idioma.Guardar')}"/></th></tr>
								<s:if test="hasActionMessages()" >
								 <div class="msg">
									<s:actionmessage/>
									<script type="text/javascript">
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