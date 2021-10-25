import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogInPage {
    private WebDriver driver;

    public LogInPage(WebDriver driver) {
        this.driver = driver;
    }

    private By userNameInput = By.xpath("//input[@id='user-name']");
    private By userPasswordInput = By.xpath("//input[@id='password']");
    private By logInButton = By.xpath("//input[@id='login-button']");
    private By testError = By.xpath("//h3[@data-test = 'error']");


    public ProductsPage clickLogInButton() {
        driver.findElement(logInButton).click();
        return new ProductsPage(driver);
    }

    public LogInPage typeUserName(String username) {
        driver.findElement(userNameInput).sendKeys(username);
        return this;
    }

    public LogInPage typePassword(String password) {
        driver.findElement(userPasswordInput).sendKeys(password);
        return this;
    }

    public String getTextErrorPasswordAndUsername() {
        return driver.findElement(testError).getText();
    }

    public String getTextErrorPassword() {
        return driver.findElement(testError).getText();
    }

    public String getTextErrorUsername() {
        return driver.findElement(testError).getText();
    }

    public ProductsPage userAuthorization(String username, String password) {
        this.typeUserName(username);
        this.typePassword(password);
        this.clickLogInButton();
        return new ProductsPage(driver);
    }
}
