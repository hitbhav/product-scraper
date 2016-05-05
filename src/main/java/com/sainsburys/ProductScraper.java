/**
 * 
 */
package com.sainsburys;

import java.io.IOException;
import java.net.URL;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

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

	public String scraper() {
		JSONObject jsonObject = new JSONObject();
		JSONArray jsonResults = new JSONArray();
		jsonObject.put("results", jsonResults);
		// Total unit price
		float total = 0.0f;

		Connection con = Jsoup.connect(webURL.toString());
		
		// First scenario: No connection
		if (con == null) {
			return "{}";
		}

		try {
			
			Element prodListner = con.get().select("ul.productLister").first();

			// Second scenario: Dont have productsn
			if (prodListner == null) {
			
				return "{}";
			}
			
			Elements prodElements = prodListner.getElementsByTag("li");
			int i =1;
			for (Element singleProductElement : prodElements) {
				
				Element prodInfoElement = singleProductElement.select("div.productInfo").first();
				Element weblinkElement = prodInfoElement.getElementsByTag("a").first();

				String productFullInfoLink = weblinkElement.attr("href");
				ProductInfo productInfo = getFullProuctInfo(productFullInfoLink);

				//Make result
				jsonResults.add(productInfo.toJSON());
				//Make total
				total += productInfo.getUnitPrice();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		jsonObject.put("total", total);
		return jsonObject.toString(); // return json
	}

	private ProductInfo getFullProuctInfo(String productFullInfoLink) {

		String title = "";
		float size = 0.0f;
		float unitPrice = 0.0f;
		String description = "";

		Connection con = Jsoup.connect(productFullInfoLink);

		// First scenario: No connection
		if (con == null) {
			return null;
		}

		try {

			Document document = con.get();

			Element element = document.select("div.productTitleDescriptionContainer").first();
												   
			if (element == null) {
				return null;
			} else {

				// Get title
				Element titleEle = element.getElementsByTag("h1").first();
				title = titleEle.text();

				// Get size of document
				size = document.toString().length() / 1024; // in kb
			}

			// Get price
			element = document.select("p.pricePerUnit").first();
			if (element == null) {
				return null;
			} else {

				String strPrice = element.text();
				strPrice = strPrice.replace("/unit", "");
				strPrice = strPrice.replace("£", "");

				unitPrice = Float.parseFloat(strPrice);
			}

			// Get description
			element = document.select("div.productText").first();
			if (element == null) {
				return null;
			} else {
				description = element.text();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		/*
		 * ProductInfo productInfo = new ProductInfo();
		 * productInfo.setTitle(title);
		 */

		ProductInfo productInfo = new ProductInfo(title, size, unitPrice, description);

		return productInfo;
	}

}
