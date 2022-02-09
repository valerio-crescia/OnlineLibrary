package it.univaq.sose.shippingservice.dto;

public class CreateShippingRequest {
	private String userInfomation;
	private String address;
	private Double objectWeight;
	
	
	
	public String getUserInfomation() {
		return userInfomation;
	}
	public void setUserInfomation(String userInfomation) {
		this.userInfomation = userInfomation;
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
	@Override
	public String toString() {
		return "CreateShippingRequest [userInfomation=" + userInfomation + ", address=" + address + ", objectWeight="
				+ objectWeight + "]";
	}
	

}
