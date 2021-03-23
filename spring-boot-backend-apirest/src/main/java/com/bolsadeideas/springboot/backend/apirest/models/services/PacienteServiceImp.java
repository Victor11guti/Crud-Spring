package com.bolsadeideas.springboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bolsadeideas.springboot.backend.apirest.model.entity.Paciente;
import com.bolsadeideas.springboot.backend.apirest.models.dao.IPacienteDao;

@Service
public class PacienteServiceImp implements IPacienteService {
    @Autowired
    private IPacienteDao pacientedao;
	@Override
	@Transactional(readOnly = true)
	public List<Paciente> findAll() {	
		return (List<Paciente>) pacientedao.findAll();
	}
	@Override
	@Transactional
	public Paciente save(Paciente paciente) {
		
		return pacientedao.save(paciente);
	}
	@Override
	@Transactional(readOnly = true)
	public Paciente findById(Long id) {
		// TODO Auto-generated method stub
		return pacientedao.findById(id).orElse(null);
	}

}
