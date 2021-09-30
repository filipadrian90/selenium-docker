package com.toolsQA.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ToolsQaHomepage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(css = "#app > header > a > img")
    private WebElement toolsQAimg;

    @FindBy(css = "#app > div > div > div.home-body > div > div:nth-child(1)")
    private WebElement elementsBtn;

    @FindBy(css = "#app > div > div > div.home-body > div > div:nth-child(2)")
    private WebElement formsBtn;

    @FindBy(css = "#app > div > div > div.home-body > div > div:nth-child(3)")
    private WebElement alertsFrameWindowsBtn;

    @FindBy(css = "#app > div > div > div.home-body > div > div:nth-child(4)")
    private WebElement widgetsBtn;

    @FindBy(css = "#app > div > div > div.home-body > div > div:nth-child(5)")
    private WebElement interactionsBtn;

    @FindBy(css = "#app > div > div > div.home-body > div > div:nth-child(6)")
    private WebElement bookStoreAppBtn;

    public ToolsQaHomepage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public void goTo(){
        this.driver.get("https://demoqa.com/");
        this.wait.until(ExpectedConditions.visibilityOf(this.toolsQAimg));
    }

    public void goToHome(){
        toolsQAimg.click();
        this.wait.until(ExpectedConditions.visibilityOf(this.toolsQAimg));
    }

    public boolean isElementsBtnEnabled(){
        return elementsBtn.isEnabled();
    }

    public boolean isFormsBtnEnabled(){
        return formsBtn.isEnabled();
    }

    public boolean isAlertsFrameWindowsBtnEnabled(){
        return alertsFrameWindowsBtn.isEnabled();
    }

    public boolean isWidgetBtnEnabled(){
        return widgetsBtn.isEnabled();
    }

    public boolean isInteractionsBtnEnabled(){
        return interactionsBtn.isEnabled();
    }

    public boolean isBookStoreAppBtnEnabled(){
        return bookStoreAppBtn.isEnabled();
    }

}
