/**
 * 
 */
package com.sainsburys;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author Hitesh
 *
 */
public class App {

	
	
	/**
	 * A class which is main entry.
	 * @param args
	 */
	public static void main(String[] args) {
		
		String webURL = "http://hiring-tests.s3-website-eu-west-1.amazonaws.com/2015_Developer_Scrape/5_products.html";
		try{
			URL url = new URL(webURL);
			ProductScraper productScraper = new ProductScraper(url);
			String output = productScraper.scraper();
			System.out.println(output);
			
			
		} catch( MalformedURLException e){
			System.err.println("webURL is not valid " + webURL);
		}
	}

}
