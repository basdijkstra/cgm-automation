package selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountsOverviewPage extends BasePage {

    public AccountsOverviewPage(WebDriver driver) {
        super(driver);
    }

    public void selectMenuItem(String item) {
        click(By.linkText(item));
    }
}
