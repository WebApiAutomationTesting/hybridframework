package com.visible.pages;

import com.visible.utils.BaseUtils;
import com.visible.utils.Hooks;
import org.openqa.selenium.WebDriver;

public class HomePage extends BaseUtils {
    public HomePage(WebDriver driver){
        super(driver);
    }

    public void navigateTo(String url){
        driver.navigate().to(url);
    }
}
