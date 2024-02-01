package com.nit;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pan_details")
public class PAN_Details {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer panID;
	@Column
	private Integer accountNumber;

	public Integer getPanID() {
		return panID;
	}

	public void setPanID(Integer panID) {
		this.panID = panID;
	}

	public Integer getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Integer accountNumber) {
		this.accountNumber = accountNumber;
	}

	@Override
	public String toString() {
		return "PAN_Details [panID=" + panID + ", accountNumber=" + accountNumber + "]";
	}
}