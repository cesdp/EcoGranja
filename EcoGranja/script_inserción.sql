INSERT INTO UsuarioAdministrador(nombreCuenta,clave,email,direccion) VALUES('CesDP',PGP_SYM_ENCRYPT('12345678','AES_KEY'),'linces@gmail.com','Monte da Condesa');
INSERT INTO UsuarioAdministrador(nombreCuenta,clave,email,direccion) VALUES('Admin',PGP_SYM_ENCRYPT('admin','AES_KEY'),'administracion@admin.com','Madrid');
INSERT INTO UsuarioClienteProductorComprador (nombreCuenta,clave,email, direccion,nombrePropio,apellidos,dni,numeroCuenta,direccionEnvio,localidad,provincia,pais,telefonoContacto,esProductor,esConsumidor)
VALUES ('FerAL',PGP_SYM_ENCRYPT('87654321','AES_KEY'),'fer@rai.usc.es','Ourense','Fernando','Arrojo Alonso','35678965B','ES604060013412340005','Ourense 12','Ourense','Ourense','España','654123890',true,true);
INSERT INTO UsuarioClienteProductorComprador (nombreCuenta,clave,email, direccion,nombrePropio,apellidos,dni,numeroCuenta,direccionEnvio,localidad,provincia,pais,telefonoContacto,esProductor,esConsumidor)
VALUES ('DavidLC',PGP_SYM_ENCRYPT('87654321','AES_KEY'),'david@rai.usc.es','Sanxenxo','David','Landin Calvo',NULL,NULL,'Sanxenxo 12','Ourense','Ourense','España','654123890',false,true);
INSERT INTO UsuarioClienteProductorComprador (nombreCuenta,clave,email, direccion,nombrePropio,apellidos,dni,numeroCuenta,direccionEnvio,localidad,provincia,pais,telefonoContacto,esProductor,esConsumidor)
VALUES ('JuanDL',PGP_SYM_ENCRYPT('87654321','AES_KEY'),'juan@rai.usc.es','Santiago','Juan','Deus Lorenzo','45678965J','ES754060013512330005',NULL,NULL,NULL,NULL,NULL,true,false);
INSERT INTO UsuarioClienteProductorComprador (nombreCuenta,clave,email, direccion,nombrePropio,apellidos,dni,numeroCuenta,direccionEnvio,localidad,provincia,pais,telefonoContacto,esProductor,esConsumidor)
VALUES ('David',PGP_SYM_ENCRYPT('1234','AES_KEY'),'david@comprador.com','Barcelona 12','David','Otero Díaz',NULL,NULL,'Barcelona 12','Madrid','Madrid','España','625127184',false,true);

INSERT INTO Granja VALUES('Hnos Rivera','ES1234567','A Coruña','España','Betanzos','Vacuna','FerAL');
INSERT INTO Granja VALUES('La Granjita','ES9874123','Lugo','España','Vilalba','Horticola','FerAL');
INSERT INTO Granja VALUES('Hnos Fernandez','ES1238868','Pontevedra','España','Vigo','Frutal','JuanDL');
INSERT INTO Granja VALUES('Pollos AR','ES1274123','Ourense','España','Ourense','Avicola','JuanDL');

INSERT INTO Producto VALUES('Aguacate','ES1238868','Fruta','Descripcion de un aguacate',cast('00000' as bytea),2.50);
INSERT INTO Producto VALUES('Fresa','ES1238868','Fruta','Descripcion de una fresa',cast('00000' as bytea),1.50);
INSERT INTO Producto VALUES('Pimiento','ES9874123','Verdura','Descripcion de un pimiento',cast('00000' as bytea),0.90);
INSERT INTO Producto VALUES('Zanahoria','ES9874123','Verdura','Descripcion de una zanahoria',cast('00000' as bytea),1.10);
INSERT INTO Producto VALUES('Leche','ES1234567','Lácteo','Descripcion de la leche',cast('00000' as bytea),0.60);
INSERT INTO Producto VALUES('Queso','ES1234567','Lácteo','Descripcion del queso',cast('00000' as bytea),3.50);
INSERT INTO Producto VALUES('Huevos','ES1274123','Avícola','Descripcion de un huevos',cast('00000' as bytea),0.75);

INSERT INTO Lote VALUES(81234567456789,15,'2019-05-12','Aguacate','ES1238868');
INSERT INTO Lote VALUES(81234567455555,30,'2019-05-12','Fresa','ES1238868');
INSERT INTO Lote VALUES(45678695867689,10,'2019-05-12','Pimiento','ES9874123');
INSERT INTO Lote VALUES(24367580456789,20,'2019-05-30','Zanahoria','ES9874123');
INSERT INTO Lote VALUES(96947365868464,50,'2019-05-12','Leche','ES1234567');
INSERT INTO Lote VALUES(46483929467574,25,'2019-07-14','Queso','ES1234567');
INSERT INTO Lote VALUES(74758484647685,120,'2019-05-20','Huevos','ES1274123');

INSERT INTO MetododePago(comprador) VALUES('FerAL');
INSERT INTO MetododePago(comprador) VALUES('JuanDL');

INSERT INTO MetododePago(comprador) VALUES('FerAL');
INSERT INTO Tarjeta(id,numero,comprador,caducidad,cvv) VALUES(1,'543215678665','FerAL','2018','632');
INSERT INTO MetododePago(comprador) VALUES('DavidLC');
INSERT INTO CuentaBancaria(id,numeroCuenta,comprador) VALUES(1,'ES508908765431233456','DavidLC');
INSERT INTO MetododePago(comprador) VALUES('David');
INSERT INTO CuentaBancaria(id,numeroCuenta,comprador) VALUES(1,'ES508908765431233457','David');

INSERT INTO Pedido(comprador,usaSaldoPropio,total,metodoPago,fechaCompra) VALUES('FerAL',false,0,1,'2019-03-15');
INSERT INTO Pedido(comprador,usaSaldoPropio,total,metodoPago,fechaCompra) VALUES('DavidLC',false,0,1,'2019-03-25');
INSERT INTO Pedido(comprador,usaSaldoPropio,total,metodoPago,fechaCompra) VALUES('DavidLC',false,0,1,'2019-03-25');
INSERT INTO Pedido(comprador,usaSaldoPropio,total,metodoPago,fechaCompra) VALUES('David',false,0,1,'2019-03-23');
INSERT INTO Pedido(comprador,usaSaldoPropio,total,metodoPago,fechaCompra) VALUES('DavidLC',false,0,1,'2019-03-25');
INSERT INTO Pedido(comprador,usaSaldoPropio,total,metodoPago,fechaCompra) VALUES('FerAL',false,0,1,'2019-03-15');
INSERT INTO Pedido(comprador,usaSaldoPropio,total,metodoPago,fechaCompra) VALUES('FerAL',false,0,1,'2019-03-16');

INSERT INTO incluye VALUES(5,false,'FerAL',NULL,81234567456789,'Aguacate','ES1238868',1,NULL,NULL,0);
INSERT INTO incluye VALUES(6,false,'FerAL',NULL,24367580456789,'Zanahoria','ES9874123',1,NULL,NULL,0);
INSERT INTO incluye VALUES(2,false,'FerAL',NULL,46483929467574,'Queso','ES1234567',1,NULL,NULL,0);
INSERT INTO incluye VALUES(1,false,'FerAL',NULL,74758484647685,'Huevos','ES1274123',1,NULL,NULL,0);

INSERT INTO incluye VALUES(5,false,'DavidLC',NULL,81234567456789,'Aguacate','ES1238868',1,NULL,NULL,0);
INSERT INTO incluye VALUES(2,false,'DavidLC',NULL,81234567455555,'Fresa','ES1238868',1,NULL,NULL,0);
INSERT INTO incluye VALUES(1,false,'DavidLC','CesDP',96947365868464,'Leche','ES1234567',1,'2019-04-12','2019-04-14',1);
INSERT INTO incluye VALUES(6,false,'DavidLC',NULL,74758484647685,'Huevos','ES1274123',1,NULL,NULL,0);

INSERT INTO incluye VALUES(5,false,'DavidLC',NULL,81234567456789,'Aguacate','ES1238868',2,NULL,NULL,0);
INSERT INTO incluye VALUES(10,false,'DavidLC',NULL,81234567455555,'Fresa','ES1238868',2,NULL,NULL,0);
INSERT INTO incluye VALUES(6,false,'DavidLC','Admin',74758484647685,'Huevos','ES1274123',2,'2019-04-12','2019-04-14',3);

INSERT INTO incluye VALUES(20,true,'David','Admin',46483929467574,'Queso','ES1234567',1,'2019-03-30','2019-04-01',5);
INSERT INTO incluye VALUES(30,false,'David',NULL,74758484647685,'Huevos','ES1274123',1,'2019-03-30',NULL,15);
INSERT INTO incluye VALUES(5,true,'David','Admin',96947365868464,'Leche','ES1234567',1,'2019-03-30','2019-04-01',5);

INSERT INTO incluye VALUES(30,false,'DavidLC',NULL,74758484647685,'Huevos','ES1274123',3,NULL,NULL,0);

INSERT INTO incluye VALUES(20,false,'FerAL',NULL,46483929467574,'Queso','ES1234567',2,NULL,NULL,0);
INSERT INTO incluye VALUES(30,false,'FerAL',NULL,74758484647685,'Huevos','ES1274123',2,NULL,NULL,0);

INSERT INTO incluye VALUES(10,false,'FerAL',NULL,96947365868464,'Leche','ES1234567',3,'2019-04-12',NULL,5);
INSERT INTO incluye VALUES(5,false,'FerAL',NULL,74758484647685,'Huevos','ES1274123',3,'2019-04-12',NULL,3);
