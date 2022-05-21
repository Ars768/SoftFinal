package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddToFavoritesPage extends BasePage{
    public AddToFavoritesPage(WebDriver driver){
        super(driver);
    }

    public String getProductTitle(By locator){
        return driver.findElement(locator).getText();
    }
}
