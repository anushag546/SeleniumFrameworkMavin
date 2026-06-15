package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

   /*  WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    By username = By.id("user-name");
    By password = By.id("password");
    By loginBtn = By.id("login-button"); */
	
	 WebDriver driver;

	    By username = By.id("user-name");
	    By password = By.id("password");
	    By loginBtn = By.id("login-button");

	    public LoginPage(WebDriver driver) {
	        this.driver = driver;
	    }

    public void login(String user, String pass) {
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(loginBtn).click();
        System.out.println("Login attempted with credentials: " + user + ", " + pass);
        // Git Branching Practice
    }
}