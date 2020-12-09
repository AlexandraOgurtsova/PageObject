package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ConverseFavoritesPage extends AbstractPage {

    public ConverseFavoritesPage(WebDriver driver){
        super(driver);
    }

    public String getFavoriteResult(){
        new WebDriverWait(driver,20).until(ExpectedConditions.presenceOfElementLocated(By
                .xpath("//div[@class='account-head__title flex flex-align-center']")));

        WebElement favoriteResult = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//a[@class='product-tile__url link--underline']")));
        return favoriteResult.getText();
    }
}
