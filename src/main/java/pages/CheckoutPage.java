package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.time.Duration;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutPage {

    WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    
    public void enterDetails() {

    	WebDriverWait wait =
    		    new WebDriverWait(driver, Duration.ofSeconds(10));

    		wait.until(
    		    ExpectedConditions.visibilityOfElementLocated(
    		        By.id("first-name")) );
    		        
        driver.findElement(By.id("first-name"))
              .sendKeys("Anusha");

        driver.findElement(By.id("last-name"))
              .sendKeys("Reddy");

        driver.findElement(By.id("postal-code"))
              .sendKeys("3000");

        driver.findElement(By.id("continue")).click();

        driver.findElement(By.id("finish")).click();
 	    System.out.println("URL after enetr of checkout details: "
	            + driver.getCurrentUrl());
    }

    public String getSuccessMessage() {

        return driver.findElement(
            By.className("complete-header"))
            .getText();
    }
}