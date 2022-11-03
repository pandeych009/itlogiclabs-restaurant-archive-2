package com.itlogiclab.billing.modal;

public class BillInfoModal {
	
	private long billInfoId; 
	private String invoiceNo; 
	private String chargeName; 
	private float chargeCost;
	
	
	/**
	 * @return the billInfoId
	 */
	public long getBillInfoId() {
		return billInfoId;
	}
	/**
	 * @param billInfoId the billInfoId to set
	 */
	public void setBillInfoId(long billInfoId) {
		this.billInfoId = billInfoId;
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
	 * @return the chargeName
	 */
	public String getChargeName() {
		return chargeName;
	}
	/**
	 * @param chargeName the chargeName to set
	 */
	public void setChargeName(String chargeName) {
		this.chargeName = chargeName;
	}
	/**
	 * @return the chargeCost
	 */
	public float getChargeCost() {
		return chargeCost;
	}
	/**
	 * @param chargeCost the chargeCost to set
	 */
	public void setChargeCost(float chargeCost) {
		this.chargeCost = chargeCost;
	}
	@Override
	public String toString() {
		return "BillInfoModal [billInfoId=" + billInfoId + ", invoiceNo=" + invoiceNo + ", chargeName=" + chargeName
				+ ", chargeCost=" + chargeCost + "]";
	} 
	
}


