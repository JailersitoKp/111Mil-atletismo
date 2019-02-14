
-- drop database `111k-atletismo`;

-- inicio script dreacion

create database `111k-atletismo` default character set latin1 collate latin1_spanish_ci;

use `111k-atletismo`;

create table Escuela (
  id_escuela int not null auto_increment,
  nombre varchar(255) unique not null, 
  primary key (id_escuela)
);

create table Categoria (
  id_categoria int not null auto_increment,
  descripcion varchar(255) unique not null, 
  sexo char(1) not null, 
  edad_desde smallint not null,
  edad_hasta smallint not null,
  primary key (id_categoria)
);

create table Aspirante (
  numero_de_documento int not null, 
  apellido varchar(255) not null, 
  nombre varchar(255) not null, 
  direccion varchar(255) not null, 
  fecha_de_nacimiento date not null, 
  sexo char(1) not null, 
  id_escuela int not null, 
  primary key (numero_de_documento), 
  foreign key (id_escuela) references Escuela (id_escuela)
);

create table Competencia (
  id_competencia int not null auto_increment, 
  descripcion varchar(255) not null, 
  fecha datetime not null, 
  primary key (id_competencia)
);

create table CompetenciaCategoria (
  id_competencia int not null, 
  id_categoria int not null,
  primary key (id_competencia, id_categoria), 
  foreign key (id_competencia) references Competencia (id_competencia), 
  foreign key (id_categoria) references Categoria (id_categoria) 
);

create table Estado (
  id_estado int not null auto_increment,
  descripcion varchar(255) not null, 
  primary key (id_estado)
);

create table Inscripcion (
  numero_de_documento_aspirante int not null,
  id_competencia int not null, 
  id_categoria int not null,
  id_estado int not null,
  primary key (numero_de_documento_aspirante, id_competencia), 
  foreign key (numero_de_documento_aspirante) references Aspirante (numero_de_documento), 
  foreign key (id_competencia) references Competencia (id_competencia), 
  foreign key (id_categoria) references Categoria (id_categoria), 
  foreign key (id_estado) references Estado (id_estado) 
);

-- ingreso datos iniciales
insert into Escuela (nombre) values ('Colegio Nacional General San Martín');
insert into Escuela (nombre) values ('Escuela Agrotécnica Número 23');

insert into Estado (descripcion) values ('Aprobada');
insert into Estado (descripcion) values ('Pre-Aprobada');

insert into Categoria (descripcion, sexo, edad_desde, edad_hasta) values ('Infantiles varones', 'M', 5, 9);
insert into Categoria (descripcion, sexo, edad_desde, edad_hasta) values ('Infantiles mujeres', 'F', 7, 9);
insert into Categoria (descripcion, sexo, edad_desde, edad_hasta) values ('Menores varones', 'M', 10, 13);
insert into Categoria (descripcion, sexo, edad_desde, edad_hasta) values ('Menores mujeres', 'F', 10, 14);

insert into Competencia (descripcion, fecha) values ('100 metros llanos', '2019-01-31 2:30:00');
insert into Competencia (descripcion, fecha) values ('300 metros con posta', '2019-02-05 12:30:00');
insert into Competencia (descripcion, fecha) values ('500 metros con posta', '2019-02-06 14:30:00');
insert into Competencia (descripcion, fecha) values ('50 metros con valla', '2019-02-06 16:30:00');
insert into Competencia (descripcion, fecha) values ('Salto en largo', '2019-02-07 18:30:00');
insert into Competencia (descripcion, fecha) values ('Salto con garrocha', '2019-02-07 20:30:00');
insert into Competencia (descripcion, fecha) values ('100 metros con valla', '2019-02-08 22:30:00');

insert into CompetenciaCategoria (id_competencia, id_categoria) values (1, 1);
insert into CompetenciaCategoria (id_competencia, id_categoria) values (1, 2);
insert into CompetenciaCategoria (id_competencia, id_categoria) values (1, 3);
insert into CompetenciaCategoria (id_competencia, id_categoria) values (1, 4);
insert into CompetenciaCategoria (id_competencia, id_categoria) values (2, 1);
insert into CompetenciaCategoria (id_competencia, id_categoria) values (2, 2);
insert into CompetenciaCategoria (id_competencia, id_categoria) values (2, 3);
insert into CompetenciaCategoria (id_competencia, id_categoria) values (2, 4);
insert into CompetenciaCategoria (id_competencia, id_categoria) values (3, 1);
insert into CompetenciaCategoria (id_competencia, id_categoria) values (3, 2);
insert into CompetenciaCategoria (id_competencia, id_categoria) values (3, 3);
insert into CompetenciaCategoria (id_competencia, id_categoria) values (3, 4);
insert into CompetenciaCategoria (id_competencia, id_categoria) values (4, 1);
insert into CompetenciaCategoria (id_competencia, id_categoria) values (4, 2);
insert into CompetenciaCategoria (id_competencia, id_categoria) values (4, 3);
insert into CompetenciaCategoria (id_competencia, id_categoria) values (4, 4);
insert into CompetenciaCategoria (id_competencia, id_categoria) values (5, 1);
insert into CompetenciaCategoria (id_competencia, id_categoria) values (5, 2);
insert into CompetenciaCategoria (id_competencia, id_categoria) values (5, 3);
insert into CompetenciaCategoria (id_competencia, id_categoria) values (5, 4);
insert into CompetenciaCategoria (id_competencia, id_categoria) values (6, 1);
insert into CompetenciaCategoria (id_competencia, id_categoria) values (6, 2);
insert into CompetenciaCategoria (id_competencia, id_categoria) values (6, 3);
insert into CompetenciaCategoria (id_competencia, id_categoria) values (7, 1);
insert into CompetenciaCategoria (id_competencia, id_categoria) values (7, 2);

-- fin script creacion
