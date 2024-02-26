

DROP TABLE IF EXISTS linea;
DROP TABLE IF EXISTS recibo;
DROP TABLE IF EXISTS producto;
DROP TABLE IF EXISTS cliente;


CREATE TABLE CLIENTE (
    id_cliente INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50),
    apellido VARCHAR(50),
    documento VARCHAR(11)
);

CREATE TABLE PRODUCTO (
    id_producto INT AUTO_INCREMENT PRIMARY KEY,
    descripcion VARCHAR(100),
    codigo VARCHAR(10),
    stock INT,
    precio DECIMAL(10, 2)
);

CREATE TABLE RECIBO (
    id_recibo INT AUTO_INCREMENT PRIMARY KEY,
    id_cliente INT,
    fecha DATE,
    cantidad INT,
    total DECIMAL(10, 2),
    CONSTRAINT FK_cliente FOREIGN KEY (id_cliente) 
    REFERENCES CLIENTE(id_cliente)
);

CREATE TABLE LINEA (
    id_linea INT AUTO_INCREMENT PRIMARY KEY,
    id_recibo INT,
    id_producto INT,
    descripcion VARCHAR(100),
    cantidad INT,
    precio_unitario DECIMAL(10, 2),
    FOREIGN KEY (id_recibo) REFERENCES RECIBO(id_recibo),
    FOREIGN KEY (id_producto) REFERENCES PRODUCTO(id_producto)
);