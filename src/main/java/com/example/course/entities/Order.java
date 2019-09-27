package com.example.course.entities;

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

import com.example.course.entities.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "tb_order")
public class Order implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id // Para definir como campo chave no BD
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Para auto incremento
	private Long id;

	// Formatar a data no ISO 8601
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant moment;
	
	//private OrderStatus orderStatus;
	private Integer orderStatus; //Internamente o orderStatus é um inteiro;

	// Para fazer a dependencia e o relacionamento

	@ManyToOne
	@JoinColumn(name = "client_id") // nome do relacionamento
	private User client;
	
	@OneToMany(mappedBy = "id.order")
	private Set<OrderItem> items = new HashSet<>();
	
	@OneToOne(mappedBy = "order", cascade=CascadeType.ALL) //Necesário devido a associação OneToOne
	private Payment payment;

	public Order() {
	}

	public Order(Long id, Instant moment, OrderStatus orderStatus, User client) {
		this.id = id;
		this.moment = moment;
		//this.orderStatus = orderStatus;
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
	
	public OrderStatus getOrderStatus() {
		//return orderStatus;
		// Utilizar o método criado para converter o código que está recebendo como argumento
		return OrderStatus.valueOf(orderStatus);
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		//this.orderStatus = orderStatus;
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
		
	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public Set<OrderItem> getItems(){
		return items;
	}

	//Método para calcular o total de cada item OrderItem
	public Double getTotal() {
		double sum = 0.0;
		for (OrderItem x : items) {
			sum += x.getSubTotal();
		}
		return sum;
	}
	
	
	//HashCode and Equals
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
