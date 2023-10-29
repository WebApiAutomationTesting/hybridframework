package com.visible.drivers;

import org.openqa.selenium.WebDriver;

public class Drivermanager {

    private static final  ThreadLocal<WebDriver> drivers= new ThreadLocal<>();

    private Drivermanager(){

    }

    public static WebDriver getDriver(){
        return  drivers.get();
    }

    public static void setDriver(WebDriver driver){
        drivers.set(driver);
    }

    public static void unloadDriver(){
        drivers.get().close();
        drivers.get().quit();
        drivers.remove();
    }
}
