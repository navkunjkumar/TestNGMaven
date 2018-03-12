package testClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import common.CommonFunctions;
import pageObject.HomePage;
import pageObject.LoginPage;

@Test(groups = "regression")
public class LoginTest {

    WebDriver driver;
    HomePage homePage;
    LoginPage loginPage;
    CommonFunctions commonFunctions;
    public String URL = "https://www.walmart.com";
       
    @BeforeTest
    public void loadObjects(){
    	commonFunctions = new CommonFunctions(driver);
        driver = commonFunctions.launchBrowser("CHROME");
        homePage = PageFactory.initElements(driver, HomePage.class);
        loginPage = PageFactory.initElements(driver, LoginPage.class);  
        
    }
    
    
    @Test(groups = {"regression", "smoke"})
    public void login_Successful_01(){
        homePage.loadHomePage(URL);
        homePage.navigateToSignInPage();
        loginPage.login("m@gmail.com", "T12345678");
        loginPage.wait(3000);
        Reporter.log("login_Successful_01");
        Reporter.log(driver.getTitle());
        

    }
    @Test(groups = {"regression", "smoke"})
    public void login_unsuccessful_01(){
        homePage.loadHomePage(URL);
        homePage.navigateToSignInPage();
        loginPage.login("navkunjkumar@gmail.com", "Knj");
        loginPage.loginButton.submit();
        loginPage.wait(1000);
        
        String errorMessage1 = "Your password and email do not match. Please try again or ";
        SoftAssert sa = new SoftAssert();
        sa.assertEquals(loginPage.InvalidLogin_ErrorMessage1.getText(), errorMessage1, "message changed");
        sa.assertTrue(loginPage.InvalidLogin_ResetPassword.isDisplayed());
        Reporter.log("login_unsuccessful_01");
        sa.assertAll();
        Reporter.log("Verified the message : " + errorMessage1);
        
    }
    
    @Test(groups = {"regression"})
    public void login_unsuccessful_02(){
        homePage.loadHomePage(URL);
        homePage.navigateToSignInPage();
        loginPage.login("nav", " ");
        loginPage.wait(1000);
        
        String errorMessage1 = "Please enter a valid email address.";
        SoftAssert sa = new SoftAssert();
        sa.assertEquals(loginPage.InvalidLogin_emailMessage.getText(), errorMessage1);
        sa.assertAll();
        Reporter.log("Verified the message : "+ errorMessage1);
    }
    
    @Test(groups = "regression")
    public void login_unsuccessful_03(){
        homePage.loadHomePage(URL);
        homePage.navigateToSignInPage();
        loginPage.login("navkunjkumar@gmail.com", "");
        loginPage.wait(1000);

        String errorMessage1 = "Password is required.";
        SoftAssert sa = new SoftAssert();
        sa.assertEquals(loginPage.InvalidLogin_Password.getText(), errorMessage1);
        sa.assertAll();
        Reporter.log("Verified the message : "+ errorMessage1);
    }
    

    @AfterTest
    public void close(){
        driver.close();
    }
}
