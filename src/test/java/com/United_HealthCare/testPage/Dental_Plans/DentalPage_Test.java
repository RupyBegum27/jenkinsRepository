package com.United_HealthCare.testPage.Dental_Plans;

import com.UnitedHealthcare.Common.Base;
import com.UnitedHealthcare.HomePage.COVID19_ResourceMethod;
import com.UnitedHealthcare.HomePage.DentelPlans_Method;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DentalPage_Test extends Base {

    public static DentelPlans_Method dental;


    @BeforeMethod
    public void getInit(){
        dental= PageFactory.initElements(driver,DentelPlans_Method.class);
    }
@Test
   public void dentalPlanFunctionality() throws InterruptedException {
        dental.insuranceLink();
        dental.dentalPlanLink();

        Thread.sleep(2000);
        dental.ViewPlansZipCode("11423");
        Thread.sleep(6000);
        //dental.cancelAlert();
        dental.planFinderButton();
        Thread.sleep(6000);
        //  dental.cancelAlert();
      // dental.clickOnOkButton();
    //dental.okAlert();


}







}
