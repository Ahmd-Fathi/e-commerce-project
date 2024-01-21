import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PersonalDetailsPage {
    WebDriver driver;

    // Locators for elements on the page
    private By firstNameField = By.id("input_first_name");
    private By lastNameField = By.id("input_last_name");
    private By phoneNumber = By.cssSelector("input[type=\"tel\"]");
    private By continueBtn = By.xpath("/html/body/div/div[4]/form/div/div[2]/div[5]/div/button/span[3]");

    /**
     * Constructs a new PersonalDetailsPage with the given WebDriver.
     *
     * @param driver The WebDriver for interacting with the web browser
     */
    public PersonalDetailsPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Sets the personal data fields and continues to the next page.
     *
     * @param firstName The first name to set
     * @param lastName  The last name to set
     * @param phoneNum  The phone number to set
     * @return The gender page after setting personal data
     * @throws InterruptedException If the thread is interrupted
     */
    public genderPage setPersonalData(String firstName, String lastName, String phoneNum) throws InterruptedException {
        driver.findElement(firstNameField).sendKeys(firstName);
        Thread.sleep(2000);
        driver.findElement(lastNameField).sendKeys(lastName);
        Thread.sleep(2000);
        driver.findElement(phoneNumber).sendKeys(phoneNum);
        Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(continueBtn));
        driver.findElement(continueBtn).click();
        return new genderPage(driver);
    }





}
