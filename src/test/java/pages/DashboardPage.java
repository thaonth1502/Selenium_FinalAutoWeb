package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class DashboardPage {

    WebDriver driver;
    Actions actions;
    By actualMessageSuccess = By.xpath("//p[contains(text(),'You are successfully logged in.')]");
    By overviewChart = By.xpath("//*[text() ='Overview Chart']");
    By quickLinks = By.xpath("//*[text() ='Quick Links']");
    By lastestFive = By.xpath("//*[text() =' Latest Five']");
    By bestSellers = By.xpath("//h2[normalize-space()='Best Sellers (Jun-2024)']");
    By menuProduct = By.xpath("//ul[@class ='nav main-menu']//li[2]/a/span[contains(text(),'Products')]");
    By menuListProduct = By.xpath("//li[@id = 'products_index']//span[1]");
    By menuBarCodePrint = By.id("products_print_barcodes");
    By menuSale = By.linkText("Sales");
    By menuAddSale = By.xpath("//li[@id= 'sales_add']//span[1]");;
    By menuPurchases = By.xpath("//ul[@class ='nav main-menu']//li[5]/a/span[contains(text(),'Purchases')]");
    By menuListPurchases = By.xpath("//*[@id='purchases_index']//span[1]");
    By menuAddPurchase = By.xpath("//*[@id='purchases_add']//span[1]");


    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(this.driver);
    }

    public void clickmenuAddPurchase(){
        WebElement menuAddPurchase = this.driver.findElement(this.menuAddPurchase);
        actions.moveToElement(menuAddPurchase).build().perform();
        if(menuAddPurchase.isDisplayed()) {
            menuAddPurchase.click();
        }else {
            clickmenuPurchases();
            menuAddPurchase.click();
        }
    }
    public void clickmenuPurchases(){
        WebElement menuPurchases = this.driver.findElement(this.menuPurchases);
        actions.moveToElement(menuPurchases).build().perform();
        menuPurchases.click();
    }

    public void clickmenuListPurchases(){
        WebElement menuListPurchases = this.driver.findElement(this.menuListPurchases);
        actions.moveToElement(menuListPurchases).build().perform();
        if(menuListPurchases.isDisplayed()) {
            menuListPurchases.click();
        }else {
            clickmenuPurchases();
            menuListPurchases.click();
        }
    }
    public void clickMenuSale(){
        WebElement menuSale = this.driver.findElement(this.menuSale);
        actions.moveToElement(menuSale).build().perform();
        menuSale.click();
    }

    public void clickMenuAddSale(){
        WebElement menuAddSale = this.driver.findElement(this.menuAddSale);
        actions.moveToElement(menuAddSale).build().perform();
        if(menuAddSale.isDisplayed()) {
            menuAddSale.click();
        }else {
            clickMenuSale();
            menuAddSale.click();
        }
    }

    public void verifyMessageSuccess(){
        WebElement actualMessageSuccess = this.driver.findElement(this.actualMessageSuccess);
        String actualMessage = actualMessageSuccess.getText();
        Assert.assertEquals(actualMessage,Common.LOGIN_MESSAGE_SUCCESS);
    }

    public void overviewChartDisplay(){
        WebElement overviewChart = this.driver.findElement(this.overviewChart);
        actions.moveToElement(overviewChart).build().perform();
        overviewChart.isDisplayed();
    }

    public void quickLinksDisplay(){
        WebElement quickLinks = this.driver.findElement(this.quickLinks);
        actions.moveToElement(quickLinks).build().perform();
        quickLinks.isDisplayed();
    }

    public void lastestFiveDisplay(){
        WebElement lastestFive = this.driver.findElement(this.lastestFive);
        actions.moveToElement(lastestFive).build().perform();
        lastestFive.isDisplayed();
    }

    public void bestSellersDisplay(){
        WebElement bestSellers = this.driver.findElement(this.bestSellers);
        actions.moveToElement(bestSellers).build().perform();
        bestSellers.isDisplayed();
    }

    public void clickMenuProducts(){
        WebElement menuProduct = this.driver.findElement(this.menuProduct);
        actions.moveToElement(menuProduct).build().perform();
        menuProduct.click();
    }

    public void clickMenuListProducts(){
        WebElement menuListProduct = this.driver.findElement(this.menuListProduct);
        actions.moveToElement(menuListProduct).build().perform();
        if(menuListProduct.isDisplayed()){
            menuListProduct.click();
        }else {
            clickMenuProducts();
            menuListProduct.click();
        }

    }

    public void clickMenuPrintBarCode(){
        WebElement menuBarCodePrint = this.driver.findElement(this.menuBarCodePrint);
        actions.moveToElement(menuBarCodePrint).build().perform();
        if(menuBarCodePrint.isDisplayed()) {
            menuBarCodePrint.click();
        }else {
            clickMenuProducts();
            menuBarCodePrint.click();
        }
    }
    public void gotoDashboardPage(){
        this.driver.navigate().to("https://sma.tec.sh/admin/");
    }
}
