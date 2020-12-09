package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ConverseCartPage extends AbstractPage {

    public ConverseCartPage(WebDriver driver){
        super(driver);
    }

    public String getCartResult(){
        WebElement cartResult = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//a[@class='text--underline set--quickview-ready']")));
        return cartResult.getText();
    }
}
