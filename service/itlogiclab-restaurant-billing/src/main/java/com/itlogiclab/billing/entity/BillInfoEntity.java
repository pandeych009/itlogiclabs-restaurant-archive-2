package com.itlogiclab.billing.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="bill_info")
public class BillInfoEntity {

	@Id
	@Column(name="bill_info_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long billInfoId;
	
	@Column(name="charge_name")
	private String chargeName; 
	
	@Column(name="charge_cost")
	private float chargeCost;
	
	@ManyToOne
	@JoinColumn(name="invoice_no", nullable = false)
	private BillEntity bill;

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

	/**
	 * @return the bill
	 */
	public BillEntity getBill() {
		return bill;
	}

	/**
	 * @param bill the bill to set
	 */
	public void setBill(BillEntity bill) {
		this.bill = bill;
	}

	@Override
	public String toString() {
		return "BillInfoEntity [billInfoId=" + billInfoId + ", chargeName=" + chargeName + ", chargeCost=" + chargeCost
				+ ", bill=" + bill + "]";
	}

	
}
