
INSERT INTO CLIENTE (nombre, apellido, documento) VALUES 
('Juan', 'Perez', '12345678901'),
('María', 'González', '98765432101'),
('Pedro', 'Sánchez', '45678901203');


INSERT INTO PRODUCTO (descripcion, codigo, stock, precio) VALUES
('Camisa', 'CAM001', 100, 25.99),
('Pantalón', 'PAN002', 80, 39.99),
('Zapatos', 'ZAP003', 50, 59.99);

INSERT INTO RECIBO (id_cliente, creacion, total) VALUES
(1, '2024-02-09', 100.50),
(2, '2024-02-09', 85.75),
(3, '2024-02-08', 60.25);


INSERT INTO RECIBO_DETALLES (id_recibo, id_producto, cantidad, precio_unitario) VALUES
(1, 1, 2, 25.99),
(1, 3, 1, 59.99),
(2, 2, 1, 39.99),
(2, 3, 2, 59.99),
(3, 1, 3, 25.99);
