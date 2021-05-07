import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.concurrent.TimeUnit;

public class Lesson111 {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","/Users/lusinepetrosyan/Desktop/chromedriver");
        WebDriver driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://picsart.com");

        WebElement loginButton = driver.findElement(By.cssSelector("[data-test='headerAuth-signInBtn pa-uiLib-headerAuth-authBtn']"));
        loginButton.click();
        new WebDriverWait(driver,2).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.name("username")));
        //Thread.sleep(1500);

        WebElement usernameFind = driver.findElement(By.name("username"));
        usernameFind.sendKeys("replayeditor");

        WebElement passwordFind = driver.findElement(By.name("password"));
        driver.findElement(By.name("password")).sendKeys("123456");

        //Thread.sleep(1500);
        driver.findElement(By.cssSelector("[class='pa-uiLib-authentication-btn primary pa-uiLib-authentication-signIn']")).click();

       // driver.quit();
    }
}
