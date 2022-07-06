package com.example.springboot.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//import com.example.springboot.app.exception.ResourceNotFoundException;
import com.example.springboot.app.model.Airport;
import com.example.springboot.app.repository.AirportRepository;

@Service
@Transactional
public class AirportServiceImple implements AirportService {
	@Autowired
	private AirportRepository airportRepository;
	
	@Override
	public Airport createAirport(Airport airport) {
		return airportRepository.save(airport);
	}
	
	@Override
	public Airport updateAirport(Airport airport) {
		Optional<Airport> airportDb = this.airportRepository.findById(airport.getId());
		if (airportDb.isPresent()) {
			Airport airportUpdate = airportDb.get();
			airportUpdate.setId(airport.getId());
			airportUpdate.setNombre(airport.getNombre());
			airportRepository.save(airportUpdate);
			return airportUpdate;
		} else {
			throw new RuntimeException("Record not found with id:" + airport.getId());
		}
	}
	
	@Override
	public List<Airport> getAllAirport() {
		return this.airportRepository.findAll();
	}
	
	@Override
	public Airport getAirportById(long airportId) {
		Optional<Airport> airportDb = this.airportRepository.findById(airportId);

		if (airportDb.isPresent()) {
			return airportDb.get();
		} else {
			throw new RuntimeException("Record not found with id:" + airportId);
		}
	}
	@Override
	public void deleteAirport(long airportId) {
		Optional<Airport> airportDb = this.airportRepository.findById(airportId);

		if (airportDb.isPresent()) {
			this.airportRepository.delete(airportDb.get());
		} else {
			throw new RuntimeException("Record not found with id:" + airportId);
		}
	}
	

}
