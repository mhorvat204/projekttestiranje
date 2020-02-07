import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

    public class HomePage {

        private static WebElement element = null;
        public static WebElement Account(WebDriver driver){
            element = driver.findElement(By.xpath("/html/body/header/div[1]/ul/li[1]"));
            return element;

        }

}
