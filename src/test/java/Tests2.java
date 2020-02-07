import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;


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

        driver.get("https://f1store.formula1.com/stores/f1/en");
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[8]/div/span")));
        driver.findElement(By.xpath("/html/body/div[8]/div/span")).click();

        HomePage.Account(driver).click();
        Login.UserName(driver).sendKeys(id);
        Login.Password(driver).sendKeys(pw);
        Login.LogIn(driver).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/nav/ul/li[1]/a/span")));
        driver.findElement(By.xpath("/html/body/nav/ul/li[1]/a/span")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/section[2]/section[1]/variable-promotional-grid/section/section/div[3]/div[1]/a/div[1]/span")));
        driver.findElement(By.xpath("/html/body/section[2]/section[1]/variable-promotional-grid/section/section/div[3]/div[1]/a/div[1]/span")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"browseResultsGrid\"]/div[1]/div[3]/browse-product/a/div[1]/img")));
        driver.findElement(By.xpath("//*[@id=\"browseResultsGrid\"]/div[1]/div[3]/browse-product/a/div[1]/img")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/section[2]/section/section[1]/section[2]/section[1]/button/p")));
        driver.findElement(By.xpath("/html/body/section[2]/section/section[1]/section[2]/section[1]/button/p")).click();

        Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);

        WebElement quit = fluentWait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver webDriver) {
                return driver.findElement(By.xpath("/html/body/section[2]/section[1]/form/aside/div/div[1]/div[5]/button"));
            }
        });
        quit.click();
        driver.quit();
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
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[8]/div/span")));
        driver.findElement(By.xpath("/html/body/div[8]/div/span")).click();
        WebElement loginButton = driver.findElement(By.linkText("SHOP BY DRIVER"));
        loginButton.click();
        WebElement favouriteDriver = driver.findElement(By.linkText("SHOP SAINZ"));
        favouriteDriver.click();

        Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);

        WebElement alonsoBox = fluentWait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver webDriver) {
                return driver.findElement(By.xpath("/html/body/section[2]/section[2]/section/section[1]/div/div[2]/div/div/div[1]/div"));
            }
        });
        alonsoBox.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/section[2]/section[2]/section/section[1]/div[2]/div[2]/div/div/div[2]/div")));
        driver.findElement(By.xpath("/html/body/section[2]/section[2]/section/section[1]/div[2]/div[2]/div/div/div[2]/div")).click();
        WebElement searchTextBox2 = driver.findElement(By.xpath("/html/body/header/div[2]/form/input"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        searchTextBox2.sendKeys("Sainz is future F1 Champion");
        driver.quit();
    }


}