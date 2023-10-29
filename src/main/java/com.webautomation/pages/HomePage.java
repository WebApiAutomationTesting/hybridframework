package com.webautomation.pages;

import com.webautomation.utils.BaseUtils;
import org.openqa.selenium.WebDriver;

public class HomePage extends BaseUtils {
    public HomePage(WebDriver driver){
        super(driver);
    }

    public void navigateTo(String url){
        driver.navigate().to(url);
    }
}
