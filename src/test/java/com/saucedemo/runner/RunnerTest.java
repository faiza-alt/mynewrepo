package com.saucedemo.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(

        features = {"src/test/resources/features"},
        glue = {"com/saucedemo"},
        dryRun = false
       // tags = ("@InvalidAccount")

)
public class RunnerTest extends AbstractTestNGCucumberTests {
}
