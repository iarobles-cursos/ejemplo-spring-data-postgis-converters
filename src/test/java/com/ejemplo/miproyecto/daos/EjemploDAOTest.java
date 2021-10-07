package com.ejemplo.miproyecto.daos;

import com.ejemplo.miproyecto.Configuracion;
import com.ejemplo.miproyecto.entidades.Ejemplo;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.time.OffsetDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.context.annotation.Import;

import net.postgis.jdbc.PGgeography;

@DataJdbcTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Import(Configuracion.class)
public class EjemploDAOTest {

    @Autowired
    private EjemploDAO ejemploDAO;

    @Test
    public void buscarPorIdTest() throws SQLException{

        Ejemplo e = ejemploDAO.findById(1).get();

        assertNotNull(e);
        assertEquals("ejemplo info",e.getInfo());
        assertEquals(45.72f,e.getPrecio());
        assertEquals(OffsetDateTime.parse("2019-08-31T15:20:30+08:00").toInstant(), e.getFecha().toInstant());
        assertEquals(new PGgeography("SRID=4326;POINT(-118.4079 33.9434)"), e.getPosicion());
        assertEquals(new PGgeography("SRID=4326;POLYGON((50.6373 3.0750,50.6374 3.0750,50.6374 3.0749,50.63 3.07491,50.6373 3.0750))"), e.getPoligono());

    }

    @Test
    public void guardar() throws SQLException{

        Ejemplo e = new Ejemplo();
        e.setInfo("ejemplo info");
        e.setPrecio(345.72f);
        e.setFecha(OffsetDateTime.parse("2019-08-31T15:20:30+08:00"));
        e.setPosicion(new PGgeography("SRID=4326;POINT(-118.4079 33.9434)"));
        e.setPoligono(new PGgeography("SRID=4326;POLYGON((50.6373 3.0750,50.6374 3.0750,50.6374 3.0749,50.63 3.07491,50.6373 3.0750))"));

        //entidad guardada
        Ejemplo eg = ejemploDAO.save(e);

        assertEquals(e.getInfo(),eg.getInfo());
        assertEquals(e.getPrecio(),eg.getPrecio());
        assertEquals(e.getFecha().toInstant(),eg.getFecha().toInstant());
        assertEquals(e.getPosicion(),eg.getPosicion());
        assertEquals(e.getPoligono(),eg.getPoligono());

        
    }
    
}
