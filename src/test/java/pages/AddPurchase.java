package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddPurchase {
    WebDriver driver;
    Actions actions;

    By addProduct = By.name("add_item");
    By supplier = By.id("select2-chosen-8");
    By searchSupplier = By.xpath("//*[@id='select2-drop']//input");
    By selectSupplier = By.xpath("//ul[@id= 'select2-results-8']//li[1]");
    By selectProduct = By.xpath("//ul[contains(@id, 'ui-id')]//li[1]");
    By addPruchaseButton = By.name("add_pruchase");
    By messageSuccess = By.xpath("//div[@class='alert alert-success']");

    public AddPurchase(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(this.driver);
    }

    public void verifyMessageSuccess(){
        String actualMessage = this.driver.findElement(this.messageSuccess).getAttribute("innerHTML");
        assert actualMessage.contains(Common.PURCH_MESSAGE_SUCCESS);
    }
    public void clickAddPruchaseButton(){
        WebElement addPruchaseButton = this.driver.findElement(this.addPruchaseButton);
        actions.moveToElement(addPruchaseButton).build().perform();
        addPruchaseButton.click();
    }

    public void clickSupplierField() throws InterruptedException{
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(supplier));
        Thread.sleep(1000);
        this.driver.findElement(this.supplier).click();
        Thread.sleep(2000);
    }
    public void searchSupplier(String supplier) throws InterruptedException{
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchSupplier));
        Thread.sleep(1000);
        this.driver.findElement(this.searchSupplier).sendKeys(supplier);
        Thread.sleep(2000);
    }

    public void selectSupplier(){
        this.driver.findElement(this.selectSupplier).click();
    }
    public void searchProduct(String product){
        WebElement addProduct = this.driver.findElement(this.addProduct);
        actions.moveToElement(addProduct).build().perform();
        addProduct.sendKeys(product);
    }
    public void selectProduct(){
        this.driver.findElement(this.selectProduct).click();
    }
}
