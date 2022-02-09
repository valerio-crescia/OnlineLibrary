package it.univaq.sose.bookservice.domain;

import java.util.Objects;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Book")
public class Book {

	private Integer id;

	private String titolo;

	private String autore;

	private int annoPubblicazione;

	private int numeroCopieDisponibili;

	private String isbn;
	
	private Double weight;
	
	private Double price;
	

	public Book() {
		super();
	}
	public Book(int id) {
		super();
		this.id = id;
	}

	public Book(Integer id, String titolo, String autore, int annoPubblicazione, int numeroCopieDisponibili, String isbn, Double weight,Double price) {
		super();
		this.id = id;
		this.titolo = titolo;
		this.autore = autore;
		this.annoPubblicazione = annoPubblicazione;
		this.numeroCopieDisponibili = numeroCopieDisponibili;
		this.isbn = isbn;
		this.weight = weight;
		this.price = price;
	}





	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(id, other.id);
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", titolo=" + titolo + ", autore=" + autore + ", annoPubblicazione="
				+ annoPubblicazione + ", numeroCopieDisponibili=" + numeroCopieDisponibili + ", isbn=" + isbn
				+ ", weight=" + weight + ", price=" + price + "]";
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getAutore() {
		return autore;
	}

	public void setAutore(String autore) {
		this.autore = autore;
	}

	public Double getWeight() {
		return weight;
	}
	public void setWeight(Double weight) {
		this.weight = weight;
	}
	public int getAnnoPubblicazione() {
		return annoPubblicazione;
	}

	public void setAnnoPubblicazione(int annoPubblicazione) {
		this.annoPubblicazione = annoPubblicazione;
	}

	public int getNumeroCopieDisponibili() {
		return numeroCopieDisponibili;
	}

	public void setNumeroCopieDisponibili(int numeroCopieDisponibili) {
		this.numeroCopieDisponibili = numeroCopieDisponibili;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}

}
