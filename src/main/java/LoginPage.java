import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.html.HTMLInputElement;

import java.util.List;

public class LoginPage {
    private WebDriver driver;

    private By usernameFieldLocation = By.name("username");
    private By passwordFieldLocation = By.name("password");
    private By loginButtonLocation = By.cssSelector(".pa-uiLib-headerAuth-signInBtn.pa-uiLib-headerAuth-authBtn");
    private By signInButtonLocation = By.cssSelector("[class^='pa-uiLib-authentication-btn primary pa-uiLib-authentication-signIn']");
    private By avatarLocation = By.cssSelector(".pa-uiLib-headerProfileInfo-avatar");
    private By errorTextLocation = By.cssSelector("[class='root-0-2-90 pa-uiLib-authentication-controlStatus']");
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLoginButton() {
        WebElement logInButton = driver.findElement(loginButtonLocation);
        logInButton.click();
        new WebDriverWait(driver, 2)
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(usernameFieldLocation));

    }

    public void typeUsername(String username) {
        WebElement usernameField = driver.findElement(usernameFieldLocation);
        usernameField.sendKeys(username);
    }

    public void typePassword(String password) {
        WebElement passwordField = driver.findElement(passwordFieldLocation);
        passwordField.sendKeys(password);
    }

    public void clickSignInButton() {
        WebElement signInButton = driver.findElement(signInButtonLocation);
        signInButton.click();
    }

    public boolean isAvatarDisplayed() {
        WebElement avatarIcon = new WebDriverWait(driver, 2)
                .until(ExpectedConditions.visibilityOfElementLocated(avatarLocation));
        return avatarIcon.isDisplayed();
    }

    public boolean isUserNameErrorDisplayed() {
        new WebDriverWait(driver, 2)
                .until(ExpectedConditions.visibilityOfElementLocated(errorTextLocation));
        List<WebElement> elements = driver.findElements(errorTextLocation);
        WebElement errorText = elements.get(0);
        return errorText.isDisplayed();
    }

    public boolean isPasswordErrorDisplayed() {
        new WebDriverWait(driver, 2)
                .until(ExpectedConditions.visibilityOfElementLocated(errorTextLocation));
        List<WebElement> elements = driver.findElements(errorTextLocation);
        WebElement errorText = elements.get(elements.size() - 1);
        return errorText.isDisplayed();
    }

    public String getUsernameErrorText() {
        List<WebElement> elements = driver.findElements(errorTextLocation);
        WebElement errorText = elements.get(0);
        return errorText.getText();
    }

    public String getPasswordErrorText() {
        List<WebElement> elements = driver.findElements(errorTextLocation);
        WebElement errorText = elements.get(elements.size() - 1);
        return errorText.getText();
    }
}
