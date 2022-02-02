package pages;

import config.App;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {

    @Step("Open main page")
    public void openMainPage() {
        open("");
    }

    @Step("Verify successful authorization")
    public void verifySuccessfulAuthorization() {
        $(".account").shouldHave(text(App.config.userLogin()));
    }

    @Step("Go to the cart")
    public void goToCart() {
        $(".cart-label").click();
    }

    @Step("Check cart filling")
    public void checkCartFilling(String sizeOfCart) {
        $(".cart-qty").shouldHave(text("("+sizeOfCart+")"));
    }
}
