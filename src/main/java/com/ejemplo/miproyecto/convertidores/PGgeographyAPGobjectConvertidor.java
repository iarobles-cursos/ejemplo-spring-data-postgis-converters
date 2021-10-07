package com.ejemplo.miproyecto.convertidores;

import java.sql.SQLException;

import org.postgresql.util.PGobject;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.WritingConverter;

import net.postgis.jdbc.PGgeography;

@WritingConverter
public class PGgeographyAPGobjectConvertidor implements Converter<PGgeography, PGobject>{

    @Override
    public PGobject convert(PGgeography origen){
        PGobject obj=new PGobject();
        try {
            obj.setValue(origen.getValue());
            obj.setType(origen.getType());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return obj;
    }
    
}
