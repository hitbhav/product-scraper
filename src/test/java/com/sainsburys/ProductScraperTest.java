/**
 * 
 */
package com.sainsburys;

import static org.junit.Assert.assertTrue;

import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author Hitesh
 *
 */
public class ProductScraperTest {

	private ProductScraper productScraper;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {

		URL webURL = new URL("http://hiring-tests.s3-website-eu-west-1.amazonaws.com/2015_Developer_Scrape/5_products.html");
		productScraper = new ProductScraper(webURL); 
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		productScraper = null;
	}

	@Ignore
	public void testProuctScraperNotEmpty() {
		String jsonReply = productScraper.scraper();
		assertTrue(!jsonReply.isEmpty());
	}
	
	@Ignore
	public void testProuctScraperHasResult() {
		String jsonReply = productScraper.scraper();
		assertTrue(jsonReply.contains("results"));
	}
	
	@Ignore
	public void testProuctScraperHasTotal() {
		String jsonReply = productScraper.scraper();
		assertTrue(jsonReply.contains("total"));
	}

}
