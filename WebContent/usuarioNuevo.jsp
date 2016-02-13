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
			
			  <link rel="stylesheet" href="css/jquery-ui-1.10.0.custom.css" />
			  <script src="js/jquery-1.9.0.js" type="text/javascript"></script>
			  <script src="http://code.jquery.com/jquery-1.8.3.js"></script>
			  <script src="js/jquery-ui-1.10.0.custom.js"></script>
			  
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
                 document.getElementById("dni").focus(); 
                
             } 
         </script>
         
         <script>
		  $(function() {
			  $("#datepicker").datepicker();
			  $("#datepicker").datepicker("option", {dateFormat: "dd/mm/yy"});
			  });
			  $("#startDate").datepicker({dateFormat: "dd/mm/yy"});

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
			
			<s:form action="saveUsuario"
					method="post">	
					<s:a href="usuarioListado.jsp"><img src="images/regresar.png"></s:a>
				<p>
				<s:textfield name="usuario.dni" key="Idioma.dni" id="dni" maxlength="8" />
				<s:textfield name="usuario.username" key="Idioma.username" id="username"/>
				<s:password name="usuario.password" key="Password" id="password"/>
				<s:textfield name="usuario.nombres" key="Idioma.nombres" id="nombres"/> 
				<s:textfield name="usuario.apellidos" key="Idioma.apellidos" id="apellidos"/>
				<s:textfield name="usuario.fechaNacimiento" key="Idioma.fechaNacimiento" type="text" id="datepicker" readonly="true" />
				<s:textfield name="usuario.correoElectronico" key="Idioma.correoElectronico" id="correoElectronico"/>
						
				<s:select list="#{'1':'Soltero', 
									'2':'Casado',
									'3':'Viudo',
									'4':'Divorciado'}"
								name="usuario.estadoCivil.codigo" key="Idioma.estadoCivil"/>
			
				<s:select list="#{  '1':'Cercado de Lima',
									'2':'Ate',
									'3':'Barranco',
									'4':'Breña',
									'5':'Comas',
									'6':'Chorrillos',
									'7':'El Agustino',
									'8':'Jesús María',
									'9':'La Molina',
									'10':'La Victoria',
									'11':'Lince',
									'12':'Magdalena del Mar',
									'13':'Miraflores',
									'14':'Pueblo Libre',
									'15':'Puente Piedra',
									'16':'Rimac',
									'17':'San Isidro',
									'18':'Independencia',
									'19':'San Juan de Miraflores',
									'20':'San Luis',
									'21':'San Martin de Porres',
									'22':'San Miguel',
									'23':'Santiago de Surco',
									'24':'Surquillo',
									'25':'Villa María del Triunfo',
									'26':'San Juan de Lurigancho',
									'27':'Santa Rosa',
									'28':'Los Olivos',
									'29':'San Borja',
									'30':'Villa El Savador',
									'31':'Santa Anita'}"
								name="usuario.distrito.codigo" key="Idioma.distrito"/>
								
				<s:select list="#{'1':'Administrador', 
									'2':'Solicitante',
									'3':'Consultor',
									'4':'Aprobador'}"
								name="usuario.tipoUsuario.tipo" key="Idioma.tipo"/>								
				
				<s:submit value="%{getText('Idioma.Grabar')}"/>
									<s:if test="hasActionMessages()" >
								 <div class="msg">
									<s:actionmessage/>
									<script type="text/javascript">
									 document.getElementById("dni").value="";
					            	 document.getElementById("username").value="";
					            	 document.getElementById("nombres").value="";
					            	 document.getElementById("password").value="";
					            	 document.getElementById("apellidos").value="";
					            	 document.getElementById("datepicker").value="";
					            	 document.getElementById("correoElectronico").value="";
					            	 document.getElementById("dni").focus();

					            	 </script>
   								 </div>
   								 </s:if>
   								 <s:if test="hasActionErrors()" >
								 <div class="msg">
									<s:actionerror />
   								 </div>
   								 </s:if>
				
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