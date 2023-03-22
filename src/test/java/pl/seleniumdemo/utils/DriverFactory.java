package pl.seleniumdemo.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    public static WebDriver getDriver(String name) {
        if (name.equals("firefox")) {
            return new FirefoxDriver();
        } else {
            ChromeOptions option = new ChromeOptions();
            option.addArguments("--remote-allow-origins=*");
            return new ChromeDriver(option);
        }
    }
}
