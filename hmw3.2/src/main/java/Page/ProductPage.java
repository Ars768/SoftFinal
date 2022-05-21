package Page;

import Constants.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {
    private WebDriver driver;
    private String productTitle;
    private String productAvailability;

    private By titleField = By.cssSelector(Constants.titleLoc);
    private By availabilityField = By.cssSelector(Constants.availabilityLoc);

    public ProductPage(WebDriver driver){
        this.driver = driver;
    }

    public String getProductTitle(){
        productTitle = driver.findElement(titleField).getText();
        return productTitle;
    }

    public String getProductAvailability(){
        productAvailability = driver.findElement(availabilityField).getText();
        productAvailability = productAvailability.replace("Առկայություն: ", "");
        return productAvailability;
    }

}
