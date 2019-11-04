RF10

INSERT INTO CAMPANA (id_Campana, fecha_inicio, fecha_fin, cancelada) 
VALUES (x,y,z, 0);

SELECT id_horario, ips, servicio, capacidad, dia, hora_inicio, hora_fin, deshabilitado
FROM HORARIO
    INNER JOIN SERVICIO_SALUD
    ON servicio = id_servicio
WHERE tipo = x;

RF11

DELETE RESERVA
FROM RESERVA
	INNER JOIN HORARIO
	ON horario = id_horario
WHERE servicio = x AND campana = y;

UPDATE CAMPANA
SET cancelada = 1 
WHERE id_campana = x;

DELETE RESERVA
FROM RESERVA
	INNER JOIN HORARIO
	ON horario = id_horario
WHERE campana = x;

RF12

SELECT *
FROM SERVICIO_DESABILITADO
WHERE fecha_inicio = x AND fecha_fin = y;

INSERT INTO SERVICIO_DESABILITADO (id, fecha_inicio, fecha_fin)
VALUES (x,y,z);

SELECT RESERVA
FROM RESERVA
	INNER JOIN HORARIO
	ON horario = id_horario
WHERE servicio = x AND ips = y AND fecha BETWEEN z AND a;

UPDATE HORARIO
SET deshabilitado = x 
WHERE servicio = y;

DELETE RESERVA
FROM RESERVA
	INNER JOIN HORARIO
	ON horario = id_horario
WHERE servicio = x AND ips = y AND fecha BETWEEN z AND a;

RF13

UPDATE HORARIO
SET deshabilitado = null 
WHERE servicio = x;

RFC1

SELECT id, localizacion, nombre, count (distinct servicio) as servicios_Prestados
FROM IPS
	INNER JOIN RESERVA
    ON horario = id_horario
	RIGHT OUTER JOIN IPS
WHERE servicio_prestado = 1 AND fecha BETWEEN x AND y
GROUP BY id, localizacion, nombre;

RFC2

SELECT * FROM (
    SELECT id_servicio, nombre, tipo
    FROM RESERVA
        INNER JOIN HORARIO 
        ON horario = id_horario
        RIGHT OUTER JOIN SERVICIO_SALUD
        ON servicio = id_servicio
    WHERE fecha BETWEEN ? AND ?
    GROUP BY id_servicio, nombre, tipo
    RODER BY COUNT(*))
WHERE ROWNUM < 21;

RFC5

SELECT COUNT(*)/COUNT(servicio_prestado)
FROM RESERVA
WHERE afiliado = ? AND fecha BETWEEN ? AND ?;

RFC7

SELECT afiliado, COUNT(*), COUNT (DISTINCT tipo)
FROM RESERVA
    INNER JOIN HORARIO
	ON horario = id_horario
	INNER JOIN SERVICIO_SALUD
	ON servicio = id_servicio
WHERE fecha BETWEEN x AND y
GROUP BY afiliado
HAVING COUNT(*) > 12 AND COUNT (DISNTINCT tipo) > 3;

RFC8

SELECT id_servicio, nombre, tipo
FROM SERVICIO_SALUD
	INNER JOIN HORARIO
	ON id_servicio = servicio
	INNER JOIN RESERVA
	ON id_horario = horario
WHERE fecha BETWEEN x AND y
GROUP BY id_servicio, nombre, tipo
HAVING COUNT(DISTINCT codigo)/z < a;

