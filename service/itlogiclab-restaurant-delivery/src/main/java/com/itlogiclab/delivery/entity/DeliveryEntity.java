package com.itlogiclab.delivery.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.itlogiclab.delivery.enums.Types;

@Entity
@Table(name="Delivery")
public class DeliveryEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private long deliveryId;
	
	private long orderId;
	
	private Types.DELIVERY_STATUS deliveryStaus;
	
	/**
	 * @return the deliveryId
	 */
	public long getDeliveryId() {
		return deliveryId;
	}
	/**
	 * @param deliveryId the deliveryId to set
	 */
	public void setDeliveryId(long deliveryId) {
		this.deliveryId = deliveryId;
	}
	/**
	 * @return the orderId
	 */
	public long getOrderId() {
		return orderId;
	}
	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	/**
	 * @return the deliveryStaus
	 */
	public Types.DELIVERY_STATUS getDeliveryStaus() {
		return deliveryStaus;
	}
	/**
	 * @param deliveryStaus the deliveryStaus to set
	 */
	public void setDeliveryStaus(Types.DELIVERY_STATUS deliveryStaus) {
		this.deliveryStaus = deliveryStaus;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "DelivreyModal [deliveryId=" + deliveryId + ", orderId=" + orderId + ", deliveryStaus=" + deliveryStaus
				+ "]";
	}
	
}
