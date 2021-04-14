package com.webstore.shop.domain;

import java.io.Serializable;

public class Customer implements Serializable{	//고객들의 정보를 DB에 담기위한 VO클래스
	/**
	 * 
	 */
	private static final long serialVersionUID = 5651045876740877155L;
	private String customerId;
	private String name;
	private String address;
	private int noOfOrdersMade;	//주문횟수
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
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
	public int getNoOfOrdersMade() {
		return noOfOrdersMade;
	}
	public void setnoOfOrdersMade(int noOfOrdersMade) {
		this.noOfOrdersMade = noOfOrdersMade;
	}

}
