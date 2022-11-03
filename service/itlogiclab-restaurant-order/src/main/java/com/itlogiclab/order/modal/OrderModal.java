package com.itlogiclab.order.modal;

import com.itlogiclab.order.enums.Types;

public class OrderModal {
	
	private long orderId;
	
	private String orderDate;
	
	private String orderTime;
	
	private Address deliveryAddress;
	
	private Types.ORDER_STATUS status;
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
	public Address getDeliveryAddress() {
		return deliveryAddress;
	}
	/**
	 * @param deliveryAddress the deliveryAddress to set
	 */
	public void setDeliveryAddress(Address deliveryAddress) {
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
		return "OrderModal [orderId=" + orderId + ", orderDate=" + orderDate + ", orderTime=" + orderTime + ", deliveryAddress=" + deliveryAddress + ", status=" + status + "]";
	}
	
}
