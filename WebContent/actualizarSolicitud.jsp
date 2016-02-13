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
				<s:form action="actualizarSolicitud">
						<table>
								<tr><td><b><s:text name="Idioma.DatosdelSolicitante"></s:text></b></td></tr>
								<tr><td><s:textfield key="Idioma.NumerodeSolicitud" name="solicitud.nroSolicitud" id="nroSolicitud" maxlength="4" ></s:textfield></td></tr>
								<tr><th colspan="2"><s:submit value="%{getText('Idioma.Consultar')}"  action="consultarSolicitudporNroA" id="NroSolicitud"/></th></tr>
								<tr><td><s:textfield key="Idioma.DNI" name="solicitud.dni" id="dni" readonly="true"></s:textfield></td></tr>
								<tr><td><s:textfield key="Idioma.Matricula" name="solicitud.matricula" id="matricula" readonly="true"></s:textfield></td></tr>
								<s:combobox key="Idioma.EstadodelaSolicitud"
								headerKey="-1" headerValue="--- Todos ---"
								list="#{'1':'Pendiente', '2':'Aprobado', '3':'Rechazado', '4':'Cancelado'}" 
								name="solicitud.estado" id="estado"/>
								<s:checkbox name="checkMe" fieldValue="true" label="%{getText('Idioma.EnviarNotificacion')}"/>
										
								<tr><th colspan="2"><s:submit value="%{getText('Idioma.Actualizar')}"/></th></tr>
																			<s:if test="hasActionMessages()" >
								 <div class="msg">
									<s:actionmessage/>
									<script type="text/javascript">
									 document.getElementById("nroSolicitud").value="";
					            	 document.getElementById("dni").value="";
					            	 document.getElementById("matricula").value="";
					            	 document.getElementById("estado").value="";
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