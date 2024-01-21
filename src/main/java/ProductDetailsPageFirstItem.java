import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductDetailsPageFirstItem {
    WebDriver driver;

    // Locators for elements on the page
    private By addToCartFirstItemBtn = By.xpath("//button[@class='add btn _prim -pea _i -fw']//span[contains(text(),'Add to cart')]");
    private By productAddOneItem = By.xpath("//span[@class='-w-32 -mas -m -fs14 -tac -lh-1']");

    /**
     * Constructs a new ProductDetailsPageFirstItem with the given WebDriver.
     *
     * @param driver The WebDriver for interacting with the web browser
     */
    public ProductDetailsPageFirstItem(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Clicks the "Add to Cart" button for the first item and waits for the product to be added.
     *
     * @throws InterruptedException If the thread is interrupted
     */
    public void clickAddToCartFirstItemBtn() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(addToCartFirstItemBtn).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(productAddOneItem));
    }
}
