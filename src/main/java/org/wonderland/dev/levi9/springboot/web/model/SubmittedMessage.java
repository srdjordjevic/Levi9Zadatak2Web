package org.wonderland.dev.levi9.springboot.web.model;

public class SubmittedMessage {

	private String budget;
	private String profit;
	private String urls;
	
	public SubmittedMessage() {
		
	}

	public String getBudget() {
		return budget;
	}

	public void setBudget(String budget) {
		this.budget = budget;
	}

	public String getProfit() {
		return profit;
	}

	public void setProfit(String profit) {
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
