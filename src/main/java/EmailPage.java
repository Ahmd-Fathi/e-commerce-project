import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EmailPage {
    WebDriver driver;


    /**
     * Constructor to initialize the WebDriver.
     *
     * @param driver The WebDriver instance
     */
    public EmailPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators for EmailPage
    private By EmailField = By.id("input_identifierValue");
    private By skipForNowLinkTxt = By.id("btn-skip-passkeys-enrollment");

    private By continueBtn = By.cssSelector("button[type=\"submit\"] span[class=\"mdc-button__touch\"]");


    /**
     * Sets the email field with the provided email and continues with the registration process.
     *
     * @param Email The email to be entered
     * @throws InterruptedException If the thread is interrupted
     */
    public void setEmailFieldAndPressContinueForRegister(String Email) throws InterruptedException {
// Wait for the email field to be clickable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(EmailField));
        Thread.sleep(2000);
        // Enter the email
        driver.findElement(EmailField).sendKeys(Email);
        Thread.sleep(2000);
        // Click the continue button
        driver.findElement(continueBtn).click();
        // Click the skip for now link
        driver.findElement(skipForNowLinkTxt).click();


    }


    public void setEmailFieldAndPressContinueForLogin(String Email) throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(EmailField));
        Thread.sleep(2000);
        driver.findElement(EmailField).sendKeys(Email);
        Thread.sleep(2000);
        driver.findElement(continueBtn).click();
//    driver.findElement(skipForNowLinkTxt).click();


    }


}
