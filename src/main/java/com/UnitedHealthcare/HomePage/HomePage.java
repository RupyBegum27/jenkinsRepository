package com.UnitedHealthcare.HomePage;

import com.UnitedHealthcare.Common.Base;
import com.UnitedHealthcare.HomwPageWebElement.HomePageElement;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.sql.SQLOutput;
import java.util.List;

import static com.UnitedHealthcare.HomwPageWebElement.HomePageElement.coverageWebElement;
//import static com.UnitedHealthcare.HomwPageWebElement.HomePageElement.selectHealthWebElement;

//ActionMethod Class: To keep Action Method and Assertion Method
//Action Method
public class HomePage extends Base {

    @FindBy(xpath = HomePageElement.searchBoxWebElement)
    public WebElement searchBox;
    @FindBy(xpath = HomePageElement.searchButtonWebElement)
    public WebElement searchButton;
    @FindBy(xpath = HomePageElement.searchResultWebElement)
    public WebElement searchResult;
    @FindBy(xpath =HomePageElement.insurancePlanWebElement )
    public WebElement insuranceLink;
    @FindBy(xpath =HomePageElement.findPlanWebElement)
    public WebElement moreHelpFindingPlan;
    //===============================================
    @FindBy (xpath = HomePageElement.coverageWebElement)
    public WebElement coverageWeb;
    //close popup
    @FindBy(xpath = HomePageElement.closePopUPBrowser)
    public WebElement disablePopUp;
    @FindBy(xpath = HomePageElement.selectAgeWebElement)
    public WebElement enterYourAge;
    @FindBy(xpath = HomePageElement.enterYourZipCodeWebElement)
    public WebElement enterYourZipCode;
    @FindBy(xpath = HomePageElement.showMoreOptionWebElement)
    public WebElement showMoreOptions;


    // @FindBy(how = How.XPATH, using= HomePageElement.searchBoxWebElement)      //this is the second approach using (How.Xpath)
    // public WebElement searchBox1;




    public void enterSearchKeyword(String searchInfo){
     // driver.findElement(By.xpath(HomePageElement.searchBoxWebElement)).sendKeys(searchInfo);
        searchBox.sendKeys(searchInfo);
  }
    public void clickOnSearchBox(){
    // driver.findElement(By.xpath(HomePageElement.searchButtonWebElement)).click();
       searchButton.click();
}
    //Assertion Method
    public void verifySearchKeyword(String expectedKeyWord){
      //String actualSearchKeyword=driver.findElement(By.xpath(HomePageElement.searchResultWebElement)).getText();  (before approach)
    String actualSearchKeyword=searchResult.getText();                                                            //(after approach)
    Assert.assertEquals(actualSearchKeyword,expectedKeyWord,"Search keyword not match");
}
//===========================================================================================================================
    public void insurancePlanLink(){
        insuranceLink.click();
}
    public void helpFindPlan(){
       moreHelpFindingPlan.click();
}

    public void alertClass() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 20);
            if (wait.until(ExpectedConditions.alertIsPresent()) == null) {
                System.out.println("Alert not displayed");
            } else {
                driver.switchTo().alert().dismiss();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // isPopUpWindowDisplayed(true,disablePopUp.click());

}
    public void selectPlan()  {
//        Select select=new Select(coverageWeb);
//        select.selectByValue("health");
        selectFromDropDown(coverageWeb,"health");


    }
    public void enterAge(String age){
        enterYourAge.sendKeys(age);

    }
    public void enterZipCode(String zipCode){
        enterYourZipCode.sendKeys(zipCode);
    }

    public void showMePlanOptions(){
        showMoreOptions.click();
    }





      }




