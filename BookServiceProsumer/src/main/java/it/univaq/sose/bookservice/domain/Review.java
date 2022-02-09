package it.univaq.sose.bookservice.domain;

import java.util.Objects;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Review")
public class Review {
	private int id;
	private int bookId;
	private String autorUsername;
	private String text;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getAutorUsername() {
		return autorUsername;
	}
	public void setAutorUsername(String autorUsername) {
		this.autorUsername = autorUsername;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	@Override
	public String toString() {
		return "Review [id=" + id + ", bookId=" + bookId + ", autorUsername=" + autorUsername + ", text=" + text + "]";
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
		Review other = (Review) obj;
		return id == other.id;
	}
	
}
