import AssertionMessages.AssertionMessages;
import Constants.Constants;
import Page.HomeMedEquipmentPage;
import Page.SearchResultPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import static Constants.Constants.*;

public class Test_ToolTipText extends BaseTest {
    @Test
    public void test_tooltip() {
        driver.get("https://barry.am/ru/"); //text of tooltip is in Russian, regardless of the language of webpage
        driver.findElement(By.cssSelector(Constants.menuItemLoc)).click();
        HomeMedEquipmentPage homeMedEquipmentPage = new HomeMedEquipmentPage(getDriver());

        WebElement element = driver.findElement(By.cssSelector(ItemImageLoc));
        //Get title attribute value
        String tooltipText = element.getAttribute("title");
        tooltipText = tooltipText.substring(0,tooltipText.indexOf("(")-1);

        String ItemTitle = driver.findElement(By.cssSelector(ItemTitleLoc)).getText();
        Assert.assertEquals(tooltipText, ItemTitle);
        System.out.println(AssertionMessages.correctToolTip);


    }
}