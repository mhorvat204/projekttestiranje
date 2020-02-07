import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login {

    private static WebElement element = null;

    public static WebElement UserName(WebDriver driver){
        element = driver.findElement(By.xpath("/html/body/section[2]/div/div/div/section[2]/div/form/div[1]/input[1]"));
        return element;
    }

    public static WebElement Password(WebDriver driver){
        element = driver.findElement(By.xpath("/html/body/section[2]/div/div/div/section[2]/div/form/div[1]/input[2]"));
        return element;
    }

    public static WebElement LogIn(WebDriver driver){
        element = driver.findElement(By.xpath("/html/body/section[2]/div/div/div/section[2]/div/form/div[3]/button"));
        return element;

    }
}
