package com.example.BankingWithSecurity.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Beneficiary {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long beneficiaryId;
	@NotBlank( message="Beneficiary name should not be empty")
	private String name;
	private String address;
	private String email;
	private String phonenumber;
	private String beneficiaryAccountNumber;
	private String ownerAccountNumber;
	public Long getBeneficiaryId() {
		return beneficiaryId;
	}
	public void setBeneficiaryId(Long beneficiaryId) {
		this.beneficiaryId = beneficiaryId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getBeneficiaryAccountNumber() {
		return beneficiaryAccountNumber;
	}
	public void setBeneficiaryAccountNumber(String beneficiaryAccountNumber) {
		this.beneficiaryAccountNumber = beneficiaryAccountNumber;
	}
	public String getOwnerAccountNumber() {
		return ownerAccountNumber;
	}
	public void setOwnerAccountNumber(String ownerAccountNumber) {
		this.ownerAccountNumber = ownerAccountNumber;
	}
	

}
