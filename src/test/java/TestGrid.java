import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
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
        Thread.sleep(3000);
        WebElement cookies = driver.findElement(By.xpath("/html/body/div[6]/div/div/div/div[2]/a"));
        boolean cookiesDisplayed = cookies.isDisplayed();
        if(cookiesDisplayed) cookies.click();
        WebElement standings = driver.findElement(By.xpath("/html/body/div[2]/header[1]/div/div[2]/div[1]/div/div[2]/ul/li[4]/a"));
        Actions act = new Actions(driver);
        act.moveToElement(standings).perform();
        Thread.sleep(3000);
        WebElement archive = driver.findElement(By.xpath("/html/body/div[2]/header[1]/div/div[2]/div[1]/div/div[2]/ul/li[4]/div/div/div/div/div/a[4]"));
        archive.click();
        Thread.sleep(5000);
        WebElement arrowUp = driver.findElement(By.xpath("/html/body/div[2]/main/article/div/div[2]/div[1]/div[1]/div/button[1]"));
        for(int i=0;i<5;i++) arrowUp.click();
        Thread.sleep(3000);
        WebElement year = driver.findElement(By.xpath("/html/body/div[2]/main/article/div/div[2]/div[1]/div[1]/ul/li[64]/a/span"));
        year.click();
        Thread.sleep(3000);
        WebElement race = driver.findElement(By.xpath("/html/body/div[2]/main/article/div/div[2]/div[1]/div[2]/ul/li[1]/a/span"));
        race.click();
        Thread.sleep(3000);
        WebElement track = driver.findElement(By.xpath("/html/body/div[2]/main/article/div/div[2]/div[1]/div[3]/ul/li[3]/a/span"));
        track.click();
        Thread.sleep(3000);
        WebElement qualy = driver.findElement(By.xpath("/html/body/div[2]/main/article/div/div[2]/div[2]/div[2]/div[1]/ul/li[4]/a"));
        qualy.click();
        Thread.sleep(2000);
        driver.quit();
    }
}
