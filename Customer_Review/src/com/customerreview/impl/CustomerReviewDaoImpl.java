package com.customerreview.impl;

import CustomerReviewConstants;
import CustomerReviewModel;
import LanguageModel;
import Logger;
import ProductModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;

import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.customerreview.model.CustomerReviewModel;

public class CustomerReviewDaoImpl implements CustomerReviewDao{
	
	@Value("curse_word")
	private String curseWord;
	
	private int[] acceptedRatings = {5, 6, 7, 8, 9, 10};
	 private static final Logger LOG = Logger.getLogger(CustomerReviewConstants.class.getName());
	 
	 private static final String INVALID_RATING="User entered invalid rating";
	 private static final String INVALID_COMMENTS="User entered invalid comments";
	 /*
	  * This method will handle exception in case of invalid rating or comments and return list of valid reviews 
	  */
	
	@Override
	  public  List<CustomerReviewModel> getReviewsForProduct(ProductModel paramProductModel){
		List<com.customerreview.model.CustomerReviewModel> reviewList=new ArrayList<CustomerReviewModel>();
		
		for(com.customerreview.model.CustomerReviewModel review:paramProductModel.getCustomerReviewList()){
			try{
				if(checkCrushWord(review) && checkRating(review)){
					reviewList.add(review);
				}
			}catch(Exception ex){
				// TODO Need logic how to handle exceptions
				if(ex.getMessage().equals(INVALID_RATING)){
					LOG.error(review.getCustomerName() +" user provided invallid rating :"+review.getRating());
				}
				if(ex.getMessage().equals(INVALID_COMMENTS)){
					LOG.error(review.getCustomerName() +" user provided invallid comments :"+review.getComments());
				}
				
			}
		}
		
		return reviewList;
	}
		private boolean checkCrushWord(CustomerReviewModel review){
			boolean isValidComments=true;
			List<String> elephantList = Arrays.asList(curseWord.split(","));
			for(String curseWord:elephantList){
				if(review.getComments().contains(curseWord)){
					throw new Exception(INVALID_COMMENTS);
				}
			}
			return isValidComments;
		}
		
		private boolean checkRating(com.customerreview.model.CustomerReviewModel review){
			boolean isValidRating=false;
			if(review.getRating()<0){
				throw new Exception(INVALID_RATING);
			}
			for (int i = 0; i < acceptedRatings.length; i++){
				if(acceptedRatings[i]==review.getRating()){
					isValidRating=true;
					break;
				}
			}
			return isValidRating;
		}
/*
 * This method throw exception in case of invalid rating or comments 
 */
	@Override
	  public  List<CustomerReviewModel> getReviewsForProductAndLanguage(ProductModel paramProductModel, LanguageModel paramLanguageModel);
		// TODO Do we really need LanguageModel ?? if yes, then need discuss bussiness scenarios
	List<com.customerreview.model.CustomerReviewModel> reviewList=new ArrayList<CustomerReviewModel>();
	
	for(com.customerreview.model.CustomerReviewModel review:paramProductModel.getCustomerReviewList()){
		if(checkCrushWord(review) && checkRating(review)){
			reviewList.add(review);
		}
	}
	}


}
