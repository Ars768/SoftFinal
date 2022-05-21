import AssertionMessages.AssertionMessages;
import Constants.Constants;
import Page.BasePage;
import Page.SearchResultPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import Constants.Constants.*;

import static Constants.Constants.*;

public class Test_Search extends BaseTest{

    @Test
    public void search(){
        //this part needed to be in searchProduct method of mainPage class, but when I run it in that way I get and error saying this.driver is null
        //I think it is a Java specific problem, I didn't manage to find a solution for it
        driver.findElement(By.className(searchButtonLoc)).click();
        driver.findElement(By.cssSelector(searchBoxLoc)).sendKeys("սայլակ");
        driver.findElement(By.cssSelector(performSearchButtonLoc)).click();
//        mainPage.searchProduct("սայլակ");

        SearchResultPage searchPage = new SearchResultPage(getDriver());
        String searchTitle = searchPage.getSearchTitle();
        Assert.assertEquals(searchTitle, AssertionMessages.expected_search);
        System.out.println(AssertionMessages.correctSearchRes);
    }
}
