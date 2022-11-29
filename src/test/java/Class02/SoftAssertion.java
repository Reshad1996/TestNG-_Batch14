package Class02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class SoftAssertion {

    WebDriver driver;
    @BeforeMethod(alwaysRun = true)
    public void launchTheWebsite() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test(groups = "Regression")
    public void invalidCredential() {
        WebElement userName = driver.findElement(By.xpath("//input[@name='txtUsername']"));
        userName.sendKeys("admin");
        WebElement password = driver.findElement(By.xpath("//input[@id = 'txtPassword']"));
        password.sendKeys("Hum@nhrm");
        WebElement logIn = driver.findElement(By.xpath("//*[@id='btnLogin']"));
        logIn.click();

        // invalid credential
        WebElement errorMSG = driver.findElement(By.xpath("//span[text()='Invalid credentials']"));
        String ActualErrorMsg = errorMSG.getText();
        String ExpectedErrorMsg = "Invalid credentials";

        // if we want to use soft Assertion we call it from the class SoftAssert by declaring an instance
        SoftAssert soft = new SoftAssert();
        // Assertion
        soft.assertEquals(ActualErrorMsg,ExpectedErrorMsg);
        // check if the webelement error message isDisplayed
        boolean isdisplayed = errorMSG.isDisplayed();
        // Assertion
        soft.assertTrue(isdisplayed);
        // assert all the assertion that have been made
        soft.assertAll();
    }


    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        driver.close();
    }


}
