import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

@Feature("Registration and Shopping Cart Features")
public class RegisterTest extends TestBase {
    EmailPage EmailObject;
    ProductDetailsPageFirstItem ProductDetailsPageFirstItemObject;
    ProductDetailsPageSecondItem ProductDetailsPageSecondItemObject;
    genderPage genderObject;
    String FirstName = "mohamed";
    BakeryPage BakeryObject;
    String lastName = "youssef";
    String phoneNum = "1006033689";
    String password = "Tedata12312";
//    String dayBirth="11";
//    String monthBirth="05";
//    String yearBirth="1980";

    PersonalDetailsPage PersonalDetailsObject;
    CartPage CartPageObject;
    passwordPage passwordObject;
    String EmailNameForSecondTask = "hhwasselselwae+1@gmail.com";
    String EmailNameFirstTask = "ajdhsakfdpes@gmail.com";
    HomePage HomeObject;

    @Test(priority = 1)
    @Description("Register new user with valid data TASK 1")
    public void TC_RegisterNewUserWithValidData() throws InterruptedException {
        HomeObject = new HomePage(driver);
        HomeObject.clickOnAccountLinkTxtAndSignIn();
        EmailObject = new EmailPage(driver);
        EmailObject.setEmailFieldAndPressContinueForRegister(EmailNameFirstTask);
        passwordObject = new passwordPage(driver);
        passwordObject.setPasswordFieldAndPressLoginForRegister(password);
        PersonalDetailsObject = new PersonalDetailsPage(driver);
        PersonalDetailsObject.setPersonalData(FirstName, lastName, phoneNum);
        genderObject = new genderPage(driver);
        genderObject.setGenderAndBirth();
    }

    @Test(priority = 2)
    @Description("Login and choose item from Bakery TASK 2")
    public void loginAndChooseItemFromBakery() throws InterruptedException, IOException {
        HomeObject = new HomePage(driver);
        HomeObject.clickOnAccountLinkTxtAndSignIn();
        EmailObject = new EmailPage(driver);
        EmailObject.setEmailFieldAndPressContinueForLogin(EmailNameForSecondTask);
        passwordObject = new passwordPage(driver);
        passwordObject.setPasswordFieldAndPressLogin(password);
        HomeObject.hoverInteraction();
        BakeryObject = new BakeryPage(driver);
        BakeryObject.ChooseFirstItem();
        ProductDetailsPageFirstItemObject = new ProductDetailsPageFirstItem(driver);
        ProductDetailsPageFirstItemObject.clickAddToCartFirstItemBtn();
        driver.navigate().back();
        BakeryObject.ClickOnSecondItem();
        ProductDetailsPageSecondItemObject = new ProductDetailsPageSecondItem(driver);
        ProductDetailsPageSecondItemObject.clickAddToCartBtn();
        driver.navigate().back();
        HomeObject.clickCartLinkTxt();
        CartPageObject = new CartPage(driver);
        System.out.println("First Item Text: " + CartPageObject.getTxtFirstItem());
        System.out.println("Second Item Text: " + CartPageObject.getTxtSecondItem());
        System.out.println("SubTotal Text: " + CartPageObject.getSubTotal());

        Assert.assertTrue(CartPageObject.getTxtFirstItem().contains("Wooden Tool For Pressing Dough"));
        Assert.assertTrue(CartPageObject.getTxtSecondItem().contains("915 Generation Copper Sheet Roll, Metal Foil Plate 1000mm x 100mm x"));
        Assert.assertTrue(CartPageObject.getSubTotal().contains("267.89"));
        Util.screenshotAfterTest_Pass(driver, "two product added successfully");

    }


}
