import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Homework2 {
    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/lusinepetrosyan/Desktop/chromedriver");
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        driver.get("https://picsart.com");
    }

    @AfterMethod
    public void tearDown() {
        //driver.quit();
    }

    @Test
    public void testOnlyUsernameMissingCase() {
        loginPage.clickLoginButton();
        loginPage.typePassword("123456");
        loginPage.clickSignInButton();

        assertTrue(loginPage.isUserNameErrorDisplayed());

        String errorText = loginPage.getUsernameErrorText();
        assertFalse(errorText.isEmpty());
        assertEquals(errorText, "Enter your username or email");
    }

    @Test
    public void testOnlyPasswordMissingCase() {
        loginPage.clickLoginButton();
        loginPage.typeUsername("replayeditor");
        loginPage.clickSignInButton();

        assertTrue(loginPage.isPasswordErrorDisplayed());

        String errorText = loginPage.getPasswordErrorText();
        assertFalse(errorText.isEmpty());
        assertEquals(errorText,  "Enter the password");
    }

    @Test
    public void testBothMissingCase() {
        loginPage.clickLoginButton();
        loginPage.clickSignInButton();

        assertTrue(loginPage.isUserNameErrorDisplayed());
        assertTrue(loginPage.isPasswordErrorDisplayed());

        String userNameErrorText = loginPage.getUsernameErrorText();
        assertFalse(userNameErrorText.isEmpty());
        assertEquals(userNameErrorText, "Enter your username or email");

        String passwordErrorText = loginPage.getPasswordErrorText();
        assertFalse(passwordErrorText.isEmpty());
        assertEquals(passwordErrorText, "Enter the password");

    }
}


