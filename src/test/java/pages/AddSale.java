package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class AddSale {
    WebDriver driver;
    Actions actions;

    By customer = By.id("s2id_slcustomer");
    By searchCustomer = By.id("s2id_autogen12_search");
    By selectCustomer = By.xpath("//*[@class ='select2-results']//div");
    By boxAddProduct = By.name("add_item");
    By selectProduct = By.xpath("//*[@class ='ui-menu-item'][1]");
    By sumbitButton = By.xpath("//input[@id ='add_sale']");
    By messageSuccess = By.xpath("//div[@class='alert alert-success']");
    public AddSale(WebDriver driver){
        this.driver = driver;
        this.actions = new Actions(this.driver);
    }

    public void verifyMessageSuccess(){
        String actualMessage = this.driver.findElement(this.messageSuccess).getText();
        assert actualMessage.contains(Common.SALE_MESSAGE_SUCCESS);
    }
    public void clickCustomerField(){
        this.driver.findElement(this.customer).click();
    }

    public void searchCustomer(String cus){
        this.driver.findElement(this.searchCustomer).sendKeys(cus);
    }

    public void selectCustomer(){
        this.driver.findElement(this.selectCustomer).click();
    }

    public void inputBoxProduct(String pro){
        WebElement boxAdd = this.driver.findElement(this.boxAddProduct);
        actions.moveToElement(boxAdd).build().perform();
        boxAdd.sendKeys(pro);
    }
    public void selectProduct(){
        this.driver.findElement(this.selectProduct).click();
    }

    public void clickSubmitButton(){
        WebElement submit = this.driver.findElement(this.sumbitButton);
        actions.moveToElement(submit).build().perform();
        submit.click();
    }
}
