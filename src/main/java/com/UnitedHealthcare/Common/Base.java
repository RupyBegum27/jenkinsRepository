package com.UnitedHealthcare.Common;

import com.UnitedHealthcare.Configuration.Reporting.ExtentManager;
import com.UnitedHealthcare.Configuration.Reporting.ExtentTestManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.annotations.Optional;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Base {
    public static WebDriver driver;
    //    //ExtentReport
//    public static ExtentReports extent;
//    public static ExtentTest logger;
//
//
//
//    public static String browserStack_userName = "unitedhealthcare_aNTwSU";
//    public static String browserStack_accesskey = "xpZk7aehSaKs52SyrUHy";
//    public static String sauceLabs_userName = "akter008";
//    public static String sauceLabs_accesskey = "";
//    public static final String browserStack_URL = "https://" + browserStack_userName + ":" + browserStack_accesskey + "@hub-cloud.browserstack.com/wd/hub";
//    // public static final String sauceLabs_URL = "https://" + sauceLabs_userName + ":" + sauceLabs_accesskey + "@ondemand.saucelabs.com:80/wd/hub";
//    public static final String sauceLabs_URL = "https://" + sauceLabs_userName + ":" + sauceLabs_accesskey + "@ondemand.us-west-1.saucelabs.com:443/wd/hub";
//
//
//
//
//
//
//    public static final String USERNAME = System.getenv("BROWSERSTACK_USERNAME");
//    public static final String AUTOMATE_KEY = System.getenv("BROWSERSTACK_ACCESS_KEY");
//    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";




    // @BeforeMethod
    public void openBrowser() {
        SetBrowser("chrome", "https://www.uhc.com/");
    }

    @BeforeMethod
    @Parameters({"browserName", "url"})

//1) setting the browser
    public void SetBrowser(@Optional("firefox") String browserName, @Optional("https://www.uhc.com/") String url) {
        if (browserName.equalsIgnoreCase("chrome")) {
            String chromeDriverPath = "BrowserDrivers\\windows\\chromedriver.exe";
            System.setProperty("webdriver.chrome.driver", chromeDriverPath);
            driver = new ChromeDriver();
            driver.get("https://www.uhc.com/");
        } else if (browserName.equalsIgnoreCase("firefox")) {
            String fireFoxDriverPath = "BrowserDrivers\\windows\\geckodriver.exe";
            System.setProperty("webdriver.gecko.driver", fireFoxDriverPath);
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
        driver.get(url);
    }

    //==============================================================================================================


//    @BeforeSuite
//    public void extentSetup(ITestContext context) {
//        ExtentManager.setOutputDirectory(context);
//        extent = ExtentManager.getInstance();
//    }

//    @BeforeMethod
//    public void startExtent(Method method) {
//        String className = method.getDeclaringClass().getSimpleName();
//        String methodName = method.getName().toLowerCase();
//        ExtentTestManager.startTest(method.getName());
//        ExtentTestManager.getTest().assignCategory(className);
//    }

//    protected String getStackTrace(Throwable t) {
//        StringWriter sw = new StringWriter();
//        PrintWriter pw = new PrintWriter(sw);
//        t.printStackTrace(pw);
//        return sw.toString();
//    }
//
//    @AfterMethod
//    public Date afterEachTestMethod(ITestResult result) throws Exception {
//        ExtentTestManager.getTest().getTest().setStartedTime(getTime(result.getStartMillis()));
//        ExtentTestManager.getTest().getTest().setEndedTime(getTime(result.getEndMillis()));
//        for (String group : result.getMethod().getGroups()) {
//            ExtentTestManager.getTest().assignCategory(group);
//        }
//        if (result.getStatus() == 1) {
//            ExtentTestManager.getTest().log(LogStatus.PASS, "Test Passed");
//        } else if (result.getStatus() == 2) {
//            //logger.log(LogStatus.FAIL, "Test Case Failed is " + result.getName());
//            // logger.log(LogStatus.FAIL, "Test Case Failed is " + result.getThrowable());
//            ExtentTestManager.getTest().log(LogStatus.FAIL, getStackTrace(result.getThrowable()));
//            //We do pass the path captured by this method in to the extent reports using "logger.addScreenCapture" method.
//            String screenshotPath = captureScreenshotPath(driver, result.getName());
//            //To add it in the extent report
//            //logger.log(LogStatus.FAIL, logger.addScreenCapture(screenshotPath));
//        } else if (result.getStatus() == 3) {
//            ExtentTestManager.getTest().log(LogStatus.SKIP, "Test Skipped");
////        }
//       ExtentTestManager.endTest();
//      extent.flush();
//
////
//
//
//        @AfterSuite
//        public void generateReport() {
//            extent.close();
//        }
//
//        private Date getTime(long millis) {
//            Calendar calendar = Calendar.getInstance();
//            calendar.setTimeInMillis(millis);
//            return calendar.getTime();
//        }
//
//
//
//        public static String captureScreenshotPath(WebDriver driver, String screenshotName) {
//            String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
//            TakesScreenshot ts = (TakesScreenshot) driver;
//            File file = ts.getScreenshotAs(OutputType.FILE);
//            String fileName = System.getProperty("user.dir") + "/Screenshots/" + screenshotName + " " + dateName + ".png";
//            try {
//                FileUtils.copyFile(file, new File(fileName));
//                System.out.println("Screenshot captured");
//            } catch (Exception e) {
//                System.out.println("Exception while taking screenshot " + e.getMessage());
//            }
//            return fileName;
//        }
//
//        public static String convertToString(String st) {
//            String splitString = "";
//            splitString = StringUtils.join(StringUtils.splitByCharacterTypeCamelCase(st), ' ');
//            return splitString;
//        }
//
//
//
//        @Parameters({"useCloudEnv", "cloudEnvName", "os", "osVersion", "browserName", "browserVersion", "url"})
//        @BeforeMethod
//        public void setUpBrowser(@Optional("false") boolean useCloudEnv, @Optional("sauceLabs") String cloudEnvName, @Optional("OS X") String os, @Optional("Big Sure") String osVersion, @Optional("firefox") String browserName, @Optional("96") String browserVersion, @Optional("https://www.google.com") String url) throws MalformedURLException {
//            if (useCloudEnv == true) {
//                if (cloudEnvName.equalsIgnoreCase("browserStack")) {
//                    getCloudDriver(cloudEnvName, browserStack_userName, browserStack_accesskey, os, osVersion, browserName, browserVersion);
//                } else if (cloudEnvName.equalsIgnoreCase("sauceLabs")) {
//                    getCloudDriver(cloudEnvName, sauceLabs_userName, sauceLabs_accesskey, os, osVersion, browserName, browserVersion);
//                }
//            } else {
//                getLocalDriver(os, browserName);
//               // getLocalDriverAutomatically(os, browserName);
//            }
//            driver.manage().window().maximize();
//            driver.manage().deleteAllCookies();
//            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//            // Navigate to URL
//            driver.get(url);
//        }
//
//        public WebDriver getLocalDriver(String os, String browserName) {
//            if (browserName.equalsIgnoreCase("chrome")) {
//                if (os.equalsIgnoreCase("OS X")) {
//                    System.setProperty("webdriver.chrome.driver", "BrowserDrivers/mac/chromedriver");
//                } else if (os.equalsIgnoreCase("windows")) {
//                    System.setProperty("webdriver.chrome.driver", "BrowserDrivers/windows/chromedriver.exe");
//                }
//                driver = new ChromeDriver();
//            } else if (browserName.equalsIgnoreCase("chrome-options")) {
//                ChromeOptions options = new ChromeOptions();
//                options.addArguments("--disable-notifications");
//                options.addArguments("--incognito");
//                options.addArguments("--start-maximized");
//                ChromeOptions capabilities = new ChromeOptions();
//                capabilities.setCapability(ChromeOptions.CAPABILITY, options);
//                if (os.equalsIgnoreCase("OS X")) {
//                    System.setProperty("webdriver.chrome.driver", "BrowserDrivers/mac/chromedriver");
//                } else if (os.equalsIgnoreCase("windows")) {
//                    System.setProperty("webdriver.chrome.driver", "BrowserDrivers/windows/chromedriver.exe");
//                }
//                driver = new ChromeDriver(options);
//            } else if (browserName.equalsIgnoreCase("firefox")) {
//                FirefoxOptions options = new FirefoxOptions();
//                //options.setHeadless(true);
//                options.addArguments("--start-maximized");
//                options.addArguments("--ignore-certificate-errors");
//                options.addArguments("--private");
//                FirefoxOptions capabilities = new FirefoxOptions();
//                capabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options);
//                if (os.equalsIgnoreCase("OS X")) {
//                    System.setProperty("webdriver.gecko.driver", "BrowserDrivers/mac/geckodriver");
//                } else if (os.equalsIgnoreCase("windows")) {
//                    System.setProperty("webdriver.gecko.driver", "BrowserDrivers/windows/geckodriver.exe");
//                }
//                //driver = new FirefoxDriver(options);
//            } else if (browserName.equalsIgnoreCase("ie")) {
//                if (os.equalsIgnoreCase("windows")) {
//                    System.setProperty("webdriver.ie.driver", "BrowserDrivers/windows/IEDriverServer.exe");
//                }
//                driver = new InternetExplorerDriver();
//            } else if (browserName.equalsIgnoreCase("safari")) {
//                if (os.equalsIgnoreCase("OS X")) {
//                    System.setProperty("webdriver.safari.driver", "BrowserDrivers/mac/safari");
//                }
//                driver = new SafariDriver();
//            }
//            return driver;
//        }
//
//
//        public WebDriver getCloudDriver(String envName, String envUserName, String envAccessKey, String os, String osVersion, String browserName, String browserVersion) throws MalformedURLException {
//            // Set these values in your capabilities
//            DesiredCapabilities caps = new DesiredCapabilities();
//            caps.setCapability("browser", browserName);
//            caps.setCapability("browser_version", browserVersion);
//            caps.setCapability("os", os);
//            caps.setCapability("os_version", osVersion);
//            if (envName.equalsIgnoreCase("sauceLabs")) {
//                driver = new RemoteWebDriver(new URL(sauceLabs_URL), caps);
//            } else if (envName.equalsIgnoreCase("browserStack")) {
//                caps.setCapability("resolution", "1024x768");
//                driver = new RemoteWebDriver(new URL(browserStack_URL), caps);
//            }
//            return driver;
//        }

//
//
//

    //==========================================================================================

    // this is reusable method for selecting from drop Down
    public void selectFromDropDown(WebElement element, String visibleTaxt) {
        Select select = new Select(element);
        select.selectByValue(visibleTaxt);
    }

    public static boolean isPopUpWindowDisplayed(WebDriver driver1, String locator) {
        boolean value = driver1.findElement(By.xpath(locator)).isDisplayed();
        return value;
    }

    //this is reusable Method for Clicking
    public void clickOnWebElementByXpath(WebElement element) {
        element.click();
    }
    public void takeEnterKeys(String locator) {
        driver.findElement(By.xpath(locator)).sendKeys(Keys.ENTER);
    }


    //this using try{}catch (){} to click on the webElement
    public void clickOnWebElement(String locator) {
        try {
            driver.findElement(By.cssSelector(locator)).click();
        } catch (Exception ex) {

            try {
                driver.findElement(By.className(locator)).click();
            } catch (Exception ex2) {
                try {
                    driver.findElement(By.id(locator)).click();
                } catch (Exception ex3) {

                    try {
                        driver.findElement(By.xpath(locator)).click();
                    } catch (Exception ex4) {
                        driver.findElement(By.linkText(locator)).click();
                    }

                }
            }
        }
    }
    //this try{}catch(){} perform "enter" like your keyboard

    public static void typeOnElementEnter(String locator, String value) {
        try {
            driver.findElement(By.cssSelector(locator)).sendKeys(value, Keys.ENTER);
        } catch (Exception ex1) {
            try {
                System.out.println("First attempt was not successful");
                driver.findElement(By.name(locator)).sendKeys(value, Keys.ENTER);
            } catch (Exception ex2) {
                try {
                    System.out.println("Second attempt was not successful");
                    driver.findElement(By.xpath(locator)).sendKeys(value, Keys.ENTER);
                } catch (Exception ex3) {
                    System.out.println("Third attempt was not successful");
                    driver.findElement(By.id(locator)).sendKeys(value, Keys.ENTER);
                }
            }
        }

    }

    // this method will help clear any text field
    public void clearField(String locator) {
        driver.findElement(By.xpath(locator)).clear();
    }

    public void clearFieldUsingWebElement(WebElement element) {
        element.clear();
    }

    public void navigateBack() {
        driver.navigate().back();
    }

    //
    public static List<String> getTextFromWebElement(String locator) {
        List<WebElement> element = new ArrayList<>();
        List<String> text = new ArrayList<>();

        element = driver.findElements(By.cssSelector(locator));
        for (WebElement web : element) {
            String st = web.getText();
            text.add(st);
        }
        return text;
    }

    //Mouse Hover using Xpath
    public void mouseHoverByXpath(String locator){
        try {
            WebElement element = driver.findElement(By.xpath(locator));
            Actions actions = new Actions(driver);
            Actions hover = actions.moveToElement(element);
        }catch(Exception ex){
            System.out.println("First attempt has been done, This is second try");
            WebElement element =driver.findElement(By.xpath(locator));
            Actions actions = new Actions(driver);
            actions.moveToElement(element).perform();
        }
    }

    // this is another mouse hover
    public void mouseHoverByXpath1(String locator){
        WebElement element = driver.findElement(By.xpath(locator));
        Actions action= new Actions(driver);
        action.moveToElement(element).perform();
    }

    //handling Alert (accept)
    public void okAlert(){
        Alert alert=driver.switchTo().alert();
        alert.accept();
    }
    //handle Alert (dismiss)
    public void cancelAlert(){
        Alert alert=driver.switchTo().alert();
        alert.dismiss();
    }
    public void alertButton() throws InterruptedException {
        Alert simpleAlert = driver.switchTo().alert();
        System.out.println(simpleAlert.getText());
        Thread.sleep(6000);
        simpleAlert.accept();
        Thread.sleep(5000);


    }



    //iframe Handle
    public void iframeHandle(WebElement element){
        driver.switchTo().frame(element);
    }

    // go back to the
    public void goBackToHomeWindow(){
        driver.switchTo().defaultContent();
    }
    // get all the link in the page
    public void getLinks(String locator){
        driver.findElement(By.linkText(locator)).findElement(By.tagName("a")).getText();
    }

    //wait until text is visible= use this method for Assert.assert
    public void waitUntilVisible(By locator){
        WebDriverWait waite = new WebDriverWait(driver,5);
        WebElement element =waite.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitUntilClickAble(By locator){
        WebDriverWait waite = new WebDriverWait(driver,5);
        WebElement element =waite.until(ExpectedConditions.elementToBeClickable(locator));
    }

    /*
    1) Implicit wait-tell the web driver to wait for a certain amount of time before it throws a “No Such Element Exception”.
    2) Explicit Wait
    3) Fluent Wait

     */
    //fluent waite
    public void waitTimeUsingFluent(String locator){
        Wait<WebDriver> wait= new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(2))
                .withMessage("Time out after 30 seconds")
                .ignoring(NoSuchElementException.class);
    }
//    public static boolean isPopUpWindowDisplayed(WebDriver driver1, String locator){
//        boolean value=driver1.findElement(By.xpath(locator)).isDisplayed();
//        return value;
//    }
//
    // keys board "Enter"
public void inputValueInTextByWebElement(WebElement webElement, String value){
        webElement.sendKeys(value+Keys.ENTER);
}


    @AfterMethod(enabled = false)

    public void closeBrowser() throws IOException {
        takeScreenShotOnFail();
        driver.close();
        if(driver !=null){
            driver.quit();
        }
    }
    @AfterTest
    public void takeScreenShotOnFail() throws IOException {

        String path="screenShot/auto";
        String timestamp= new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
        File screenShot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShot, new File(path+"_"+timestamp+".jpg"),true);

    }



}
