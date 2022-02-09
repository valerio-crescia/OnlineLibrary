package it.univaq.sose.paymentservice.domain;

public class Payment {
	
	private int idPayment;
	private String sellerReference;
	private String cardUserInformation;
	private String cardNumber;
	private int cardSecretCode;
	private String transactionReferenceNumber;
	private Double amount;
	
	public int getIdPayment() {
		return idPayment;
	}
	public void setIdPayment(int idPayment) {
		this.idPayment = idPayment;
	}
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
	public String getTransactionReferenceNumber() {
		return transactionReferenceNumber;
	}
	public void setTransactionReferenceNumber(String transactionReferenceNumber) {
		this.transactionReferenceNumber = transactionReferenceNumber;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "Payment [idPayment=" + idPayment + ", sellerReference=" + sellerReference + ", cardUserInformation="
				+ cardUserInformation + ", cardNumber=" + cardNumber + ", cardSecretCode=" + cardSecretCode
				+ ", transactionReferenceNumber=" + transactionReferenceNumber + ", amount=" + amount + "]";
	}

}
