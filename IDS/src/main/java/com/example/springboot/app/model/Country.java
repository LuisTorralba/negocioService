package com.example.springboot.app.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "country")
public class Country {
	@Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "codigo")
    private String codigo;
    
    @Column(name = "nombre")
    private String nombre;
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id")
    private List<Airport> airport;
    
    @OneToOne(mappedBy = "country", cascade = CascadeType.ALL)
    private Empleados empleados;
    
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public List<Airport> getAirports() {
        return airport;
    }

    public void setAirports(List<Airport> airport) {
        this.airport = airport;
    }

    public Empleados getEmployee() {
        return empleados;
    }

    public void setEmployee(Empleados empleados) {
        this.empleados = empleados;
    }

    @Override
    public String toString() {
        return "Country{" +
                "country_id=" + id +
                ", code='" + codigo + '\'' +
                ", name='" + nombre + '\'' +
                ", airports=" + airport +
                ", employee=" + empleados +
                '}';
    }
    
    
}
