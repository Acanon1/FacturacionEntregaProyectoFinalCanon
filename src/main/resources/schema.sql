SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS LINEA;
DROP TABLE IF EXISTS RECIBO;
DROP TABLE IF EXISTS PRODUCTO;
DROP TABLE IF EXISTS CLIENTE;

SET FOREIGN_KEY_CHECKS = 1;

CREATE TABLE CLIENTE (
    id_cliente INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(75) NOT NULL,
    apellido VARCHAR(75) NOT NULL,
    documento VARCHAR(11) NOT NULL
);

CREATE TABLE PRODUCTO (
    id_producto INT PRIMARY KEY AUTO_INCREMENT,
    descripcion VARCHAR(150) NOT NULL,
    codigo VARCHAR(50) NOT NULL,
    stock int NOT NULL,
    precio double NOT NULL
);

CREATE TABLE RECIBO (
    id_recibo INT PRIMARY KEY AUTO_INCREMENT,
    id_cliente INT,
    fecha DATE,
    cantidad INT,
    total DOUBLE,
    FOREIGN KEY (id_cliente) REFERENCES CLIENTE(id_cliente)
);



CREATE TABLE LINEA (
    id_linea INT PRIMARY KEY AUTO_INCREMENT,
    id_recibo INT,
    id_producto INT,
    descripcion VARCHAR(150), 
    cantidad INT,
    precio_unitario DOUBLE,
    FOREIGN KEY (id_recibo) REFERENCES RECIBO(id_recibo),
    FOREIGN KEY (id_producto) REFERENCES PRODUCTO(id_producto)
);