package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class PurchaseList {

    WebDriver driver;
    By listPurchase = By.xpath("//*[@id='POData']//tbody/tr");
    By referenceNo = By.xpath("//*[@id='POData']//tbody/tr/td[3]");
    By dateList = By.xpath("//*[@id='POData']//tbody/tr/td[2]");

    public PurchaseList(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyNumberItems() throws InterruptedException {
        List<WebElement> listItems = this.driver.findElements(this.listPurchase);
        Thread.sleep(4000);
        System.out.println(listItems.size());
        System.out.println(listItems);
        Assert.assertTrue(listItems.size() == 9);

    }

    public void verifyReferenceNoDesc(){
        List<WebElement> listReferenceNo = this.driver.findElements(this.referenceNo);
        List<String> listReferenceNoValue = new ArrayList<String>();
        for (WebElement element : listReferenceNo){
            listReferenceNoValue.add(element.getAttribute("innerHTML"));
        }
//        System.out.println(listReferenceNoValue);
        List<String> listReferenNoDesc = new ArrayList<String>();
        listReferenNoDesc.addAll(listReferenceNoValue);
        Collections.sort(listReferenNoDesc,Collections.reverseOrder());
//        System.out.println(listReferenNoDesc);

        Assert.assertTrue(listReferenNoDesc.size() == listReferenceNoValue.size());
        for (int i = 0; i < listReferenceNoValue.size(); i++) {
            Assert.assertEquals(listReferenceNoValue.get(i),listReferenNoDesc.get(i));
        }
        System.out.println(listReferenceNoValue);
        System.out.println(listReferenNoDesc);
    }

    public void chekFormatDateTime() throws ParseException {
        List<WebElement> listDateTime = this.driver.findElements(this.dateList);
        List<String> listDateValue = new ArrayList<String>();
        for (WebElement element : listDateTime){
            listDateValue.add(element.getAttribute("innerHTML"));
        }
        for (int i = 0; i < listDateValue.size(); i++) {
            Assert.assertTrue(Common.validateDateFormat(listDateValue.get(i)));
        }


    }
}
