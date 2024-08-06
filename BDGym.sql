create database Gym;
use Gym;
create table Producto(
codigoProducto int primary key not null,
nombreProducto varchar(50),
cantidad int, -- cambiar a stock
precio DECIMAL(10, 2),
categoria int);

CREATE TABLE cuentaEmpleado (
    usuario VARCHAR(50) PRIMARY KEY,
    contrasena VARCHAR(50) NOT NULL
);

CREATE TABLE Empleado (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    apellidos VARCHAR(50) NOT NULL,
    usuario_cuentaEmpleado VARCHAR(50),
    FOREIGN KEY (usuario_cuentaEmpleado) REFERENCES cuentaEmpleado(usuario)
);

INSERT INTO cuentaEmpleado (usuario, contrasena) VALUES
('usuario1', 'contrasena1'),
('usuario2', 'contrasena2'),
('usuario3', 'contrasena3'),
('usuario4', 'contrasena4'),
('usuario5', 'contrasena5');

INSERT INTO Empleado (nombre, apellidos, usuario_cuentaEmpleado) VALUES
('Juan', 'Pérez', 'usuario1'),
('María', 'Gómez', 'usuario2'),
('Carlos', 'López', 'usuario3'),
('Ana', 'Martínez', 'usuario4'),
('Luis', 'Rodríguez', 'usuario5');


INSERT INTO cuentaEmpleado (usuario, contrasena) VALUES
('admin', '');

INSERT INTO Empleado (nombre, apellidos, usuario_cuentaEmpleado) VALUES
('Bruno', 'Guerra', 'admin');


select * from Empleado;
select * from Cliente;
select * from Producto;

CREATE TABLE Cliente (
    codigoCliente INT PRIMARY KEY,
    nombre VARCHAR(255),
    apellidos VARCHAR(255),
    edad INT,
    direccion VARCHAR(255),
    genero VARCHAR(50),
    talla DECIMAL(10, 2),
    peso DECIMAL(10, 2),
    tipoMembresia VARCHAR(255)
);



SELECT Empleado.id, Empleado.nombre, Empleado.apellidos, cuentaEmpleado.usuario, cuentaEmpleado.contrasena
FROM Empleado
JOIN cuentaEmpleado ON Empleado.cuentaEmpleado_id = cuentaEmpleado.id;

CREATE TABLE Boleta (
    numeroBoleta INT PRIMARY KEY,
    fecha DATE,
    total DECIMAL(10, 2),
    codigoCliente INT,
    FOREIGN KEY (codigoCliente) REFERENCES Cliente(codigoCliente)
);

CREATE TABLE detalleBoleta (
    id INT AUTO_INCREMENT PRIMARY KEY,
    numeroBoleta INT,
    codigoProducto INT,
    cantidad INT,
    precioUnitario DECIMAL(10, 2),
    subtotal DECIMAL(10, 2),
    FOREIGN KEY (numeroBoleta) REFERENCES boleta(numeroBoleta),
    FOREIGN KEY (codigoProducto) REFERENCES Producto(codigoProducto)
);

CREATE TABLE Asistencia (
    codigoCliente INT NOT NULL,
    fecha DATE NOT NULL,
    hora_entrada TIME NOT NULL ,
    FOREIGN KEY (codigoCliente) REFERENCES Cliente(codigoCliente)
);

Drop table Asistencia;
select * from Boleta;
select * from detalleBoleta;



SELECT c.codigoCliente, c.nombre, a.fecha, a.hora_entrada
FROM Cliente c INNER JOIN Asistencia a ON c.codigoCliente = a.codigoCliente;

select*from Asistencia;
INSERT INTO Asistencia (codigoCliente, fecha, hora_entrada) VALUES ('1',CURDATE(),CURTIME());
Select curdate();

SELECT db.id, db.codigoProducto, p.nombreProducto, db.cantidad, db.precioUnitario, db.subtotal
FROM detalleBoleta db INNER JOIN Producto p ON db.codigoProducto = p.codigoProducto;

SELECT * FROM detalleboleta;

SELECT MAX(numeroBoleta) AS NumeroBoletaMaximo FROM Boleta;
SELECT MAX(numeroBoleta)FROM Boleta;
