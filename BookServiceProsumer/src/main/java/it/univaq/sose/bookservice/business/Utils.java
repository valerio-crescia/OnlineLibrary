package it.univaq.sose.bookservice.business;

import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import it.univaq.sose.bookservice.domain.Review;

public class Utils {
	
	public static List<Review> objectMapperToListModelReview(List<it.univaq.sose.reviewservice.api.Review> list){
    	ObjectMapper mapper = new ObjectMapper();
    	List<Review> personInfo = mapper.convertValue(list,new  TypeReference<List<Review>>() {});
        return personInfo;
    }

}
