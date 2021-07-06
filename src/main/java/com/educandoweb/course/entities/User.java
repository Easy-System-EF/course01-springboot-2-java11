package com.educandoweb.course.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

// mapeamento obj p/ bco dados relacional
@Entity
//anotação para conflito de palavras reservadas, ou aqq mudo o nome da tabela
@Table(name = "tb_user")
public class User implements Serializable{

	private static final long serialVersionUID = 1L;
	
//informando chave principal
	@Id	
// informa auto incrementação
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String telefone;
	private String email;
	private String password;
	
/*	
    instanciando associação user (1) com varios pedidos(0rder)
	asociacao um para muitos mapeado por cliente
    json impede looping e mostra o cliente no pedido -> 
    o contrario tb e verdade e é conf true q mostra, se for false da erro 500
	anotação p/ não ter looping (jsonignore)
*/	
	@JsonIgnore
	@OneToMany(mappedBy = "client")
	private List<Order> orders = new ArrayList<>();
	
	public User() {
	}

	public User(Long id, String name, String telefone, String email, String password) {
		super();
		this.id = id;
		this.name = name;
		this.telefone = telefone;
		this.email = email;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
 
	public List<Order> getOrders() {
		return orders;
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
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", telefone=" + telefone + ", email=" + email + ", password="
				+ password + "]";
	}
	
}

