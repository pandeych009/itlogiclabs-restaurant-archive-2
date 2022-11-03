package com.itlogiclab.order.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.itlogiclab.order.enums.Types;

@Entity
@Table(name="orders")
public class OrderEntity {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id; 
	
	private String orderDate;
	
	private String orderTime;
	
	@OneToOne(targetEntity=AddressEntity.class, cascade=CascadeType.ALL)
	private AddressEntity deliveryAddress;
	
	private Types.ORDER_STATUS status;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the orderDate
	 */
	public String getOrderDate() {
		return orderDate;
	}

	/**
	 * @param orderDate the orderDate to set
	 */
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	/**
	 * @return the orderTime
	 */
	public String getOrderTime() {
		return orderTime;
	}

	/**
	 * @param orderTime the orderTime to set
	 */
	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}


	/**
	 * @return the deliveryAddress
	 */
	public AddressEntity getDeliveryAddress() {
		return deliveryAddress;
	}

	/**
	 * @param deliveryAddress the deliveryAddress to set
	 */
	public void setDeliveryAddress(AddressEntity deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	/**
	 * @return the status
	 */
	public Types.ORDER_STATUS getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(Types.ORDER_STATUS status) {
		this.status = status;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "OrderEntity [id=" + id + ", orderDate=" + orderDate + ", orderTime=" + orderTime + ", deliveryAddress="
				+ deliveryAddress + ", status=" + status + "]";
	} 
	
}
