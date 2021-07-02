package com.educandoweb.course.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
//anotação para conflito de palavras reservadas, ou aqq mudo o nome da tabela
@Table(name = "tb_product")
public class Product implements Serializable { 
	 
		private static final long serialVersionUID = 1L;
 	
//informando chave principal
	@Id	
// informa auto incrementação
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String description;
	private Double price;
	private String imgUrl;
	
/*	
   associação via coleção instanciada para não começar = null, tem q ser vazio
   set p/ não duplicar categorias
   set é uma interface, por isso a classe hashset para instanciar
   trasiente impede que jpa interprete essa associação antes do mapeamento relacional jpa	
	@Transient
	mapeamento transf coleção na tab de associação do modelo relacional
*/	
 	@ManyToMany
 	// nome da tabela e quais as chaves estrangeiras que associarão tabelas
	@JoinTable(name = "tb_product_category", 
	 joinColumns = @JoinColumn(name = "product_id"),
	 inverseJoinColumns = @JoinColumn(name = "category_id"))
	private Set<Category> categories = new HashSet<>();
	
 /* id da classe orderItem
  * product = orderItemPK 
  */
	@OneToMany(mappedBy = "id.product")
	private Set<OrderItem> items = new HashSet<>();
 	
	public Product() {
	}

	public Product(Integer id, String name, String description, Double price, String imgUrl) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.imgUrl = imgUrl;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
 	
	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
 	
	public Set<Category> getCategories() {
		return categories;
	}
 
/* nome getOrders = diagrama
 * varrer o orderItem = items
 * vai montar uma coleção set, q é o resultado da varrida da coleção items
 * json para o pedido mostrar o(s) produto(s) -> 
 * invertido com json no orderItem, q mostra produto e pedido(s)
  */
	@JsonIgnore
	public Set<Order> getOrders() {
		Set <Order> set = new HashSet<>();
		for (OrderItem x: items) {
			 set.add(x.getOrder());	 
		}
		return set;
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
		Product other = (Product) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
