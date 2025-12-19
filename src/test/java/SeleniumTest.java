import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class SeleniumTest {
    @Test
    public void logintest(){
        WebDriver driver = new ChromeDriver(new ChromeOptions().addArguments("--guest"));
        driver.manage().window().maximize();
        driver.get("http://localhost:3333/");
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement inputusername = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Username")));
        inputusername.sendKeys("employee");
        WebElement inputpassword =wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Password")));
        inputpassword.sendKeys("employee123");
        WebElement clicksubmit = driver.findElement(By.id("submit"));
        clicksubmit.click();
        wait.until(ExpectedConditions.urlToBe("http://localhost:3333/employee"));
        String url = driver.getCurrentUrl();
        Assertions.assertEquals( "http://localhost:3333/employee",url);
    }

    @Test
    public void addtest() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--guest","--disable-notifications","start-maximized");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("http://localhost:3333/");
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement inputusername = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Username")));
        inputusername.sendKeys("employee");
        WebElement inputpassword =wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Password")));
        inputpassword.sendKeys("employee123");
        WebElement clicksubmit = driver.findElement(By.id("submit"));
        clicksubmit.click();
        WebElement clickadd = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("add")));
        clickadd.click();
        WebElement inputname = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name")));
        inputname.sendKeys("demo");
        WebElement inputemail = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
        inputemail.sendKeys("demo@email.com");
        WebElement inputdepartment = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("department")));
        inputdepartment.sendKeys("marketing");
        WebElement inputrole = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("role")));
        inputrole.sendKeys("sr marketing");
        WebElement clickaddemployee = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("add")));
        clickaddemployee.click();
        wait.until(ExpectedConditions.urlToBe("http://localhost:3333/employee"));
        String url = driver.getCurrentUrl();
        Assertions.assertEquals( "http://localhost:3333/employee",url);
    }

    @Test
    public void edittest(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--guest","start-maximized");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("http://localhost:3333/");
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement inputusername = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Username")));
        inputusername.sendKeys("employee");
        WebElement inputpassword =wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Password")));
        inputpassword.sendKeys("employee123");
        WebElement clicksubmit = driver.findElement(By.id("submit"));
        clicksubmit.click();
        WebElement editButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tr[td[text()='demo@email.com']]//button[text()='Edit']")));
        editButton.click();
        WebElement inputname = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name")));
        inputname.clear();
        inputname.sendKeys("demo done");
        WebElement inputemail = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
        inputemail.clear();
        inputemail.sendKeys("demo1@email.com");
        WebElement inputdepartment = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("department")));
        inputdepartment.clear();
        inputdepartment.sendKeys("marketing");
        WebElement inputrole = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("role")));
        inputrole.clear();
        inputrole.sendKeys("Sr Marketing");
        WebElement clickupdate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("update")));
        clickupdate.click();
        wait.until(ExpectedConditions.urlToBe("http://localhost:3333/employee"));
        String url = driver.getCurrentUrl();
        Assertions.assertEquals( "http://localhost:3333/employee",url);
    }

    @Test
    public void deletetest(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--guest","--disable-notifications","start-maximized");
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:3333/");
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement inputusername = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Username")));
        inputusername.sendKeys("employee");
        WebElement inputpassword =wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Password")));
        inputpassword.sendKeys("employee123");
        WebElement clicksubmit = driver.findElement(By.id("submit"));
        clicksubmit.click();
        WebElement clickdelete = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tr[td[text()='harsh@email.com']]//button[text()='Delete']")));
        clickdelete.click();
        wait.until(ExpectedConditions.urlToBe("http://localhost:3333/employee"));
        String url = driver.getCurrentUrl();
        Assertions.assertEquals( "http://localhost:3333/employee",url);
    }
}
