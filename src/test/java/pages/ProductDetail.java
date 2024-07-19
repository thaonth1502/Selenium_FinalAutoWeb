package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ProductDetail {

    WebDriver driver;
    Actions actions;
    By productImage = By.id("pr-image");
    By barQRLable = By.xpath("//td[contains(text(),'Barcode & QRcode')]");
    By barCode = By.xpath("//*[@class = 'bcimg']");
    By qrCode = By.xpath("//*[@class = 'qrimg']");
    By typeLable = By.xpath("//td[contains(text(),'Type')]");
    By typeValue = By.xpath("//td[contains(text(),'Standard')]");
    By nameLable = By.xpath("//td[contains(text(),'Name')]");
    By nameValue = By.xpath("//td[contains(text(),'Lemon')]");
    By codeLable = By.xpath("//td[contains(text(),'Code')]");
    By codeValue = By.xpath("//td[contains(text(),'FFR03')]");
    By categoryLable = By.xpath("//td[contains(text(),'Category')]");
    By categoryValue = By.xpath("//td[contains(text(),'Fruits')]");
    By unitLable = By.xpath("//td[contains(text(),'Unit')]");
    By unitValue = By.xpath("//td[contains(text(),'Piece (pc)')]");
    By costLable = By.xpath("//td[contains(text(),'Cost')]");
    By costValue = By.xpath("//td[contains(text(),'1.95')]");
    By priceLable = By.xpath("//td[contains(text(),'Price')]");
    By priceValue = By.xpath("//td[contains(text(),'3.00')]");
    By taxRateLable = By.xpath("//td[contains(text(),'Tax Rate')]");
    By taxRateValue = By.xpath("//td[contains(text(),'GST @0%')]");
    By taxMethodLable = By.xpath("//td[contains(text(),'Tax Method')]");
    By taxMethodValue = By.xpath("//td[contains(text(),'Inclusive')]");
    By quantityLable = By.xpath("//td[contains(text(),'Alert Quantity')]");
    By quantityValue = By.xpath("//td[contains(text(),'5.00')]");
    By productDetailLable = By.xpath("//div[contains(text(),'Product Details')]");


    public ProductDetail(WebDriver driver){
        this.driver = driver;
        this.actions = new Actions(this.driver);
    }

    public void switchToProductList(){
        this.driver.switchTo().defaultContent().findElement(By.id("content"));
    }
    public void switchToProductDetail(){
        this.driver.switchTo().activeElement().findElement(By.id("myModal"));
    }

    public void productImageDisplay(){
        WebElement productImage = this.driver.findElement(this.productImage);
        productImage.isDisplayed();
    }

    public void barQRDisplay(){
        WebElement barQRLable = this.driver.findElement(this.barQRLable);
        WebElement barCode = this.driver.findElement(this.barCode);
        WebElement qrCode = this.driver.findElement(this.qrCode);
        barQRLable.isDisplayed();
        barQRLable.getText().equals("Barcode & QRcode");
        barCode.isDisplayed();
        qrCode.isDisplayed();
    }

    public void typeDisplay(){
        WebElement typeLable = this.driver.findElement(this.typeLable);
        WebElement typeValue = this.driver.findElement(this.typeValue);
        typeLable.isDisplayed();
        typeValue.isDisplayed();
        typeLable.getText().equals("Type");
        typeValue.getText().equals("Standard");
    }

    public void nameDisplay(){
        WebElement nameLable = this.driver.findElement(this.nameLable);
        WebElement nameValue = this.driver.findElement(this.nameValue);
        nameLable.isDisplayed();
        nameValue.isDisplayed();
        nameLable.getText().equals("Name");
        nameValue.getText().equals("Lemon");
    }
    public void codeDisplay(){
        WebElement codeLable = this.driver.findElement(this.codeLable);
        WebElement codeValue = this.driver.findElement(this.codeValue);
        codeLable.isDisplayed();
        codeValue.isDisplayed();
        codeLable.getText().equals("Code");
        codeValue.getText().equals("FFR03");
    }

    public void categoryDisplay(){
        WebElement categoryLable = this.driver.findElement(this.categoryLable);
        WebElement categoryValue = this.driver.findElement(this.categoryValue);
        categoryLable.isDisplayed();
        categoryValue.isDisplayed();
        categoryLable.getText().equals("Category");
        categoryValue.getText().equals("Fruits");
    }

    public void unitDisplay(){
        WebElement unitLable = this.driver.findElement(this.unitLable);
        WebElement unitValue = this.driver.findElement(this.unitValue);
        unitLable.isDisplayed();
        unitValue.isDisplayed();
        unitLable.getText().equals("Unit");
        unitValue.getText().contains("Piece (pc)");
    }
    public void  costDisplay(){
        WebElement costLable = this.driver.findElement(this.costLable);
        WebElement costValue = this.driver.findElement(this.costValue);
        costLable.isDisplayed();
        costValue.isDisplayed();
        costLable.getText().equals("Cost");
        costValue.getText().equals("1.95");
    }

    public void priceDisplay(){
        WebElement priceLable = this.driver.findElement(this.priceLable);
        WebElement priceValue = this.driver.findElement(this.priceValue);
        priceLable.isDisplayed();
        priceValue.isDisplayed();
        priceLable.getText().equals("Price");
        priceValue.getText().equals("3.00");
    }

    public void taxRateDisplay(){
        WebElement taxRateLable = this.driver.findElement(this.taxRateLable);
        WebElement taxRateValue = this.driver.findElement(this.taxRateValue);
        taxRateLable.isDisplayed();
        taxRateValue.isDisplayed();
        taxRateLable.getText().equals("Tax Rate");
        taxRateValue.getText().equals("GST @0%");
    }

    public void taxMethodDisplay(){
        WebElement taxMethodLable = this.driver.findElement(this.taxMethodLable);
        WebElement taxMethodValue = this.driver.findElement(this.taxMethodValue);
        taxMethodLable.isDisplayed();
        taxMethodValue.isDisplayed();
        taxMethodLable.getText().equals("Tax Method");
        taxMethodValue.getText().equals("Inclusive");
    }

    public void quantityDisplay(){
        WebElement quantityLable = this.driver.findElement(this.quantityLable);
        WebElement quantityValue = this.driver.findElement(this.quantityValue);
        quantityLable.isDisplayed();
        quantityValue.isDisplayed();
        quantityLable.getText().equals("Alert Quantity");
        quantityValue.getText().equals("5.00");
    }
    public void productDetailLableDisplay(){
        WebElement productDetailLable = this.driver.findElement(this.productDetailLable);
       actions.moveToElement(productDetailLable).build().perform();
       productDetailLable.isDisplayed();
       productDetailLable.getText().equals("Product Details");
    }
    public void backPreviousPage(){
        this.driver.navigate().back();
    }
}
