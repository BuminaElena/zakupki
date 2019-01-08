import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class MainClass {
    static WebDriver driver;

    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\User\\IdeaProjects\\drivers\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://www.zakupki.gov.ru/epz/order/extendedsearch/search.html");
        MainPage page = new MainPage(driver);
        SearchResult result = page.search(3000000, 20000000, "Москва");
        result.sortByPrice();
        PurchaseInfo info = result.getInfo();
        info.saveContacts();
        driver.quit();
    }
}
