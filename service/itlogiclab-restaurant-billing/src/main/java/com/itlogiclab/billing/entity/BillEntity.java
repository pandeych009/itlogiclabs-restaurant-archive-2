package com.itlogiclab.billing.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Billing")
public class BillEntity {
	@Id
	@Column(name="bill_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long billId; 
	
	@Column(name="cust_id")
	private long customerId;
	
	@Column(name="invoice_no")
	private String invoiceNo;
	
	@Column(name="bill_amt")
	private float billAmount; 
	
	@Column(name="create_date")
	private String date;
	
	@Column(name="order_id")
	private long orderId; 
	
	private String status;
	
	@OneToMany(mappedBy = "bill", cascade = CascadeType.ALL)
	private Set<BillInfoEntity> billInfoList;

	/**
	 * @return the billId
	 */
	public long getBillId() {
		return billId;
	}

	/**
	 * @param billId the billId to set
	 */
	public void setBillId(long billId) {
		this.billId = billId;
	}

	/**
	 * @return the customerId
	 */
	public long getCustomerId() {
		return customerId;
	}

	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	/**
	 * @return the invoiceNo
	 */
	public String getInvoiceNo() {
		return invoiceNo;
	}

	/**
	 * @param invoiceNo the invoiceNo to set
	 */
	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	/**
	 * @return the billAmount
	 */
	public float getBillAmount() {
		return billAmount;
	}

	/**
	 * @param billAmount the billAmount to set
	 */
	public void setBillAmount(float billAmount) {
		this.billAmount = billAmount;
	}

	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
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
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the billInfoList
	 */
	public Set<BillInfoEntity> getBillInfoList() {
		return billInfoList;
	}

	/**
	 * @param billInfoList the billInfoList to set
	 */
	public void setBillInfoList(Set<BillInfoEntity> billInfoList) {
		this.billInfoList = billInfoList;
	}

	@Override
	public String toString() {
		return "BillEntity [billId=" + billId + ", customerId=" + customerId + ", invoiceNo=" + invoiceNo
				+ ", billAmount=" + billAmount + ", date=" + date + ", orderId=" + orderId + ", status=" + status
				+ ", billInfoList=" + billInfoList + "]";
	} 
	
}
