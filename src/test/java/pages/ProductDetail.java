package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class ProductDetail {

    WebDriver driver;
    Actions actions;
    By productImage = By.id("pr-image");

    public ProductDetail(WebDriver driver){
        this.driver = driver;
        this.actions = new Actions(this.driver);
    }
    public void switchToProductDetail(){
        this.driver.switchTo().activeElement().findElement(By.id("myModal"));
    }

    public void productImageDisplay(){
        WebElement productImage = this.driver.findElement(this.productImage);
        productImage.isDisplayed();
    }
    public void backPreviousPage(){
        this.driver.navigate().back();
    }

    public void productDetailDisplay(){
     List <WebElement> elementLabels = this.driver.findElements(By.xpath("//div[@class='col-xs-7']//tbody/tr/td[1]"));
     List<WebElement> elementValues = this.driver.findElements(By.xpath("//div[@class='col-xs-7']//tbody/tr/td[2]"));
     String[] lablesExpected = {"","Barcode & QRcode","Type","Name","Code","Brand","Category","Unit","Cost","Price","Tax Rate","Tax Method","Alert Quantity"};
     String[] valueExpected ={"Standard", "Lemon", "FFR03", "", "Fruits", "Piece (pc)", "1.95", "3.00", "GST @0%", "Inclusive","5.00"};
     for (int i = 0; i < elementLabels.size(); i++){
         elementLabels.get(i).isDisplayed();
         Assert.assertEquals(elementLabels.get(i).getText(), lablesExpected[i]);
     }
        for (int i = 1; i < elementValues.size(); i++){
            elementValues.get(i).isDisplayed();
            Assert.assertEquals(elementValues.get(i).getAttribute("innerHTML"),valueExpected[i-1]);
     }
    }
}
