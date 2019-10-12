package com.example.democrud.commons;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/*
 * para poder utilizar este método --> public abstract CrudRepository<T, ID> getDao();
 * se realiza la siguiente importación*/
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/*
 * Esta clase va a implementar la interfaz GenericServiceAPI<T, ID >
 * De igual forma recibe por parametros la interfaz seializable -->
 * Explicación de serializable en package com.example.democrud.commons
 * dentro de la interfaz interface GenericServiceAPI  */

/*
 * El extends de Serializabledebe ser en la interfaz de la clase y no en la implementacion*/

@Service
public abstract class GenericServiceImpl <T, ID extends Serializable> implements GenericServiceAPI<T, ID>  {

	/*
	 *Se implementan los métodos de la interfaz GenericServiceAPI */
	
	
	/*Utilizando el método abstracto getDao() se complementan 
	 * los métods llamados traer gracias a la implementacion
	 * de la interfaz GenericServiceAPI */
	
	
	@Override
	public T save(T entity) {
		
		return getDao().save(entity);
	}

	@Override
	public void delete(ID id) {
		
		getDao().deleteById(id);
	}

	@Override
	public T get(ID id) {
		Optional<T> obj = getDao().findById(id);
		if(obj.isPresent()) {
			return obj.get();
		}
		return null;
	}

	@Override
	public List<T> getAll() {
		List<T> returnList = new ArrayList<>();
		getDao().findAll().forEach(obj -> returnList.add(obj));
		return returnList;
	}
/*
 * Se rrquiere crear un método que ayude a indicar a que repositorio
 * se esta llamadno a solicitando (com.example.democrud.dao.api --> interface PersonaDaoApi) */
	
	public abstract CrudRepository<T, ID> getDao();
}




