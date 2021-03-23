package com.bolsadeideas.springboot.backend.apirest.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name="pacientes")
public class Paciente  implements Serializable{

   @Id
   @GeneratedValue(strategy =GenerationType.IDENTITY )
   
	private long id;
     @Column(nullable = false)
	private String nombres;
     @Column(nullable = false)
	private String apellidos;
	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date fecha_nacimiento;
	@Column(nullable = false)
	private String tipo_de_documento;
	@Column(nullable = false)
	private int numero_documento;
	private int telefono;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public String getTipo_de_documento() {
		return tipo_de_documento;
	}

	public void setTipo_de_documento(String tipo_de_documento) {
		this.tipo_de_documento = tipo_de_documento;
	}

	public int getNumero_documento() {
		return numero_documento;
	}

	public void setNumero_documento(int numero_documento) {
		this.numero_documento = numero_documento;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
