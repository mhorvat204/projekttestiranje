import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;


public class TestGrid {
    @Test
    public void Test() throws MalformedURLException, InterruptedException {
        DesiredCapabilities capability = DesiredCapabilities.chrome();
        capability.setPlatform(Platform.WINDOWS);

        URL url = new URL("http://localhost:4444/wd/hub");
        WebDriver driver = new RemoteWebDriver(url,capability);

        driver.manage().window().maximize();
        driver.get("https://www.formula1.com/");
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[6]/div/div/div/div[2]/a")));
        driver.findElement(By.xpath("/html/body/div[6]/div/div/div/div[2]/a")).click();
        WebElement standings = driver.findElement(By.xpath("/html/body/div[2]/header[1]/div/div[2]/div[1]/div/div[2]/ul/li[4]/a"));
        Actions act = new Actions(driver);
        act.moveToElement(standings).perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/header[1]/div/div[2]/div[1]/div/div[2]/ul/li[4]/div/div/div/div/div/a[4]")));
        driver.findElement(By.xpath("/html/body/div[2]/header[1]/div/div[2]/div[1]/div/div[2]/ul/li[4]/div/div/div/div/div/a[4]")).click();
        WebElement arrowUp = driver.findElement(By.xpath("/html/body/div[2]/main/article/div/div[2]/div[1]/div[1]/div/button[1]"));
        for(int i=0;i<3;i++) arrowUp.click();
        WebElement year = driver.findElement(By.xpath("/html/body/div[2]/main/article/div/div[2]/div[1]/div[1]/ul/li[64]/a/span"));
        year.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/article/div/div[2]/div[2]/div/div[2]/table/tbody/tr[8]/td[2]/a")));
        driver.findElement(By.xpath("/html/body/div[2]/main/article/div/div[2]/div[2]/div/div[2]/table/tbody/tr[8]/td[2]/a")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/article/div/div[2]/div[2]/div[2]/div[1]/ul/li[4]/a")));
        driver.findElement(By.xpath("/html/body/div[2]/main/article/div/div[2]/div[2]/div[2]/div[1]/ul/li[4]/a")).click();

        driver.quit();
    }
}
