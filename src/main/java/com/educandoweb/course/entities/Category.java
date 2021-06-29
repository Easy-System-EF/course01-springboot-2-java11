package com.educandoweb.course.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

 
 
@Entity
// anotação para conflito de palavras reservadas, ou aqq mudo o nome da tabela
@Table(name = "tb_category")

public class Category implements Serializable { 
 
	private static final long serialVersionUID = 1L;
 
//informando chave principal
	@Id	
// informa auto incrementação
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;

/* coleção de prods instanciada para não ser = null (pode ser vazia)	
   trasiente impede que jpa interprete essa associação antes do mapeamento	
	@Transient
   referencia para o mapeamento la do produto (associação s/ '/") . jsonignore para looping postman
*/
  	@ManyToMany(mappedBy = "categories")
 	
	private Set<Product> products = new HashSet<>();
	
 	public Category() {
	}

	public Category(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@JsonIgnore
 	public Set<Product> getProdutcts() {
		return products;
	}
 
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
