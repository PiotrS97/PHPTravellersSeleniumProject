package pl.seleniumdemo.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import pl.seleniumdemo.pages.HotelSearchPage;
import pl.seleniumdemo.pages.LoggedUserPage;
import pl.seleniumdemo.pages.SignUpPage;

public class SignUpTest extends BaseTest {
    @Test
    public void signUpTest() {

        LoggedUserPage loggedUserPage = new HotelSearchPage(driver)
                .openSignUpForm()
                .setFirstName("Piotr")
                .setLastName("Szatkowski")
                .setPhone("123456789")
                .setEmail()
                .setPassword("test123")
                .setPasswordConfirmation("test123")
                .performSignUp();

        Assert.assertEquals(loggedUserPage.getHeadingText(), "Hi, Piotr Szatkowski");
    }
}
