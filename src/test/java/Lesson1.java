import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class Lesson1 {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/lusinepetrosyan/Desktop/chromedriver");
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void tearDown() {
        //driver.quit();
    }

    @Test
    public void testAvatarDisplayedWhenLogin() {
        driver.get("https://picsart.com");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLoginButton();
        loginPage.typeUsername("replayeditor");
        loginPage.typePassword("123456");
        loginPage.clickSignInButton();
        System.out.println(driver.getCurrentUrl());

        assertTrue(loginPage.isAvatarDisplayed(), "user is not Logged in!");
    }

}


