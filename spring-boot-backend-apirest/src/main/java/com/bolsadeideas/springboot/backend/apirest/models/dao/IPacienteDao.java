package com.bolsadeideas.springboot.backend.apirest.models.dao;


import org.springframework.data.repository.CrudRepository;

import com.bolsadeideas.springboot.backend.apirest.model.entity.Paciente;

public interface IPacienteDao extends CrudRepository<Paciente, Long> {

}
