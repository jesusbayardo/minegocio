CREATE  TABLE "public".tbl_cliente ( 
	id_cliente           serial  NOT NULL  ,
	tipo_identificacion  varchar(6)  NOT NULL  ,
	numero_identificacion varchar(13)  NOT NULL  ,
	nombres              varchar(100)  NOT NULL  ,
	correo               varchar(100)  NOT NULL  ,
	CONSTRAINT pk_tbl_cliente PRIMARY KEY ( id_cliente )
 );

CREATE  TABLE "public".tbl_rol ( 
	id_rol               integer  NOT NULL  ,
	name_role            varchar(255)    ,
	CONSTRAINT tbl_rol_pkey PRIMARY KEY ( id_rol )
 );

CREATE  TABLE "public".tbl_sucursal ( 
	id_sucursal          serial  NOT NULL  ,
	provincia            varchar(100)  NOT NULL  ,
	ciudad               varchar(100)  NOT NULL  ,
	direccion            varchar(100)  NOT NULL  ,
		tipo            varchar(100)    ,
	CONSTRAINT pk_tbl_sucursal PRIMARY KEY ( id_sucursal )
 );

CREATE  TABLE "public".tbl_users ( 
	id_user              serial  NOT NULL  ,
	user_name            varchar(100)    ,
	user_password        varchar(300)    ,
	id_rol               integer  NOT NULL  ,
	user_login           varchar(100)    ,
	CONSTRAINT pk_tbl_user PRIMARY KEY ( id_user )
 );

CREATE  TABLE "public".tbl_asignacion ( 
	id_asignacion        serial  NOT NULL  ,
	id_cliente           integer  NOT NULL  ,
	id_sucursal          integer  NOT NULL  ,
	CONSTRAINT pk_tbl_asignacion PRIMARY KEY ( id_asignacion )
 );

ALTER TABLE "public".tbl_asignacion ADD CONSTRAINT fk_tbl_asignacion_tbl_cliente FOREIGN KEY ( id_cliente ) REFERENCES "public".tbl_cliente( id_cliente ) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE "public".tbl_asignacion ADD CONSTRAINT fk_tbl_asignacion_tbl_sucursal FOREIGN KEY ( id_sucursal ) REFERENCES "public".tbl_sucursal( id_sucursal ) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE "public".tbl_users ADD CONSTRAINT fk6dnwig3pks0qc436egq74d0f5 FOREIGN KEY ( id_rol ) REFERENCES "public".tbl_rol( id_rol );




INSERT INTO "public".tbl_rol( id_rol, name_role ) VALUES ( 1, 'ROLE_ADMIN');


INSERT INTO "public".tbl_users( id_user, user_name, user_password, id_rol, user_login ) VALUES ( 3, 'bayardo', '$2a$10$mbWXsmfImrVXPQGqNFynC.0b0lMJbMkCZiFIwKWK8ePqmKci6Lydq', 1, 'bayardo');










