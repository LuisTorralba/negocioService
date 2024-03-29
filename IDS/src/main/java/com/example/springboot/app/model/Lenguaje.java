package com.example.springboot.app.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;



@Entity//Notación que indica que es una entidad y permite que JPA tome esta clase de Java y pueda interpetara como una tabla en SQL
@Table(name = "lenguaje")//Indica el nombre de la tabla, que JPA creara en la Base de Datos
public class Lenguaje {
	@Id //Llave primaria de la tabla
    @GeneratedValue(strategy = GenerationType.AUTO) //Se le indica que el campo ID es Autonumerico
    private long id;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "nombre")
    private String nombre;
    
    @ManyToMany(mappedBy = "likedLenguaje", cascade = CascadeType.PERSIST)
    private List<Empleados> likes;
    
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
	
	public List<Empleados> getLikes() {
        return likes;
    }

    public void setLikes(List<Empleados> likes) {
        this.likes = likes;
    }

    @Override
    public String toString() {
        return "Language{" +
                "id=" + id +
                ", code='" + codigo + '\'' +
                ", name='" + nombre + '\'' +
                ", likes=" + likes +
                '}';
    }
    

}
