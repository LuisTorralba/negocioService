package com.example.springboot.app.service;

import java.util.List;

import com.example.springboot.app.model.Lenguaje;

public interface LenguajeService {
	Lenguaje createLenguaje(Lenguaje lenguaje);

	Lenguaje updateLenguaje(Lenguaje lenguaje);
	
	List<Lenguaje> getAllLenguaje(); 

	Lenguaje getLenguajeById(long lenguajeId); 

	void deleteLenguaje(long id);

}
