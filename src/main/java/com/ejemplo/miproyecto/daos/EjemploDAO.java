package com.ejemplo.miproyecto.daos;

import com.ejemplo.miproyecto.entidades.Ejemplo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EjemploDAO extends CrudRepository<Ejemplo,Integer>{ //CRUD
    
}
