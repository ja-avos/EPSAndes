--Delete de todos los datos de las tablas
delete from PROCEDIMIENTO;
delete from EXAMEN_DIAGNOSTICO;
delete from HOSPITALIZACION;
delete from TERAPIA;
delete from CONSULTA;
delete from RESERVA;
delete from ORDEN;
delete from HORARIO;
delete from TRABAJA_EN;
delete from RECEPCIONISTA;
delete from AFILIADO;
delete from MEDICO;
delete from IPS;
delete from PARTICIPAN;
delete from CAMPANA;
delete from SERVICIO_SALUD;
delete from SERVICIO_DESHABILITADO;
delete from USUARIO;
delete from TIPO_CONSULTA;
delete from TIPO_SERVICIO;
delete from TIPO_ID;
delete from ROL;

--Registro de tipo de documentos.
insert into TIPO_ID (ID_TIPO, NOMBRE) values (1, 'CC');
insert into TIPO_ID (ID_TIPO, NOMBRE) values (2, 'CE');
insert into TIPO_ID (ID_TIPO, NOMBRE) values (3, 'TI');
insert into TIPO_ID (ID_TIPO, NOMBRE) values (4, 'NIT');

--Registro de tipo de servicio.
insert into TIPO_SERVICIO (ID_SERVICIO, NOMBRE) values (1, 'Consulta');
insert into TIPO_SERVICIO (ID_SERVICIO, NOMBRE) values (2, 'ExamenDiagnostico');
insert into TIPO_SERVICIO (ID_SERVICIO, NOMBRE) values (3, 'Terapia');
insert into TIPO_SERVICIO (ID_SERVICIO, NOMBRE) values (4, 'Procedimiento');
insert into TIPO_SERVICIO (ID_SERVICIO, NOMBRE) values (5, 'Hospitalizacion');

--Registro de tipo de consultas.
insert into TIPO_CONSULTA (ID_TIPO, NOMBRE) values (1, 'General');
insert into TIPO_CONSULTA (ID_TIPO, NOMBRE) values (2, 'Especialista');
insert into TIPO_CONSULTA (ID_TIPO, NOMBRE) values (3, 'Control');
insert into TIPO_CONSULTA (ID_TIPO, NOMBRE) values (4, 'Urgencias');

--Para tabla roles (RF1), 5 roles diferentes.
insert into ROL (ID_ROL, ROL) values (1, 'Afiliado');
insert into ROL (ID_ROL, ROL) values (2, 'Medico');
insert into ROL (ID_ROL, ROL) values (3, 'Recepcionista');
insert into ROL (ID_ROL, ROL) values (4, 'Administrador de Datos');
insert into ROL (ID_ROL, ROL) values (5, 'Gerente');

--Registro de usuarios. (1 gerente, 1 admin de datos, 1 recepcionista por IPS (2), 4 medicos por cada servicio (32), 15 afiliados) RF2
--Gerente (id: 999999999)
insert into USUARIO (ID_USUARIO, NOMBRE, CORREO, ID, TIPO_ID, ROL) values (999999999, 'Jdavie Kibbe', 'jkibbe0@google.co.jp', 607716678, 2, 5);
--Admin de datos (id: 888888888)
insert into USUARIO (ID_USUARIO, NOMBRE, CORREO, ID, TIPO_ID, ROL) values (888888888, 'Charmian Garfit', 'cgarfit1@woothemes.com', 497352866, 1, 4);

--Registro de Servicios de Salud:
insert into SERVICIO_SALUD (ID_SERVICIO, NOMBRE, TIPO) values (1, 'Consulta general', 1);
insert into SERVICIO_SALUD (ID_SERVICIO, NOMBRE, TIPO) values (2, 'Consulta de urgencias', 1);
insert into SERVICIO_SALUD (ID_SERVICIO, NOMBRE, TIPO) values (3, 'Remision con especialista', 1);
insert into SERVICIO_SALUD (ID_SERVICIO, NOMBRE, TIPO) values (4, 'Consulta de control', 1);
insert into SERVICIO_SALUD (ID_SERVICIO, NOMBRE, TIPO) values (5, 'Examen diagnostico', 2);
insert into SERVICIO_SALUD (ID_SERVICIO, NOMBRE, TIPO) values (6, 'Terapia', 3);
insert into SERVICIO_SALUD (ID_SERVICIO, NOMBRE, TIPO) values (7, 'Procedimiento medico', 4);
insert into SERVICIO_SALUD (ID_SERVICIO, NOMBRE, TIPO) values (8, 'Hospitalizacion', 5);

--Registro de Campanas:
insert into CAMPANA (ID_CAMPANA, CANCELADA, FECHA_INICIO, FECHA_FIN) values (1, 0, TIMESTAMP '2019-01-01 08:00:00', TIMESTAMP '2020-01-01 16:00:00');
insert into CAMPANA (ID_CAMPANA, CANCELADA, FECHA_INICIO, FECHA_FIN) values (2, 0, TIMESTAMP '2019-06-01 08:00:00', TIMESTAMP '2020-06-01 16:00:00');
insert into CAMPANA (ID_CAMPANA, CANCELADA, FECHA_INICIO, FECHA_FIN) values (3, 0, TIMESTAMP '2019-03-03 08:00:00', TIMESTAMP '2020-03-03 16:00:00');
insert into CAMPANA (ID_CAMPANA, CANCELADA, FECHA_INICIO, FECHA_FIN) values (4, 0, TIMESTAMP '2019-10-10 08:00:00', TIMESTAMP '2020-05-10 16:00:00');

COMMIT;