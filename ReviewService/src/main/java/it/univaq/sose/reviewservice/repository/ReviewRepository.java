package it.univaq.sose.reviewservice.repository;

import java.util.ArrayList;
import java.util.List;

import it.univaq.sose.reviewservice.domain.Review;

public class ReviewRepository {
	
	private static  ReviewRepository INSTANCE;

	private static Review[] REVIEWS = {
		//
		new Review(1,1,"Anna"," Non male, lo consiglio anche a tutti i non appassionati di cosmologia "),
		new Review(2,1,"Chiara","Riassunto dei precedenti libri di Hawking"),
		new Review(9,1,"Sergio"," Interessante - ma molto ripetitivo "),
		new Review(10,1,"Maurizio"," Compito divulgativo impegnativo ed ambizioso, realizzato in parte."),
		//Dal big bang ai buchi neri. Breve storia del tempo
		new Review(3,2,"Anna","cquisto verificato\r\n"
				+ "Il libro è molto interessante, si legge volentieri e stimola molte domande, non sempre si dilunga in approfondimenti e quindi consigliato a coloro che hanno già certe basi sulla fisica quantistica e sulla relatività."),
		new Review(4,2,"Valerio","Libro arrivato in tempi brevi.\r\n"
				+ "Questo è un argomento che mi ha sempre affascinato, ho guardato documentari sull'argomento ma mai letto niente."),
		
		new Review(5,3,"Chiara","Libro molto bello"),
		new Review(6,3,"Claudia","Libro non granche'"),
		
		new Review(7,3,"Luigi","Libro molto bello"),
		new Review(8,3,"Mario","Libro non granche'"), 
	};
	
	
	private ReviewRepository() {
		
	}
	
	public static ReviewRepository getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new ReviewRepository();
        }
        
        return INSTANCE;
    }
	
	
	
	public synchronized List<Review> getBookReview(int idBook) {
		List<Review> reviews = new ArrayList<Review>();
		for(Review review : REVIEWS) {
			if(review.getBookId() == idBook) {
				reviews.add(review);
			}
		}
		return reviews;
	}
	
}
