import AssertionMessages.AssertionMessages;
import Constants.Constants;
import Page.HomeMedEquipmentPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import Constants.Constants.*;
import java.util.concurrent.TimeUnit;

public class Test_Card extends BaseTest{
    @Test
    public void testCard(){
        //I have implemented to test both adding and removing, but the dropdown menu didn't appear after clicking on "bag" icon
        //I know that many parts needed to be in POM classes as methods and get called here, but I got an error saying
        //this.driver is null

        //Also could not get the Web Element of green box when new item is added to cart
        //Otherwise I have planned to implement wait strategy connected with the green box
        By counterloc = By.cssSelector(Constants.itemCounterLoc);
        String counter = driver.findElement(counterloc).getText();
        Assert.assertEquals(counter, AssertionMessages.expected_ItemCountZero);

        driver.findElement(By.cssSelector(Constants.menuItemLoc)).click();
        HomeMedEquipmentPage homeMedEquipmentPage = new HomeMedEquipmentPage(getDriver());
//        homeMedEquipmentPage.addToPurchaseFirstItem();
        By itemloc = By.cssSelector(Constants.itemLoc);
        driver.findElement(itemloc).click();
        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.presenceOfElementLocated((By.cssSelector(Constants.greenBoxLoc))));

        counter = driver.findElement(counterloc).getText();
        Assert.assertEquals(counter, AssertionMessages.expected_cartcount);
        System.out.println(AssertionMessages.correctAddFunc);


//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.findElement(By.cssSelector("#products-layout > div > div > div:nth-child(1) > div > div > div.image-content > div > a > img")).click();
//        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.className("toast-title"))));
//        By dropdownloc = By.cssSelector("#cart > span");
////        driver.findElement(dropdownloc).click();
//        Actions actions = new Actions(driver);
//
//        actions.moveToElement(driver.findElement(dropdownloc)).click().perform();
//
//        By removeloc = By.cssSelector("#cart > ul > li:nth-child(1) > table > tbody > tr > td:nth-child(5) > button");
////        driver.findElement(removeloc).click();
//        WebElement removeButton = driver.findElement(removeloc);
//        JavascriptExecutor executor = (JavascriptExecutor) driver;
//        executor.executeScript("arguments[0].scrollIntoView(true);", removeButton);
//        removeButton.click();
////        Actions actions1 = new Actions(driver);
////        actions1.moveToElement(driver.findElement(removeloc)).click().perform();
//
//        counter = driver.findElement(counterloc).getText();
//        Assert.assertEquals(counter, "0");

    }
}
