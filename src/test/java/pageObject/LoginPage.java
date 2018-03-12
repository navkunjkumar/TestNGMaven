package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import common.CommonFunctions;


public class LoginPage extends CommonFunctions {

    @FindBy(xpath= "//input[@type = \"email\"]")
    WebElement userName;

    @FindBy(xpath= "//input[@type = 'password']")
    WebElement password;
    
    @FindBy(xpath = "//button[contains(text(), 'Sign In')]")
    public WebElement loginButton;
    
    @FindBy(xpath = "//span[@class='alert active alert-error alert-block']//span[contains(text(), 'Your password and email ')]")
    public WebElement InvalidLogin_ErrorMessage1;
    
    @FindBy(xpath="//button[contains(text(), 'reset your password')]")
	public WebElement InvalidLogin_ResetPassword;
    
    @FindBy(xpath="//span[contains(text(), 'Please enter a valid email address.')]")
    public WebElement InvalidLogin_emailMessage;

    @FindBy(xpath = "//span[contains(text(), 'Password is required.')]")
    public WebElement InvalidLogin_Password;
    
    HomePage homePage = new HomePage(driver);

    public LoginPage(WebDriver driver){
        super(driver);
    }

    public void login(String uName, String pWord){
        userName.sendKeys(uName);
        password.sendKeys(pWord);
//        loginButton.submit();
    }

}
