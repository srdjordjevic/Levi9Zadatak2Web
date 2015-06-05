package org.wonderland.dev.levi9.springboot.web.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class SubmittedMessage {

	@NotNull
    @Min(0)
	private double budget;
	
	@NotNull
    @Min(0)
	private double profit;
	
	@NotNull
	private String urls;
	
	public SubmittedMessage() {
		
	}

	

	public double getBudget() {
		return budget;
	}



	public void setBudget(double budget) {
		this.budget = budget;
	}



	public double getProfit() {
		return profit;
	}



	public void setProfit(double profit) {
		this.profit = profit;
	}



	public String getUrls() {
		return urls;
	}
	
	public void setUrls(String urls) {
		this.urls = urls;
	}
	
	
	@Override
	public String toString() {
		return "SubmittedMessage [budget=" + budget + ", profit=" + profit
				+ ", urls=" + urls + "]";
	}

}
