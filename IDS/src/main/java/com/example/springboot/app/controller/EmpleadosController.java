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
import com.example.springboot.app.model.Empleados;

import com.example.springboot.app.service.EmpleadoService;



 
@RestController 
@RequestMapping("/empleados")
public class EmpleadosController {

	//Inyección de dependencias
	@Autowired
	private EmpleadoService service;

	@GetMapping("/listempleados")
	public ResponseEntity<?> getAllEmpleados() {
		List<Empleados> lista = service.getAllEmpleados();
		if(lista.isEmpty()){
			return new ResponseEntity<>(new Mensaje("Sin empleados en la Base de Datos"), HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.ok().body(service.getAllEmpleados());
	}

	@GetMapping("/empleados/{id}")
	public ResponseEntity<Empleados> getEmpleadosById(@PathVariable long id) {
		return ResponseEntity.ok().body(service.getEmpleadosById(id));
	}
	
	@PostMapping("/creaempleado")
	public ResponseEntity<Empleados> createEmpleados(@RequestBody Empleados empleados) {
		return ResponseEntity.ok().body(this.service.createEmplados(empleados));
	}
	
	
	@PutMapping("/actualizaempleado/{id}")
	public ResponseEntity<Empleados> updateProduct(@PathVariable long id, @RequestBody Empleados empleados) {
		empleados.setId(id);
		return ResponseEntity.ok().body(this.service.updateEmpleados(empleados));
	}

	@DeleteMapping("/eliminaempleado/{id}")
	public HttpStatus deleteEmpleados(@PathVariable long id) {
		this.service.deleteEmpleados(id);
		return HttpStatus.OK;
	}
	
	@PostMapping("/apiv1/clientes/add")
    public ResponseEntity<Empleados> addEmployee(@RequestBody Empleados empleados){
        return ResponseEntity.ok().body(this.service.addEmpleados(empleados));
    }
	
}




