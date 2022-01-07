package com.UnitedHealthcare.HomwPageWebElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HomePageElement {
    // home page click privacy link
    public static final String privacyWebElement="//a[@href='/privacy']";
    // home page click on webSite privacy policy
    public static final String privacyPolicyWebElement="//a[@href='/privacy#website']";
    // home page verify privacy policy
    public static final String privacyPolicyResultWebElement="//*[@id=\"website\"]";
//===============================================================================================
    //Home Page_Search box
    public static final String searchBoxWebElement="//*[@id=\"search-desktop\"]";
    public static final String searchButtonWebElement="//*[@id=\"search__button-desktop\"]";
    public static final String searchResultWebElement="//*[@id=\"search-results-count__header\"]/span/b";
//=================================================================================================================
  //Home Page_Insurance Plans link
    public static final String insurancePlanWebElement="//div[1]/header/div/div[1]/div[4]/div/div[1]/nav/ul/li[1]";
   //"Help me find a plan"
    public static final String findPlanWebElement="//*[@id=\"flyoutCTA-planfinder\"]";
    //click on POPUP
    public static final String closePopUPBrowser="//*[@id=\"ip-no\"]";
    //choose "Health" from the from drop down
    public static final String coverageWebElement="//*[@id=\"plan-selector\"][@name='coverageType']";
    //Enter age in the input
    public static final String selectAgeWebElement="//input[@id=\"age\"]";
    //Enter Your Zip Code
    public static final String enterYourZipCodeWebElement="//input[@id=\"zipcode\"]";
    //click on show me plan options
    public static final String showMoreOptionWebElement="//button[@form='planfinderForm'][@type='submit']";


}
