package Page;

import Constants.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class MainPage extends BasePage{
    protected WebDriver driver;
    private WebElement news_image;
    private By newsImageField = By.cssSelector(Constants.newsImageLoc);
    private By menuItemField = By.cssSelector(Constants.menuItemLoc);

    private static final int TIMEOUT = 5;
    private static final int POLLING = 100;
    private WebDriverWait wait;

    public MainPage(WebDriver driver){
        super(driver);
        wait = new WebDriverWait(driver, TIMEOUT, POLLING);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, TIMEOUT), this);
//        super(driver);
    }

    public void goToHomeMedEquipmentPage(){
        driver.findElement(menuItemField).click();
//        HomeMedEquipmentPage newPage = new HomeMedEquipmentPage(driver);
//        return newPage;
    }

    public WebElement news_photos(){
        news_image = driver.findElement(newsImageField);
        return news_image;
    }

    public void searchProduct(String keyword){
        driver.findElement(By.className("search_button")).click();
        driver.findElement(By.className("form-control input-lg")).sendKeys(keyword);
        driver.findElement(By.className("btn btn-default btn-lg")).click();
    }
}
