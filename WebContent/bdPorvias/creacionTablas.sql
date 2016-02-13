SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

DROP SCHEMA IF EXISTS `bd_provias` ;
CREATE SCHEMA IF NOT EXISTS `bd_provias` DEFAULT CHARACTER SET utf8 ;
USE `bd_provias` ;

-- -----------------------------------------------------
-- Table `bd_provias`.`tb_distrito`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `bd_provias`.`tb_distrito` (
  `codigo` VARCHAR(2) NOT NULL DEFAULT '' ,
  `descripcion` VARCHAR(45) NULL DEFAULT NULL ,
  PRIMARY KEY (`codigo`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bd_provias`.`tb_estado`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `bd_provias`.`tb_estado` (
  `estado` VARCHAR(1) NOT NULL ,
  `descripcion` VARCHAR(45) NULL DEFAULT NULL ,
  PRIMARY KEY (`estado`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bd_provias`.`tb_estado_civil`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `bd_provias`.`tb_estado_civil` (
  `codigo` VARCHAR(2) NOT NULL DEFAULT '' ,
  `descripcion` VARCHAR(45) NULL DEFAULT NULL ,
  PRIMARY KEY (`codigo`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bd_provias`.`tb_solicitante`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `bd_provias`.`tb_solicitante` (
  `dni` VARCHAR(8) NOT NULL ,
  `nombre` VARCHAR(45) NULL DEFAULT NULL ,
  `apellidoPaterno` VARCHAR(45) NULL DEFAULT NULL ,
  `apellidoMaterno` VARCHAR(45) NULL DEFAULT NULL ,
  `fechaNacimiento` VARCHAR(10) NULL DEFAULT NULL ,
  `sexo` VARCHAR(10) NULL DEFAULT NULL ,
  `direccion` VARCHAR(45) NULL DEFAULT NULL ,
  `telefono` VARCHAR(12) NULL DEFAULT NULL ,
  `correoElectronico` VARCHAR(30) NULL DEFAULT NULL ,
  PRIMARY KEY (`dni`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bd_provias`.`tb_solicitud`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `bd_provias`.`tb_solicitud` (
  `nroSolicitud` VARCHAR(10) NOT NULL ,
  `dni` VARCHAR(8) NULL DEFAULT NULL ,
  `matricula` VARCHAR(15) NULL DEFAULT NULL ,
  `estado` VARCHAR(1) NULL DEFAULT NULL ,
  `fechaSolicitud` VARCHAR(10) NULL DEFAULT NULL ,
  `revisionTecnica` VARCHAR(100) NULL DEFAULT NULL ,
  `fechaModificacion` VARCHAR(10) NULL DEFAULT NULL ,
  `tb_solicitudcol` VARCHAR(45) NULL DEFAULT NULL ,
  PRIMARY KEY (`nroSolicitud`) ,
  INDEX `Fk_Solicitud_Vehiculo_idx` (`matricula` ASC) ,
  INDEX `Fk_Solicitud_Solicitante_idx` (`dni` ASC) ,
  INDEX `Fk_Solicitud_Estado_idx` (`estado` ASC) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bd_provias`.`tb_tipousuario`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `bd_provias`.`tb_tipousuario` (
  `tipo` VARCHAR(1) NOT NULL ,
  `descripcion` VARCHAR(15) NULL DEFAULT NULL )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bd_provias`.`tb_usuario`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `bd_provias`.`tb_usuario` (
  `dni` VARCHAR(8) NOT NULL ,
  `username` VARCHAR(10) NULL DEFAULT NULL ,
  `password` VARCHAR(10) NULL DEFAULT NULL ,
  `nombres` VARCHAR(45) NULL DEFAULT NULL ,
  `apellidos` VARCHAR(45) NULL DEFAULT NULL ,
  `fechaNacimiento` VARCHAR(45) NULL DEFAULT NULL ,
  `estadoCivil` VARCHAR(45) NULL DEFAULT NULL ,
  `distrito` VARCHAR(45) NULL DEFAULT NULL ,
  `correoElectronico` VARCHAR(40) NULL DEFAULT NULL ,
  `tipo` VARCHAR(1) NULL DEFAULT NULL ,
  PRIMARY KEY (`dni`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bd_provias`.`tb_vehiculo`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `bd_provias`.`tb_vehiculo` (
  `matricula` VARCHAR(15) NOT NULL ,
  `titular` VARCHAR(45) NULL DEFAULT NULL ,
  `modelo` VARCHAR(45) NULL DEFAULT NULL ,
  `peso` VARCHAR(45) NULL DEFAULT NULL ,
  `longitud` VARCHAR(45) NULL DEFAULT NULL ,
  `altura` VARCHAR(45) NULL DEFAULT NULL ,
  PRIMARY KEY (`matricula`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
