package com.example.democrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.democrud.model.Persona;
import com.example.democrud.service.api.PersonaServiceAPI;


/**
 * @Controller : realiza las tareas de controlador y gestión de la comunicación entre el usuario y el aplicativo. 
 * Para ello se apoya habitualmente en algún motor de plantillas o librería de etiquetas que
 * facilitan la creación de páginas.
*/
@Controller
public class PersonaController {
/**
 * Se agrega nuestro servicio con un miembro de la clase PersonaServiceApi
 */
	@Autowired
	private PersonaServiceAPI personaServiceAPI;
	/*
	 * */
	/*
	 * El método index hace referencia a la ruta inical de nuestro controlador
	 * */
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("list",personaServiceAPI.getAll());
	 return "index"; 	
	}
	
	/**
	 * */
	@GetMapping("/save/{id}")
	/*
	 *La anotación @PathVariable se usa para vincular las variables de plantilla
	 * de URI a los parámetros del método de controlador de un controlador en el marco Spring MVC. */
	public String showSave (@PathVariable("id") Long id, Model model) {
		if(id != null) {
			model.addAttribute("persona", personaServiceAPI.get(id));
			/*
			 * Con el if se valida que si ni hay nada que salvar, no se haga nada
			 * pero que si hay, que se agregue un atributo persona-->
			 * teniendo en cuenta que el valor de referencia es id */
		}
		return "save";
	}

	/* Método que hara la transicción de guardar*/
	
	@PostMapping("/save/")
	public String save(Persona persona, Model model) {
		
		/*Lógica para guardar nuestro usuario*/
		
		personaServiceAPI.save(persona);
		
		return "redirect:/";
	}
	
	
	/*Método que permite eliminar al usuario*/
	
	public String delete(@PathVariable Long id, Model model){
		personaServiceAPI.delete(id);
		return "redirect:/";
	}
}


