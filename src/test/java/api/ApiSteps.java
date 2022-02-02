package api;

import config.App;
import io.qameta.allure.Step;
import org.openqa.selenium.Cookie;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static io.restassured.RestAssured.given;

public class ApiSteps {
    String loginEndpoint = "/login";
    String addBookToCartEndpoint = "/addproducttocart/details/45/1";

    @Step("Get and set authorization cookie to the browser")
    public void getAndSetCookieToTheBrowser() {
        String authorizationCookie =
                given()
                        .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                        .formParam("Email", App.config.getUserLogin())
                        .formParam("Password", App.config.getUserPassword())
                        .when()
                        .post(loginEndpoint)
                        .then()
                        .statusCode(302)
                        .extract()
                        .cookie("NOPCOMMERCE.AUTH");
        open("/Themes/DefaultClean/Content/images/logo.png");
        getWebDriver().manage().addCookie(
                new Cookie("NOPCOMMERCE.AUTH", authorizationCookie));
    }

    @Step("Add book to the cart")
    public void addBookToCart() {
        String data = "addtocart_45.EnteredQuantity=1";

        String authorizationCookie =
                given()
                        .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                        .body(data)
                        .when()
                        .post(addBookToCartEndpoint)
                        .then()
                        .statusCode(200)
                        .extract()
                        .cookie("Nop.customer");
        open("/Themes/DefaultClean/Content/images/logo.png");
        getWebDriver().manage().addCookie(new Cookie("Nop.customer", authorizationCookie));
    }
}
