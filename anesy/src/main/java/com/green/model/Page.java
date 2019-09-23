package com.green.model;

import java.util.ArrayList;
import java.util.List;

import com.green.util.ApplicationConfig;

public class Page<T> {
	private int current;
	private int total;
	private long totalRows;
	private List<T> list;

	public Page() {
		current = 1;
		total = 1;
		totalRows = 0;
		list = new ArrayList<>();
	}

	public int getCurrent() {
		return current;
	}

	public void setCurrent(int current) {
		this.current = current;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}
	
	public long getTotalRows() {
		return totalRows;
	}
	
	public void setTotalRows(long totalRows) {
		this.totalRows = totalRows;
		
		int pageSize = Integer.parseInt(ApplicationConfig.getConfig("paging.size"));
		total = (int) (totalRows/pageSize);
		if (totalRows % pageSize > 0) {
			total++;
		}
	}

}
