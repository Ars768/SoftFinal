package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultPage extends BasePage{
    public SearchResultPage(WebDriver driver){
//        this.driver = driver;
        super(driver);
        By loc = By.cssSelector("#content > label");
        waitForElementsToAppear(loc);
    }

    public String getSearchTitle(){
        By searchTitle = By.cssSelector("#content > h1");
        String titleText = driver.findElement(searchTitle).getText();
        return titleText;
    }

    public String getProductTitle(By locator){
        String titleText = driver.findElement(locator).getText();
        return titleText;
    }
}
