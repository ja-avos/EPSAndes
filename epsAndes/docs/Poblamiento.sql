--Delete de todos los datos de las tablas
delete from HORARIO;
delete from TRABAJA_EN;
delete from AFILIADO;
delete from MEDICO;
delete from IPS;
delete from SERVICIO_SALUD;
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
--Gerente (id: 1)
insert into USUARIO (ID_USUARIO, NOMBRE, CORREO, ID, TIPO_ID, ROL) values (1, 'Jdavie Kibbe', 'jkibbe0@google.co.jp', 607716678, 2, 5);
--Admin de datos (id: 2)
insert into USUARIO (ID_USUARIO, NOMBRE, CORREO, ID, TIPO_ID, ROL) values (2, 'Charmian Garfit', 'cgarfit1@woothemes.com', 497352866, 1, 4);
--Recepcionistas (id: 3-4)
insert into USUARIO (ID_USUARIO, NOMBRE, CORREO, ID, TIPO_ID, ROL) values (3, 'Jobi Ondrasek', 'jondrasek2@instagram.com', 1248758333, 2, 3);
insert into USUARIO (ID_USUARIO, NOMBRE, CORREO, ID, TIPO_ID, ROL) values (4, 'Shadow Renfield', 'srenfield3@earthlink.net', 312089295, 1, 3);
--Medicos (id: 5 - 36)
insert into USUARIO (ID_USUARIO, NOMBRE, CORREO, ID, TIPO_ID, ROL) values (5, 'Tiebold Hedylstone', 'thedylstone4@cbslocal.com', 853874181, 1, 2);
insert into USUARIO (ID_USUARIO, NOMBRE, CORREO, ID, TIPO_ID, ROL) values (6, 'Marius Heggadon', 'mheggadon5@1und1.de', 1137366266, 2, 2);
insert into USUARIO (ID_USUARIO, NOMBRE, CORREO, ID, TIPO_ID, ROL) values (7, 'Osbourn Oakwell', 'ooakwell6@comcast.net', 1441804553, 1, 2);
insert into USUARIO (ID_USUARIO, NOMBRE, CORREO, ID, TIPO_ID, ROL) values (8, 'Hugh Bumpus', 'hbumpus7@icq.com', 779296636, 2, 2);
insert into USUARIO (ID_USUARIO, NOMBRE, CORREO, ID, TIPO_ID, ROL) values (9, 'Crin Staker', 'cstaker8@nature.com', 899927549, 2, 2);
insert into USUARIO (ID_USUARIO, NOMBRE, CORREO, ID, TIPO_ID, ROL) values (10, 'Sheridan Bonnefin', 'sbonnefin9@geocities.jp', 1424426318, 1, 2);
insert into USUARIO (ID_USUARIO, NOMBRE, CORREO, ID, TIPO_ID, ROL) values (11, 'Hadley Johnston', 'hjohnstona@infoseek.co.jp', 442631563, 2, 2);
insert into USUARIO (ID_USUARIO, NOMBRE, CORREO, ID, TIPO_ID, ROL) values (12, 'Frederich Tuckwell', 'ftuckwellb@mit.edu', 843208357, 2, 2);
insert into USUARIO (ID_USUARIO, NOMBRE, CORREO, ID, TIPO_ID, ROL) values (13, 'Nerti Avrasin', 'navrasinc@fc2.com', 705312019, 2, 2);
insert into USUARIO (ID_USUARIO, NOMBRE, CORREO, ID, TIPO_ID, ROL) values (14, 'Lesley Nassey', 'lnasseyd@telegraph.co.uk', 705667983, 2, 2);
insert into USUARIO (ID_USUARIO, NOMBRE, CORREO, ID, TIPO_ID, ROL) values (15, 'Dillie Anwell', 'danwelle@tripod.com', 676151576, 2, 2);
insert into USUARIO (ID_USUARIO, NOMBRE, CORREO, ID, TIPO_ID, ROL) values (16, 'Josepha Portinari', 'jportinarif@youtube.com', 1026339032, 1, 2);
insert into USUARIO (ID_USUARIO, NOMBRE, CORREO, ID, TIPO_ID, ROL) values (17, 'Cris Skydall', 'cskydallg@cmu.edu', 202276304, 2, 2);
insert into USUARIO (ID_USUARIO, NOMBRE, CORREO, ID, TIPO_ID, ROL) values (18, 'Oralla Willbond', 'owillbondh@uiuc.edu', 849104806, 2, 2);
insert into USUARIO (ID_USUARIO, NOMBRE, CORREO, ID, TIPO_ID, ROL) values (19, 'Melvin Doeg', 'mdoegi@parallels.com', 1403214948, 1, 2);
insert into USUARIO (ID_USUARIO, NOMBRE, CORREO, ID, TIPO_ID, ROL) values (20, 'Fifine Pietsma', 'fpietsmaj@hao123.com', 128139535, 2, 2);
insert into USUARIO (ID_USUARIO, NOMBRE, CORREO, ID, TIPO_ID, ROL) values (21, 'Tony Veasey', 'tveaseyk@gravatar.com', 977584451, 1, 2);
insert into USUARIO (ID_USUARIO, NOMBRE, CORREO, ID, TIPO_ID, ROL) values (22, 'King Sowman', 'ksowmanl@bbc.co.uk', 848749316, 2, 2);
insert into USUARIO (ID_USUARIO, NOMBRE, CORREO, ID, TIPO_ID, ROL) values (23, 'Luce Bernt', 'lberntm@godaddy.com', 1107487723, 1, 2);
insert into USUARIO (ID_USUARIO, NOMBRE, CORREO, ID, TIPO_ID, ROL) values (24, 'Brade Charlo', 'bcharlon@buzzfeed.com', 429136749, 2, 2);
insert into USUARIO (ID_USUARIO, NOMBRE, CORREO, ID, TIPO_ID, ROL) values (25, 'Deloria Dowbakin', 'ddowbakino@cbc.ca', 835490686, 2, 2);
insert into USUARIO (ID_USUARIO, NOMBRE, CORREO, ID, TIPO_ID, ROL) values (26, 'Bethena Jedraszczyk', 'bjedraszczykp@squarespace.com', 1076053197, 1, 2);
insert into USUARIO (ID_USUARIO, NOMBRE, CORREO, ID, TIPO_ID, ROL) values (27, 'Amalie Carleton', 'acarletonq@nhs.uk', 1495579512, 2, 2);
insert into USUARIO (ID_USUARIO, NOMBRE, CORREO, ID, TIPO_ID, ROL) values (28, 'Adolphe Moatt', 'amoattr@wired.com', 1372701307, 2, 2);
insert into USUARIO (ID_USUARIO, NOMBRE, CORREO, ID, TIPO_ID, ROL) values (29, 'Melantha Sidary', 'msidarys@eventbrite.com', 509336557, 2, 2);
insert into USUARIO (ID_USUARIO, NOMBRE, CORREO, ID, TIPO_ID, ROL) values (30, 'Lyn Szymon', 'lszymont@bloglovin.com', 578738279, 1, 2);
insert into USUARIO (ID_USUARIO, NOMBRE, CORREO, ID, TIPO_ID, ROL) values (31, 'Martie Haller', 'mhalleru@naver.com', 756268235, 1, 2);
insert into USUARIO (ID_USUARIO, NOMBRE, CORREO, ID, TIPO_ID, ROL) values (32, 'Meggy O'' Hanvey', 'mov@china.com.cn', 704696218, 2, 2);
insert into USUARIO (ID_USUARIO, NOMBRE, CORREO, ID, TIPO_ID, ROL) values (33, 'Spense Maymond', 'smaymondw@virginia.edu', 1185446338, 1, 2);
insert into USUARIO (ID_USUARIO, NOMBRE, CORREO, ID, TIPO_ID, ROL) values (34, 'James Pedlow', 'jpedlowx@cornell.edu', 124367808, 2, 2);
insert into USUARIO (ID_USUARIO, NOMBRE, CORREO, ID, TIPO_ID, ROL) values (35, 'Carolan Brunelli', 'cbrunelliy@skype.com', 630924635, 2, 2);
insert into USUARIO (ID_USUARIO, NOMBRE, CORREO, ID, TIPO_ID, ROL) values (36, 'Verina Napthine', 'vnapthinez@time.com', 296734237, 1, 2);
--Afiliados (id: 37-51)
insert into USUARIO (ID_USUARIO, NOMBRE, CORREO, ID, TIPO_ID, ROL) values (37, 'Averell Haddleton', 'ahaddleton10@taobao.com', 290800505, 2, 1);
insert into USUARIO (ID_USUARIO, NOMBRE, CORREO, ID, TIPO_ID, ROL) values (38, 'Cheri Feighney', 'cfeighney11@mapquest.com', 329665339, 1, 1);
insert into USUARIO (ID_USUARIO, NOMBRE, CORREO, ID, TIPO_ID, ROL) values (39, 'Forster McAtamney', 'fmcatamney12@nature.com', 1006773112, 1, 1);
insert into USUARIO (ID_USUARIO, NOMBRE, CORREO, ID, TIPO_ID, ROL) values (40, 'Rex Fealey', 'rfealey13@oracle.com', 84944189, 1, 1);
insert into USUARIO (ID_USUARIO, NOMBRE, CORREO, ID, TIPO_ID, ROL) values (41, 'Glynis Jent', 'gjent14@naver.com', 124131052, 2, 1);
insert into USUARIO (ID_USUARIO, NOMBRE, CORREO, ID, TIPO_ID, ROL) values (42, 'Sheri Weston', 'sweston15@51.la', 241607704, 2, 1);
insert into USUARIO (ID_USUARIO, NOMBRE, CORREO, ID, TIPO_ID, ROL) values (43, 'Rolf Stickland', 'rstickland16@wp.com', 520412892, 1, 1);
insert into USUARIO (ID_USUARIO, NOMBRE, CORREO, ID, TIPO_ID, ROL) values (44, 'Ab Birks', 'abirks17@seesaa.net', 1458488906, 1, 1);
insert into USUARIO (ID_USUARIO, NOMBRE, CORREO, ID, TIPO_ID, ROL) values (45, 'Brockie MacMearty', 'bmacmearty18@paypal.com', 865997028, 1, 1);
insert into USUARIO (ID_USUARIO, NOMBRE, CORREO, ID, TIPO_ID, ROL) values (46, 'Eldridge McPaik', 'emcpaik19@cdbaby.com', 1073184341, 1, 1);
insert into USUARIO (ID_USUARIO, NOMBRE, CORREO, ID, TIPO_ID, ROL) values (47, 'Sallee Frazier', 'sfrazier1a@pen.io', 147850271, 1, 1);
insert into USUARIO (ID_USUARIO, NOMBRE, CORREO, ID, TIPO_ID, ROL) values (48, 'Evelyn Gulk', 'egulk1b@plala.or.jp', 1342247027, 1, 1);
insert into USUARIO (ID_USUARIO, NOMBRE, CORREO, ID, TIPO_ID, ROL) values (49, 'Eddie Bauld', 'ebauld1c@webs.com', 776666212, 1, 1);
insert into USUARIO (ID_USUARIO, NOMBRE, CORREO, ID, TIPO_ID, ROL) values (50, 'Pearle Fowlestone', 'pfowlestone1d@state.tx.us', 785971393, 1, 1);
insert into USUARIO (ID_USUARIO, NOMBRE, CORREO, ID, TIPO_ID, ROL) values (51, 'Polly Biscomb', 'pbiscomb1e@diigo.com', 901934300, 1, 1);
--Registro de Servicios de Salud:
insert into SERVICIO_SALUD (ID_SERVICIO, NOMBRE, TIPO) values (1, 'Consulta general', 1);
insert into SERVICIO_SALUD (ID_SERVICIO, NOMBRE, TIPO) values (2, 'Consulta de urgencias', 1);
insert into SERVICIO_SALUD (ID_SERVICIO, NOMBRE, TIPO) values (3, 'Remision con especialista', 1);
insert into SERVICIO_SALUD (ID_SERVICIO, NOMBRE, TIPO) values (4, 'Consulta de control', 1);
insert into SERVICIO_SALUD (ID_SERVICIO, NOMBRE, TIPO) values (5, 'Examen diagnostico', 2);
insert into SERVICIO_SALUD (ID_SERVICIO, NOMBRE, TIPO) values (6, 'Terapia', 3);
insert into SERVICIO_SALUD (ID_SERVICIO, NOMBRE, TIPO) values (7, 'Procedimiento medico', 4);
insert into SERVICIO_SALUD (ID_SERVICIO, NOMBRE, TIPO) values (8, 'Hospitalizacion', 5);

--Registro de IPS (2) RF3:
insert into IPS (ID_IPS, NOMBRE, LOCALIZACION) values (1, 'Roob, Purdy and Kuphal', '922 Moulton Circle');
insert into IPS (ID_IPS, NOMBRE, LOCALIZACION) values (2, 'Keebler, Kunze and Kozey', '35 Oak Valley Alley');

--Registro de medicos (16) RF4:
insert into MEDICO (ID_MEDICO, REGISTRO_MEDICO, ESPECIALIDAD, USUARIO) values (1, 19804177, 'Internal Auditor', 5);
insert into MEDICO (ID_MEDICO, REGISTRO_MEDICO, ESPECIALIDAD, USUARIO) values (2, 60562696, 'Engineer I', 6);
insert into MEDICO (ID_MEDICO, REGISTRO_MEDICO, ESPECIALIDAD, USUARIO) values (3, 88057503, 'Media Manager II', 7);
insert into MEDICO (ID_MEDICO, REGISTRO_MEDICO, ESPECIALIDAD, USUARIO) values (4, 77914889, 'Design Engineer', 8);
insert into MEDICO (ID_MEDICO, REGISTRO_MEDICO, ESPECIALIDAD, USUARIO) values (5, 49136244, 'Senior Cost Accountant', 9);
insert into MEDICO (ID_MEDICO, REGISTRO_MEDICO, ESPECIALIDAD, USUARIO) values (6, 41036195, 'Senior Developer', 10);
insert into MEDICO (ID_MEDICO, REGISTRO_MEDICO, ESPECIALIDAD, USUARIO) values (7, 56626722, 'Senior Sales Associate', 11);
insert into MEDICO (ID_MEDICO, REGISTRO_MEDICO, ESPECIALIDAD, USUARIO) values (8, 38061477, 'Account Coordinator', 12);
insert into MEDICO (ID_MEDICO, REGISTRO_MEDICO, ESPECIALIDAD, USUARIO) values (9, 25249124, 'Financial Analyst', 13);
insert into MEDICO (ID_MEDICO, REGISTRO_MEDICO, ESPECIALIDAD, USUARIO) values (10, 76200649, 'Human Resources Manager', 14);
insert into MEDICO (ID_MEDICO, REGISTRO_MEDICO, ESPECIALIDAD, USUARIO) values (11, 81524743, 'Environmental Specialist', 15);
insert into MEDICO (ID_MEDICO, REGISTRO_MEDICO, ESPECIALIDAD, USUARIO) values (12, 89481732, 'Research Nurse', 16);
insert into MEDICO (ID_MEDICO, REGISTRO_MEDICO, ESPECIALIDAD, USUARIO) values (13, 76858062, 'Account Coordinator', 17);
insert into MEDICO (ID_MEDICO, REGISTRO_MEDICO, ESPECIALIDAD, USUARIO) values (14, 39687792, 'Dental Hygienist', 18);
insert into MEDICO (ID_MEDICO, REGISTRO_MEDICO, ESPECIALIDAD, USUARIO) values (15, 38331712, 'Software Consultant', 19);
insert into MEDICO (ID_MEDICO, REGISTRO_MEDICO, ESPECIALIDAD, USUARIO) values (16, 86658730, 'Physical Therapy Assistant', 20);
--Registro trabaja en:
insert into TRABAJA_EN (IPS, MEDICO) values (1, 1);
insert into TRABAJA_EN (IPS, MEDICO) values (1, 2);
insert into TRABAJA_EN (IPS, MEDICO) values (2, 3);
insert into TRABAJA_EN (IPS, MEDICO) values (1, 4);
insert into TRABAJA_EN (IPS, MEDICO) values (2, 5);
insert into TRABAJA_EN (IPS, MEDICO) values (2, 6);
insert into TRABAJA_EN (IPS, MEDICO) values (1, 7);
insert into TRABAJA_EN (IPS, MEDICO) values (2, 8);
insert into TRABAJA_EN (IPS, MEDICO) values (1, 9);
insert into TRABAJA_EN (IPS, MEDICO) values (1, 10);
insert into TRABAJA_EN (IPS, MEDICO) values (1, 11);
insert into TRABAJA_EN (IPS, MEDICO) values (1, 12);
insert into TRABAJA_EN (IPS, MEDICO) values (1, 13);
insert into TRABAJA_EN (IPS, MEDICO) values (2, 14);
insert into TRABAJA_EN (IPS, MEDICO) values (2, 15);
insert into TRABAJA_EN (IPS, MEDICO) values (1, 16);

--Registro de Afiliados (15) RF5:
insert into AFILIADO (ID_AFILIADO, FECHA_NACIMIENTO, USUARIO) values (1, TIMESTAMP '1966-05-29 18:56:21.000000', 37);
insert into AFILIADO (ID_AFILIADO, FECHA_NACIMIENTO, USUARIO) values (2, TIMESTAMP '1965-05-04 11:58:08.000000', 38);
insert into AFILIADO (ID_AFILIADO, FECHA_NACIMIENTO, USUARIO) values (3, TIMESTAMP '1991-06-02 05:13:40.000000', 39);
insert into AFILIADO (ID_AFILIADO, FECHA_NACIMIENTO, USUARIO) values (4, TIMESTAMP '1933-05-28 07:00:10.000000', 40);
insert into AFILIADO (ID_AFILIADO, FECHA_NACIMIENTO, USUARIO) values (5, TIMESTAMP '1988-10-27 04:39:32.000000', 41);
insert into AFILIADO (ID_AFILIADO, FECHA_NACIMIENTO, USUARIO) values (6, TIMESTAMP '1994-07-21 18:48:28.000000', 42);
insert into AFILIADO (ID_AFILIADO, FECHA_NACIMIENTO, USUARIO) values (7, TIMESTAMP '1961-08-20 22:27:10.000000', 43);
insert into AFILIADO (ID_AFILIADO, FECHA_NACIMIENTO, USUARIO) values (8, TIMESTAMP '1955-07-02 21:22:24.000000', 44);
insert into AFILIADO (ID_AFILIADO, FECHA_NACIMIENTO, USUARIO) values (9, TIMESTAMP '1933-09-19 07:18:10.000000', 45);
insert into AFILIADO (ID_AFILIADO, FECHA_NACIMIENTO, USUARIO) values (10, TIMESTAMP '1961-06-16 02:29:34.000000', 46);
insert into AFILIADO (ID_AFILIADO, FECHA_NACIMIENTO, USUARIO) values (11, TIMESTAMP '1945-11-03 03:41:53.000000', 47);
insert into AFILIADO (ID_AFILIADO, FECHA_NACIMIENTO, USUARIO) values (12, TIMESTAMP '1951-08-07 17:39:47.000000', 48);
insert into AFILIADO (ID_AFILIADO, FECHA_NACIMIENTO, USUARIO) values (13, TIMESTAMP '1969-12-19 23:32:41.000000', 49);
insert into AFILIADO (ID_AFILIADO, FECHA_NACIMIENTO, USUARIO) values (14, TIMESTAMP '1932-03-04 03:35:34.000000', 50);
insert into AFILIADO (ID_AFILIADO, FECHA_NACIMIENTO, USUARIO) values (15, TIMESTAMP '1986-03-13 00:26:24.000000', 51);

--Registro de Servicios prestados por IPS RF6:
insert into HORARIO (ID_HORARIO, IPS, SERVICIO, CAPACIDAD, DIA, HORA_INICIO, HORA_FIN) values (1, 1, 1, 50, 7, TIMESTAMP '2000-01-01 08:00:00', TIMESTAMP '2000-01-01 16:00:00');
insert into HORARIO (ID_HORARIO, IPS, SERVICIO, CAPACIDAD, DIA, HORA_INICIO, HORA_FIN) values (2, 1, 1, 46, 4, TIMESTAMP '2000-01-01 10:00:00', TIMESTAMP '2000-01-01 16:00:00');
insert into HORARIO (ID_HORARIO, IPS, SERVICIO, CAPACIDAD, DIA, HORA_INICIO, HORA_FIN) values (3, 1, 1, 17, 2, TIMESTAMP '2000-01-01 09:00:00', TIMESTAMP '2000-01-01 16:30:00');
insert into HORARIO (ID_HORARIO, IPS, SERVICIO, CAPACIDAD, DIA, HORA_INICIO, HORA_FIN) values (4, 1, 2, 20, 3, TIMESTAMP '2000-01-01 10:00:00', TIMESTAMP '2000-01-01 15:00:00');
insert into HORARIO (ID_HORARIO, IPS, SERVICIO, CAPACIDAD, DIA, HORA_INICIO, HORA_FIN) values (5, 1, 3, 17, 7, TIMESTAMP '2000-01-01 10:00:00', TIMESTAMP '2000-01-01 15:00:00');
insert into HORARIO (ID_HORARIO, IPS, SERVICIO, CAPACIDAD, DIA, HORA_INICIO, HORA_FIN) values (6, 1, 3, 46, 4, TIMESTAMP '2000-01-01 10:00:00', TIMESTAMP '2000-01-01 16:00:00');
insert into HORARIO (ID_HORARIO, IPS, SERVICIO, CAPACIDAD, DIA, HORA_INICIO, HORA_FIN) values (7, 1, 3, 29, 5, TIMESTAMP '2000-01-01 09:00:00', TIMESTAMP '2000-01-01 16:00:00');
insert into HORARIO (ID_HORARIO, IPS, SERVICIO, CAPACIDAD, DIA, HORA_INICIO, HORA_FIN) values (8, 1, 4, 48, 4, TIMESTAMP '2000-01-01 10:00:00', TIMESTAMP '2000-01-01 15:30:00');
insert into HORARIO (ID_HORARIO, IPS, SERVICIO, CAPACIDAD, DIA, HORA_INICIO, HORA_FIN) values (9, 1, 5, 27, 7, TIMESTAMP '2000-01-01 10:00:00', TIMESTAMP '2000-01-01 15:00:00');
insert into HORARIO (ID_HORARIO, IPS, SERVICIO, CAPACIDAD, DIA, HORA_INICIO, HORA_FIN) values (10, 1, 1, 19, 4, TIMESTAMP '2000-01-01 09:00:00', TIMESTAMP '2000-01-01 16:00:00');
insert into HORARIO (ID_HORARIO, IPS, SERVICIO, CAPACIDAD, DIA, HORA_INICIO, HORA_FIN) values (11, 2, 1, 38, 5, TIMESTAMP '2000-01-01 10:00:00', TIMESTAMP '2000-01-01 15:00:00');
insert into HORARIO (ID_HORARIO, IPS, SERVICIO, CAPACIDAD, DIA, HORA_INICIO, HORA_FIN) values (12, 2, 5, 12, 5, TIMESTAMP '2000-01-01 10:00:00', TIMESTAMP '2000-01-01 16:00:00');
insert into HORARIO (ID_HORARIO, IPS, SERVICIO, CAPACIDAD, DIA, HORA_INICIO, HORA_FIN) values (13, 2, 6, 39, 3, TIMESTAMP '2000-01-01 09:00:00', TIMESTAMP '2000-01-01 16:00:00');
insert into HORARIO (ID_HORARIO, IPS, SERVICIO, CAPACIDAD, DIA, HORA_INICIO, HORA_FIN) values (14, 2, 7, 44, 2, TIMESTAMP '2000-01-01 09:00:00', TIMESTAMP '2000-01-01 16:00:00');
insert into HORARIO (ID_HORARIO, IPS, SERVICIO, CAPACIDAD, DIA, HORA_INICIO, HORA_FIN) values (15, 2, 8, 22, 7, TIMESTAMP '2000-01-01 09:00:00', TIMESTAMP '2000-01-01 15:00:00');
insert into HORARIO (ID_HORARIO, IPS, SERVICIO, CAPACIDAD, DIA, HORA_INICIO, HORA_FIN) values (16, 2, 7, 16, 4, TIMESTAMP '2000-01-01 10:00:00', TIMESTAMP '2000-01-01 15:00:00');
insert into HORARIO (ID_HORARIO, IPS, SERVICIO, CAPACIDAD, DIA, HORA_INICIO, HORA_FIN) values (17, 2, 6, 18, 7, TIMESTAMP '2000-01-01 08:00:00', TIMESTAMP '2000-01-01 16:00:00');
insert into HORARIO (ID_HORARIO, IPS, SERVICIO, CAPACIDAD, DIA, HORA_INICIO, HORA_FIN) values (18, 2, 5, 25, 7, TIMESTAMP '2000-01-01 08:00:00', TIMESTAMP '2000-01-01 16:00:00');
insert into HORARIO (ID_HORARIO, IPS, SERVICIO, CAPACIDAD, DIA, HORA_INICIO, HORA_FIN) values (19, 2, 2, 26, 6, TIMESTAMP '2000-01-01 08:00:00', TIMESTAMP '2000-01-01 15:00:00');
insert into HORARIO (ID_HORARIO, IPS, SERVICIO, CAPACIDAD, DIA, HORA_INICIO, HORA_FIN) values (20, 2, 7, 27, 7, TIMESTAMP '2000-01-01 08:00:00', TIMESTAMP '2000-01-01 16:00:00');