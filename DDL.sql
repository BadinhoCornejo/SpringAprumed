/* ---------------------------------------------------- */
/*  Generated by Enterprise Architect Version 13.5 		*/
/*  Created On : 13-Set.-2019 10:55:35 				*/
/*  DBMS       : MySql 						*/
/* ---------------------------------------------------- */

SET FOREIGN_KEY_CHECKS=0 
;

/* Drop Tables */

DROP TABLE IF EXISTS `Categoria` CASCADE
;

DROP TABLE IF EXISTS `ComprobantePago` CASCADE
;

DROP TABLE IF EXISTS `Cuenta` CASCADE
;

DROP TABLE IF EXISTS `Ejemplar` CASCADE
;

DROP TABLE IF EXISTS `Libro` CASCADE
;

DROP TABLE IF EXISTS `LineaVenta` CASCADE
;

DROP TABLE IF EXISTS `Receptor` CASCADE
;

DROP TABLE IF EXISTS `TipoUsuario` CASCADE
;

DROP TABLE IF EXISTS `Usuario` CASCADE
;

DROP TABLE IF EXISTS `Venta` CASCADE
;

/* Create Tables */

CREATE TABLE `Categoria`
(
	`NombreCategoria` NVARCHAR(30) NULL,
	`CategoriaID` INT NOT NULL AUTO_INCREMENT,
	`Estado` VARCHAR(20) NULL,
	CONSTRAINT `PK_Categoria` PRIMARY KEY (`CategoriaID` ASC)
)

;

CREATE TABLE `ComprobantePago`
(
	`FechaCp` DATE NULL,
	`HoraCp` DATETIME NULL,
	`Ruc` NVARCHAR(13) NULL,
	`Subtotal` DECIMAL(9,3) NULL,
	`ComprobantePagoID` INT NOT NULL AUTO_INCREMENT,
	`VentaID` INT NOT NULL,
	CONSTRAINT `PK_ComprobantePago` PRIMARY KEY (`ComprobantePagoID` ASC)
)

;

CREATE TABLE `Cuenta`
(
	`Email` NVARCHAR(40) NULL,
	`Estado` VARCHAR(20) NULL,
	`UsrPassword` NVARCHAR(25) NULL,
	`CuentaID` INT NOT NULL AUTO_INCREMENT,
	`UsuarioID` INT NOT NULL,
	CONSTRAINT `PK_Cuenta` PRIMARY KEY (`CuentaID` ASC)
)

;

CREATE TABLE `Ejemplar`
(
	`Sku` VARCHAR(15) NULL,
	`EjemplarID` INT NOT NULL AUTO_INCREMENT,
	`Estado` VARCHAR(20) NULL,
	`LibroID` INT NOT NULL,
	CONSTRAINT `PK_Ejemplar` PRIMARY KEY (`EjemplarID` ASC)
)

;

CREATE TABLE `Libro`
(
	`Autor` NVARCHAR(40) NULL,
	`FechaPublicacion` DATE NULL,
	`Isbn` NVARCHAR(15) NULL,
	`Precio` DECIMAL(9,3) NULL,
	`Stock` INT NULL,
	`Titulo` NVARCHAR(60) NULL,
	`LibroID` INT NOT NULL AUTO_INCREMENT,
	`CategoriaID` INT NOT NULL,
	`Estado` VARCHAR(20) NULL,
	CONSTRAINT `PK_Libro` PRIMARY KEY (`LibroID` ASC)
)

;

CREATE TABLE `LineaVenta`
(
	`LineaventaID` INT NOT NULL AUTO_INCREMENT,
	`EjemplarID` INT NULL,
	`VentaID` INT NULL,
	CONSTRAINT `PK_LineaVenta` PRIMARY KEY (`LineaventaID` ASC)
)

;

CREATE TABLE `Receptor`
(
	`Apellido` NVARCHAR(40) NULL,
	`Dni` VARCHAR(8) NULL,
	`Nombre` NVARCHAR(40) NULL,
	`Telefono` VARCHAR(9) NULL,
	`ReceptorID` INT NOT NULL AUTO_INCREMENT,
	`VentaID` INT NOT NULL,
	CONSTRAINT `PK_Receptor` PRIMARY KEY (`ReceptorID` ASC)
)

;

CREATE TABLE `TipoUsuario`
(
	`NombreTipoUsuario` NVARCHAR(20) NULL,
	`Estado` VARCHAR(20) NULL,
	`TipoUsuarioID` INT NOT NULL AUTO_INCREMENT,
	CONSTRAINT `PK_TipoUsuario` PRIMARY KEY (`TipoUsuarioID` ASC)
)

;

CREATE TABLE `Usuario`
(
	`Apellido` NVARCHAR(40) NULL,
	`Dni` NVARCHAR(8) NULL,
	`Nombre` NVARCHAR(40) NULL,
	`Sexo` VARCHAR(20) NULL,
	`Telefono` VARCHAR(9) NULL,
	`UsuarioID` INT NOT NULL AUTO_INCREMENT,
	`TipoUsuarioID` INT NOT NULL,
	CONSTRAINT `PK_Usuario` PRIMARY KEY (`UsuarioID` ASC)
)

;

CREATE TABLE `Venta`
(
	`FechaVenta` DATE NULL,
	`HoraVenta` DATETIME NULL,
	`VentaID` INT NOT NULL AUTO_INCREMENT,
	`Estado` VARCHAR(20) NULL,
	`UsuarioID` INT NOT NULL,
	CONSTRAINT `PK_Venta` PRIMARY KEY (`VentaID` ASC)
)

;

/* Create Foreign Key Constraints */

ALTER TABLE `ComprobantePago` 
 ADD CONSTRAINT `FK_ComprobantePago_Venta`
	FOREIGN KEY (`VentaID`) REFERENCES `Venta` (`VentaID`) ON DELETE No Action ON UPDATE No Action
;

ALTER TABLE `Cuenta` 
 ADD CONSTRAINT `FK_Cuenta_Usuario`
	FOREIGN KEY (`UsuarioID`) REFERENCES `Usuario` (`UsuarioID`) ON DELETE No Action ON UPDATE No Action
;

ALTER TABLE `Ejemplar` 
 ADD CONSTRAINT `FK_Ejemplar_Libro`
	FOREIGN KEY (`LibroID`) REFERENCES `Libro` (`LibroID`) ON DELETE No Action ON UPDATE No Action
;

ALTER TABLE `Libro` 
 ADD CONSTRAINT `FK_Libro_Categoria`
	FOREIGN KEY (`CategoriaID`) REFERENCES `Categoria` (`CategoriaID`) ON DELETE No Action ON UPDATE No Action
;

ALTER TABLE `LineaVenta` 
 ADD CONSTRAINT `FK_LineaVenta_Ejemplar`
	FOREIGN KEY (`EjemplarID`) REFERENCES `Ejemplar` (`EjemplarID`) ON DELETE No Action ON UPDATE No Action
;

ALTER TABLE `LineaVenta` 
 ADD CONSTRAINT `FK_LineaVenta_Venta`
	FOREIGN KEY (`VentaID`) REFERENCES `Venta` (`VentaID`) ON DELETE No Action ON UPDATE No Action
;

ALTER TABLE `Receptor` 
 ADD CONSTRAINT `FK_Receptor_Venta`
	FOREIGN KEY (`VentaID`) REFERENCES `Venta` (`VentaID`) ON DELETE No Action ON UPDATE No Action
;

ALTER TABLE `Usuario` 
 ADD CONSTRAINT `FK_Usuario_TipoUsuario`
	FOREIGN KEY (`TipoUsuarioID`) REFERENCES `TipoUsuario` (`TipoUsuarioID`) ON DELETE No Action ON UPDATE No Action
;

ALTER TABLE `Venta` 
 ADD CONSTRAINT `FK_Venta_Usuario`
	FOREIGN KEY (`UsuarioID`) REFERENCES `Usuario` (`UsuarioID`) ON DELETE No Action ON UPDATE No Action
;

SET FOREIGN_KEY_CHECKS=1 
;
