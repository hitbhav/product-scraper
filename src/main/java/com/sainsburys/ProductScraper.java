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
			for (Element singleProductElement : prodElements) {

				Element prodInfoElement = singleProductElement.select("div.productInfo").first();

				Element weblinkElement = prodInfoElement.getElementsByTag("a").first();

				String productFullInfoLink = weblinkElement.attr("href");

				ProductInfo productInfo = getFullProuctInfo(productFullInfoLink);

				jsonResults.add(productInfo.toJSON());
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return ""; // return json
	}

	private ProductInfo getFullProuctInfo(String productFullInfoLink) {

		String title="";
		float size= 0.0f;
		float unitPrice=0.0f;
		String description="";

		Connection con = Jsoup.connect(productFullInfoLink);

		//First scenario: No connection
		if(con == null){
			return null;
		}
				
		try {
			
			Document document = con.get();
			
			Element element = document.select("div.productTitleDesciptionContainer").first();
			if(element ==null)
			{
				return null;
			}
			
			//get title
			Element titleEle = element.getElementsByTag("h1").first();
			title = titleEle.text();
		
			
		}catch(IOException e){
			e.printStackTrace();
		}
		
		ProductInfo productInfo = new ProductInfo();
		productInfo.setTitle(title);
		
		
		return productInfo;
	}
	
	
	
}
