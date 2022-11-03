package com.itlogiclab.payment.modal;

import com.itlogiclab.payment.enums.Types;
import com.itlogiclab.payment.enums.Types.PAYMENT_STATUS;
import com.itlogiclab.payment.enums.Types.PAYMENT_TYPE;

public class PaymentModal {
	
	private long paymentId;
	private String txnId;
	private String paymentDate;
	private Types.PAYMENT_STATUS paymentStatus;
	private Types.PAYMENT_TYPE type;
	public PaymentModal(long paymentId, String txnId, String paymentDate, PAYMENT_STATUS paymentStatus,
			PAYMENT_TYPE type) {
		super();
		this.paymentId = paymentId;
		this.txnId = txnId;
		this.paymentDate = paymentDate;
		this.paymentStatus = paymentStatus;
		this.type = type;
	}
	public PaymentModal() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the paymentId
	 */
	public long getPaymentId() {
		return paymentId;
	}
	/**
	 * @param paymentId the paymentId to set
	 */
	public void setPaymentId(long paymentId) {
		this.paymentId = paymentId;
	}
	/**
	 * @return the txnId
	 */
	public String getTxnId() {
		return txnId;
	}
	/**
	 * @param txnId the txnId to set
	 */
	public void setTxnId(String txnId) {
		this.txnId = txnId;
	}
	/**
	 * @return the paymentDate
	 */
	public String getPaymentDate() {
		return paymentDate;
	}
	/**
	 * @param paymentDate the paymentDate to set
	 */
	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}
	/**
	 * @return the paymentStatus
	 */
	public Types.PAYMENT_STATUS getPaymentStatus() {
		return paymentStatus;
	}
	/**
	 * @param paymentStatus the paymentStatus to set
	 */
	public void setPaymentStatus(Types.PAYMENT_STATUS paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	/**
	 * @return the type
	 */
	public Types.PAYMENT_TYPE getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(Types.PAYMENT_TYPE type) {
		this.type = type;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PaymentModal [paymentId=" + paymentId + ", txnId=" + txnId + ", paymentDate=" + paymentDate
				+ ", paymentStatus=" + paymentStatus + ", type=" + type + "]";
	} 
	
}
