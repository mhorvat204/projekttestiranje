import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Login {

    WebDriver driver;

    public Login(WebDriver localDriver){
        this.driver=localDriver;
    }
    @FindBy(how=How.NAME,using="EmailAddress")
    @CacheLookup
    WebElement email;

    @FindBy(how=How.NAME,using="Password")
    @CacheLookup
    WebElement password;

    @FindBy(how=How.XPATH,using="//*[@id=\"loginDetails\"]/div[3]/button")
    @CacheLookup
    WebElement submit;

public void login(String id,String pw){
    email.sendKeys(id);
    password.sendKeys(pw);
    submit.click();
    }
}
