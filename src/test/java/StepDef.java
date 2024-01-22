import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class StepDef extends TestBase{
    EmailPage EmailObject;
    ProductDetailsPageFirstItem ProductDetailsPageFirstItemObject;
    ProductDetailsPageSecondItem ProductDetailsPageSecondItemObject;
    genderPage genderObject;
    String FirstName = "mohamed";
    BakeryPage BakeryObject;
    String lastName = "youssef";
    String phoneNum = "1006033689";
    String password = "Tedata12312";

    PersonalDetailsPage PersonalDetailsObject;
    CartPage CartPageObject;
    passwordPage passwordObject;
    String EmailNameForSecondTask = "hhwasselselwae+1@gmail.com";
    String EmailNameFirstTask = "ajdhsakfdpes@gmail.com";
    HomePage HomeObject;
    @Given("the user is on the home page")
    public void the_user_is_on_the_home_page() {
        HomeObject = new HomePage(driver);
    }
    @When("the user clicks on the account link text and signs in")
    public void the_user_clicks_on_the_account_link_text_and_signs_in() {
        HomeObject.clickOnAccountLinkTxtAndSignIn();
    }
    @When("enters the email and continues for registration")
    public void enters_the_email_and_continues_for_registration() throws InterruptedException {
        EmailObject = new EmailPage(driver);
        EmailObject.setEmailFieldAndPressContinueForRegister(EmailNameFirstTask);
    }
    @When("sets the password and logs in for registration")
    public void sets_the_password_and_logs_in_for_registration() throws InterruptedException {
        passwordObject = new passwordPage(driver);
        passwordObject.setPasswordFieldAndPressLoginForRegister(password);
    }
    @When("provides personal details including First Name, Last Name, and Phone Number")
    public void provides_personal_details_including_first_name_last_name_and_phone_number() throws InterruptedException {
        PersonalDetailsObject = new PersonalDetailsPage(driver);
        PersonalDetailsObject.setPersonalData(FirstName, lastName, phoneNum);
    }
    @When("sets_gender_and_birth_information")
    public void sets_gender_and_birth_information() {
        genderObject = new genderPage(driver);

    }
    @Then("the_user_should_b_successfully_registered")
    public void the_user_should_be_successfully_registered() {
        genderObject.setGenderAndBirth();
    }

////////////////////////////////////////Second Task///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Given("the_user_is_on_the_home_page_without_being_signed_in")
    public void userIsOnHomePageNotSignedIn() {
        HomeObject = new HomePage(driver);

    }

    @When("the_user_selects_the_account_link_text_and_signs_in")
    public void userSelectsAccountLinkAndSignsIn() {
        HomeObject.clickOnAccountLinkTxtAndSignIn();
    }

    @When("enters_the_email_and_continues_for_login")
    public void entersEmailToContinueLogin() throws InterruptedException {
        EmailObject = new EmailPage(driver);
        EmailObject.setEmailFieldAndPressContinueForLogin(EmailNameForSecondTask);
    }

    @When("sets_the_password_and_logs_in")
    public void setsPasswordAndLogsIn() throws InterruptedException {
        passwordObject = new passwordPage(driver);
        passwordObject.setPasswordFieldAndPressLogin(password);
    }

    @When("hovers_over_the_Bakery_section")
    public void hoversOverBakerySection() throws InterruptedException {
        HomeObject.hoverInteraction();
        BakeryObject = new BakeryPage(driver);
        BakeryObject.ChooseFirstItem();
    }

    @When("chooses_and_adds_the_first_item_to_the_cart")
    public void addsFirstItemToCart() throws InterruptedException {
        ProductDetailsPageFirstItemObject = new ProductDetailsPageFirstItem(driver);
        ProductDetailsPageFirstItemObject.clickAddToCartFirstItemBtn();
        driver.navigate().back();
    }

    @When("chooses_and_adds_the_second_item_to_the_cart")
    public void addsSecondItemToCart() throws InterruptedException {
        BakeryObject.ClickOnSecondItem();
        ProductDetailsPageSecondItemObject = new ProductDetailsPageSecondItem(driver);
        ProductDetailsPageSecondItemObject.clickAddToCartBtn();
        driver.navigate().back();
    }

    @When("goes_to_the_cart")
    public void goesToCart() {
        HomeObject.clickCartLinkTxt();
        CartPageObject = new CartPage(driver);
    }

    @Then("the_cart_should_contain_the_following_items_and_subtotal")
    public void cartShouldContainItemsAndSubtotal() {
        Assert.assertTrue(CartPageObject.getTxtFirstItem().contains("Wooden Tool For Pressing Dough"));
        Assert.assertTrue(CartPageObject.getTxtSecondItem().contains("915 Generation Copper Sheet Roll, Metal Foil Plate 1000mm x 100mm x"));
        Assert.assertTrue(CartPageObject.getSubTotal().contains("267.89"));
    }






























}
