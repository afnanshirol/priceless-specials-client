package com.mastercard.priceless.category.model;

import java.util.ArrayList;

public class CategoryResponse {
	private float count;
	ArrayList<Object> data = new ArrayList<Object>();

	public float getCount() {
		return count;
	}
	
	public void setCount(float count) {
		this.count = count;
	}

	
	public ArrayList<Object> getData() {
		return data;
	}

	public void setData(ArrayList<Object> data) {
		this.data = data;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CategoryResponse [count=");
		builder.append(count);
		builder.append(", data=");
		builder.append(data);
		builder.append("]");
		return builder.toString();
	}
	
	
}