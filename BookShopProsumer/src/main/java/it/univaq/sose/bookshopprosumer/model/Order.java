package it.univaq.sose.bookshopprosumer.model;

public class Order {
	private int id;
	private int userId;
	private int shipmentId;
	private String recipient;
	private Double amount;
	private String TRN;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getShipmentId() {
		return shipmentId;
	}
	public void setShipmentId(int shipmentId) {
		this.shipmentId = shipmentId;
	}
	public String getRecipient() {
		return recipient;
	}
	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}
	public Double getAmount() {
		return amount;
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (id != other.id)
			return false;
		return true;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getTRN() {
		return TRN;
	}
	public void setTRN(String tRN) {
		TRN = tRN;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", userId=" + userId + ", shipmentId=" + shipmentId + ", recipient=" + recipient
				+ ", amount=" + amount + ", TRN=" + TRN + "]";
	}
	
	
	
}
