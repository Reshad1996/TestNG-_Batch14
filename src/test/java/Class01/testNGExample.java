package Class01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class testNGExample {

    public static WebDriver driver;

    // Writing down all the pre-conditions for a test case
    @BeforeMethod(alwaysRun = true)
    public  void SetupBrowser() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }


    // Writing down all the post conditions for a test case
    @AfterMethod(alwaysRun = true)
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }

    //  ------  Test 1 ----------
    // goto syntax HRMS
    // create the username and password , verify that you logged in
    // close the browser

    @Test(groups = "Smoke")
    public void LoginFunctionality(){
        WebElement userName = driver.findElement(By.xpath("//input[@name='txtUsername']"));
        userName.sendKeys("admin");
        WebElement password = driver.findElement(By.xpath("//input[@id = 'txtPassword']"));
        password.sendKeys("Hum@nhrm123");
        WebElement logIn = driver.findElement(By.xpath("//*[@id='btnLogin']"));
        logIn.click();
    }
    //  ------  Test 1 ----------
    // goto syntax Hrms
    // verify the  password is there
    // close the browser
    @Test
    public void PsswordBoxVerification(){

        WebElement password = driver.findElement(By.xpath("//input[@id = 'txtPassword']"));
        System.out.println( password.isDisplayed());

    }

}