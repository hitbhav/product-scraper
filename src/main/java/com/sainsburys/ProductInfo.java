/**
 * 
 */
package com.sainsburys;

import org.json.simple.JSONObject;

/**
 * @author Hitesh
 *
 */
public class ProductInfo {

	private String title;
	private float size;
	private float unitPrice;
	private String description;
	
	/**
	 * 
	 */
	public ProductInfo() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param title
	 * @param size
	 * @param unitPrice
	 * @param description
	 */
	public ProductInfo(String title, float size, float unitPrice, String description) {
		super();
		this.title = title;
		this.size = size;
		this.unitPrice = unitPrice;
		this.description = description;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public float getSize() {
		return size;
	}

	public void setSize(float size) {
		this.size = size;
	}

	public float getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(float unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	/*
	 * Use this method to get json object
	 */
	
	public JSONObject toJSON(){
		JSONObject jsonResult = new JSONObject();
		jsonResult.put("title", title);
		jsonResult.put("size", size);
		jsonResult.put("unit_price", unitPrice);
		jsonResult.put("description", description);
		
		return jsonResult;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ProductInfo [title=" + title + ", size=" + size + ", unitPrice=" + unitPrice + ", description="
				+ description + "]";
	}

	
	
}
