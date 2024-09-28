-- Generado por Oracle SQL Developer Data Modeler 23.1.0.087.0806
--   en:        2024-09-28 10:21:38 COT
--   sitio:      Oracle Database 12c
--   tipo:      Oracle Database 12c



-- predefined type, no DDL - MDSYS.SDO_GEOMETRY

-- predefined type, no DDL - XMLTYPE

CREATE TABLE bodega (
    nombre               VARCHAR2(100 BYTE),
    tamaño               FLOAT,
    capacidad            FLOAT,
    bodega_id            NUMBER NOT NULL,
    sucursal_sucursal_id NUMBER NOT NULL
);

ALTER TABLE bodega ADD CONSTRAINT bodega_pk PRIMARY KEY ( bodega_id );

CREATE TABLE categoria (
    codigo                        VARCHAR2(100 CHAR),
    nombre                        VARCHAR2(100 CHAR),
    descripcion                   LONG,
    caracteristicasalmacenamiento LONG,
    categoria_id                  NUMBER NOT NULL
);

ALTER TABLE categoria ADD CONSTRAINT categoria_pk PRIMARY KEY ( categoria_id );

CREATE TABLE ciudad (
    nombre    VARCHAR2(100 CHAR),
    codigo    VARCHAR2(100 CHAR),
    ciudad_id NUMBER NOT NULL
);

ALTER TABLE ciudad ADD CONSTRAINT ciudad_pk PRIMARY KEY ( ciudad_id );

CREATE TABLE cliente (
    cedula     VARCHAR2(100 CHAR),
    nombre     VARCHAR2(100 CHAR),
    telefonp   VARCHAR2(100 CHAR),
    cliente_id NUMBER NOT NULL
);

ALTER TABLE cliente ADD CONSTRAINT cliente_pk PRIMARY KEY ( cliente_id );

CREATE TABLE detallecostobodega (
    costounitariobod   FLOAT,
    cantexistencias    INTEGER,
    infoextrabodega_id NUMBER NOT NULL
);

CREATE TABLE documentorecepcion (
    fechaentregado             DATE,
    id                         INTEGER,
    bodega_bodega_id           NUMBER NOT NULL,
    ordencompra_ordencompra_id NUMBER NOT NULL
);

CREATE UNIQUE INDEX documentorecepcion__idx ON
    documentorecepcion (
        ordencompra_ordencompra_id
    ASC );

CREATE TABLE especificacionempaquetado (
    volumen                      FLOAT,
    peso                         FLOAT,
    especificacionempaquetado_id NUMBER NOT NULL
);

ALTER TABLE especificacionempaquetado ADD CONSTRAINT empaquetado_pk PRIMARY KEY ( especificacionempaquetado_id );

CREATE TABLE infoextrabodega (
    totalexistencias        INTEGER,
    costopromedio           FLOAT,
    capacidadalmacenamiento INTEGER,
    nivelminimoreorden      INTEGER,
    infoextrabodega_id      NUMBER NOT NULL,
    bodega_bodega_id        NUMBER NOT NULL,
    producto_producto_id    NUMBER NOT NULL
);

ALTER TABLE infoextrabodega ADD CONSTRAINT infoextrabodega_pk PRIMARY KEY ( infoextrabodega_id );

CREATE TABLE infoextraorden (
    cantidad                   INTEGER,
    costounitario              FLOAT,
    producto_producto_id       NUMBER NOT NULL,
    ordencompra_ordencompra_id NUMBER NOT NULL
);

CREATE TABLE infoextraproveedor (
    cantidadexistencias    INTEGER,
    proveedor_proveedor_id NUMBER NOT NULL,
    producto_producto_id   NUMBER NOT NULL
);

CREATE TABLE infoextraventa (
    cantidad             INTEGER,
    preciounitarioventa  FLOAT,
    venta_venta_id       NUMBER NOT NULL,
    producto_producto_id NUMBER NOT NULL
);

CREATE TABLE ordencompra (
    precio                 FLOAT,
    fechaentrega           DATE,
    estado                 VARCHAR2(100 CHAR),
    fechacreacion          DATE,
    ordencompra_id         NUMBER NOT NULL,
    proveedor_proveedor_id NUMBER NOT NULL,
    sucursal_sucursal_id   NUMBER NOT NULL
);

ALTER TABLE ordencompra ADD CONSTRAINT ordencompra_pk PRIMARY KEY ( ordencompra_id );

CREATE TABLE perecederos (
    producto_producto_id NUMBER NOT NULL,
    fechavencimiento     DATE
);

ALTER TABLE perecederos ADD CONSTRAINT perecederos_pk PRIMARY KEY ( producto_producto_id );

CREATE TABLE producto (
    producto_id                  NUMBER NOT NULL,
    nombre                       VARCHAR2(100 CHAR),
    costoenbodega                FLOAT,
    preciounitario               FLOAT,
    presentacion                 LONG,
    cantidadpresentacion         INTEGER,
    unidadmedida                 VARCHAR2(100 CHAR),
    especificacionempaquetado    LONG,
    codigobarras                 RAW(2000),
    fechaexpiracion              DATE,
    categoria_categoria_id       NUMBER NOT NULL,
    especificacionempaquetado_id NUMBER NOT NULL
);

ALTER TABLE producto ADD CONSTRAINT producto_pk PRIMARY KEY ( producto_id );

CREATE TABLE proveedor (
    nit             VARCHAR2(100 CHAR),
    nombre          VARCHAR2(100 CHAR),
    direccion       VARCHAR2(100 CHAR),
    personacontacto VARCHAR2(100 CHAR),
    telefono        VARCHAR2(100 CHAR),
    proveedor_id    NUMBER NOT NULL
);

ALTER TABLE proveedor ADD CONSTRAINT proveedor_pk PRIMARY KEY ( proveedor_id );

CREATE TABLE sucursal (
    nombre           VARCHAR2(100 CHAR),
    tamaño           FLOAT,
    telefono         VARCHAR2(100 CHAR),
    direccion        VARCHAR2(100 CHAR),
    sucursal_id      NUMBER NOT NULL,
    ciudad_ciudad_id NUMBER NOT NULL
);

ALTER TABLE sucursal ADD CONSTRAINT sucursal_pk PRIMARY KEY ( sucursal_id );

CREATE TABLE venta (
    id                   INTEGER,
    fecha                DATE,
    venta_id             NUMBER NOT NULL,
    sucursal_sucursal_id NUMBER NOT NULL,
    cliente_cliente_id   NUMBER NOT NULL
);

ALTER TABLE venta ADD CONSTRAINT venta_pk PRIMARY KEY ( venta_id );

ALTER TABLE bodega
    ADD CONSTRAINT bodega_sucursal_fk FOREIGN KEY ( sucursal_sucursal_id )
        REFERENCES sucursal ( sucursal_id );

ALTER TABLE detallecostobodega
    ADD CONSTRAINT detallecbod_infoexbod_fk FOREIGN KEY ( infoextrabodega_id )
        REFERENCES infoextrabodega ( infoextrabodega_id );

ALTER TABLE documentorecepcion
    ADD CONSTRAINT documentorecepcion_bodega_fk FOREIGN KEY ( bodega_bodega_id )
        REFERENCES bodega ( bodega_id );

ALTER TABLE documentorecepcion
    ADD CONSTRAINT drecepcion_ocompra_fk FOREIGN KEY ( ordencompra_ordencompra_id )
        REFERENCES ordencompra ( ordencompra_id );

ALTER TABLE infoextraproveedor
    ADD CONSTRAINT infoeproveedor_proveedor_fk FOREIGN KEY ( proveedor_proveedor_id )
        REFERENCES proveedor ( proveedor_id );

ALTER TABLE infoextrabodega
    ADD CONSTRAINT infoextrabodega_bodega_fk FOREIGN KEY ( bodega_bodega_id )
        REFERENCES bodega ( bodega_id );

ALTER TABLE infoextrabodega
    ADD CONSTRAINT infoextrabodega_producto_fk FOREIGN KEY ( producto_producto_id )
        REFERENCES producto ( producto_id );

ALTER TABLE infoextraorden
    ADD CONSTRAINT infoextraorden_ordencompra_fk FOREIGN KEY ( ordencompra_ordencompra_id )
        REFERENCES ordencompra ( ordencompra_id );

ALTER TABLE infoextraorden
    ADD CONSTRAINT infoextraorden_producto_fk FOREIGN KEY ( producto_producto_id )
        REFERENCES producto ( producto_id );

ALTER TABLE infoextraproveedor
    ADD CONSTRAINT infoextraproveedor_producto_fk FOREIGN KEY ( producto_producto_id )
        REFERENCES producto ( producto_id );

ALTER TABLE infoextraventa
    ADD CONSTRAINT infoextraventa_producto_fk FOREIGN KEY ( producto_producto_id )
        REFERENCES producto ( producto_id );

ALTER TABLE infoextraventa
    ADD CONSTRAINT infoextraventa_venta_fk FOREIGN KEY ( venta_venta_id )
        REFERENCES venta ( venta_id );

ALTER TABLE ordencompra
    ADD CONSTRAINT ordencompra_proveedor_fk FOREIGN KEY ( proveedor_proveedor_id )
        REFERENCES proveedor ( proveedor_id );

ALTER TABLE ordencompra
    ADD CONSTRAINT ordencompra_sucursal_fk FOREIGN KEY ( sucursal_sucursal_id )
        REFERENCES sucursal ( sucursal_id );

ALTER TABLE perecederos
    ADD CONSTRAINT perecederos_producto_fk FOREIGN KEY ( producto_producto_id )
        REFERENCES producto ( producto_id );

ALTER TABLE producto
    ADD CONSTRAINT producto_categoria_fk FOREIGN KEY ( categoria_categoria_id )
        REFERENCES categoria ( categoria_id );

ALTER TABLE producto
    ADD CONSTRAINT producto_empaquetado_fk FOREIGN KEY ( especificacionempaquetado_id )
        REFERENCES especificacionempaquetado ( especificacionempaquetado_id );

ALTER TABLE sucursal
    ADD CONSTRAINT sucursal_ciudad_fk FOREIGN KEY ( ciudad_ciudad_id )
        REFERENCES ciudad ( ciudad_id );

ALTER TABLE venta
    ADD CONSTRAINT venta_cliente_fk FOREIGN KEY ( cliente_cliente_id )
        REFERENCES cliente ( cliente_id );

ALTER TABLE venta
    ADD CONSTRAINT venta_sucursal_fk FOREIGN KEY ( sucursal_sucursal_id )
        REFERENCES sucursal ( sucursal_id );

CREATE SEQUENCE bodega_bodega_id_seq START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER bodega_bodega_id_trg BEFORE
    INSERT ON bodega
    FOR EACH ROW
    WHEN ( new.bodega_id IS NULL )
BEGIN
    :new.bodega_id := bodega_bodega_id_seq.nextval;
END;
/

CREATE SEQUENCE categoria_categoria_id_seq START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER categoria_categoria_id_trg BEFORE
    INSERT ON categoria
    FOR EACH ROW
    WHEN ( new.categoria_id IS NULL )
BEGIN
    :new.categoria_id := categoria_categoria_id_seq.nextval;
END;
/

CREATE SEQUENCE ciudad_ciudad_id_seq START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER ciudad_ciudad_id_trg BEFORE
    INSERT ON ciudad
    FOR EACH ROW
    WHEN ( new.ciudad_id IS NULL )
BEGIN
    :new.ciudad_id := ciudad_ciudad_id_seq.nextval;
END;
/

CREATE SEQUENCE cliente_cliente_id_seq START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER cliente_cliente_id_trg BEFORE
    INSERT ON cliente
    FOR EACH ROW
    WHEN ( new.cliente_id IS NULL )
BEGIN
    :new.cliente_id := cliente_cliente_id_seq.nextval;
END;
/

CREATE SEQUENCE empaquetado_especificacionempa START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER empaquetado_especificacionempa BEFORE
    INSERT ON especificacionempaquetado
    FOR EACH ROW
    WHEN ( new.especificacionempaquetado_id IS NULL )
BEGIN
    :new.especificacionempaquetado_id := empaquetado_especificacionempa.nextval;
END;
/

CREATE SEQUENCE infoextrabodega_infoextrabodeg START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER infoextrabodega_infoextrabodeg BEFORE
    INSERT ON infoextrabodega
    FOR EACH ROW
    WHEN ( new.infoextrabodega_id IS NULL )
BEGIN
    :new.infoextrabodega_id := infoextrabodega_infoextrabodeg.nextval;
END;
/

CREATE SEQUENCE ordencompra_ordencompra_id_seq START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER ordencompra_ordencompra_id_trg BEFORE
    INSERT ON ordencompra
    FOR EACH ROW
    WHEN ( new.ordencompra_id IS NULL )
BEGIN
    :new.ordencompra_id := ordencompra_ordencompra_id_seq.nextval;
END;
/

CREATE SEQUENCE producto_producto_id_seq START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER producto_producto_id_trg BEFORE
    INSERT ON producto
    FOR EACH ROW
    WHEN ( new.producto_id IS NULL )
BEGIN
    :new.producto_id := producto_producto_id_seq.nextval;
END;
/

CREATE SEQUENCE proveedor_proveedor_id_seq START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER proveedor_proveedor_id_trg BEFORE
    INSERT ON proveedor
    FOR EACH ROW
    WHEN ( new.proveedor_id IS NULL )
BEGIN
    :new.proveedor_id := proveedor_proveedor_id_seq.nextval;
END;
/

CREATE SEQUENCE sucursal_sucursal_id_seq START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER sucursal_sucursal_id_trg BEFORE
    INSERT ON sucursal
    FOR EACH ROW
    WHEN ( new.sucursal_id IS NULL )
BEGIN
    :new.sucursal_id := sucursal_sucursal_id_seq.nextval;
END;
/

CREATE SEQUENCE venta_venta_id_seq START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER venta_venta_id_trg BEFORE
    INSERT ON venta
    FOR EACH ROW
    WHEN ( new.venta_id IS NULL )
BEGIN
    :new.venta_id := venta_venta_id_seq.nextval;
END;
/



-- Informe de Resumen de Oracle SQL Developer Data Modeler: 
-- 
-- CREATE TABLE                            17
-- CREATE INDEX                             1
-- ALTER TABLE                             32
-- CREATE VIEW                              0
-- ALTER VIEW                               0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                          11
-- ALTER TRIGGER                            0
-- CREATE COLLECTION TYPE                   0
-- CREATE STRUCTURED TYPE                   0
-- CREATE STRUCTURED TYPE BODY              0
-- CREATE CLUSTER                           0
-- CREATE CONTEXT                           0
-- CREATE DATABASE                          0
-- CREATE DIMENSION                         0
-- CREATE DIRECTORY                         0
-- CREATE DISK GROUP                        0
-- CREATE ROLE                              0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE SEQUENCE                         11
-- CREATE MATERIALIZED VIEW                 0
-- CREATE MATERIALIZED VIEW LOG             0
-- CREATE SYNONYM                           0
-- CREATE TABLESPACE                        0
-- CREATE USER                              0
-- 
-- DROP TABLESPACE                          0
-- DROP DATABASE                            0
-- 
-- REDACTION POLICY                         0
-- TSDP POLICY                              0
-- 
-- ORDS DROP SCHEMA                         0
-- ORDS ENABLE SCHEMA                       0
-- ORDS ENABLE OBJECT                       0
-- 
-- ERRORS                                   0
-- WARNINGS                                 0
