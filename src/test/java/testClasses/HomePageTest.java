package testClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import common.CommonFunctions;
import pageObject.HomePage;
import pageObject.LoginPage;

public class HomePageTest {
	
	WebDriver driver;
    HomePage homePage;
    LoginPage loginPage;
    String URL;
       
    @BeforeMethod
    public void loadObjects(){

        driver = new CommonFunctions(driver).launchBrowser("CHROME");
        homePage = PageFactory.initElements(driver, HomePage.class);
        

    }
    @Test
    public void verifyTopBar(){
        homePage.loadHomePage(URL);
        

    }
    @Test
    public void verifySearchBar(){
        homePage.loadHomePage(URL);
        
    }
    @Test
    public void VerifyMenuBar(){
        homePage.loadHomePage(URL);
        

    }
    
    @Test
    public void VerifyWelcomeMessage_NotAvailable(){
        homePage.loadHomePage(URL);
        

    }
    

    @AfterMethod
    public void close(){
        driver.close();
    }
}