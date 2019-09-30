package com.green.entity;

import java.util.HashMap;
import java.util.Map;

public class Cart {
	private long total;
	private Map<Integer, Course> details;
	private boolean paid;

	public Cart() {
		this.total = 0;
		this.details = new HashMap<Integer, Course>();
	}

	

	/**
	 * @return the total
	 */
	public long getTotal() {
		return total;
	}



	/**
	 * @param total the total to set
	 */
	public void setTotal(long total) {
		this.total = total;
	}



	/**
	 * @return the details
	 */
	public Map<Integer, Course> getDetails() {
		return details;
	}



	/**
	 * @param details the details to set
	 */
	public void setDetails(Map<Integer, Course> details) {
		this.details = details;
	}



	public void calculate() {
		long total = 0;
		for (Integer key : details.keySet()) {
			total += details.get(key).getPrice();
		}

		this.total = total;
	}

	/**
	 * @return the paid
	 */
	public boolean isPaid() {
		return paid;
	}

	/**
	 * @param paid the paid to set
	 */
	public void setPaid(boolean paid) {
		this.paid = paid;
	}
}