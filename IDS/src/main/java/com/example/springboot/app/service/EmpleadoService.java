package com.example.springboot.app.service;

import java.util.List;

import com.example.springboot.app.model.Empleados;

public interface EmpleadoService {
Empleados updateEmpleados(Empleados empleados);
	
	List<Empleados> getAllEmpleados(); 

	Empleados getEmpleadosById(long empleadosId); 

	void deleteEmpleados(long id);

	Empleados createEmplados(Empleados empleados);
	
	Empleados addEmpleados(Empleados empleados);

}
