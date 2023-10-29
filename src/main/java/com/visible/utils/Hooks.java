package com.visible.utils;

import com.visible.drivers.DriverFactory;
import com.visible.drivers.Drivermanager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

public class Hooks {

    @Before
    public void setUp(Scenario scenario){
        Reporter.log("Execution started for scenario = "+scenario.getName()+"     ###",true);
        new DriverFactory().createDriver(scenario.getName(), "chrome");
    }

    @After
    public void tearDown(Scenario scenario){
        Reporter.log("Execution completed for scenario = "+scenario.getName()+"     ###",true);
        Drivermanager.unloadDriver();
    }
}
