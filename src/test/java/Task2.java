import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Task2 {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    @Test
    public void testPageTitle() {
        driver.get("https://www.techlistic.com/");

        driver.manage().window().maximize();
        //sleep(2000);
        driver.findElement(By.cssSelector("#LinkList3>.widget-content>ul>li:nth-child(4)>a")).click();
        driver.navigate().back();
        driver.findElement(By.cssSelector("#LinkList3>.widget-content>ul>li:nth-of-type(1)")).click();
        driver.navigate().back();
        driver.findElement(By.cssSelector("#LinkList2>.widget-content>ul>li:nth-of-type(5)")).click();
        driver.navigate().back();
        driver.findElement(By.cssSelector("#LinkList3>.widget-content>ul>li:nth-of-type(2)")).click();
    }
}
