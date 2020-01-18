import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class Tests2 {
    WebDriver driver;
    public static final String id = "";       //enter email here
    public static final String pw = "";      //enter password here
    @Test
    @Parameters("browser")
    public void LoginTest(String browser) throws InterruptedException {
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("opera")) {
            WebDriverManager.operadriver().setup();
            driver = new OperaDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else if (browser.equalsIgnoreCase("IE")) {
            WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver();
        }
        driver.manage().window().maximize();
        driver.get("https://f1store.formula1.com/stores/f1/en//Account/Login");
        WebElement cookies = driver.findElement(By.xpath("/html/body/div[4]/div/span"));
        boolean cookiesDisplayed = cookies.isDisplayed();
        if(cookiesDisplayed) cookies.click();
        Thread.sleep(3000);
        Login loginPage = PageFactory.initElements(driver, Login.class);
        loginPage.login(id,pw);
        Thread.sleep(3000);
        WebElement shop = driver.findElement(By.xpath("/html/body/nav/ul/li[1]/a/span"));
        shop.click();
        Thread.sleep(2000);
        WebElement team = driver.findElement(By.xpath("/html/body/section[2]/section[1]/variable-promotional-grid/section/section/div[3]/div[1]/a/div[1]/span"));
        team.click();
        Thread.sleep(3000);
        WebElement cap = driver.findElement(By.xpath("//*[@id=\"browseResultsGrid\"]/div[1]/div[3]/browse-product/a/div[1]/img"));
        cap.click();
        Thread.sleep(3000);
        WebElement addToBasket = driver.findElement(By.xpath("/html/body/section[2]/section/section[1]/section[2]/section[1]/button/p"));
        addToBasket.click();


        WebDriverWait wait = new WebDriverWait(driver,10);
        WebElement creditCardList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"basketContent\"]/div/table/tbody[2]/tr/td[2]")));
        boolean isDisplayed = ((WebElement) creditCardList).isDisplayed();
        if(isDisplayed) driver.quit();
    }

    @Test
    @Parameters("browser")
    public void FutureTest(String browser) throws InterruptedException {
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("opera")) {
            WebDriverManager.operadriver().setup();
            driver = new OperaDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else if (browser.equalsIgnoreCase("IE")) {
            WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver();
        }
        driver.manage().window().maximize();
        driver.get("https://f1store.formula1.com/stores/f1/en");
        Thread.sleep(3000);
        WebElement cookies = driver.findElement(By.xpath("/html/body/div[8]/div/span"));
        boolean cookiesDisplayed = cookies.isDisplayed();
        if(cookiesDisplayed) cookies.click();
        WebElement loginButton = driver.findElement(By.linkText("SHOP BY DRIVER"));
        loginButton.click();
        WebElement favouriteDriver = driver.findElement(By.linkText("SHOP SAINZ"));
        favouriteDriver.click();
        WebElement alonsoBox = driver.findElement(By.xpath("/html/body/section[2]/section[2]/section/section[1]/div/div[2]/div/div/div[1]/div"));
        alonsoBox.click();
        Thread.sleep(2000);
        WebElement sennaBox = driver.findElement(By.xpath("/html/body/section[2]/section[2]/section/section[1]/div[2]/div[2]/div/div/div[2]/div"));
        sennaBox.click();
        Thread.sleep(3000);
        WebElement searchTextBox2 = driver.findElement(By.xpath("/html/body/header/div[2]/form/input"));
        searchTextBox2.sendKeys("Sainz is future F1 Champion");
        Thread.sleep(2000);
        driver.quit();
    }


}