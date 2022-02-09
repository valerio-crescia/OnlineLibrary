package it.univaq.sose.paymentservice.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "PayResponse")
public class PayResponse {
	private String transactionReferenceNumber;

	public String getTransactionReferenceNumber() {
		return transactionReferenceNumber;
	}

	public void setTransactionReferenceNumber(String transactionReferenceNumber) {
		this.transactionReferenceNumber = transactionReferenceNumber;
	}

	@Override
	public String toString() {
		return "PayResponse [transactionReferenceNumber=" + transactionReferenceNumber + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((transactionReferenceNumber == null) ? 0 : transactionReferenceNumber.hashCode());
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
		PayResponse other = (PayResponse) obj;
		if (transactionReferenceNumber == null) {
			if (other.transactionReferenceNumber != null)
				return false;
		} else if (!transactionReferenceNumber.equals(other.transactionReferenceNumber))
			return false;
		return true;
	}
	
	
	
	
	

}
