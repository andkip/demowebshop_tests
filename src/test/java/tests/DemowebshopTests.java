package tests;

import api.ApiSteps;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.MainPage;

public class DemowebshopTests extends TestBase {
    ApiSteps apiSteps = new ApiSteps();
    MainPage mainPage = new MainPage();


    @Test
    @DisplayName("Successful authorization to the demowebshop (API + UI)")
    void loginWithCookieTest() {
        apiSteps.getAndSetCookieToTheBrowser();
        mainPage.openMainPage();
        mainPage.verifySuccessfulAuthorization();
    }

    @Test
    @DisplayName("Add book to cart and check its presence (API + UI)")
    void addBookToCartAndCheckIt() {
        apiSteps.addBookToCart();
        mainPage.openMainPage();
        mainPage.checkCartFilling("1");
    }
}