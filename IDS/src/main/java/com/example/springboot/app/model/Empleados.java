package com.example.springboot.app.model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;




@Entity//Notación que indica que es una entidad y permite que JPA tome esta clase de Java y pueda interpetara como una tabla en SQL
@Table(name = "employee")//Indica el nombre de la tabla, que JPA creara en la Base de Datos
public class Empleados {

    @Id //Llave primaria de la tabla
    @GeneratedValue(strategy = GenerationType.AUTO) //Se le indica que el campo ID es Autonumerico
    private long id;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "nombre")
    private String nombre;
    
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
    		name = "lenguajes_like",
    		joinColumns = @JoinColumn(name = "lenguaje_id"))
    private List<Lenguaje> likedLenguaje;
    
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "country_id")
    private Country country;
    

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
    
	public List<Lenguaje> getLikedLanguages() {
        return likedLenguaje;
    }

    public void setLikedLanguages(List<Lenguaje> likedLanguages) {
        this.likedLenguaje = likedLanguages;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", surname='" + nombre + '\'' +
                ", firstname='" + apellido + '\'' +
                ", likedLanguages=" + likedLenguaje +
                ", country=" + country +
                '}';
    }
    
    
}
 