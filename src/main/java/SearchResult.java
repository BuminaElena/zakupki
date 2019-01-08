import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResult {
    public WebDriver driver;

    public SearchResult(WebDriver driver) {
        this.driver = driver;
    }

    By sortByPriceButton = By.xpath(".//div[@class='sortBy']//span[text()='Цене']");
    By elementsInfo = By.xpath(".//div[@class='registerBox registerBoxBank margBtm20']//a[contains(text(),'Сведения')]");

    public SearchResult sortByPrice() {
        driver.findElement(sortByPriceButton).click();
        return this;
    }

    public PurchaseInfo getInfo() {
        driver.findElement(elementsInfo).click();
        for (String windowHandle : driver.getWindowHandles()) driver.switchTo().window(windowHandle);
        return new PurchaseInfo(driver);
    }

}
