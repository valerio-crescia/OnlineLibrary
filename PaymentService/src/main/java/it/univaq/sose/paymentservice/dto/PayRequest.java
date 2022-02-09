package it.univaq.sose.paymentservice.dto;

public class PayRequest {
	
	private String sellerReference;
	private String cardUserInformation;
	private String cardNumber;
	private int cardSecretCode;
	private Double amount;
	public String getSellerReference() {
		return sellerReference;
	}
	public void setSellerReference(String sellerReference) {
		this.sellerReference = sellerReference;
	}
	public String getCardUserInformation() {
		return cardUserInformation;
	}
	public void setCardUserInformation(String cardUserInformation) {
		this.cardUserInformation = cardUserInformation;
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
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "PayRequest [sellerReference=" + sellerReference + ", cardUserInformation=" + cardUserInformation
				+ ", cardNumber=" + cardNumber + ", cardSecretCode=" + cardSecretCode + ", amount=" + amount + "]";
	}

	

}
