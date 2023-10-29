package com.visible.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(features = {"target/failedrerun.txt"},
        plugin = {
                "pretty",
                "html:target/cucumber.reports",
                "json:target/cucumber.json",
                "io.qameta.allure.cucumberjvm.AllureCucumberJvm",
        },
        glue = "com.visible.steps")

public class TestRunner_Retry extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios(){
        return super.scenarios();
    }
}

