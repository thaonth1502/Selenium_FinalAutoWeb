package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class BaseClass {

    WebDriver driver;
    public LoginPage loginPage;
    public DashboardPage dashboardPage;
    public Products products;
    public ProductDetail productDetail;
    public EditProduct editProduct;
    public PrintBarcodesPage printBarcodesPage;
    public AddSale addSale;
    public PurchaseList purchaseList;
    public AddPurchase addPurchase;

    @BeforeTest
    public void setup(){
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
        this.driver.get(Common.URL);
        this.driver.manage().window().maximize();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        this.loginPage = new LoginPage(this.driver);
        this.dashboardPage = new DashboardPage(this.driver);
        this.products = new Products(this.driver);
        this.productDetail = new ProductDetail(this.driver);
        this.editProduct = new EditProduct(this.driver);
        this.printBarcodesPage = new PrintBarcodesPage(this.driver);
        this.addSale = new AddSale(this.driver);
        this.purchaseList = new PurchaseList(this.driver);
        this.addPurchase = new AddPurchase(this.driver);
    }
    @AfterTest
    public void after(){
        this.driver.quit();
    }
}
