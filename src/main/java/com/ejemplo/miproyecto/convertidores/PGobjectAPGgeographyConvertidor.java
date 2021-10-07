package com.ejemplo.miproyecto.convertidores;

import java.sql.SQLException;

import org.postgresql.util.PGobject;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;

import net.postgis.jdbc.PGgeography;

@ReadingConverter
public class PGobjectAPGgeographyConvertidor implements Converter<PGobject,PGgeography>{

    @Override
    public PGgeography convert(PGobject origen) {

        PGgeography obj= new PGgeography();
        try {
            obj.setValue(origen.getValue());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        obj.setType("geography");
        return obj;
    }
    
}
