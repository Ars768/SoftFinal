import AssertionMessages.AssertionMessages;
import Constants.Constants;
import Page.AddToFavoritesPage;
import Page.BasePage;
import Page.SearchResultPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import static Constants.Constants.*;

public class Test_AddToFavorites extends BaseTest{
    @Test
    public void search_and_addToFavorites(){
        driver.findElement(By.className(searchButtonLoc)).click();
        driver.findElement(By.cssSelector(searchBoxLoc)).sendKeys("սայլակ");
        driver.findElement(By.cssSelector(performSearchButtonLoc)).click();

        SearchResultPage searchPage = new SearchResultPage(getDriver());
        By prodtitleloc = By.cssSelector(productLoc);
        String productTitle = searchPage.getProductTitle(prodtitleloc);
        By addToFavoritesButtonField = By.cssSelector(addtofavLoc);
        driver.findElement(addToFavoritesButtonField).click();

        By myMenu = By.cssSelector(myMenuLoc);
        driver.findElement(myMenu).click();

        By favorites = By.cssSelector(favoritesListLoc);
        driver.findElement(favorites).click();

        AddToFavoritesPage favoritesPage = new AddToFavoritesPage(getDriver());
        By favoriteloc = By.cssSelector(OneFavLoc);
        String favoriteName = favoritesPage.getProductTitle(favoriteloc);

        Assert.assertEquals(favoriteName, productTitle);
        System.out.println(AssertionMessages.correctAddFav);
    }
}
