package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    WebDriver driver;
    
    By checkoutBtn = By.name("checkout");
    

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void checkout() {
    	try {
	        Thread.sleep(5000);
	    } catch(Exception e) {
	    }
    	
    	 driver.findElement(checkoutBtn).click();

    	 try {
    	        Thread.sleep(10000);
    	    } catch(Exception e) {
    	    }

    	    System.out.println("URL after checkout click: "
    	            + driver.getCurrentUrl());
    }

   /* public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    By productName = By.className("inventory_item_name");
    By checkoutBtn = By.id("checkout");

    public String getProductName() {
        return driver.findElement(productName).getText();
    }

    public void clickCheckout() {
        driver.findElement(checkoutBtn).click();
    } */
}