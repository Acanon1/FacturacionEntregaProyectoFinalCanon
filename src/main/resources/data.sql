-- Insertar datos en la tabla CLIENTE
INSERT INTO CLIENTE (nombre, apellido, documento) VALUES
('John', 'Doe', '12345678901'),
('Jane', 'Smith', '23456789012');

-- Obtener el último ID insertado en CLIENTE
SET @id_cliente_1 = LAST_INSERT_ID();

-- Insertar datos en la tabla PRODUCTO
INSERT INTO PRODUCTO (descripcion, codigo, stock, precio) VALUES
('Laptop', 'LT001', 10, 999.99),
('Smartphone', 'SP001', 20, 499.99);

-- Obtener el último ID insertado en PRODUCTO
SET @id_producto_1 = LAST_INSERT_ID();

-- Insertar datos en la tabla RECIBO
INSERT INTO RECIBO (id_cliente, fecha, cantidad, total) VALUES
(@id_cliente_1, '2024-02-10', 1, 999.99),
(@id_cliente_1 + 1, '2024-02-10', 2, 999.98);

-- Obtener el último ID insertado en RECIBO
SET @id_recibo_1 = LAST_INSERT_ID();

-- Insertar datos en la tabla LINEA
INSERT INTO LINEA (id_recibo, id_producto, descripcion, cantidad, precio_unitario) VALUES
(@id_recibo_1, @id_producto_1, 'Laptop', 1, 999.99),
(@id_recibo_1 + 1, @id_producto_1 + 1, 'Smartphone', 2, 499.99);



