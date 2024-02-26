INSERT INTO CLIENTE (nombre, apellido, documento) VALUES
('Juan', 'Pérez', '12345678901'),
('María', 'García', '23456789012'),
('Pedro', 'López', '34567890123');

INSERT INTO PRODUCTO (descripcion, codigo, stock, precio) VALUES
('Camisa de algodón', 'CAM001', 50, 29.99),
('Pantalón de mezclilla', 'PAN002', 30, 39.99),
('Zapatos de cuero', 'ZAP003', 20, 79.99);

INSERT INTO RECIBO (id_cliente, fecha, cantidad, total) VALUES
(1, '2024-02-12', 2, 59.98),
(2, '2024-02-11', 1, 39.99);
