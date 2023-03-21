package pl.seleniumdemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {
    public SignUpPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(name = "firstname")
    private WebElement firstNameInput;
    @FindBy(name = "lastname")
    private WebElement lastNameInput;
    @FindBy(name = "phone")
    private WebElement phoneInput;
    @FindBy(name = "email")
    private WebElement emailInput;
    @FindBy(name = "password")
    private WebElement passwordInput;
    @FindBy(name = "confirmpassword")
    private WebElement confirmPasswordInput;
    @FindBy(xpath = "//button[text()=' Sign Up']")
    private WebElement signUpButton;

    private WebDriver driver;

    public SignUpPage setFirstName(String firstName) {
        firstNameInput.sendKeys(firstName);
        return this;
    }

    public SignUpPage setLastName(String lastName) {
        lastNameInput.sendKeys(lastName);
        return this;
    }

    public SignUpPage setPhone(String phone) {
        phoneInput.sendKeys(phone);
        return this;
    }

    public SignUpPage setEmail() {
        emailInput.sendKeys("abc" + System.currentTimeMillis() + "@cbz.pl");
        return this;
    }

    public SignUpPage setPassword(String password) {
        passwordInput.sendKeys(password);
        return this;
    }

    public SignUpPage setPasswordConfirmation(String password) {
        confirmPasswordInput.sendKeys(password);
        return this;
    }

    public LoggedUserPage performSignUp() {
        signUpButton.click();

        return new LoggedUserPage(driver);
    }

}
