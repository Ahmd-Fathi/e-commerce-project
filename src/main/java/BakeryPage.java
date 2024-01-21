import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BakeryPage {
    WebDriver driver;

    public BakeryPage(WebDriver driver) {
        // Constructor to initialize the WebDriver
        this.driver = driver;
    }

    // Locators for the first and second items
    private By FirstItem = By.xpath("//article[2]//a[1]//div[1]//img[1]");
    private By SecondItem = By.xpath("//article[3]//a[1]//div[1]//img[1]");


    /**
     * Clicks on the first item and returns the ProductDetailsPageFirstItem.
     *
     * @return ProductDetailsPageFirstItem
     * @throws InterruptedException If the thread is interrupted while sleeping
     */
    public ProductDetailsPageFirstItem ChooseFirstItem() throws InterruptedException {
        // Click on the first item
        driver.findElement(FirstItem).click();

        // Wait for 2 seconds (adjust if needed)
        Thread.sleep(2000);

        // Return the ProductDetailsPageFirstItem
        return new ProductDetailsPageFirstItem(driver);
    }

    /**
     * Clicks on the second item and returns the ProductDetailsPageSecondItem.
     *
     * @return ProductDetailsPageSecondItem
     * @throws InterruptedException If the thread is interrupted while sleeping
     */
    public ProductDetailsPageSecondItem ClickOnSecondItem() throws InterruptedException {
        // Wait for 2 seconds (adjust if needed)
        Thread.sleep(2000);

        // Click on the second item
        driver.findElement(SecondItem).click();

        // Return the ProductDetailsPageSecondItem
        return new ProductDetailsPageSecondItem(driver);
    }


}