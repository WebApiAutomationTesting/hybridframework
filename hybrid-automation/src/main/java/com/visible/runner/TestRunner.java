package com.visible.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(features = {"src/main/resources/features"},
        plugin = {
                "pretty",
                "html:target/cucumber.reports",
                "json:target/cucumber.json",
                "io.qameta.allure.cucumberjvm.AllureCucumberJvm",
                "rerun:target/failedrerun.txt"
        },
        glue = "com.visible.steps",
        tags = "@debug")

public class TestRunner extends AbstractTestNGCucumberTests {

        @Override
        @DataProvider(parallel = true)
        public Object[][] scenarios(){
                return super.scenarios();
        }
}
