package it.univaq.sose.bookshopprosumer.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="RequestBuyDTO")
public class RequestBuyDTO {
	
	private String Jwt;
	private int bookId;
	private int userId;
	private String recipient;
	private String address;
	private String cardHolder;
	private String cardNumber;
	private int cardSecretCode;
	private double amount;
	private double weight;
	
	
	public RequestBuyDTO() {
		super();
	}
	
	
	public RequestBuyDTO(String jwt, int bookId, String recipient, String address, String cardHolder, String cardNumber,
			int cardSecretCode, double amount, double weight, int userId) {
		super();
		Jwt = jwt;
		this.bookId = bookId;
		this.recipient = recipient;
		this.address = address;
		this.cardHolder = cardHolder;
		this.cardNumber = cardNumber;
		this.cardSecretCode = cardSecretCode;
		this.amount = amount;
		this.weight = weight;
		this.userId = userId;
	}


	public String getJwt() {
		return Jwt;
	}
	public void setJwt(String jwt) {
		Jwt = jwt;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getRecipient() {
		return recipient;
	}
	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCardHolder() {
		return cardHolder;
	}
	public void setCardHolder(String cardHolder) {
		this.cardHolder = cardHolder;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public int getCardSecretCode() {
		return cardSecretCode;
	}
	public void setCardSecretCode(int cardSecretCode) {
		this.cardSecretCode = cardSecretCode;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
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
		result = prime * result + ((Jwt == null) ? 0 : Jwt.hashCode());
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + bookId;
		result = prime * result + ((cardHolder == null) ? 0 : cardHolder.hashCode());
		result = prime * result + ((cardNumber == null) ? 0 : cardNumber.hashCode());
		result = prime * result + cardSecretCode;
		result = prime * result + ((recipient == null) ? 0 : recipient.hashCode());
		temp = Double.doubleToLongBits(weight);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		RequestBuyDTO other = (RequestBuyDTO) obj;
		if (Jwt == null) {
			if (other.Jwt != null)
				return false;
		} else if (!Jwt.equals(other.Jwt))
			return false;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (bookId != other.bookId)
			return false;
		if (cardHolder == null) {
			if (other.cardHolder != null)
				return false;
		} else if (!cardHolder.equals(other.cardHolder))
			return false;
		if (cardNumber == null) {
			if (other.cardNumber != null)
				return false;
		} else if (!cardNumber.equals(other.cardNumber))
			return false;
		if (cardSecretCode != other.cardSecretCode)
			return false;
		if (recipient == null) {
			if (other.recipient != null)
				return false;
		} else if (!recipient.equals(other.recipient))
			return false;
		if (Double.doubleToLongBits(weight) != Double.doubleToLongBits(other.weight))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "RequestBuyDTO [Jwt=" + Jwt + ", bookId=" + bookId + ", userId=" + userId + ", recipient=" + recipient
				+ ", address=" + address + ", cardHolder=" + cardHolder + ", cardNumber=" + cardNumber
				+ ", cardSecretCode=" + cardSecretCode + ", amount=" + amount + ", weight=" + weight + "]";
	}
	
	
	
	
	
	

}
