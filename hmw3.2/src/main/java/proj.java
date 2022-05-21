import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class proj {
    public static WebDriver driver;

    public static void initDriver(){
        System.setProperty("webdriver.chrome.driver", "src/driver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
}
