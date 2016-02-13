$(document).ready(function(){
	$("#texto").html("");
	//el query debe tener la sgte estructura
	//insert into valores(descripcion,cod_categoria,cod_tipo_param) values(,,);
	for(var i=0;i<10;i++){
		//aqui los querys son del cod 1 y el tipo 3 por ende
		//la fecha debe tener el sgte formato 2012-05-05 año mes dia
		//el años sera entre 1998 y 2012
		//el mes entre 01 y 12
		//el dia entre 01 y 29
		var año=Math.round(Math.random()*16+1996);
		var mes=Math.round(Math.random()*11+1);
		var dia=Math.round(Math.random()*21+1);
		if(mes<10){
			mes="0"+mes;
		}
		if(dia<10){
			dia="0"+dia;
		}
		var query="insert into valores(descripcion,cod_categoria,cod_tipo_parametro) values('"+año+"-"+mes+"-"+dia
		+"',"+1+","+3+");"+"<br>";
		$("#texto").append(query);
		
	}
	var aNombre=["Daniel","Juan","Adrian","Marc","Alejandro","José","David","Diego","Ángel","Pablo","Federico","Andrey","Diana"];
	for(var i=0;i<13;i++){
		var query="insert into valores(descripcion,cod_categoria,cod_tipo_parametro) values('"+aNombre[i]
		+"',"+2+","+2+");"+"<br>";
		$("#texto").append(query);
	}
	 var aApellidos=["Flores","Quispe","Sanchez","Rodriguez","García","Rojas","Gonzales","Chavez","Diaz","Lopez","Ramos","Ramirez","Torres","Castillo","Guzman"];
	for(var i=0;i<15;i++){
		var query="insert into valores(descripcion,cod_categoria,cod_tipo_parametro) values('"+aApellidos[i]
		+"',"+3+","+2+");"+"<br>";
		$("#texto").append(query);
	}
	$("#texto").append("insert into valores(descripcion,cod_categoria,cod_tipo_parametro) values('ninguno',"+5+","+2+");"+"<br>");
	for(var i=0;i<15;i++){
		//generando aleatorio de talla entre 1 y 2m
		var talla=Math.round((Math.random()*0.5+1.5)*10)/10;
		var query="insert into valores(descripcion,cod_categoria,cod_tipo_parametro) values("+talla
		+","+6+","+4+");"+"<br>";
		$("#texto").append(query);
	}
	for(var i=0;i<15;i++){
		//generando aleatorio de talla entre 1 y 2m
		var peso=Math.round((Math.random()*25+50)*10)/10;
		var query="insert into valores(descripcion,cod_categoria,cod_tipo_parametro) values("+peso
		+","+7+","+4+");"+"<br>";
		$("#texto").append(query);
	}
	var stock=[200,250,300,350,400,450,500];
	for(var i=0;i<15;i++){
		//generando aleatorio de talla entre 1 y 2m
		var c=Math.round((Math.random()*6));
		var query="insert into valores(descripcion,cod_categoria,cod_tipo_parametro) values("+stock[c]
		+","+8+","+1+");"+"<br>";
		$("#texto").append(query);
	}
	//var aApellidos=["Flores","Quispe","Sanchez","Rodriguez","García","Rojas","Gonzales","Chavez","Diaz","Lopez","Ramos","Ramirez","Torres","Castillo","Guzman"];
	var letras=['a','b','c','d','e','f','g','h','i','j','k'];
	for(var i=0;i<15;i++){
		//generando aleatorio de talla entre 1 y 2m
		var c=Math.round((Math.random()*13))+1;
		var d=Math.round((Math.random()*9))+1;
		var letra=letras[d];
		var apellido=aApellidos[c];
		var query="insert into valores(descripcion,cod_categoria,cod_tipo_parametro) values('"+letra
		+apellido+"',"+9+","+2+");"+"<br>";
		
		var query2="insert into valores(descripcion,cod_categoria,cod_tipo_parametro) values('"+letra
		+apellido+"',"+10+","+2+");"+"<br>";
		$("#texto").append(query).append(query2);
	}
});
