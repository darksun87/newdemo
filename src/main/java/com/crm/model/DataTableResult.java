package com.crm.model;

import java.util.List;

public class DataTableResult<E> {

	private Integer pages;
	private List<E> records;
	private Long total;
	public Integer getPages() {
		return pages;
	}
	public void setPages(Integer pages) {
		this.pages = pages;
	}
	public List<E> getRecords() {
		return records;
	}
	public void setRecords(List<E> records) {
		this.records = records;
	}
	public Long getTotal() {
		return total;
	}
	public void setTotal(Long total) {
		this.total = total;
	}
}
