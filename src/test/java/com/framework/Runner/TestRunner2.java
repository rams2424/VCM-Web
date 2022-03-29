package com.framework.Runner;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;


@io.cucumber.testng.CucumberOptions(features = "src/test/resources/com/framework/FeatureFiles",
plugin= {"pretty", "html:target/cucumber/cucumber-html-reports"
        ,"json:target/cucumber.json","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","timeline:test-output-thread/"},
monochrome = true,
tags="{@Regression}",
glue= {"com.framework.StepDefinations","com.framework.Hook"})   

@Test
public class TestRunner2  extends AbstractTestNGCucumberTests {
    
    @DataProvider(parallel=true)
    public Object[][] scenarios() {
          return super.scenarios();
    }
    
    
}

