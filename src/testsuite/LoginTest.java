package testsuite;
/**
 *2. Create the package ‘testsuite’ and create the following class inside the ‘testsuite’ package.
 * 1. LoginTest
 * 3. Write down the following test into ‘LoginTest’ class
 * 1. userSholdLoginSuccessfullyWithValidCredentials * Enter “tomsmith” username
 * * Enter “SuperSecretPassword!” password
 * * Click on ‘LOGIN’ button
 * * Verify the text “Secure Area”
 * 2. verifyTheUsernameErrorMessage
 * * Enter “tomsmith1” username
 * * Enter “SuperSecretPassword!” password
 * * Click on ‘LOGIN’ button
 * * Verify the error message “Your username is invalid!”
 * 3. verifyThePasswordErrorMessage
 * * Enter “tomsmith” username
 * * Enter “SuperSecretPassword” password
 * * Click on ‘LOGIN’ button
 * * Verify the error message “Your password is invalid!”
 *
 */
import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "http://the-internet.herokuapp.com/login";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //Find the userName field
        WebElement userNameField = driver.findElement(By.id("username"));
        userNameField.sendKeys("tomsmith");

        //Find the password field and type the password to password field
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");

        //Find the login btn element and click
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        String expectedText = "Secure Area";

        //Find the actual text element and get the text from element
        WebElement actualTextElement = driver.findElement(By.xpath("//h2"));
        String actualText = actualTextElement.getText();

        //Verify expected and actual text
        Assert.assertEquals("Secure Area", expectedText, actualText);
    }

    @Test
    public void verifyTheUsernameErrorMessage() {
        //Find the userName field
        WebElement userNameField = driver.findElement(By.id("username"));
        userNameField.sendKeys("tomsmith1");

        //Find the password field and type the password to password field
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");

        //Find the login btn element and click
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        String expectedText = "Your username is invalid!\n×";

        //Find the actual text element and get the text from element
        WebElement actualTextElement = driver.findElement(By.xpath("//div[@class='flash error']"));
        String actualText = actualTextElement.getText();
        //Verify expected and actual text
        Assert.assertEquals("Your username is invalid!\n×", expectedText, actualText);

    }

    @Test
    public void verifyThePasswordErrorMessage() {
        //Find the username field
        WebElement userNameField = driver.findElement(By.id("username"));
        userNameField.sendKeys("tomsmith");

        //Find the password field and type the password to password field
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword");

        //find the login btn element and click
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        String expectedText = "Your password is invalid!\n×";
        //find the actual text element and get the text from element
        WebElement actualTextElement = driver.findElement(By.xpath("//div[@class='flash error']"));
        String actualText = actualTextElement.getText();
        //Verify expected and actual text
        Assert.assertEquals("Your password is invalid!\n×", expectedText, actualText);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
