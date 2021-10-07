DROP TABLE IF EXISTS app.ejemplo;
CREATE TABLE app.ejemplo(
    id SERIAL PRIMARY KEY,
    info VARCHAR,
    precio REAL,    
    fecha TIMESTAMP WITH TIME ZONE,    /* fecha en UTC */
    posicion public.GEOGRAPHY(Point),   /* punto para latitud y longitud*/
    poligono public.GEOGRAPHY(Polygon) /* para determinar áreas geográficas */    
);

INSERT INTO app.ejemplo(info,precio,fecha,posicion,poligono) 
VALUES('ejemplo info',
45.72,
'2019-08-31T15:20:30+08:00',
'SRID=4326;POINT(-118.4079 33.9434)',
'SRID=4326;POLYGON((50.6373 3.0750,50.6374 3.0750,50.6374 3.0749,50.63 3.07491,50.6373 3.0750))');



