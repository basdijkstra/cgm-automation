package selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class RequestLoanTest {

    @Test
    public void requestLoan() throws InterruptedException {

        // Set up Chrome driver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Navigate to application
        driver.get("https://parabank.parasoft.com");

        // Log in
        driver.findElement(By.name("username")).sendKeys("john");
        driver.findElement(By.name("password")).sendKeys("demo");
        driver.findElement(By.xpath("//input[@value='Log In']")).click();

        // Go to Request Loan page
        driver.findElement(By.linkText("Request Loan")).click();

        // Fill in loan application form
        driver.findElement(By.id("amount")).sendKeys("10000");
        driver.findElement(By.id("downPayment")).sendKeys("1000");

        // TODO For some reason we need to wait here...
        Thread.sleep(2000);

        Select dropdownFromAccountId = new Select(driver.findElement(By.id("fromAccountId")));
        dropdownFromAccountId.selectByVisibleText("12345");

        driver.findElement(By.xpath("//input[@value='Apply Now']")).click();

        // Assert on result
        // TODO for some reason we need to wait here, too...

        Thread.sleep(2000);

        String result = driver.findElement(By.id("loanStatus")).getText();

        Assertions.assertEquals("Denied", result);

        driver.quit();
    }
}
