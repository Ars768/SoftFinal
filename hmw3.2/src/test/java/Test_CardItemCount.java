import AssertionMessages.AssertionMessages;
import Constants.Constants;
import Page.HomeMedEquipmentPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test_CardItemCount extends BaseTest{
    @Test
    public void test_itemCount(){
        By counterloc = By.cssSelector(Constants.itemCounterLoc);
        String counter = driver.findElement(counterloc).getText();
        Assert.assertEquals(counter, "0");

        driver.findElement(By.cssSelector(Constants.menuItemLoc)).click();
        HomeMedEquipmentPage homeMedEquipmentPage = new HomeMedEquipmentPage(getDriver());
        By itemloc = By.cssSelector(Constants.itemLoc);
        driver.findElement(itemloc).click();
        WebDriverWait wait = new WebDriverWait(driver, 2);
//        wait.until(ExpectedConditions.presenceOfElementLocated((By.className("toast-title"))));
        wait.until(ExpectedConditions.presenceOfElementLocated((By.cssSelector(Constants.greenBoxLoc))));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(Constants.cartLoc))); //Overlaying with green box
//        wait.until(ExpectedConditions.invisibilityOf((driver.findElement(By.cssSelector("#toast-container")))));

        //Second Item
        By item1loc = By.cssSelector(Constants.item1Loc);
        driver.findElement(item1loc).click();
        wait.until(ExpectedConditions.presenceOfElementLocated((By.cssSelector(Constants.greenBoxLoc))));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(Constants.cartLoc)));

        //Third item
        By item2loc = By.cssSelector(Constants.item2Loc);
        driver.findElement(item2loc).click();
        wait.until(ExpectedConditions.presenceOfElementLocated((By.cssSelector(Constants.greenBoxLoc))));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(Constants.cartLoc)));

        String newcounter = driver.findElement(counterloc).getText();
        Assert.assertEquals(newcounter, AssertionMessages.expected_ItemCount);
        System.out.println(AssertionMessages.correctItemCount);//For some reason it gets value 1, but in page it is written 3
                                                            //the locator is correct
    }
}
