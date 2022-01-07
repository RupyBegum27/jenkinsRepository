package com.UnitedHealthcare.HomePage;

import com.UnitedHealthcare.Common.Base;
import com.UnitedHealthcare.HomwPageWebElement.SignUpWebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPageMethod extends Base {

@FindBy(xpath = SignUpWebElement.signInWebElement)
    public WebElement signInWeb;
@FindBy(xpath = SignUpWebElement.medicareWebElement)
    public WebElement medicareWeb;
@FindBy(xpath = SignUpWebElement.registerWebElement)
    public WebElement registerWeb;



public void ClickOnSignInWebElement(){
    //signInWeb.click();
    clickOnWebElementByXpath(signInWeb);

}
public void MedicareWebLink(){
    medicareWeb.click();
    //clickOnWebElementByXpath(medicareWeb);
}

public void registerWebElementLink(){
     registerWeb.click();

     //clickOnWebElementByXpath(registerWeb);
}















}

