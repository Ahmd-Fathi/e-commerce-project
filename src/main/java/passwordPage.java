import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class passwordPage {
    WebDriver driver;

    // Locators for elements on the page
    private By passwordField = By.cssSelector("input[type='password']");
    private By confirmPassword = By.cssSelector("input[aria-labelledby=\"confirm-password\"]");
    private By skipForNowLinkTxt = By.id("btn-skip-passkeys-enrollment");
    private By continueBtn = By.xpath("/html/body/div/div[4]/form/div/div[1]/div[5]/div/button/span[3]");
    private By loginBtn = By.className("mdc-button__touch");

    /**
     * Constructs a new PasswordPage with the given WebDriver.
     *
     * @param driver The WebDriver for interacting with the web browser
     */
    public passwordPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Sets the password field, confirms the password, and presses continue for registration.
     *
     * @param password The password to set
     * @throws InterruptedException If the thread is interrupted
     */
    public void setPasswordFieldAndPressLoginForRegister(String password) throws InterruptedException {
        driver.findElement(passwordField).sendKeys(password);
        Thread.sleep(2000);
        driver.findElement(confirmPassword).sendKeys(password);
        Thread.sleep(2000);
        driver.findElement(continueBtn).click();
    }

    /**
     * Sets the password field and presses login, then skips for now during registration.
     *
     * @param password The password to set
     */
    public void setPasswordFieldAndPressLogin(String password) {
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginBtn).click();
        driver.findElement(skipForNowLinkTxt).click();
    }



}



