package com.educandoweb.course.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.educandoweb.course.entities.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
// anotação para conflito de palavras reservadas, ou aqq mudo o nome da tabela
@Table(name = "tb_order")
public class Order implements Serializable { 

	private static final long serialVersionUID = 1L;
	
//informando chave principal
	@Id	
// informa auto incrementação
	@GeneratedValue(strategy = GenerationType.IDENTITY)
  	private Long id;
	
// configutação da data GMT
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant moment;
	
	private Integer orderStatus; 
	
// associação pedido(s) cliente (nome no diagrama)
// anotações muitos p/ um e key estrangeira (client
	@ManyToOne
	@JoinColumn(name = "client_id")
// nao instancia pq é um obj	
	private User client;
	
/*
   preciso de uma coleção de orderitem itens associados ao order (pedido)
   (inicializada sempre) de itens p/ relacionamento cliente pedidos
	PK é um atributo do pedido (OrderItem)
	no orderItem eu tenho o id e o id tem o pedido
*/
	@OneToMany(mappedBy = "id.order")
	private Set<OrderItem> items = new HashSet<>();

// um p/ um mapeado pelo atributo do payment = order e cascade pq 1/1 com mesmo id	
	@OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
	private Payment payment;
	
	public Order () {
	}
 	
	public Order(Long id, Instant moment, OrderStatus orderStatus, User client) {
		super();
		this.id = id;
		this.moment = moment;
// via set q busca code		
		setOrderStatus(orderStatus);
		this.client = client;
	}

 	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}
 
// pegando o OS e convertendo para code	
	public OrderStatus getOrderStatus() {
		return OrderStatus.valueOff(orderStatus);
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		if (orderStatus != null) {
			this.orderStatus = orderStatus.getCode();
		}	
	}

	public User getClient() {
		return client;
	}

	public void setClient(User client) {
		this.client = client;
	}
	
// o pedido agora conhece seus itens	
	public Set<OrderItem> getItems() {
		return items;
	}
	
	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
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
		Order other = (Order) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
