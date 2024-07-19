package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginPage {

    WebDriver driver;
    WebElement username;
    WebElement password;
    WebElement rememberMe;
    WebElement loginButton;
    String expectedTitle = "Login";
    String actualTitle;
    public LoginPage(WebDriver driver){
        this.driver = driver;
        this.username = this.driver.findElement(By.name("identity"));
        this.password = this.driver.findElement(By.name("password"));
        this.rememberMe = this.driver.findElement(By.xpath("//*[text()= 'Remember me']"));
        this.loginButton = this.driver.findElement(By.xpath("//button[@class='btn btn-success pull-right']"));
        this.actualTitle =  this.driver.getTitle();
    }

    public void verifyTitle(){
        Assert.assertEquals(actualTitle,expectedTitle);
    }

    public void userNameDisplay(){
        this.username.isDisplayed();
    }

    public void passwordDisplay(){
        this.password.isDisplayed();
    }

    public void rememberMeDisplay(){
        this.rememberMe.isDisplayed();
    }

    public void loginButtonDisplay(){
        this.loginButton.isDisplayed();
    }

    public void inputUsername(String username){
            this.username.clear();
            this.username.sendKeys(username);
    }

    public void inputPassword(String password){
        this.password.clear();
        this.password.sendKeys(password);
    }

    public void clickLoginButton(){
        this.loginButton.click();
    }
}
