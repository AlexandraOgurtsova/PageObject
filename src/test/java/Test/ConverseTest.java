package Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import Page.ConverseSneakerPage;

public class ConverseTest {
    private WebDriver driver;
    private final String expectedResult =  "Chuck Taylor All Star";

    @BeforeTest
    public void init(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void filesCookingTest(){
        String cartResult = new ConverseSneakerPage(driver)
                .openPage()
                .closeThePopUpWindow()
                .addProductToCart()
                .closeItemsInCart()
                .LogIntoAccount()
                .openCartPage()
                .getCartResult();
        Assert.assertEquals(cartResult, expectedResult);
    }

    @Test
    public void addToFavoritesTest(){
        String favoriteResult = new ConverseSneakerPage(driver)
                .openPage()
                .closeThePopUpWindow()
                .LogIntoAccount()
                .addProductToFavorites()
                .openFavoritePage()
                .getFavoriteResult();
        Assert.assertEquals(favoriteResult, expectedResult);
    }

    @AfterMethod
    public void driverShutDown(){
        driver.quit();
        driver=null;
    }

}
