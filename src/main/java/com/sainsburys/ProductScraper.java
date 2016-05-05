/**
 * 
 */
package com.sainsburys;

import java.net.URL;

import org.jsoup.Connection;

/**
 * @author Hitesh
 *
 */
public class ProductScraper {

	private URL webURL;
	private Connection webConnection;
	
	/**
	 * @param webURL
	 */
	public ProductScraper(URL webURL) {
		super();
		this.webURL = webURL;
	}
	
	public String scraper(){
	
		return ""; // return json 
	}
	
	
}
