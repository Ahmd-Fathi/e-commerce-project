import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductDetailsPageSecondItem {
    WebDriver driver;

    // Locators for elements on the page
    private By addToCartBtn = By.cssSelector("button[class='add btn _prim -pea _i -fw'] span");
    private By secondProductAdded = By.xpath("//span[@class='-w-32 -mas -m -fs14 -tac -lh-1']");

    /**
     * Constructs a new ProductDetailsPageSecondItem with the given WebDriver.
     *
     * @param driver The WebDriver for interacting with the web browser
     */
    public ProductDetailsPageSecondItem(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Clicks the "Add to Cart" button and waits for the product to be added.
     *
     * @throws InterruptedException If the thread is interrupted
     */
    public void clickAddToCartBtn() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(addToCartBtn).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(secondProductAdded));
    }}