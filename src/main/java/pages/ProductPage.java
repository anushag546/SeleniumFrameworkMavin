package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {

    WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    By addToCart = By.id("add-to-cart-sauce-labs-backpack");
    By cart = By.className("shopping_cart_link");

    public void addProduct() {
        driver.findElement(addToCart).click();
    }

    public void openCart() {
    	
        driver.findElement(cart).click();
    }
}