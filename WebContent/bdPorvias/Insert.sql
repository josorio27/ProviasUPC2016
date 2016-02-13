-- -----------------------------------------------------
-- Insert `bd_provias`.`tb_usuario`
-- -----------------------------------------------------
INSERT INTO `bd_provias`.`tb_usuario` (`dni`, `username`, `password`, `nombres`, `apellidos`, `fechaNacimiento`, `estadoCivil`, `distrito`, `correoElectronico`, `tipo`) VALUES ('43873005', 'gbardalez', '123', 'Guillermo', 'Bardalez Chavarry', '26/11/1986', '2', '1', 'gbchavarry@gmail.com', '1');
INSERT INTO `bd_provias`.`tb_usuario` (`dni`, `username`, `password`, `nombres`, `apellidos`, `fechaNacimiento`, `estadoCivil`, `distrito`, `correoElectronico`, `tipo`) VALUES ('11111111', 'lcarbonel', '123', 'Lina', 'Carbonel', '20/10/1984', '1', '2', 'cynthia.carbonelarce@gmail.com', '2');
INSERT INTO `bd_provias`.`tb_usuario` (`dni`, `username`, `password`, `nombres`, `apellidos`, `fechaNacimiento`, `estadoCivil`, `distrito`, `correoElectronico`, `tipo`) VALUES ('22222222', 'mviru', '123', 'Miguel', 'Viru', '10/09/1985', '2', '3', 'virumiguel@gmail.com', '3');
INSERT INTO `bd_provias`.`tb_usuario` (`dni`, `username`, `password`, `nombres`, `apellidos`, `fechaNacimiento`, `estadoCivil`, `distrito`, `correoElectronico`, `tipo`) VALUES ('33333333', 'alevano', '123', 'Anthony', 'Levano', '01/03/1988', '1', '4', 'dos_jarras@hotmail.com', '4');
-- -----------------------------------------------------
-- Insert `bd_provias`.`tb_tipoUsuario`
-- -----------------------------------------------------
INSERT INTO `bd_provias`.`tb_tipoUsuario` (`tipo`, `descripcion`) VALUES ('1', 'Administrador');
INSERT INTO `bd_provias`.`tb_tipoUsuario` (`tipo`, `descripcion`) VALUES ('2', 'Solicitante');
INSERT INTO `bd_provias`.`tb_tipoUsuario` (`tipo`, `descripcion`) VALUES ('3', 'Consultor');
INSERT INTO `bd_provias`.`tb_tipoUsuario` (`tipo`, `descripcion`) VALUES ('4', 'Aprobador');
-- -----------------------------------------------------
-- Insert `bd_provias`.`tb_solicitante`
-- -----------------------------------------------------
INSERT INTO `bd_provias`.`tb_solicitante` (`dni`, `nombre`, `apellidoPaterno`, `apellidoMaterno`, `fechaNacimiento`, `sexo`, `direccion`, `telefono`, `correoElectronico`) VALUES ('43873005', 'Guillermo', 'Bardalez', 'Chavarry', '26-11-1986', 'Masculino', '', '', '');
INSERT INTO `bd_provias`.`tb_solicitante` (`dni`, `nombre`, `apellidoPaterno`, `apellidoMaterno`, `fechaNacimiento`, `sexo`, `direccion`, `telefono`, `correoElectronico`) VALUES ('45566880', 'Alvaro', 'Mondragon', 'Valdivia', '10-04-1985', 'Masculino', '', '', '');
INSERT INTO `bd_provias`.`tb_solicitante` (`dni`, `nombre`, `apellidoPaterno`, `apellidoMaterno`, `fechaNacimiento`, `sexo`, `direccion`, `telefono`, `correoElectronico`) VALUES ('45236988', 'Claudia', 'Romero', 'Vildoso', '10-10-1980', 'Femenino', '', '', '');
INSERT INTO `bd_provias`.`tb_solicitante` (`dni`, `nombre`, `apellidoPaterno`, `apellidoMaterno`, `fechaNacimiento`, `sexo`, `direccion`, `telefono`, `correoElectronico`) VALUES ('12345678', 'Ricardo', 'Quispe', 'Quispe', '10-04-1985', 'Masculino', '', '', '');
INSERT INTO `bd_provias`.`tb_solicitante` (`dni`, `nombre`, `apellidoPaterno`, `apellidoMaterno`, `fechaNacimiento`, `sexo`, `direccion`, `telefono`, `correoElectronico`) VALUES ('87654321', 'Miguel', 'Viru', 'Viru', '10-10-1980', 'Masculino', '', '', '');
-- -----------------------------------------------------
-- Insert `bd_provias`.`tb_vehiculo`
-- -----------------------------------------------------
INSERT INTO `bd_provias`.`tb_vehiculo` (`matricula`, `titular`, `modelo`, `peso`, `longitud`, `altura`) VALUES ('ABC123', 'Pedrito Martinez', 'Ford', '70', '20', '3');
INSERT INTO `bd_provias`.`tb_vehiculo` (`matricula`, `titular`, `modelo`, `peso`, `longitud`, `altura`) VALUES ('XYZ123', 'Angie Lozano', 'Scania', '71', '21', '3');
INSERT INTO `bd_provias`.`tb_vehiculo` (`matricula`, `titular`, `modelo`, `peso`, `longitud`, `altura`) VALUES ('AAA123', 'Juan perez', 'Ford', '78', '20', '4');
INSERT INTO `bd_provias`.`tb_vehiculo` (`matricula`, `titular`, `modelo`, `peso`, `longitud`, `altura`) VALUES ('EEE123', 'Victor Lurita', 'Scania', '75', '23', '3');
INSERT INTO `bd_provias`.`tb_vehiculo` (`matricula`, `titular`, `modelo`, `peso`, `longitud`, `altura`) VALUES ('III123', 'Marco Chavarry', 'Ford', '72', '18', '5');
-- -----------------------------------------------------
-- Insert `bd_provias`.`tb_estado`
-- -----------------------------------------------------
INSERT INTO `bd_provias`.`tb_estado` (`estado`, `descripcion`) VALUES ('1', 'Pendiente');
INSERT INTO `bd_provias`.`tb_estado` (`estado`, `descripcion`) VALUES ('2', 'Aprobado');
INSERT INTO `bd_provias`.`tb_estado` (`estado`, `descripcion`) VALUES ('3', 'Rechazado');
INSERT INTO `bd_provias`.`tb_estado` (`estado`, `descripcion`) VALUES ('4', 'Cancelado');
INSERT INTO `bd_provias`.`tb_estado` (`estado`, `descripcion`) VALUES ('5', 'Reenvio');
-- -----------------------------------------------------
-- Insert `bd_provias`.`tb_solicitud`
-- -----------------------------------------------------
INSERT INTO `bd_provias`.`tb_solicitud` (`nroSolicitud`, `dni`, `matricula`, `estado`, `fechaSolicitud`, `revisionTecnica`) VALUES ('0001', '43873005','ABC123','1','16-01-2013','revisionTecnica.doc');
INSERT INTO `bd_provias`.`tb_solicitud` (`nroSolicitud`, `dni`, `matricula`, `estado`, `fechaSolicitud`, `revisionTecnica`) VALUES ('0002', '45566880','XYZ123','2','16-01-2013','revisionTecnica.doc');
INSERT INTO `bd_provias`.`tb_solicitud` (`nroSolicitud`, `dni`, `matricula`, `estado`, `fechaSolicitud`, `revisionTecnica`) VALUES ('0003', '45236988','AAA123','3','16-01-2013','revisionTecnica.doc');
INSERT INTO `bd_provias`.`tb_solicitud` (`nroSolicitud`, `dni`, `matricula`, `estado`, `fechaSolicitud`, `revisionTecnica`) VALUES ('0004', '12345678','EEE123','4','16-01-2013','revisionTecnica.doc');
INSERT INTO `bd_provias`.`tb_solicitud` (`nroSolicitud`, `dni`, `matricula`, `estado`, `fechaSolicitud`, `revisionTecnica`) VALUES ('0005', '87654321','III123','1','16-01-2013','revisionTecnica.doc');
-- -----------------------------------------------------
-- Insert `bd_provias`.`tb_estadoCivil`
-- -----------------------------------------------------
INSERT INTO bd_provias.tb_estado_civil(codigo, descripcion) VALUES ('1', 'Soltero');
INSERT INTO bd_provias.tb_estado_civil(codigo, descripcion) VALUES ('2', 'Casado');
INSERT INTO bd_provias.tb_estado_civil(codigo, descripcion) VALUES ('3', 'Viudo');
INSERT INTO bd_provias.tb_estado_civil(codigo, descripcion) VALUES ('4', 'Divorciado');
-- -----------------------------------------------------
-- Insert `bd_provias`.`tb_distrito`
-- -----------------------------------------------------
INSERT INTO bd_provias.tb_distrito(codigo, descripcion) VALUES ('1', 'Cercado de Lima');
INSERT INTO bd_provias.tb_distrito(codigo, descripcion) VALUES ('2', 'Ate');
INSERT INTO bd_provias.tb_distrito(codigo, descripcion) VALUES ('3', 'Barranco');
INSERT INTO bd_provias.tb_distrito(codigo, descripcion) VALUES ('4', 'Breña');
INSERT INTO bd_provias.tb_distrito(codigo, descripcion) VALUES ('5', 'Comas');
INSERT INTO bd_provias.tb_distrito(codigo, descripcion) VALUES ('6', 'Chorrillos');
INSERT INTO bd_provias.tb_distrito(codigo, descripcion) VALUES ('7', 'El Agustino');
INSERT INTO bd_provias.tb_distrito(codigo, descripcion) VALUES ('8', 'Jesús María');
INSERT INTO bd_provias.tb_distrito(codigo, descripcion) VALUES ('9', 'La Molina');
INSERT INTO bd_provias.tb_distrito(codigo, descripcion) VALUES ('10', 'La Victoria');
INSERT INTO bd_provias.tb_distrito(codigo, descripcion) VALUES ('11', 'Lince');
INSERT INTO bd_provias.tb_distrito(codigo, descripcion) VALUES ('12', 'Magdalena del Mar');
INSERT INTO bd_provias.tb_distrito(codigo, descripcion) VALUES ('13', 'Miraflores');
INSERT INTO bd_provias.tb_distrito(codigo, descripcion) VALUES ('14', 'Pueblo Libre');
INSERT INTO bd_provias.tb_distrito(codigo, descripcion) VALUES ('15', 'Puente Piedra');
INSERT INTO bd_provias.tb_distrito(codigo, descripcion) VALUES ('16', 'Rimac');
INSERT INTO bd_provias.tb_distrito(codigo, descripcion) VALUES ('17', 'San Isidro');
INSERT INTO bd_provias.tb_distrito(codigo, descripcion) VALUES ('18', 'Independencia');
INSERT INTO bd_provias.tb_distrito(codigo, descripcion) VALUES ('19', 'San Juan de Miraflores');
INSERT INTO bd_provias.tb_distrito(codigo, descripcion) VALUES ('20', 'San Luis');
INSERT INTO bd_provias.tb_distrito(codigo, descripcion) VALUES ('21', 'San Martin de Porres');
INSERT INTO bd_provias.tb_distrito(codigo, descripcion) VALUES ('22', 'San Miguel');
INSERT INTO bd_provias.tb_distrito(codigo, descripcion) VALUES ('23', 'Santiago de Surco');
INSERT INTO bd_provias.tb_distrito(codigo, descripcion) VALUES ('24', 'Surquillo');
INSERT INTO bd_provias.tb_distrito(codigo, descripcion) VALUES ('25', 'Villa María del Triunfo');
INSERT INTO bd_provias.tb_distrito(codigo, descripcion) VALUES ('26', 'San Juan de Lurigancho');
INSERT INTO bd_provias.tb_distrito(codigo, descripcion) VALUES ('27', 'Santa Rosa');
INSERT INTO bd_provias.tb_distrito(codigo, descripcion) VALUES ('28', 'Los Olivos');
INSERT INTO bd_provias.tb_distrito(codigo, descripcion) VALUES ('29', 'San Borja');
INSERT INTO bd_provias.tb_distrito(codigo, descripcion) VALUES ('30', 'Villa El Savador');
INSERT INTO bd_provias.tb_distrito(codigo, descripcion) VALUES ('31', 'Santa Anita');

