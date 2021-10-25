import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LogInPageTest {
    private WebDriver driver;
    private LogInPage logInPage;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        logInPage = new LogInPage(driver);
    }

    @Test
    public void authInvalidUsernameAndPasswordTest() {
        logInPage.userAuthorization("testUser", "testUser11");
        String errorText = logInPage.getTextErrorPasswordAndUsername();
        Assertions.assertEquals("Epic sadface: Username and password do not match any user in this service", errorText);
    }

    @Test
    public void authInvalidUsernameTest() {
        logInPage.userAuthorization("errorUsername", "secret_sauce");
        String errorText = logInPage.getTextErrorUsername();
        Assertions.assertEquals("Epic sadface: Username and password do not match any user in this service", errorText);
    }

    @Test
    public void authInvalidPasswordTest() {
        logInPage.userAuthorization("standard_user", "errorPassword");
        String errorText = logInPage.getTextErrorPassword();
        Assertions.assertEquals("Epic sadface: Username and password do not match any user in this service", errorText);
    }


    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
