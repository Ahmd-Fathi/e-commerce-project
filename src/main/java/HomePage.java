import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    WebDriver driver;

    // Locators for elements on the page
    private By WelcomeMsg = By.cssSelector("button[class=\"cls\"] svg[class=\"ic\"]");
    private By AccountLinkTxt = By.cssSelector("label[for=\"dpdw-login\"]");
    private By SuperMarketLinkTxt = By.xpath("/html[1]/body[1]/div[1]/main[1]/div[1]/div[1]/div[1]/div[1]/a[1]/span[1]");
    private By Bakery = By.cssSelector("div[class=\"cat\"] a[href=\"/breads-bakery/\"]");
    private By signInLinkText = By.cssSelector("a[class=\"btn _prim -fw _md\"]");
    private By CartLinkTxt = By.cssSelector(".-df.-i-ctr.-gy9.-hov-or5.-phs.-fs16");

    /**
     * Constructs a new HomePage with the given WebDriver.
     *
     * @param driver The WebDriver for interacting with the web browser
     */
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Clicks on the account link and sign-in link to navigate to the EmailPage.
     *
     * @return An instance of the EmailPage
     */
    public EmailPage clickOnAccountLinkTxtAndSignIn() {
        driver.findElement(WelcomeMsg).click();
        driver.findElement(AccountLinkTxt).click();
        driver.findElement(signInLinkText).click();
        return new EmailPage(driver);
    }

    /**
     * Performs a hover interaction on the Supermarket link and clicks on the Bakery link to navigate to the BakeryPage.
     *
     * @return An instance of the BakeryPage
     * @throws InterruptedException If the thread is interrupted
     */
    public BakeryPage hoverInteraction() throws InterruptedException {
        Actions action = new Actions(driver);
        Thread.sleep(2000);
        // Hover over the Supermarket link
        action.moveToElement(driver.findElement(SuperMarketLinkTxt)).build().perform();

        // Wait for a short duration if needed
        Thread.sleep(2000);

        // Click on the Bakery link
        action.moveToElement(driver.findElement(Bakery)).click().build().perform();

        // Optionally, wait for a short duration after the click
        Thread.sleep(2000);
        return new BakeryPage(driver);
    }

    /**
     * Clicks on the Cart link to navigate to the CartPage.
     *
     * @return An instance of the CartPage
     */
    public CartPage clickCartLinkTxt() {
        driver.findElement(CartLinkTxt).click();
        return new CartPage(driver);
    }


}














