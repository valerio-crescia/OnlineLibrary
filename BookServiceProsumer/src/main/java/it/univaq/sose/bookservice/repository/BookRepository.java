package it.univaq.sose.bookservice.repository;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import it.univaq.sose.bookservice.business.BusinessException;
import it.univaq.sose.bookservice.domain.Book;

public class BookRepository {

	private static BookRepository INSTANCE;

	private static List<Book> BOOKS = new ArrayList<Book>() {
		{
			add(new Book(1, "Le mie risposte alle grandi domande", "Stephen Hawking", 2020, 3, "8817142573", 0.32,9.60));
			add(new Book(2, "Dal big bang ai buchi neri. Breve storia del tempo", "Stephen Hawking", 2015, 3, "8817079758", 0.36, 10.40));
			add(new Book(3, "La cura dei 10 minuti: Trasforma la tua vita un mattino alla volta ", "Owen o'kate", 2020, 3, "bvbvb", 0.23,23.00));
			add(new Book(4, "Libri che mi hanno rovinato la vita e altri amori malinconici ", "Daria bignardi", 2020, 3, "nfdhhd", 0.24,23.00));
			add(new Book(5, "Le ossa parlano", "Antonio Manzini", 2020, 3, "gdgdh", 0.24,23.00));
			add(new Book(6, "Harry Potter e la Pietra Filosofale", "JK Rowling", 2020, 3, "ffgfg", 0.25,23.00));
			add(new Book(8, "Ci vediamo un giorno di questi", "Federica Bosco", 2020, 3, "gdsgfds", 0.26,23.00));
			add(new Book(9, "Tu non conosci la vergogna. La mia vita eleganzissima", "Drusilla fourie", 2020, 3, "gdsgfds", 0.26,23.00));
			add(new Book(10, "Morgana. L'uomo ricco sono io", "Federica Bosco", 2020, 3, "gdsgfds", 0.26,23.00));
			add(new Book(11, "Harry Potter: La Saga Completa (1-7)", "JK Rowling", 2020, 3, "gdsgfds", 0.26,23.00));
		}
	};

	private BookRepository() {
	}

	public static synchronized BookRepository getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new BookRepository();

		}
		return INSTANCE;
	}

	public List<Book> getBooks() {
		return BOOKS;
	}

	public Book getBook(Integer bookid) throws BusinessException {
		for (Book book : BOOKS) {
			if (book.getId().equals(bookid)) {
				return book;
			}
		}
		throw new BusinessException("Book not found");
	}

	public void updateBook(Book book) throws BusinessException {
		
		for (Book b : BOOKS) {
			if (b.getId().equals((Integer)book.getId())) {
				b.setTitolo(book.getTitolo());
				b.setAutore(book.getAutore());
				b.setWeight(book.getWeight());
				b.setAnnoPubblicazione(book.getAnnoPubblicazione());
				b.setNumeroCopieDisponibili(book.getNumeroCopieDisponibili());
				b.setIsbn(book.getIsbn());
				return;
			}
		}
		throw new BusinessException("Book not found");
	}
}
