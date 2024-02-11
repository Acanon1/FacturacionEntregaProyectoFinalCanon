
INSERT INTO CLIENTE (nombre, apellido, documento) VALUES 
('Juan', 'Perez', '12345678901'),
('María', 'González', '98765432101'),
('Pedro', 'Sánchez', '45678901203');


INSERT INTO PRODUCTO (descripcion, codigo, stock, precio) VALUES
('Laptop', 'LT1001', 10, 1200.00),
('Smartphone', 'SP2001', 20, 800.00),
('Tablet', 'TB3001', 15, 500.00);

INSERT INTO RECIBO (id_cliente, fecha, cantidad, total) VALUES
(1, '2024-02-10', 2, 2400.00),
(2, '2024-02-10', 3, 2400.00),
(3, '2024-02-09', 1, 500.00);;
