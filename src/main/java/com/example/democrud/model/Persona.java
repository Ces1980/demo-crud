package com.example.democrud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/*
 * La anotación @Entity marca a una clase como una entidad cuyo estado será persistido 
 * en una base de datos y que será identificado univocamente.
 * Especifica que se va a crear una entidad.
 * */
@Entity
public class Persona {

	/*
	 *La anotación @Id  indica cual va a ser la Primary key de la entidad. */
	@Id
	/*
	 * La anotación @GeneratedValue es configurar la forma de incremento de la columna (campo) especificada
	 * En el proyecto se especifica que el incremento va a ser incrementado de forma automatica*/
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	
	/*
	 * La anotación @Column Sirve para especificar que la clave está asociada a un atributo de la tabla*/
	@Column
	private String nombre;
	@Column
	private String apellido;
	@Column
	private String direccion;
	@Column
	private String Telefono;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return Telefono;
	}
	public void setTelefono(String telefono) {
		Telefono = telefono;
	}
	
	
}
