import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    public WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    By fz44 = By.xpath(".//input[@id='fz44']");
    By fz223 = By.xpath(".//input[@id='fz223']");
    By ppRf615 = By.xpath(".//input[@id='ppRf615']");
    By orderstages = By.xpath(".//span[@title='Выберите один или несколько этапов']");
    By af = By.xpath(".//li[@id='orderStages']//input[@id='af']"); //подача заявок
    By ca = By.xpath(".//li[@id='orderStages']//input[@id='ca']"); //работа комиссии
    By pc = By.xpath(".//li[@id='orderStages']//input[@id='pc']"); //процедура завершена
    By pa = By.xpath(".//li[@id='orderStages']//input[@id='pa']"); //процедура отменена
    By selectButton = By.xpath(".//li[@id='orderStages']//span[@class='btnBtn blueBtn']"); //Выбрать
    By minPriceField = By.xpath(".//input[@id='priceFromGeneral']"); //Ввести мин цену
    By maxPriceField = By.xpath(".//input[@id='priceToGeneral']"); //Ввести макс цену
    By chooseCurrency = By.xpath(".//div[@id='currencyChangecurrencyIdGeneral']"); //Выбрать валюту
    By chooseRuble = By.xpath(".//input[@id='contextSearchcurrencyIdGeneral']/ancestor::div//span[@id='1']"); //Выбрать рубли
    By addressField = By.xpath(".//input[@id='deliveryAddress']"); //Написать адрес
    By searchButton = By.xpath(".//span[@class='bigOrangeBtn searchBtn']"); //Кнопка поиска

    public MainPage selectKapRem() {
        if (driver.findElement(fz44).isSelected()) {
            driver.findElement(fz44).click();
        }
        if (driver.findElement(fz223).isSelected()) {
            driver.findElement(fz223).click();
        }
        if (!driver.findElement(ppRf615).isSelected()) {
            driver.findElement(ppRf615).click();
        }
        return this;
    }

    public MainPage selectOrderStages() {
        driver.findElement(orderstages).click();
        if (!driver.findElement(af).isSelected()) {
            driver.findElement(af).click();
        }
        if (driver.findElement(ca).isSelected()) {
            driver.findElement(ca).click();
        }
        if (driver.findElement(pc).isSelected()) {
            driver.findElement(pc).click();
        }
        if (driver.findElement(pa).isSelected()) {
            driver.findElement(pa).click();
        }
        driver.findElement(selectButton).click();
        return  this;
    }

    public MainPage chooseSum(int min, int max) {
        driver.findElement(minPriceField).sendKeys(""+min);
        driver.findElement(maxPriceField).sendKeys(""+max);
        driver.findElement(chooseCurrency).click();
        driver.findElement(chooseRuble).click();
        return this;
    }

    public MainPage enterAddress(String address) {
        driver.findElement(addressField).sendKeys(address);
        return this;
    }

    public SearchResult search(int min, int max, String address) {
        this.selectKapRem();
        this.selectOrderStages();
        this.chooseSum(min, max);
        this.enterAddress(address);
        driver.findElement(searchButton).click();
        return new SearchResult(driver);
    }







}
