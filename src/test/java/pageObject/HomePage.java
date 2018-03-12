package pageObject;


import common.CommonFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends CommonFunctions{

    public HomePage(WebDriver driver){
        super(driver);

    }


    By signInText = By.xpath("//span[contains(text(), 'Sign In')]");
    By signInButton = By.xpath("//a[@alt = 'Sign In']");


    public void loadHomePage(String URL){
        driver.get(URL);
        wait(2000);

    }

    public void navigateToSignInPage(){
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(signInText)).build().perform();
        wait(1000);
        driver.findElements(signInButton).get(0).click();
        wait(3000);
    }

}
