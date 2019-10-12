package com.example.democrud.commons;

import java.io.Serializable;
import java.util.List;



/*+
 * Básicamente serializar es pasar un Objeto a un array de bytes y viceversa. 
 * Sirve para poder trasmitir y escribir objetos a medios externos como webservices, archivos.
 * Por ello la interfaz GenericServiceAPI extiende de la interfaz  Serializable
 * */
public interface GenericServiceAPI<T, ID extends Serializable> {

	// La T que se declara dentro de la lista indica la entidad o el tipo
	/*Todos los tipos (T) van a ser remplazados por las entidades de tipo persona*/
	
	/*Al ser usada esta interfaz mandandola llamar posteriormente en la interface PersonaServiceAPI
	 * los valores van a ser sustituidos por  
	 *<Persona = T, Long = entity>  */
	
	/*Método de guardar -> Guarda la entidad */
	T save(T entity);
	/*Método de borrar el cual recibe por parametro el id de la entidad*/
	void delete(ID id);
	/*Metodo de obtener el cual recibe por parametro el id de la entidad*/
	T get(ID id);
	/*Método que permite listar todos --> se importa el paquete de java.util.List*/
	List <T> getAll();
}
