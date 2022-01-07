package com.United_HealthCare.testPage.HomePage_Test;

import com.UnitedHealthcare.Common.Base;
import com.UnitedHealthcare.HomePage.HomePage;
import com.UnitedHealthcare.HomwPageWebElement.HomePageElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.UnitedHealthcare.Common.Base.driver;

//Test Class: To keep Test methods


public class HomePageTest extends Base {
    public static HomePage homePage;


    @BeforeMethod
    public void getInit() {
        homePage = PageFactory.initElements(driver, HomePage.class);
    }

    @Test
    //Search box functionality
    public void testSearchBoxFunctionality() {
        homePage.enterSearchKeyword("forms");
        homePage.clickOnSearchBox();
        homePage.verifySearchKeyword("forms");
        //homePage.verifySearchKeyword("1-20 of 752 results for forms");
        driver.navigate().back();
    }

    @Test
    // Insurance Plan link
    public void testInsurancePlanLink() throws InterruptedException {
        homePage.insurancePlanLink();
        homePage.helpFindPlan();
        //homePage.alertClass();
        Thread.sleep(2000);
        homePage.alertClass();
        Thread.sleep(2000);
        homePage.selectPlan();
        homePage.enterAge("34");
        homePage.enterZipCode("11423");
        homePage.showMePlanOptions();
       // driver.navigate().back();
    }
    //under Insurance Plan check the functionality of vision plans link
    @Test
      public void testVisionPlanFunctionality(){
        homePage.insurancePlanLink();




    }


}