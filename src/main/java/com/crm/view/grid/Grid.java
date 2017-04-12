package com.crm.view.grid;

import java.util.ArrayList;
import java.util.List;

public class Grid<E> {
	
	private List<GridHead> head = new ArrayList<GridHead>();
	private List<E> contentDate = new ArrayList<E>();
	
	public List<GridHead> getHead() {
		return head;
	}
	public void setHead(List<GridHead> head) {
		this.head = head;
	}
	public List<E> getContentDate() {
		return contentDate;
	}
	public void setContentDate(List<E> contentDate) {
		this.contentDate = contentDate;
	}
	
	
	
}
