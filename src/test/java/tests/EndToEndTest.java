package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.*;

public class EndToEndTest extends BaseTest {

    @Test
    public void placeOrderTest() {

        LoginPage login = new LoginPage(driver);
        ProductPage product = new ProductPage(driver);
        CartPage cart = new CartPage(driver);
        CheckoutPage checkout = new CheckoutPage(driver);

        login.login("standard_user", "secret_sauce");
        System.out.println("After Login: " + driver.getCurrentUrl());

        product.addProduct();
              String cartCount =
            driver.findElement(By.className("shopping_cart_badge"))
                  .getText();

        System.out.println("Cart Count = " + cartCount);

        product.openCart();
        System.out.println("After Cart Click: " + driver.getCurrentUrl());
        

        cart.checkout();
        System.out.println("After Checkout Click: " + driver.getCurrentUrl());

        checkout.enterDetails();

        Assert.assertEquals(
            checkout.getSuccessMessage(),
            "Thank you for your order!"
        );
    }
}