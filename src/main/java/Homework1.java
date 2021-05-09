import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Homework1 {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "/Users/lusinepetrosyan/Desktop/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://picsart.com");
        WebElement loginButton = driver.findElement(By.cssSelector("[data-test='headerAuth-signInBtn pa-uiLib-headerAuth-authBtn']"));

        boolean isButtonEnabled = loginButton.isEnabled();

        if (!isButtonEnabled) {
            WebElement usernameFind = driver.findElement(By.name("username"));
            usernameFind.sendKeys("replayeditor");

            WebElement passwordFind = driver.findElement(By.name("password"));
            driver.findElement(By.name("password")).sendKeys("123456");

        }
        loginButton.click();
    }
}