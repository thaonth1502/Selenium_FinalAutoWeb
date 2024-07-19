package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class EditProduct {

    WebDriver driver;
    Actions actions;
    By editButton = By.name("edit_product");
    By prodctType = By.id("s2id_type");
    By productTypeSelect = By.cssSelector("#select2-result-label-16");
    By barCode = By.cssSelector("#s2id_barcode_symbology");
    By barCodeSelect = By.cssSelector("#select2-result-label-22");
    By taxMethod = By.cssSelector("#select2-chosen-13");
    By taxMethodSelect = By.cssSelector("#select2-result-label-27");

    public EditProduct(WebDriver driver){
        this.driver = driver;
        this.actions = new Actions(this.driver);
    }

    public void editProductType(){
        WebElement productType = this.driver.findElement(this.prodctType);
        productType.click();
        this.driver.findElement(this.productTypeSelect).click();
    }

    public void editBarcodeSymbology(){
        WebElement barCode = this.driver.findElement(this.barCode);
        actions.moveToElement(barCode).build().perform();
        barCode.click();
        this.driver.findElement(this.barCodeSelect).click();
    }

    public void editTaxMethod(){
        WebElement taxtMethod = this.driver.findElement(this.taxMethod);
        actions.moveToElement(taxtMethod).build().perform();
        taxtMethod.click();
        this.driver.findElement(this.taxMethodSelect).click();
    }
    public void clickEditButton(){
        WebElement editButton = this.driver.findElement(this.editButton);
        actions.moveToElement(editButton).build().perform();
        editButton.click();
    }

    public void backPreviousPage(){
        this.driver.navigate().back();
    }
}
