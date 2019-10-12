package com.example.democrud.dao.api;

import org.springframework.data.repository.CrudRepository;

import com.example.democrud.model.Persona;

/*
 * Se crea el paquete com.example.democrud.dao.api y despues se crea una
 * interfaz llamada PersonaDAoApi la cual extiende de la interfaz CrudRepository
 * Esta interfaz recibe como primer parametro Objetos de la clase persona
 * y como segundo parametro el tipo de dato con el cual se declaro a la clave primaria 
 * cuando se creo la clase Persona (com.example.democrud.model) */

public interface PersonaDaoApi extends CrudRepository<Persona, Long> {

}
