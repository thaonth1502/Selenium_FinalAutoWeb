package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class Products {

    WebDriver driver;
    By lemon = By.xpath("//td[contains(text(),'Lemon')]");
    By searchBox = By.xpath("//input[@class='input-xs']");
    By actionButton = By.xpath("//button[contains(text(), 'Actions')]");
    By editProduct = By.xpath("//a[contains(text(), ' Edit Product')]");

    public Products(WebDriver driver){
        this.driver = driver;
    }

    public void clickEditProduct(){
        WebElement editProduct = this.driver.findElement(this.editProduct);
        editProduct.click();
    }

    public void clickActionButton(){
        WebElement actionButton = this.driver.findElement(this.actionButton);
        actionButton.click();
    }

    public void inputSearchBox(String productName){
        WebElement searchBox = this.driver.findElement(this.searchBox);
        searchBox.sendKeys(productName);
    }

    public void searchProduct(){
        WebElement searchBox = this.driver.findElement(this.searchBox);
        searchBox.sendKeys(Keys.ENTER);
    }

    public void clickLemonProduct(){
        WebElement lemon = this.driver.findElement(this.lemon);
        lemon.click();
    }

    public void verifyColumNameProductTable(){
        String[] column = {"","Image","Code", "Name", "Brand", "Category", "Cost", "Price", "Quantity", "Unit", "Alert Quantity","Actions"};
        List<String> actualColumn = new ArrayList<>();
        List<WebElement> elements = this.driver.findElements(By.xpath("//tr[@class = 'primary']//child::th"));
        for(WebElement element: elements){
           actualColumn.add(element.getText());
        }

        for (int i = 0; i < actualColumn.size(); i++) {
            Assert.assertEquals(actualColumn.get(i), column[i]);
        }
    }
}
