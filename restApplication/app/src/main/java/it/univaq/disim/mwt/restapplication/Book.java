package it.univaq.disim.mwt.restapplication;

import android.os.Parcel;
import android.os.Parcelable;

public class Book implements Parcelable {
    private Integer id;

    private String titolo;

    private String autore;

    private int annoPubblicazione;

    private int numeroCopieDisponibili;

    private String isbn;

    private Double weight;

    private Double price;

    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel parcel) {
            return new Book(parcel);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };

    public Book() {
    }

    public Book(Integer id, String titolo, String autore,
                int annoPubblicazione, int numeroCopieDisponibili,
                String isbn, Double weight, Double price) {
        this.id = id;
        this.titolo = titolo;
        this.autore = autore;
        this.annoPubblicazione = annoPubblicazione;
        this.numeroCopieDisponibili = numeroCopieDisponibili;
        this.isbn = isbn;
        this.weight = weight;
        this.price = price;
    }

    public Book(Parcel in){
        this.id = in.readInt();
        this.titolo = in.readString();
        this.autore = in.readString();
        this.annoPubblicazione = in.readInt();
        this.numeroCopieDisponibili = in.readInt();
        this.isbn = in.readString();
        this.weight = in.readDouble();
        this.price = in.readDouble();
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

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.id);
        parcel.writeString(this.titolo);
        parcel.writeString(this.autore);
        parcel.writeInt(this.annoPubblicazione);
        parcel.writeInt(this.numeroCopieDisponibili);
        parcel.writeString(this.isbn);
        parcel.writeDouble(this.weight);
        parcel.writeDouble(this.price);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", titolo='" + titolo + '\'' +
                ", autore='" + autore + '\'' +
                ", annoPubblicazione=" + annoPubblicazione +
                ", numeroCopieDisponibili=" + numeroCopieDisponibili +
                ", isbn='" + isbn + '\'' +
                ", weight=" + weight +
                ", price=" + price +
                '}';
    }
}
