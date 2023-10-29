package com.visible.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import java.time.Duration;

public class DriverFactory {

    public void createDriver(String scenarioName, String browser){

        WebDriver driver = getLocalDriver(browser);

        Drivermanager.setDriver(driver);

        driver.manage().window().maximize();
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

    }

    private WebDriver getLocalDriver(String browserName){
        WebDriver driver=null;

        if("chrome".equalsIgnoreCase(browserName)){
            WebDriverManager.chromedriver().setup();

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remoter-allow-origins=*");
            options.addArguments("--incognito");
            driver = new ChromeDriver(options);
        }else {
            Assert.fail("Given browser is not yet configured");
        }

        return driver;
    }
}
