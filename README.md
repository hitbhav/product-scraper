# product-scraper

prouct-scraper is a console application that scrapes the Sainsbury’s grocery site - Ripe Fruits page and print out a JSON array of all the products on the page.

# Source Tree

src/main/java/

com.sainsbury.App.java
com.sainsbuty.ProductInfo.java
ProuductScraper.java

src/test/java/

ProductScraperTest.java
 

# dependencies

- json-simple
- jsoup
- junit

# run the application

mkdir sainsburys
cd sainsburys 
git clone git@github.com:hitbhav/product-scraper.git
mvn compile
mvn exec: java