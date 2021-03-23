package com.bolsadeideas.springboot.backend.apirest.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bolsadeideas.springboot.backend.apirest.model.entity.Paciente;
import com.bolsadeideas.springboot.backend.apirest.models.services.IPacienteService;
@CrossOrigin (origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class PacienteRestController {

	@Autowired
	private IPacienteService pacienteSerivec;
	@GetMapping("/pacientes")
	public List<Paciente> index(){
		
		return pacienteSerivec.findAll();
		
	}
	
	@GetMapping("/pacientes/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {
		Paciente paciente = null;
		Map<String ,Object> response = new HashMap<>();
		try {
		paciente =  pacienteSerivec.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje","Error al realizar la consulta");
			return new ResponseEntity<Map<String ,Object>>(response, HttpStatus.NOT_FOUND);
		
		}
		if(paciente==null) {
			response.put("mensaje","El paciente ID: ".concat(id.toString().concat("no existe en la BD")));
			return new ResponseEntity<Map<String ,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
	return  new ResponseEntity<Paciente>(paciente,HttpStatus.OK);
	}
	
	@PostMapping("/pacientes")
	
	public ResponseEntity<?>  create(@RequestBody Paciente paciente) {
		Paciente pacientenuevo=null;
		Map<String ,Object> response = new HashMap<>();
		try {
			pacientenuevo =pacienteSerivec.save(paciente);
		} catch (DataAccessException e) {
			response.put("mensaje","Error al guardar");
			return new ResponseEntity<Map<String ,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);


		}
		response.put("mensaje", "paciente creado con exito");
		response.put("paciente", pacientenuevo);
		return new ResponseEntity <Map<String,Object>> (response ,HttpStatus.CREATED);
		 
	} 
	
	@PutMapping("/pacientes/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	
	public ResponseEntity<?> update(@RequestBody Paciente paciente, @PathVariable Long id ) {
		Paciente pacienteActual = pacienteSerivec.findById(id);
		Paciente pacienteN = null;
		Map<String ,Object> response = new HashMap<>();
		if(pacienteActual==null) {
			response.put("mensaje","El paciente ID: ".concat(id.toString().concat("no existe en la BD , no se puede actualizar")));
			return new ResponseEntity<Map<String ,Object>>(response, HttpStatus.NOT_FOUND);
			
		}
		try {
			pacienteActual.setNombres(paciente.getNombres());
			pacienteActual.setApellidos(paciente.getApellidos());
			pacienteActual.setTipo_de_documento(paciente.getTipo_de_documento());
		    pacienteActual.setTelefono(paciente.getTelefono());
		    pacienteActual.setNumero_documento(paciente.getNumero_documento());
		    pacienteActual.setFecha_nacimiento(pacienteActual.getFecha_nacimiento());
			
		    pacienteN = pacienteSerivec.save(pacienteActual);
		}catch (Exception e) {
	 
			response.put("mensaje", "paciente editado con exito");
			response.put("paciente", pacienteN);
			
			return new ResponseEntity<Map<String ,Object>>(response, HttpStatus.CREATED);

		}
	
	    
	    
	    pacienteN= pacienteSerivec.save(pacienteActual);
	    return  new ResponseEntity <Map<String,Object>> (response ,HttpStatus.CREATED);
	}
}
