package selenium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import selenium.models.User;
import selenium.pages.*;

public class RequestLoanTest extends TestBase {

    @Test
    public void requestLoan() {

        User user = new User("john", "demo");

        new LoginPage(driver)
                .loginAs(user);

        // Go to Request Loan page
        new AccountsOverviewPage(driver)
                .selectMenuItem("Request Loan");

        // Fill in loan application form
        new RequestLoanPage(driver)
                .applyForLoan("10000", "1000", "12345");

        String result = new RequestLoanResultPage(driver)
                .getLoanApplicationResult();

        Assertions.assertEquals("Denied", result);
    }
}
