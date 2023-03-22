package pl.seleniumdemo.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.seleniumdemo.utils.SeleniumHelper;

public class HotelSearchPage {

    @FindBy(xpath = "//span[text()='Search by Hotel or City Name']")
    private WebElement searchHotelSpan;
    @FindBy(xpath = "//div[@id='select2-drop']//input")
    private WebElement searchHotelInput;
    @FindBy(xpath = "//span[@class='select2-match' and text()='Dubai']")
    private WebElement hotelMatch;
    @FindBy(name = "checkin")
    private WebElement checkinInput;
    @FindBy(name = "checkout")
    private WebElement checkoutInput;
    @FindBy(id = "travellersInput")
    private WebElement travellersInput;
    @FindBy(id = "adultPlusBtn")
    private WebElement adultPlusBtn;
    @FindBy(id = "childPlusBtn")
    private WebElement childPlusBtn;
    @FindBy(xpath = "//button[contains(text(),' Search')]")
    private WebElement searchButton;

    private static final Logger logger = LogManager.getLogger();

    public WebDriver driver;

    public HotelSearchPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void setCity(String cityName) {
        logger.info("Setting city " + cityName);
        searchHotelSpan.click();
        searchHotelInput.sendKeys(cityName);
        String xpath = String.format("//span[@class='select2-match' and text()='%s']", cityName);
        SeleniumHelper.waitForElementToExist(driver, By.xpath(xpath));
        hotelMatch.click();
        logger.info("Setting city done");
    }

    public void setDates(String checkin, String checkout) {
        logger.info("Setting dates check-in: " + checkin + " check-out " + checkout);
        checkinInput.sendKeys(checkin);
        checkoutInput.sendKeys(checkout);
        logger.info("Setting dates done");
    }

    public void setTravellers() {
        logger.info("Adding one adult and one child");
        travellersInput.click();
        adultPlusBtn.click();
        childPlusBtn.click();
        logger.info("Adding travelers done");
    }

    public void performSearch() {
        searchButton.click();
    }
}
