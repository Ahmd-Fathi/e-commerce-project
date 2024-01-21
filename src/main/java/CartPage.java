import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    WebDriver driver;

    /**
     * Constructor to initialize the WebDriver.
     *
     * @param driver The WebDriver instance
     */
    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators for the first item, second item, and subtotal
    private By NameOfFirstItem = By.xpath("(//a[@class=\"core\"]//div[@class=\"main\"]//h3)[1]"); // Wooden Tool For Pressing Dough
    private By NameOfSecondItem = By.xpath("(//a[@class=\"core\"]//div[@class=\"main\"]//h3)[2]"); // 915 Generation Copper Sheet Roll, Metal Foil Plate 1000mm x 100mm x
    private By SubTotal = By.cssSelector("div[class=\"-df -i-ctr -j-bet -m -fs14 -pas\"] p[class=\"-fs20 -plm -tar\"]");


    /**
     * Gets the text of the first item.
     *
     * @return The text of the first item
     */
    public String getTxtFirstItem() {
        return driver.findElement(NameOfFirstItem).getText();
    }

    /**
     * Gets the text of the second item.
     *
     * @return The text of the second item
     */
    public String getTxtSecondItem() {
        return driver.findElement(NameOfSecondItem).getText();
    }

    /**
     * Gets the subtotal text.
     *
     * @return The subtotal text
     */
    public String getSubTotal() {
        return driver.findElement(SubTotal).getText();
    }
}
