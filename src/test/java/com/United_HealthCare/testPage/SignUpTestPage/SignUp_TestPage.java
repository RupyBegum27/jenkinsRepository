package com.United_HealthCare.testPage.SignUpTestPage;

import com.UnitedHealthcare.Common.Base;
import com.UnitedHealthcare.HomePage.HomePage;
import com.UnitedHealthcare.HomePage.SignUpPageMethod;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignUp_TestPage extends Base {
    SignUpPageMethod signUpPage;

    @BeforeMethod
    public void getInit() {
        signUpPage = PageFactory.initElements(driver, SignUpPageMethod.class);
    }
 @Test
    public void testSignUp() throws InterruptedException {
        signUpPage.ClickOnSignInWebElement();
        Thread.sleep(6000);
        signUpPage.MedicareWebLink();
        Thread.sleep(6000);
        signUpPage.registerWebElementLink();


 }

}
