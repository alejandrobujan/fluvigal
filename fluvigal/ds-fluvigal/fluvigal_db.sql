--------------------------------------------------------------------------------------------------------------------------------------------------------------
--DESEÑO LÓXICO DA BASE DE DATOS (Modelo Relacional)
--------------------------------------------------------------------------------------------------------------------------------------------------------------
--	Rio(idRio, nome) PK-> idRio
--	Provincia(idProvincia, nome) PK-> idProvincia
--	Estacion(idEstacion, nome, latitude, lonxitude, concello, idRio, idProvincia) PK-> idEstacion | FK(Rio)-> idRio | FK(Provincia)-> idProvincia
--	TipoMedicion(idTipo, nome) PK-> idTipo
--	Medicion(idEstacion, idTipo, unidade, valor, data) PK-> (idEstacion, idTipo) | FK(Estacion)-> idEstacion [UC][DC] | FK(TipoMedicion)-> idTipo
--------------------------------------------------------------------------------------------------------------------------------------------------------------
--SCRIPT CREACIÓN BASE DE DATOS MYSQL
--------------------------------------------------------------------------------------------------------------------------------------------------------------
CREATE DATABASE fluvigal_db;
USE fluvigal_db;

create user ''@'%';
grant SELECT on fluvigal_db.* to ''@'%';
grant all on fluvigal_db.* to usuario@'%' identified by 'abc123.';

CREATE TABLE Rio (
    idRio INT         PRIMARY KEY,
    nome  VARCHAR(50) UNIQUE
);

CREATE TABLE Provincia (
    idProvincia INT         PRIMARY KEY,
    nome        VARCHAR(50) UNIQUE
);

CREATE TABLE Estacion (
    idEstacion  INT         PRIMARY KEY,
    nome        VARCHAR(50) UNIQUE,
    latitude    DOUBLE,
    lonxitude   DOUBLE,
    concello    VARCHAR(50),
    idRio       INT         REFERENCES Rio (idRio),
    idProvincia INT         REFERENCES Provincia (idProvincia) 
);

CREATE TABLE TipoMedicion (
    idTipo INT         PRIMARY KEY,
    nome   VARCHAR(50) UNIQUE
);

CREATE TABLE Medicion (
    idEstacion INT         REFERENCES Estacion (idEstacion) ON UPDATE CASCADE ON DELETE CASCADE,
    idTipo     INT	   REFERENCES TipoMedicion (idTipo) ON UPDATE CASCADE ON DELETE CASCADE,
    unidade    VARCHAR(50),
    valor      DOUBLE,
    data       DATETIME,
    PRIMARY KEY (idEstacion, idTipo)
);

INSERT INTO Provincia VALUES (1,'A Coruña');
INSERT INTO Provincia VALUES (2,'Pontevedra');
INSERT INTO Provincia VALUES (3,'Lugo');
INSERT INTO Provincia VALUES (4,'Ourense');

INSERT INTO TipoMedicion VALUES (1, 'Nivel Medio da Auga');
INSERT INTO TipoMedicion VALUES (4, 'Caudal Medio da Auga');

INSERT INTO Rio VALUES(1, 'Masma');
INSERT INTO Rio VALUES(2, 'Ouro');
INSERT INTO Rio VALUES(3, 'Cobo');
INSERT INTO Rio VALUES(4, 'Landro');
INSERT INTO Rio VALUES(5, 'Sor');
INSERT INTO Rio VALUES(6, 'Mera');
INSERT INTO Rio VALUES(7, 'Mestas');
INSERT INTO Rio VALUES(8, 'Xubia');
INSERT INTO Rio VALUES(9, 'Belelle');
INSERT INTO Rio VALUES(10, 'Eume');
INSERT INTO Rio VALUES(11, 'Mandeo');
INSERT INTO Rio VALUES(12, 'Mendo');
INSERT INTO Rio VALUES(13, 'Mero');
INSERT INTO Rio VALUES(14, 'Anllóns');
INSERT INTO Rio VALUES(15, 'Castro');
INSERT INTO Rio VALUES(16, 'Cee');
INSERT INTO Rio VALUES(17, 'Xallas');
INSERT INTO Rio VALUES(18, 'Tambre');
INSERT INTO Rio VALUES(19, 'Lengüelle');
INSERT INTO Rio VALUES(20, 'Dubra');
INSERT INTO Rio VALUES(21, 'Barcala');
INSERT INTO Rio VALUES(22, 'Sar');
INSERT INTO Rio VALUES(23, 'Furelos');
INSERT INTO Rio VALUES(24, 'Ulla');
INSERT INTO Rio VALUES(25, 'Arnego');
INSERT INTO Rio VALUES(26, 'Deza');
INSERT INTO Rio VALUES(27, 'Lérez');
INSERT INTO Rio VALUES(28, 'Verdugo');
INSERT INTO Rio VALUES(29, 'Oitavén');
INSERT INTO Rio VALUES(30, 'Lagares');
INSERT INTO Rio VALUES(31, 'Miñor');
INSERT INTO Rio VALUES(32, 'Grova');

INSERT INTO Estacion VALUES(30431, 'Masma', 43.47774, -7.33423, 'Mondoñedo', 1, 3);
INSERT INTO Estacion VALUES(30433, 'Ouro', 43.55815, -7.37617, 'Foz', 2, 3);
INSERT INTO Estacion VALUES(30435, 'Cobo', 43.68621, -7.44773, 'Cervo', 3, 3);
INSERT INTO Estacion VALUES(30438, 'Landro', 43.61945, -7.58993, 'Viveiro', 4, 3);
INSERT INTO Estacion VALUES(30441, 'Sor (Baixo)', 43.70354, -7.693, 'O Vicedo', 5, 3);
INSERT INTO Estacion VALUES(30443, 'Mera', 43.64048, -7.90734, 'Ortigueira', 6, 1);
INSERT INTO Estacion VALUES(30445, 'Rego das Mestas', 43.62607, -8.03861, 'Valdoviño', 7, 1);
INSERT INTO Estacion VALUES(30446, 'Xubia', 43.53364, -8.07699, 'San Sadurniño', 8, 1);
INSERT INTO Estacion VALUES(30449, 'Belelle', 43.5052, -8.13047, 'Neda', 9, 1);
INSERT INTO Estacion VALUES(30455, 'Eume (Ribeira)', 43.45616, -7.83313, 'As Pontes', 10, 1);
INSERT INTO Estacion VALUES(30464, 'Mandeo', 43.24944, -8.05481, 'Aranga', 11, 1);
INSERT INTO Estacion VALUES(30469, 'Mendo', 43.26607, -8.19984, 'Betanzos', 12, 1);
INSERT INTO Estacion VALUES(30470, 'Mero', 43.25781, -8.25531, 'Betanzos', 13, 1);
INSERT INTO Estacion VALUES(30473, 'Mero (A Telva)', 43.2955, -8.35528, 'Cambre', 13, 1);
INSERT INTO Estacion VALUES(30483, 'Anllóns (Carballo)', 43.21126, -8.69119, 'Carballo', 14, 1);
INSERT INTO Estacion VALUES(30485, 'Anllóns', 43.2289, -8.8853, 'Ponteceso', 14, 1);
INSERT INTO Estacion VALUES(30506, 'Castro', 43.00426, -9.1904, 'Cee', 15, 1);
INSERT INTO Estacion VALUES(30510, 'Cee', 42.96173, -9.19015, 'Cee', 16, 1);
INSERT INTO Estacion VALUES(30512, 'Xallas 1', 42.99734, -8.88816, 'Santa Comba', 17, 1);
INSERT INTO Estacion VALUES(30514, 'Xallas 2', 42.96324, -9.01682, 'Mazaricos', 17, 1);
INSERT INTO Estacion VALUES(30520, 'Tambre', 42.9766, -8.39864, 'Oroso', 18, 1);
INSERT INTO Estacion VALUES(30522, 'Lengüelle (Desembocadura en Tambre)', 42.99201, -8.45415, 'Oroso', 19, 1);
INSERT INTO Estacion VALUES(30525, 'Dubra (Desembocadura en Tambre)', 42.97659, -8.65293, 'Val Do Dubra', 20, 1);
INSERT INTO Estacion VALUES(30528, 'Barcala (Desembocadura en Tambre)', 42.90797, -8.73848, 'Negreira', 21, 1);
INSERT INTO Estacion VALUES(30540, 'Sar', 42.83151, -8.64697, 'Brion', 22, 1);
INSERT INTO Estacion VALUES(30542, 'Furelos', 42.85923, -8.01902, 'Santiso', 23, 1);
INSERT INTO Estacion VALUES(30544, 'Ulla', 42.84794, -8.02389, 'Santiso', 24, 1);
INSERT INTO Estacion VALUES(30546, 'Arnego (Desembocadura en Ulla)', 42.77903, -8.10049, 'Agolada', 25, 2);
INSERT INTO Estacion VALUES(30550, 'Ulla (Touro)', 42.82528, -8.27062, 'Touro', 24, 1);
INSERT INTO Estacion VALUES(30552, 'Deza', 42.7783, -8.33605, 'Silleda', 26, 2);
INSERT INTO Estacion VALUES(30554, 'Ulla (Teo)', 42.76065, -8.54616, 'Teo', 24, 1);
INSERT INTO Estacion VALUES(30578, 'Lérez', 42.45326, -8.61271, 'Pontevedra', 27, 2);
INSERT INTO Estacion VALUES(30585, 'Verdugo', 42.39133, -8.49865, 'Pontecaldelas', 28, 2);
INSERT INTO Estacion VALUES(30588, 'Oitavén', 42.34143, -8.55525, 'Soutomaior', 29, 2);
INSERT INTO Estacion VALUES(30593, 'Lagares', 42.22339, -8.69378, 'Vigo', 30, 2);
INSERT INTO Estacion VALUES(30594, 'Miñor', 42.11177, -8.77275, 'Gondomar', 31, 2);
INSERT INTO Estacion VALUES(30595, 'Grova', 42.10645, -8.81705, 'Baiona', 32, 2);

INSERT INTO Medicion VALUES(30431, 1, NULL, NULL, NULL);
INSERT INTO Medicion VALUES(30431, 4, NULL, NULL, NULL);
INSERT INTO Medicion VALUES(30433, 1, NULL, NULL, NULL);
INSERT INTO Medicion VALUES(30433, 4, NULL, NULL, NULL);
INSERT INTO Medicion VALUES(30435, 1, NULL, NULL, NULL);
INSERT INTO Medicion VALUES(30435, 4, NULL, NULL, NULL);
INSERT INTO Medicion VALUES(30438, 1, NULL, NULL, NULL);
INSERT INTO Medicion VALUES(30438, 4, NULL, NULL, NULL);
INSERT INTO Medicion VALUES(30441, 1, NULL, NULL, NULL);
INSERT INTO Medicion VALUES(30441, 4, NULL, NULL, NULL);
INSERT INTO Medicion VALUES(30443, 1, NULL, NULL, NULL);
INSERT INTO Medicion VALUES(30443, 4, NULL, NULL, NULL);
INSERT INTO Medicion VALUES(30445, 1, NULL, NULL, NULL);
INSERT INTO Medicion VALUES(30445, 4, NULL, NULL, NULL);
INSERT INTO Medicion VALUES(30446, 1, NULL, NULL, NULL);
INSERT INTO Medicion VALUES(30446, 4, NULL, NULL, NULL);
INSERT INTO Medicion VALUES(30449, 1, NULL, NULL, NULL);
INSERT INTO Medicion VALUES(30449, 4, NULL, NULL, NULL);
INSERT INTO Medicion VALUES(30455, 1, NULL, NULL, NULL);
INSERT INTO Medicion VALUES(30455, 4, NULL, NULL, NULL);
INSERT INTO Medicion VALUES(30464, 1, NULL, NULL, NULL);
INSERT INTO Medicion VALUES(30464, 4, NULL, NULL, NULL);
INSERT INTO Medicion VALUES(30469, 1, NULL, NULL, NULL);
INSERT INTO Medicion VALUES(30469, 4, NULL, NULL, NULL);
INSERT INTO Medicion VALUES(30470, 1, NULL, NULL, NULL);
INSERT INTO Medicion VALUES(30470, 4, NULL, NULL, NULL);
INSERT INTO Medicion VALUES(30473, 1, NULL, NULL, NULL);
INSERT INTO Medicion VALUES(30473, 4, NULL, NULL, NULL);
INSERT INTO Medicion VALUES(30483, 1, NULL, NULL, NULL);
INSERT INTO Medicion VALUES(30483, 4, NULL, NULL, NULL);
INSERT INTO Medicion VALUES(30485, 1, NULL, NULL, NULL);
INSERT INTO Medicion VALUES(30485, 4, NULL, NULL, NULL);
INSERT INTO Medicion VALUES(30506, 1, NULL, NULL, NULL);
INSERT INTO Medicion VALUES(30506, 4, NULL, NULL, NULL);
INSERT INTO Medicion VALUES(30510, 1, NULL, NULL, NULL);
INSERT INTO Medicion VALUES(30510, 4, NULL, NULL, NULL);
INSERT INTO Medicion VALUES(30512, 1, NULL, NULL, NULL);
INSERT INTO Medicion VALUES(30512, 4, NULL, NULL, NULL);
INSERT INTO Medicion VALUES(30514, 1, NULL, NULL, NULL);
INSERT INTO Medicion VALUES(30514, 4, NULL, NULL, NULL);
INSERT INTO Medicion VALUES(30520, 1, NULL, NULL, NULL);
INSERT INTO Medicion VALUES(30520, 4, NULL, NULL, NULL);
INSERT INTO Medicion VALUES(30522, 1, NULL, NULL, NULL);
INSERT INTO Medicion VALUES(30522, 4, NULL, NULL, NULL);
INSERT INTO Medicion VALUES(30525, 1, NULL, NULL, NULL);
INSERT INTO Medicion VALUES(30525, 4, NULL, NULL, NULL);
INSERT INTO Medicion VALUES(30528, 1, NULL, NULL, NULL);
INSERT INTO Medicion VALUES(30528, 4, NULL, NULL, NULL);
INSERT INTO Medicion VALUES(30540, 1, NULL, NULL, NULL);
INSERT INTO Medicion VALUES(30540, 4, NULL, NULL, NULL);
INSERT INTO Medicion VALUES(30542, 1, NULL, NULL, NULL);
INSERT INTO Medicion VALUES(30542, 4, NULL, NULL, NULL);
INSERT INTO Medicion VALUES(30544, 1, NULL, NULL, NULL);
INSERT INTO Medicion VALUES(30544, 4, NULL, NULL, NULL);
INSERT INTO Medicion VALUES(30546, 1, NULL, NULL, NULL);
INSERT INTO Medicion VALUES(30546, 4, NULL, NULL, NULL);
INSERT INTO Medicion VALUES(30550, 1, NULL, NULL, NULL);
INSERT INTO Medicion VALUES(30550, 4, NULL, NULL, NULL);
INSERT INTO Medicion VALUES(30552, 1, NULL, NULL, NULL);
INSERT INTO Medicion VALUES(30552, 4, NULL, NULL, NULL);
INSERT INTO Medicion VALUES(30554, 1, NULL, NULL, NULL);
INSERT INTO Medicion VALUES(30554, 4, NULL, NULL, NULL);
INSERT INTO Medicion VALUES(30578, 1, NULL, NULL, NULL);
INSERT INTO Medicion VALUES(30578, 4, NULL, NULL, NULL);
INSERT INTO Medicion VALUES(30585, 1, NULL, NULL, NULL);
INSERT INTO Medicion VALUES(30585, 4, NULL, NULL, NULL);
INSERT INTO Medicion VALUES(30588, 1, NULL, NULL, NULL);
INSERT INTO Medicion VALUES(30588, 4, NULL, NULL, NULL);
INSERT INTO Medicion VALUES(30593, 1, NULL, NULL, NULL);
INSERT INTO Medicion VALUES(30593, 4, NULL, NULL, NULL);
INSERT INTO Medicion VALUES(30594, 1, NULL, NULL, NULL);
INSERT INTO Medicion VALUES(30594, 4, NULL, NULL, NULL);
INSERT INTO Medicion VALUES(30595, 1, NULL, NULL, NULL);
INSERT INTO Medicion VALUES(30595, 4, NULL, NULL, NULL);

