import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class Tests {

    @Test
    public void BuyingTickets() throws InterruptedException {
        WebDriver driver = new BrowserFactory().startBrowser("chrome","https://tickets.formula1.com/en");
        driver.manage().window().maximize();


        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div[2]/div[4]/div/div[2]/button")));
        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[4]/div/div[2]/button")).click();
        WebElement italy = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[16]/div/div/div[2]"));
        Actions act = new Actions(driver);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        act.moveToElement(italy).perform();
        WebElement bookNow = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[16]/div/div/div[2]/div/a"));
        bookNow.click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Actions act2 = new Actions(driver);
        WebElement slider = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[4]/div[1]/div/div[2]/div[2]/div[1]/div[2]/div/div/div[1]/div[1]"));
        act2.dragAndDropBy(slider,100,0).release().build().perform();
        slider.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[2]/div[4]/div[1]/div/div[2]/div[2]/div[1]/div[6]/div/label/span")));
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[4]/div[1]/div/div[2]/div[2]/div[1]/div[6]/div/label/span")).click();
        WebElement paddock_inmydreams = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[4]/div[1]/div/div[2]/div[3]/div[1]/div[2]/div[2]/div[2]/div/a"));
        paddock_inmydreams.click();


        WebElement quiting = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/header/div/div[2]/div[1]/div/div[1]/a/span/img")));
        boolean isDisplayed = ((WebElement) quiting).isDisplayed();
        if(isDisplayed) driver.quit();
    }


    @Test
    public void MclarenTest() throws InterruptedException {
        WebDriver driver = new BrowserFactory().startBrowser("chrome","https://www.formula1.com");
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[6]/div/div/div/div[2]/a")));
        driver.findElement(By.xpath("/html/body/div[6]/div/div/div/div[2]/a")).click();
        WebElement teams = driver.findElement(By.xpath("/html/body/div[2]/header/div/div[2]/div[1]/div/div[2]/ul/li[6]/a/span"));
        Actions act = new Actions(driver);
        act.moveToElement(teams).perform();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        WebElement mclaren = driver.findElement(By.xpath("/html/body/div[2]/header/div/div[2]/div[1]/div/div[2]/ul/li[6]/div/div/div/div/div[2]/ul/li[4]/a/span[1]"));
        mclaren.click();


        WebElement quiting = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/article/div/header[2]/section[1]/div/section/div[1]/img")));
        boolean isDisplayed = ((WebElement) quiting).isDisplayed();
        if(isDisplayed) driver.quit();

    }


}