package com.example.springboot.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.example.springboot.app.exception.Mensaje;
import com.example.springboot.app.model.Lenguaje;
import com.example.springboot.app.service.LenguajeService;

@RestController 
@RequestMapping("/lenguaje")
public class LenguajeController {
	//Inyección de dependencias 
		@Autowired
		private LenguajeService service;

		@GetMapping("/listlenguaje")
		public ResponseEntity<?> getAllEmpleados() {
			List<Lenguaje> lista = service.getAllLenguaje();
			if(lista.isEmpty()){
				return new ResponseEntity<>("Sin datos.", HttpStatus.BAD_REQUEST);
			}
			return ResponseEntity.ok().body(service.getAllLenguaje());
		}

		@GetMapping("/lenguaje/{id}")
		public ResponseEntity<Lenguaje> getLenguajeById(@PathVariable long id) {
			return ResponseEntity.ok().body(service.getLenguajeById(id));
		}
		
		@PostMapping("/crealenguaje")
		public ResponseEntity<Lenguaje> createLenguaje(@RequestBody Lenguaje lenguaje) {
			return ResponseEntity.ok().body(this.service.createLenguaje(lenguaje));
		}
		
		@PutMapping("/actualizalenguaje/{id}")
		public ResponseEntity<Lenguaje> updateLenguaje(@PathVariable long id, @RequestBody Lenguaje lenguaje) {
			lenguaje.setId(id);
			return ResponseEntity.ok().body(this.service.updateLenguaje(lenguaje));
		}

		@DeleteMapping("/eliminalenguaje/{id}")
		public HttpStatus deleteLenguaje(@PathVariable long id) {
			this.service.deleteLenguaje(id);
			return HttpStatus.OK;
		}
}
