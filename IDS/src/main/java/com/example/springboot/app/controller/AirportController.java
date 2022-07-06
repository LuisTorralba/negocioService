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

import com.example.springboot.app.exception.Mensaje;
import com.example.springboot.app.model.Airport;
import com.example.springboot.app.service.AirportService;

@RestController 
@RequestMapping("/airport")
public class AirportController {
	//Inyección de dependencias
		@Autowired
		private AirportService service;

		@GetMapping("/listairpot")
		public ResponseEntity<?> getAllAirport() {
			List<Airport> lista = service.getAllAirport();
			if(lista.isEmpty()){
				return new ResponseEntity<>(new Mensaje("Sin aereopuertos en la Base de Datos"), HttpStatus.BAD_REQUEST);
			}
			return ResponseEntity.ok().body(service.getAllAirport());
		}

		@GetMapping("/airport/{id}")
		public ResponseEntity<Airport> getAirportById(@PathVariable long id) {
			return ResponseEntity.ok().body(service.getAirportById(id));
		}
		
		@PostMapping("/creaairport")
		public ResponseEntity<Airport> createAirport(@RequestBody Airport airport) {
			return ResponseEntity.ok().body(this.service.createAirport(airport));
		}
		
		@PutMapping("/actualizaairport/{id}")
		public ResponseEntity<Airport> updateAirport(@PathVariable long id, @RequestBody Airport airport) {
			airport.setId(id);
			return ResponseEntity.ok().body(this.service.updateAirport(airport));
		}

		@DeleteMapping("/eliminaairport/{id}")
		public HttpStatus deleteAirport(@PathVariable long id) {
			this.service.deleteAirport(id);
			return HttpStatus.OK;
		}
}