package com.toolsQA.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ToolsQaHomepage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(css = "#app > header > a > img")
    private WebElement toolsQAimg;

    public ToolsQaHomepage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public void goTo(){
        this.driver.get("https://demoqa.com/");
    }

    public void goToHome(){
        toolsQAimg.click();
    }

}
