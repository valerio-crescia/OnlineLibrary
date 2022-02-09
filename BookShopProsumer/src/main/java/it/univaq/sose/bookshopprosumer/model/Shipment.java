package it.univaq.sose.bookshopprosumer.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "shipment")
public class Shipment {
	
	private int id;
	private String userInformation;
	private String address;
	private Double objectWeight;
	private Date shippingStart;
	private Date shippingArrives;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserInformation() {
		return userInformation;
	}
	public void setUserInformation(String userInformation) {
		this.userInformation = userInformation;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Double getObjectWeight() {
		return objectWeight;
	}
	public void setObjectWeight(Double objectWeight) {
		this.objectWeight = objectWeight;
	}
	public Date getShippingStart() {
		return shippingStart;
	}
	public void setShippingStart(Date shippingStart) {
		this.shippingStart = shippingStart;
	}
	public Date getShippingArrives() {
		return shippingArrives;
	}
	public void setShippingArrives(Date shippingArrives) {
		this.shippingArrives = shippingArrives;
	}
	@Override
	public String toString() {
		return "Shipment [id=" + id + ", userInformation=" + userInformation + ", address=" + address
				+ ", objectWeight=" + objectWeight + ", shippingStart=" + shippingStart + ", shippingArrives="
				+ shippingArrives + "]";
	}
}