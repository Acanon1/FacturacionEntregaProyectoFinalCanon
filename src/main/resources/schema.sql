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
(2, '2024-02-11', 1, 39.99),
(3, '2024-02-10', 3, 239.97);

INSERT INTO LINEA (id_recibo, id_producto, descripcion, cantidad, precio_unitario) VALUES
(1, 1, 'Camisa de algodón talla M', 1, 29.99),
(1, 3, 'Zapatos de cuero talla 10', 1, 79.99),
(2, 2, 'Pantalón de mezclilla talla 32', 1, 39.99),
(3, 1, 'Camisa de algodón talla L', 2, 29.99),
(3, 3, 'Zapatos de cuero talla 9', 1, 79.99);
