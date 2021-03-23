package com.bolsadeideas.springboot.backend.apirest.models.services;

import java.util.List;

import com.bolsadeideas.springboot.backend.apirest.model.entity.Paciente;

public interface IPacienteService {
public List< Paciente> findAll();
public  Paciente save(Paciente paciente);
public Paciente findById(Long id);
}
