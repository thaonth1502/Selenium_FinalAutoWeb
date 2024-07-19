package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class PrintBarcodesPage {

    WebDriver driver;
    Actions actions;
    By addProduct = By.xpath("//label[contains(text(),'Add Product')]");
    By style = By.cssSelector("label[for='style']");
    By print = By.xpath("//span[contains(text(),'Print:')]");
    By boxAddItem = By.id("add_item");
    By boxStyle = By.id("s2id_style");
    By updateButton = By.name("print");


    public PrintBarcodesPage(WebDriver driver){
        this.driver = driver;
        this.actions = new Actions(this.driver);
    }

    public void verifyPrintBarCode() throws InterruptedException {
        actions.moveToElement(this.driver.findElement(By.cssSelector(".barcodea4"))).build().perform();
        Thread.sleep(3000);
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfAllElements(this.driver.findElements(By.xpath("//div[@class='barcodea4']//div/span"))));
        this.driver.findElement(By.xpath("//span[@class='product_image']//img")).isDisplayed();
       Assert.assertEquals(this.driver.findElement(By.cssSelector(".barcode_site")).getAttribute("innerHTML"),"Stock Manager Advance");
       Assert.assertEquals(this.driver.findElement(By.cssSelector(".barcode_name")).getAttribute("innerHTML"),"Kiwi");
       Assert.assertEquals(this.driver.findElement(By.cssSelector(".barcode_price")).getAttribute("innerHTML"),"Price USD: 3.90, ERU: 2.86");
       Assert.assertEquals(this.driver.findElement(By.cssSelector(".barcode_unit")).getAttribute("innerHTML"),"Unit: 4");
       Assert.assertEquals(this.driver.findElement(By.cssSelector(".barcode_category")).getAttribute("innerHTML"),"Category: Fruits");
        this.driver.findElement(By.cssSelector(".barcode_image")).isDisplayed();
    }
    public void clickUpdateButton(){
        WebElement updateButton = this.driver.findElement(this.updateButton);
        actions.moveToElement(updateButton).build().perform();
        updateButton.click();
    }

    public void selectPrint() throws InterruptedException {
        List<WebElement> listPrint = this.driver.findElements(By.xpath("//div[@class='form-group'][2]//div"));
        actions.moveToElement(listPrint.get(1)).build().perform();
        for (int i = 3; i < 8; i++){
            listPrint.get(i).click();
            Thread.sleep(1000);

        }
        Thread.sleep(1000);
    }
    public void addProduct(String productName) throws InterruptedException {
        this.driver.findElement(this.boxAddItem).sendKeys(productName);
    }
    public void selectStyle() throws InterruptedException {
        this.driver.findElement(this.boxStyle).click();
        Thread.sleep(1000);
        this.driver.findElement(By.xpath("//ul[@class='select2-results']//li/div[contains(text(),'18')]")).click();
    }
    public void printDisplay(){
        this.driver.findElement(this.print).isDisplayed();
        List<WebElement> listPrint = this.driver.findElements(By.xpath("//div[@class='form-group'][2]//label"));
        actions.moveToElement(listPrint.get(1)).build().perform();
        for (WebElement printList : listPrint){
            printList.isDisplayed();
        }
    }

    public void addProducteDisplay(){
        this.driver.findElement(this.addProduct).isDisplayed();
    }

    public void styleDisplay(){
        this.driver.findElement(this.style).isDisplayed();
    }
}
