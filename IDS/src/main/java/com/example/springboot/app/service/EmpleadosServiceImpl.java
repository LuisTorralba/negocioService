package com.example.springboot.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.springboot.app.exception.ResourceNotFoundException;
import com.example.springboot.app.model.Empleados;
import com.example.springboot.app.repository.EmpleadosRepository;

@Service
@Transactional
public class EmpleadosServiceImpl implements EmpleadoService{ 
	@Autowired
	private EmpleadosRepository empleadosRepository;
	
	@Override
	public Empleados createEmplados(Empleados empleados) {
		return empleadosRepository.save(empleados);
	}
	
	@Override
	public Empleados updateEmpleados(Empleados empleados) {
		Optional<Empleados> empleadosDb = this.empleadosRepository.findById(empleados.getId());
		
		if(empleadosDb.isPresent()) {
			Empleados empleadosUpdate = empleadosDb.get();
			empleadosUpdate.setId(empleados.getId());
			empleadosUpdate.setApellido(empleados.getApellido());
			empleadosUpdate.setNombre(empleados.getNombre());
			empleadosRepository.save(empleadosUpdate);
			return empleadosUpdate;
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + empleados.getId());
		}
	}
	
	@Override
	public List<Empleados> getAllEmpleados() {
		return this.empleadosRepository.findAll();
	 }
	
	@Override
	public Empleados getEmpleadosById(long empleadosId) {
		Optional<Empleados> empleadosDb = this.empleadosRepository.findById(empleadosId);
		if(empleadosDb.isPresent()) {
			return empleadosDb.get();
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + empleadosId);
		}
		
	}
	
	@Override
	public void deleteEmpleados(long empleadosId) {
		Optional<Empleados> empleadosDb = this.empleadosRepository.findById(empleadosId);
		if(empleadosDb.isPresent()) {
			this.empleadosRepository.delete(empleadosDb.get());
		} else {
			throw new ResourceNotFoundException("Record not found with id : " + empleadosId);
		}
		
	}
	
	 @Override
	    public Empleados addEmpleados(Empleados empleados) {
	        return empleadosRepository.save(empleados);
	    }

}
