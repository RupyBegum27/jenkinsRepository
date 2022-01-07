package com.United_HealthCare.testPage.Covid19_Resources_Test;

import com.UnitedHealthcare.Common.Base;
import com.UnitedHealthcare.HomePage.COVID19_ResourceMethod;
import com.UnitedHealthcare.HomePage.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Covid19_TestPage extends Base {
    public static COVID19_ResourceMethod covidTest;


    @BeforeMethod
    public void getInit() {
       covidTest  = PageFactory.initElements(driver, COVID19_ResourceMethod.class);
    }


   @Test
    public void  COVID19ResourcesCenterTest() throws InterruptedException {
    covidTest.memberResource();
    covidTest.Covid19Resource();
    Thread.sleep(6000);
    covidTest.Covid19Vaccines();
    Thread.sleep(6000);
    //covidTest.radioButtonChoose();
    Thread.sleep(6000);










}



}
