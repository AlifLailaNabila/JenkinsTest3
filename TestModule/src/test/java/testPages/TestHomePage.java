package testPages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestHomePage extends HomePage {
    HomePage homePage;

    @BeforeMethod
    public void initializationOfElement() {
        homePage = PageFactory.initElements(driver, HomePage.class);
    }


    @Test
    public void search() {
        //driver.findElement(By.cssSelector("#search-field")).sendKeys("Table", Keys.ENTER);
        HomePage hp1 = PageFactory.initElements(driver, HomePage.class);
        hp1.getSearchResult("Table");
    }
}
