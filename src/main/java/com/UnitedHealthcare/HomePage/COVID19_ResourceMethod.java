package com.UnitedHealthcare.HomePage;

import com.UnitedHealthcare.Common.Base;
import com.UnitedHealthcare.HomwPageWebElement.Covid19_ResourceCenterWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class COVID19_ResourceMethod extends Base {

    @FindBy(xpath = Covid19_ResourceCenterWebElement.memberResourceWebElement)
    public WebElement memberResourceWeb;
    @FindBy(xpath = Covid19_ResourceCenterWebElement.Covid19ResourceWebElement)
    public WebElement Covid19ResourceWeb;
    @FindBy(xpath = Covid19_ResourceCenterWebElement.Covid19SymptomWebElement)
    public WebElement CovidSymptomWeb;
    @FindBy(xpath = Covid19_ResourceCenterWebElement.radioWebElement)
    public WebElement radioButton;


    public void memberResource(){
        clickOnWebElementByXpath(memberResourceWeb);
    }

    public void Covid19Resource(){
        clickOnWebElementByXpath(Covid19ResourceWeb);
    }
    public void Covid19Vaccines(){
        clickOnWebElementByXpath(CovidSymptomWeb);
    }
    public void radioButtonChoose(){
     //waitTimeUsingFluent("radioButton");
    radioButton.click();
}

//    public void assertEqualByXpath(String loc, String expValue) {
//        String act = driver.findElement(By.xpath(radioButton)).getText();
//        // act is coming from Domain -- the one developer build and release
//        String exp = expValue; // exp is coming from Requirement or Mock-up
//        Assert.assertEquals(act, exp);



        //  enterZipCodeWeb.sendKeys(input);
        //clickOnWebElementByXpath(enterZipCodeWeb);
    }

