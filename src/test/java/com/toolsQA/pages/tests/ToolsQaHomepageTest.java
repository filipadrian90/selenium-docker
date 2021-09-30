package com.toolsQA.pages.tests;

import com.toolsQA.pages.ToolsQaHomepage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import tests.BaseTest;

public class ToolsQaHomepageTest extends BaseTest {

    @Test
    public void clickElements(){
        ToolsQaHomepage toolsQaHomepage = new ToolsQaHomepage(driver);
        toolsQaHomepage.goTo();

        Assert.assertTrue(toolsQaHomepage.isElementsBtnEnabled());
        Assert.assertTrue(toolsQaHomepage.isFormsBtnEnabled());
        Assert.assertTrue(toolsQaHomepage.isAlertsFrameWindowsBtnEnabled());
        Assert.assertTrue(toolsQaHomepage.isWidgetBtnEnabled());
        Assert.assertTrue(toolsQaHomepage.isInteractionsBtnEnabled());
        Assert.assertTrue(toolsQaHomepage.isBookStoreAppBtnEnabled());

    }

}
