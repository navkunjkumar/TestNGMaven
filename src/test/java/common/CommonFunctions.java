package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;

public class CommonFunctions {

    protected WebDriver driver;
    public Properties prop = new Properties();

    public CommonFunctions(WebDriver driver){
        this.driver = driver;
        
    }

    public void wait(int time) {
        try {
            Thread.sleep(time);
        } catch (Exception e) {

        }
    }
    
    public void  loadPropertiesFile(){
    	try{
    		System.out.println(System.getProperty("user.dir"));
    		System.out.println(System.getProperty("user.dir") + "\\src\\test\\resources\\project.properties");
    		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\project.properties");
    		prop.load(fis);
    		System.out.println(prop.getProperty("URL"));
    		
    	}catch(IOException ie){
    		
    	}
    }

    public WebDriver launchBrowser(String browser) {

        switch (browser) {
            case "CHROME": {
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\Drivers\\chromedriver.exe");
                ChromeOptions cOptions = new ChromeOptions();
                cOptions.addArguments("disable-infobars");
                driver = new ChromeDriver(cOptions);
                driver.manage().window().maximize();
                break;
            }
            case "IE":{
                System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\Drivers\\IEDriverServer.exe");
                driver = new InternetExplorerDriver();
                driver.manage().window().maximize();
                break;
            }

            default: {
                //To be done
            }
        }
        return  driver;
    }

}
