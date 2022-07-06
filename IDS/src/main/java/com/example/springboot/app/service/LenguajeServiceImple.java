package com.example.springboot.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//import com.example.springboot.app.exception.ResourceNotFoundException;
import com.example.springboot.app.model.Lenguaje;
import com.example.springboot.app.repository.LenguajeRepository;

@Service
@Transactional
public class LenguajeServiceImple implements LenguajeService {
	@Autowired
	private LenguajeRepository lenguajeRepository;
	
	@Override
	public Lenguaje createLenguaje(Lenguaje lenguaje) {
		return lenguajeRepository.save(lenguaje);
	}
	
	@Override
	public Lenguaje updateLenguaje(Lenguaje lenguaje) {
		Optional<Lenguaje> lenguajeDb = this.lenguajeRepository.findById(lenguaje.getId());
		
		if (lenguajeDb.isPresent()) {
			Lenguaje lenguajeUpdate = lenguajeDb.get();
			lenguajeUpdate.setId(lenguaje.getId());
			lenguajeUpdate.setCodigo(lenguaje.getCodigo());
			lenguajeUpdate.setNombre(lenguaje.getNombre());
			lenguajeRepository.save(lenguajeUpdate);
			return lenguajeUpdate;
		} else {
			throw new RuntimeException("Record not found with id:" + lenguaje.getId());
		}
	}
	
	@Override
	public List<Lenguaje> getAllLenguaje() {
		return this.lenguajeRepository.findAll();
	}
	
	@Override
	public Lenguaje getLenguajeById(long lenguajeId) {
		Optional<Lenguaje> lenguajeDb = this.lenguajeRepository.findById(lenguajeId);

		if (lenguajeDb.isPresent()) {
			return lenguajeDb.get();
		} else {
			throw new RuntimeException("Record not found with id:" + lenguajeId);
		}
	}
	
	@Override
	public void deleteLenguaje(long lenguajeId) {
		Optional<Lenguaje> lenguajeDb = this.lenguajeRepository.findById(lenguajeId);

		if (lenguajeDb.isPresent()) {
			this.lenguajeRepository.delete(lenguajeDb.get());
		} else {
			throw new RuntimeException("Record not found with id:" + lenguajeId);
		}
	}

}
