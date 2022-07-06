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
import com.example.springboot.app.model.Country;
import com.example.springboot.app.service.CountryService;

@RestController 
@RequestMapping("/country")
public class CountryController {
	//Inyección de dependencias
		@Autowired
		private CountryService service;

		@GetMapping("/listcountry")
		public ResponseEntity<?> getAllCountry() {
			List<Country> lista = service.getAllCountry();
			if(lista.isEmpty()){
				return new ResponseEntity<>("Sin datos.", HttpStatus.BAD_REQUEST);
			}
			return ResponseEntity.ok().body(service.getAllCountry());
		}

		@GetMapping("/country/{id}")
		public ResponseEntity<Country> getCountryById(@PathVariable long id) {
			return ResponseEntity.ok().body(service.getCountryById(id));
		}
		
		@PostMapping("/creacountry")
		public ResponseEntity<Country> createCountry(@RequestBody Country country) {
			return ResponseEntity.ok().body(this.service.createCountry(country));
		}
		
		@PutMapping("/actualizacountry/{id}")
		public ResponseEntity<Country> updateCountry(@PathVariable long id, @RequestBody Country country) {
			country.setId(id);
			return ResponseEntity.ok().body(this.service.updateCountry(country));
		}

		@DeleteMapping("/eliminacountry/{id}")
		public HttpStatus deleteCountry(@PathVariable long id) {
			this.service.deleteCountry(id);
			return HttpStatus.OK;
		}
}
