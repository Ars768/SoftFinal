package Page;

import Constants.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomeMedEquipmentPage extends BasePage{
    protected WebDriver driver;
    static String header;
    private String productCode;

    private By headerField = By.cssSelector(Constants.headerLoc);
    private By productCodeField = By.cssSelector(Constants.productCodeLoc);
    private By clickableImageField = By.cssSelector(Constants.clickableImageLoc);

    public HomeMedEquipmentPage(WebDriver driver){
//        this.driver = driver;
        super(driver);
    }

    public String getHeader(){
        header = driver.findElement(headerField).getText();
        return header;
    }

    public String getProductCode(){
        productCode = driver.findElement(productCodeField).getText();
        return productCode;
    }

    public ProductPage goToProductPage(){
        WebElement productCodeElement = driver.findElement(productCodeField);
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(productCodeElement));

        driver.findElement(clickableImageField).click();
        ProductPage productPage = new ProductPage(driver);
        return productPage;
    }

    public void addToPurchaseFirstItem(){
        By itemloc = By.cssSelector("#products-layout > div > div > div:nth-child(1) > div > div > div.product-actions > div > button.addtocart.btn.btn-primary");
        driver.findElement(itemloc).click();
    }
}
