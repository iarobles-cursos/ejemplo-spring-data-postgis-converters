package com.ejemplo.miproyecto;

import java.util.Arrays;
import java.util.List;

import com.ejemplo.miproyecto.convertidores.PGgeographyAPGobjectConvertidor;
import com.ejemplo.miproyecto.convertidores.PGobjectAPGgeographyConvertidor;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration;

@Configuration
public class Configuracion extends AbstractJdbcConfiguration{

    private Log log = LogFactory.getLog(Configuracion.class);
    
    @Override
    protected List<?> userConverters() { 
        log.info("habilitando convertidores");
        return Arrays.asList(new PGobjectAPGgeographyConvertidor(), new PGgeographyAPGobjectConvertidor());
    }
    
}
