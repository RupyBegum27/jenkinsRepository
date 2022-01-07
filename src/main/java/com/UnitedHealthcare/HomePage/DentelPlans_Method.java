package com.UnitedHealthcare.HomePage;

import com.UnitedHealthcare.HomwPageWebElement.DentalPlanWebElement;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.UnitedHealthcare.Common.Base.driver;

public class DentelPlans_Method {

    @FindBy(xpath = DentalPlanWebElement.insurancePlanPageWebElement)
    public WebElement insurancePlaneWeb;

    @FindBy(xpath = DentalPlanWebElement.dentalPlanWebElement)
    public WebElement dentalPlanWeb;
    @FindBy(xpath = DentalPlanWebElement.ViewPlansZipCodeWebElement)
    public WebElement ViewPlansZipCodeWeb;
    @FindBy(xpath= DentalPlanWebElement.planFinderButtonWebElement)
    public WebElement planFinderWeb;
    //@FindBy(xpath= DentalPlanWebElement.ClickOnOkButtonWebElement)
  //  public WebElement clickOnOkButtonWeb;




    public void insuranceLink(){
       insurancePlaneWeb.click();
   }
   public void dentalPlanLink(){
    dentalPlanWeb.click();

}
public void ViewPlansZipCode(String ZipCode){
    ViewPlansZipCodeWeb.sendKeys(ZipCode);
}

public void planFinderButton() throws InterruptedException {
       planFinderWeb.click();   //click on plane Finder
       Thread.sleep(6000);
              Alert simpleAlert=driver.switchTo().alert();
       System.out.println(simpleAlert.getText());
       Thread.sleep(6000);
       simpleAlert.accept();
       Thread.sleep(5000);



}
    public void cancelAlert(){
        Alert alert=driver.switchTo().alert();
        alert.dismiss();
    }

    public void clickOnOkButton() throws InterruptedException {
        Alert simpleAlert=driver.switchTo().alert();
        System.out.println(simpleAlert.getText());
        Thread.sleep(6000);
        simpleAlert.accept();
        Thread.sleep(5000);
    }

    public void okAlert(){
        Alert alert=driver.switchTo().alert();
        alert.accept();
    }





}