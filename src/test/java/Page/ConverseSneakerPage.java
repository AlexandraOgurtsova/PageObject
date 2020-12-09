package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ConverseSneakerPage extends AbstractPage {

    private final String SNEAKERS_URL = "https://www.converse.com/shop/p/chuck-taylor-all-star-unisex-high-top-shoe/M9622_040.html?pid=M9006MP&dwvar_M9006MP_color=navy&dwvar_M9006MP_size=040&dwvar_M9006MP_width=standard&styleNo=M9622&pdp=true";

    @FindBy(xpath="//button[@class='window-modal__close']")
    private WebElement closeBlockButtonLocator;
    @FindBy(xpath="//div[@class='header-utility__item header-utility__item--icon header-user flex display--small-up']")
    private WebElement signInLocator;
    @FindBy(xpath="//input[@class='input-text validate-strict-email tab-hidden  required']")
    private WebElement inputLoginLocator;
    @FindBy(xpath="//input[@class='input-text tab-hidden  required']")
    private WebElement inputPasswordLocator;
    @FindBy(xpath="//button[@class='button button--primary set--full']")
    private WebElement signInButtonLocator;
    @FindBy(xpath="//div[@class='primary-information__favorite invert-theme']")
    private WebElement addToFavoriteButtonLocator;
    @FindBy(xpath="//a[@class='header-favorites__link flex']")
    private WebElement goToFavoriteButtonLocator;
    @FindBy(xpath="//button[@class='minicart__header-action minicart__header-action-close']")
    private WebElement closeItemsInCartButtonLocator;
    @FindBy(xpath="//a[@class='header-utility__item--icon minicart__link flex']")
    private WebElement goToCartButtonLocator;

    public ConverseSneakerPage(WebDriver driver){
        super(driver);
    }

    public ConverseSneakerPage openPage(){
        driver.get(SNEAKERS_URL);
        return this;
    }

    public ConverseSneakerPage closeThePopUpWindow(){
        WebElement closeBlockButton = (new WebDriverWait(driver, 100))
                .until(ExpectedConditions.elementToBeClickable(closeBlockButtonLocator));
        closeBlockButton.click();
        return this;
    }

    public ConverseSneakerPage LogIntoAccount(){
        WebElement signIn = (new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.visibilityOf(signInLocator));
        signIn.click();
        WebElement inputLogin = (new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.visibilityOf(inputLoginLocator));
        inputLogin.sendKeys("ogurtsova-01@mail.ru");
        WebElement inputPassword = (new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.visibilityOf(inputPasswordLocator));
        inputPassword.sendKeys("20022001_Alog");
        WebElement signInButton = (new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(signInButtonLocator));
        signInButton.click();

        new WebDriverWait(driver,20).until(ExpectedConditions.presenceOfElementLocated(By
                .xpath("//span[text()='Hey, Alexandra']")));
        return this;
    }

    public ConverseSneakerPage addProductToFavorites(){
        WebElement addToFavoriteButton = (new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.visibilityOf(addToFavoriteButtonLocator));
        Actions actions = new Actions(driver);
        actions.moveToElement(addToFavoriteButton).click().build().perform();
        addToFavoriteButton.click();

        new WebDriverWait(driver,20).until(ExpectedConditions.presenceOfElementLocated(By
                .cssSelector(".favorite-action__add")));
        return this;
    }

    public ConverseFavoritesPage openFavoritePage(){
        WebElement goToFavoritesButton = (new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(goToFavoriteButtonLocator));
        goToFavoritesButton.click();
        return new ConverseFavoritesPage(driver);
    }

    public ConverseSneakerPage addProductToCart(){
        WebElement addToCartButton = (new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//button[@class='button button--primary button--add-to-cart-pdp set--full set--themeable']")));
        addToCartButton.click();
        return this;
    }

    public  ConverseSneakerPage closeItemsInCart(){
        WebElement closeItemsInCartButton = (new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(closeItemsInCartButtonLocator));
        closeItemsInCartButton.click();
        return this;
    }

    public ConverseCartPage openCartPage(){
        WebElement goToCartButton = (new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(goToCartButtonLocator));
        goToCartButton.click();
        return new ConverseCartPage(driver);
    }
}
