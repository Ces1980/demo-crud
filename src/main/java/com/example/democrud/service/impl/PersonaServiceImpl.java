package com.example.democrud.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.example.democrud.commons.GenericServiceImpl;
import com.example.democrud.dao.api.PersonaDaoApi;
import com.example.democrud.model.Persona;
import com.example.democrud.service.api.PersonaServiceAPI;


@Service
public class PersonaServiceImpl extends GenericServiceImpl<Persona, Long> implements PersonaServiceAPI{

	/*
	 *@Autowired sire para buscar que componente inyectar */
	@Autowired
	private PersonaDaoApi personaDaoAPI;
	
	
	@Override
	public CrudRepository<Persona, Long> getDao() {
		return personaDaoAPI;
	}

	/*
	 *Cuando se invoca un método de el dao el metodo CrudRepository<Persona, Long> getDao()
	 *va a mandar personaDaoAPI */
}
