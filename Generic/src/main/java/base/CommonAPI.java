package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CommonAPI {
    public WebDriver driver = null;

    @Parameters({"url"})
    @BeforeMethod
    public void setUp(@Optional("https://www.costco.com/") String url){
        System.setProperty("webdriver.chrome.driver", "/Users/alifnabila/IdeaProjects/Jenkins3/Generic/browser-driver/chromedriver");
        //driver = new Chr
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);

    }

    @AfterMethod
    public void cleanUp(){
        driver.close();
    }
    public List<String> getTextFromWebElements(String locator){
        List<WebElement> element = new ArrayList<WebElement>();
        List<String> text = new ArrayList<String>();
        element = driver.findElements(By.cssSelector(locator));
        for(WebElement web:element){
            text.add(web.getText());
        }
        return text;
    }

    public String  getCurrentPageUrl(){
        String url = driver.getCurrentUrl();
        System.out.println(url);
        return url;
    }

    public void navigate(){
        driver.navigate().to("https://www.costco.com");
        driver.navigate().to("https://www.costco.com/LogonForm");
        driver.navigate().to("https://www.costcophotocenter.com/Home?utm_source=costco.com&utm_medium=referral&utm_campaign=Costco.com%20Navigation%20Bar&utm_term=Photo%20Main&utm_content=Photo");
    }

    public void navigateBack(){
        driver.navigate().back();
    }
    public void navigateForward(){
        driver.navigate().forward();
    }
    public void refreshPage(){
        driver.navigate().refresh();
    }

    public String getTextByXpath(String locator){
        String st = driver.findElement(By.xpath(locator)).getText();
        System.out.println(st);
        return st;
    }
}
