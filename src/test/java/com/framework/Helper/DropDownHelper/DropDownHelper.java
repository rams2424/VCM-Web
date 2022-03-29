package com.framework.Helper.DropDownHelper;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class DropDownHelper {
    
    Logger log = Logger.getLogger(DropDownHelper.class);
    
    public void SelectUsingVisibleValue(WebElement element,String visibleValue) {
        Select se = new Select(element);
        log.info(visibleValue);
        se.selectByVisibleText(visibleValue);
    }
    
    public void SelectUsingValue(WebElement element,String value) {
        Select se = new Select(element);
        log.info(value);
        se.selectByValue(value);
    }
    
    public void SelectUsingIndex(WebElement element,int index) {
        Select se = new Select(element);
        log.info(index);
        se.selectByIndex(index);
    }
    
    public String getSelectedValue(WebElement element) {
        String value = new Select(element).getFirstSelectedOption().getText();
        log.info(value);
        return value;
    }
    
    public List<String> getAllDropDownValues(WebElement element) {
        Select select = new Select(element);
        List<WebElement> elementList = select.getOptions();
        ArrayList<String>values = new ArrayList<String>();
        for (WebElement e : elementList) {
            System.out.println(e.getText());
            values.add(e.getText());
        }
        return values;
    }
    
}
