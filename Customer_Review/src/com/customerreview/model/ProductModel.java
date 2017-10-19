package com.customerreview.model;

import java.util.ArrayList;
import java.util.List;

public class ProductModel {

	private String productName;
	private int modelNo;
	private List<CustomerReviewModel> customerReviewList;

	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getModelNo() {
		return modelNo;
	}
	public void setModelNo(int modelNo) {
		this.modelNo = modelNo;
	}
	public List<CustomerReviewModel> getCustomerReviewList() {
		if(customerReviewList!=null){
			return customerReviewList;
		}else{
			customerReviewList=new ArrayList<CustomerReviewModel>();
			return customerReviewList;
		}
		
	}
	public void setCustomerReviewList(List<CustomerReviewModel> customerReviewList) {
		this.customerReviewList = customerReviewList;
	}
}
