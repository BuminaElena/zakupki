import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class PurchaseInfo {
    public WebDriver driver;

    public PurchaseInfo(WebDriver driver) {
        this.driver = driver;
    }

    By purchaseNumber = By.xpath(".//td[contains(text(),'Номер закупки')]/following-sibling::td");
    By phone = By.xpath(".//td[text()='Номер телефона']/following-sibling::td");
    By contactPerson = By.xpath(".//td[text()='Контактное лицо']/following-sibling::td");

    public PurchaseInfo saveContacts() {
        String purchase = driver.findElement(purchaseNumber).getText();
        String phoneNumber = driver.findElement(phone).getText();
        String contact = driver.findElement(contactPerson).getText();
        try {
            FileWriter writer = new FileWriter("C:\\Users\\User\\IdeaProjects\\"+purchase+".txt");
            writer.write("Номер закупки: "+purchase+" ФИО "+contact+" Номер телефона "+phoneNumber);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this;
    }

}
