import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class genderPage {
    WebDriver driver;

    // Locators for elements on the page
    private By Terms = By.id("acceptTC");
    private By Cont = By.xpath("/html/body/div/div[4]/form/div/div[3]/div/div[3]/div[2]/button/span[3]");
    private By genderField = By.id("gender");
    private By male = By.cssSelector("li[data-value=\"M\"]");
    By inputBirthDate = By.xpath("/html[1]/body[1]/div[1]/div[4]/form[1]/div[1]/div[3]/div[1]/div[2]/label[1]/input[1]");

    /**
     * Constructs a new GenderPage with the given WebDriver.
     *
     * @param driver The WebDriver for interacting with the web browser
     */
    public genderPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Sets the gender and birthdate on the page.
     */
    public void setGenderAndBirth() {
        try {
            // Click the gender field and select male
            driver.findElement(genderField).click();
            driver.findElement(male).click();

            // Click the birthdate input field
            driver.findElement(inputBirthDate).click();

            // Sleep for 5 seconds
            Thread.sleep(5000);

            // Enter the birthdate in the format MMDDYYYY
            driver.findElement(inputBirthDate).sendKeys("02");
            Thread.sleep(2000);
            driver.findElement(inputBirthDate).sendKeys("02");
            Thread.sleep(2000);
            driver.findElement(inputBirthDate).sendKeys("1980");

            // Accept terms and continue
            driver.findElement(Terms).click();
            driver.findElement(Cont).click();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }}