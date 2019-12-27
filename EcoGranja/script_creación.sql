create sequence seq_numeroAdmin;
create sequence seq_numeroPedido;
create sequence seq_numeroSocio;
create sequence seq_numeroTarjeta;
CREATE EXTENSION IF NOT EXISTS pgcrypto;

create table UsuarioAdministrador(
	nombreCuenta varchar(20),
	clave varchar(255) not null,
	email varchar(50) not null unique,
	imagenUsuario bytea,
	direccion varchar(40) not null,
	numeroAdmin integer default nextval('seq_numeroAdmin') not null unique,
	primary key(nombreCuenta)
);

create table UsuarioClienteProductorComprador(
	nombreCuenta varchar(20),
	clave varchar(255) not null,
	email varchar(50) not null unique,
	imagenUsuario bytea,
	direccion varchar(40) not null,
	numeroSocio integer default nextval('seq_numeroSocio') not null unique,
	nombrePropio varchar(20) ,
	apellidos varchar(40),
	dni varchar(9),
	numeroCuenta varchar(24),
	direccionEnvio varchar(40),
	localidad varchar(20),
	provincia varchar(20),
	pais varchar(20),
	telefonoContacto varchar(11),
	saldoPropio float DEFAULT 0,
	esProductor boolean not null,
	esConsumidor boolean not null,
	primary key(nombreCuenta)
);

create table Granja(
	nombre varchar(20) not null,
	cif varchar(9),
	provincia varchar(20) not null,
	pais varchar(20) not null,
	direccion varchar(40) not null,
	tipo varchar(15) not null,
	productor varchar(20) not null,
	primary key(cif),
	foreign key(productor) references UsuarioClienteProductorComprador(nombreCuenta) on delete restrict on update cascade
);


create table Producto(
	nombre varchar(20),
	granja varchar(9),
	categoria varchar(20) not null,
	descripcion varchar(750) not null,
	imagen bytea,
	coste float not null,
	primary key(nombre,granja),
	foreign key(granja) references Granja(cif) on delete cascade on update cascade
);



create table Lote(
	codigoBarras bigint,
	unidades integer not null,
	fechaCaducidad date not null,
	producto varchar(20),
	granja varchar(9),
	primary key(codigoBarras, producto,granja),
	foreign key(producto,granja) references Producto(nombre,granja) on delete cascade on update cascade
);

create table MetododePago(
	id integer not null ,
	comprador varchar(20),
	primary key(id, comprador),
	foreign key(comprador) references UsuarioClienteProductorComprador(nombreCuenta) on delete cascade on update cascade
);

create table Tarjeta(
	id integer  not null ,
	numero varchar(12) ,
	comprador varchar(20),
	caducidad varchar(4) not null,
	cvv varchar(3) not null,
	primary key(id, comprador),
	foreign key(id, comprador) references MetododePago(id, comprador) on delete cascade on update cascade
);

create table CuentaBancaria(
	id integer  not null,
	numeroCuenta varchar(24),
	comprador varchar(20),
	primary key(id, numeroCuenta),
	foreign key(id, comprador) references MetododePago(id, comprador) on delete cascade on update cascade
);

create table Pedido(
	id integer not null ,
	comprador varchar(20),
	usaSaldoPropio boolean not null,
	fechaCompra timestamp not null,
	total float not null,
	metodoPago integer not null ,
	primary key(id, comprador),
	foreign key(metodoPago, comprador) references MetododePago(id, comprador) on delete cascade on update cascade
);

create table incluye(
	unidadesCompr integer,
	devolucion boolean not null,
	comprador varchar(20),
	administrador varchar(20),
	lote bigint,
	producto varchar(20),
	granja varchar(9),
	pedido integer not null,
	fechaDevolucion timestamp,
	fechaProcesado timestamp,
	unidadesDev integer,
	primary key(unidadesCompr, comprador, lote, producto,pedido,granja),
	foreign key(lote, producto,granja) references Lote(codigoBarras, producto,granja) on delete cascade on update cascade,
	foreign key(pedido, comprador) references Pedido(id, comprador) on delete cascade on update cascade,
	foreign key(administrador) references UsuarioAdministrador(nombreCuenta) on delete cascade on update cascade
);


--Triggers

create or replace function controla_secuencias_metodos() returns trigger as $csl$
begin
  case TG_OP
    when 'INSERT' then
      execute 'create sequence seq_metodos_comprador_'||(NEW.nombreCuenta);
      return new;
    when 'UPDATE' then
      execute 'drop sequence seq_metodos_comprador_'||(OLD.nombreCuenta );
      execute 'create sequence seq_metodos_comprador_'||(NEW.nombreCuenta );
      return new;
    when 'DELETE' then 
      execute 'drop sequence seq_metodos_comprador_'||(OLD.nombreCuenta );
      return old;
    else null;
  end case;
end;
$csl$ Language plpgsql;


create trigger afterMetodos after insert or update or delete on UsuarioClienteProductorComprador
for each row execute procedure controla_secuencias_metodos();

create or replace function controla_secuencias_pedidos() returns trigger as $csl$
begin
  case TG_OP
    when 'INSERT' then
      execute 'create sequence seq_pedidos_comprador_'||(NEW.nombreCuenta );
      return new;
    when 'UPDATE' then
      execute 'drop sequence seq_pedidos_comprador_'||(OLD.nombreCuenta);
      execute 'create sequence seq_pedidos_comprador_'||(NEW.nombreCuenta);
      return new;
    when 'DELETE' then 
      execute 'drop sequence seq_pedidos_comprador_'||(OLD.nombreCuenta);
      return old;
    else null;
  end case;
end;
$csl$ Language plpgsql;


create trigger afterPedido after insert or update or delete on UsuarioClienteProductorComprador
for each row execute procedure controla_secuencias_pedidos();






create or replace function controla_devolucion() returns trigger as $csl$
declare
	precio double precision;
	devueltas integer;
	compradas integer;
begin
      IF NEW.devolucion=true THEN
	select sum(unidadesDev) into devueltas from incluye where lote=NEW.lote  and producto=NEW.producto and pedido=NEW.pedido and comprador=NEW.comprador and granja=NEW.granja ;
	select sum(unidadesCompr) into compradas from incluye where lote=NEW.lote  and producto=NEW.producto and pedido=NEW.pedido and comprador=NEW.comprador and granja=NEW.granja  ;
		IF devueltas <=compradas THEN
		     select coste into precio from producto where nombre=NEW.producto and granja=NEW.granja ;
		     update UsuarioClienteProductorComprador set saldopropio= saldopropio+ NEW.unidadesDev*precio  where nombreCuenta=NEW.comprador;
		ELSE
			RAISE EXCEPTION 'Cantidad de devueltas mayor que compradas: % > %', devueltas,compradas 
 			  USING HINT = 'Revisa las unidades devueltas';
		END IF;
      END IF;
      return new;
end;
$csl$ Language plpgsql;

create trigger gestionaDevolucion after update or insert on incluye
for each row execute procedure controla_devolucion();


create or replace function controla_compra() returns trigger as $csl$
DECLARE
    costeT double precision;
    valorProducto double precision;
BEGIN
    select sum(total) into costeT from Pedido where id=NEW.pedido and comprador=NEW.comprador;
    select sum(coste) into valorProducto from producto where nombre= NEW.producto;
    costeT:= costeT + NEW.unidadesCompr* valorProducto;
    UPDATE Pedido SET total=costeT WHERE id=NEW.pedido  and comprador=NEW.comprador;
    RETURN new;
END;
$csl$ Language plpgsql;

create trigger gestionaCompra after insert on incluye
for each row execute procedure controla_compra();

--Funciones
create or replace function introduce_num_pedido() returns trigger as $csl$
begin
  new.id:=nextval('seq_pedidos_comprador_'||cast(NEW.comprador as text));
  return new;
end;
$csl$ Language plpgsql;


create trigger beforeInsertPedidos before insert on Pedido
for each row execute procedure introduce_num_pedido();


create or replace function introduce_num_metodo() returns trigger as $csl$
begin
  new.id:=nextval('seq_metodos_comprador_'||cast(NEW.comprador as text));
  return new;
end;
$csl$ Language plpgsql;


create trigger beforeInsertMetodos before insert on MetododePago
for each row execute procedure introduce_num_metodo();

