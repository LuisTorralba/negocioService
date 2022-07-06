package com.example.springboot.app.service;

import java.util.List;

import com.example.springboot.app.model.Airport;

public interface AirportService {
	Airport createAirport(Airport airport);

	Airport updateAirport(Airport airport);
	
	List<Airport> getAllAirport(); 

	Airport getAirportById(long airportId); 

	void deleteAirport(long id);
	
}
