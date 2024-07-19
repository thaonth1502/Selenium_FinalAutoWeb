package tests;

import org.testng.annotations.Test;
import pages.BaseClass;
import pages.Common;

import java.text.ParseException;

public class TestFinalAutoWeb extends BaseClass {

    @Test (priority = 0)
    public void tc01(){
        //Verify Title
        this.loginPage.verifyTitle();
        //username field display
        this.loginPage.userNameDisplay();
        //password field display
        this.loginPage.passwordDisplay();
        //remember me display
        this.loginPage.rememberMeDisplay();
        //login button display
        this.loginPage.loginButtonDisplay();
    }

    @Test (priority = 1)
    public void tc02(){
        //input username
        this.loginPage.inputUsername(Common.USERNAME);
        //input password
        this.loginPage.inputPassword(Common.PASSWORD);
        //click login button
        this.loginPage.clickLoginButton();
        //verify message login successful
        this.dashboardPage.verifyMessageSuccess();
        //overview Chart display
        this.dashboardPage.overviewChartDisplay();
        //quick Link display
        this.dashboardPage.quickLinksDisplay();
        //Lastest Five display
        this.dashboardPage.lastestFiveDisplay();
        //Best Seller Display
        this.dashboardPage.bestSellersDisplay();
    }

    @Test (priority = 2)
    public void tc03(){
        //Click Products left menu
        this.dashboardPage.clickMenuProducts();
        //Click on List Products submenu of Products
        this.dashboardPage.clickMenuListProducts();
        //Verify column name of Product Table
        this.products.verifyColumNameProductTable();
    }

    @Test (priority = 3)
    public void tc04(){
        //click Lemon product
        this.products.clickLemonProduct();
        //Switch to Product Detail form
        this.productDetail.switchToProductDetail();
        //verify Product Image is displayed
        this.productDetail.productImageDisplay();
        //verify barQR of product is displayed
        this.productDetail.barQRDisplay();
        //verify type display
        this.productDetail.typeDisplay();
        //verify name display
        this.productDetail.nameDisplay();
        //verify code display
        this.productDetail.codeDisplay();
        //verify category display
        this.productDetail.categoryDisplay();
        //verify unit display
        this.productDetail.unitDisplay();
        //verify price display
        this.productDetail.priceDisplay();
        //verify cost display
        this.productDetail.costDisplay();
        //verify taxMethod display
        this.productDetail.taxMethodDisplay();
        //verify taxRate display
        this.productDetail.taxRateDisplay();
        //verify alert quantity display
        this.productDetail.quantityDisplay();
        //verify product detail display
        this.productDetail.productDetailLableDisplay();
        //back to previous page
        this.productDetail.backPreviousPage();
    }

    @Test(priority = 4)
    public void tc05(){
        this.dashboardPage.clickMenuProducts();
        this.dashboardPage.clickMenuListProducts();
        this.products.inputSearchBox("Mouse");
        this.products.searchProduct();
        this.products.clickActionButton();
        this.products.clickEditProduct();
        this.editProduct.editProductType();
        this.editProduct.editBarcodeSymbology();
        this.editProduct.editTaxMethod();
        this.editProduct.clickEditButton();
        this.editProduct.backPreviousPage();
    }

    @Test (priority = 5)
    public void tc06(){
        this.dashboardPage.clickMenuProducts();
        this.dashboardPage.clickMenuPrintBarCode();
        this.printBarcodesPage.addProducteDisplay();
        this.printBarcodesPage.styleDisplay();
        this.printBarcodesPage.printDisplay();
    }

    @Test (priority = 6)
    public void tc07() throws InterruptedException {
        this.dashboardPage.clickMenuProducts();
        this.dashboardPage.clickMenuPrintBarCode();
        this.printBarcodesPage.addProduct("Kiwi");
        this.printBarcodesPage.selectStyle();
        this.printBarcodesPage.selectPrint();
        this.printBarcodesPage.clickUpdateButton();
        this.printBarcodesPage.verifyPrintBarCode();
    }

    @Test(priority = 7)
    public void tc08(){
        this.dashboardPage.clickMenuSale();
        this.dashboardPage.clickMenuAddSale();
        this.addSale.clickCustomerField();
        this.addSale.searchCustomer("a");
        this.addSale.selectCustomer();
        this.addSale.inputBoxProduct("h");
        this.addSale.selectProduct();
        this.addSale.clickSubmitButton();
        this.addSale.verifyMessageSuccess();
    }

    @Test (priority = 8)
    public void tc09() throws InterruptedException, ParseException {
        this.dashboardPage.clickmenuPurchases();
        this.dashboardPage.clickmenuListPurchases();
        this.purchaseList.verifyNumberItems();
        this.purchaseList.verifyReferenceNoDesc();
        this.purchaseList.chekFormatDateTime();
    }

    @Test (priority = 9)
    public void tc10() throws InterruptedException{
        this.dashboardPage.clickmenuPurchases();
        this.dashboardPage.clickmenuAddPurchase();
        this.addPurchase.clickSupplierField();
        this.addPurchase.searchSupplier("a");
        this.addPurchase.selectSupplier();
        this.addPurchase.searchProduct("a");
        this.addPurchase.selectProduct();
        this.addPurchase.clickAddPruchaseButton();
        this.addPurchase.verifyMessageSuccess();
    }
}
