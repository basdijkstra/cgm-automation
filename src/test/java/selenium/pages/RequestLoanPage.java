package selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RequestLoanPage extends BasePage {

    private final By textfieldLoanAmount = By.id("amount");
    private final By textfieldDownPayment = By.id("downPayment");
    private final By dropdownFromAccount = By.id("fromAccountId");
    private final By buttonApplyForLoan = By.xpath("//input[@value='Apply Now']");

    public RequestLoanPage(WebDriver driver) {
        super(driver);
    }

    public void applyForLoan(String loanAmount, String downPayment, String fromAccountId) {
        sendKeys(textfieldLoanAmount, loanAmount);
        sendKeys(textfieldDownPayment, downPayment);
        select(dropdownFromAccount, fromAccountId);
        click(buttonApplyForLoan);
    }
}
