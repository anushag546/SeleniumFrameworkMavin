package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.*;

@Listeners(listeners.TestListener.class)
public class EndToEndTest extends BaseTest {

    @Test
    public void placeOrderTest() {

        LoginPage login = new LoginPage(driver);
        ProductPage product = new ProductPage(driver);
        CartPage cart = new CartPage(driver);
        CheckoutPage checkout = new CheckoutPage(driver);

        login.login("standard_user", "secret_sauce");

        product.addProduct();
        product.openCart();

        cart.checkout();
        checkout.enterDetails();

        Assert.assertEquals(
                checkout.getSuccessMessage(),
                "Thank you for your order!"
        );
    }
}