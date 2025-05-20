package ui.pages;

import org.openqa.selenium.support.ui.Select;
import ui.pages.utils.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class UserManagementPage {
    private final WebDriver driver;
    private final WaitHelper wait;

    private final String baseUri = "https://test-api-ui-teal.vercel.app/";
//    private final String baseUri = "http://localhost:5173";

    private final By nameInput = By.cssSelector("[data-testid='name-input']");
    private final By emailInput = By.cssSelector("[data-testid='email-input']");
    private final By ageInput = By.cssSelector("[data-testid='age-input']");
    private final By roleSelect = By.cssSelector("[data-testid='role-select']");
    private final By addUserButton = By.cssSelector("[data-testid='add-button']");
    private final By userItems = By.cssSelector("[data-testid='user-item']");

    // TODO: jak resit dynamicky lokator?
    private final String userItemNameXpath = "//span[@data-testid='name-item']";

    public UserManagementPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitHelper(driver, Duration.ofSeconds(5));
    }

    public UserManagementPage goToUserManagementPage() {
//        driver.get(baseUri);
        driver.get(baseUri);
        return this;
    }

    public UserManagementPage enterName(String name) {
        driver.findElement(nameInput).sendKeys(name);
        return this;
    }

    public UserManagementPage enterEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
        return this;
    }

    public UserManagementPage enterAge(String age) {
        driver.findElement(ageInput).sendKeys(age);
        return this;
    }

    public UserManagementPage enterRole(String role) {
        Select selectRole = new Select(driver.findElement(roleSelect));
        selectRole.selectByValue(role);
        return this;
    }

    public UserManagementPage clickAdd() {
        driver.findElement(addUserButton).click();
        return this;
    }

    public String getNameAdded(String name){
        By userName = By.xpath(userItemNameXpath +"[contains(text(), '"+name+"')]");

        wait.waitForElementVisible(userName);
        return driver.findElement(userName).getText();
    }

    public boolean isAddingSuccessful() {
        return driver.findElements(userItems).size() > 0;
    }

    public int getNumberOfUsers(){
        return driver.findElements(userItems).size();
    }
}
