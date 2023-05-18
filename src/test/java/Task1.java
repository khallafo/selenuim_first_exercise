import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Task1 {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void testPageTitle() {

        // Go to the website
        driver.get("https://www.techlistic.com/p/selenium-practice-form.html");

        // Initialize the Page Object Model
        SeleniumPracticeFormPage page = new SeleniumPracticeFormPage(driver);

        // Enter the first name
        page.firstNameInput.sendKeys("lofa");

        // Enter the last name
        page.lastNameInput.sendKeys("ucar");

        // Select the male gender
        page.maleRadioButton.click();

        // Select the 1 year experience
        page.oneYearExperienceRadioButton.click();

        // Enter the date of birth
        page.dateOfBirthInput.sendKeys("10/04/2019");

        // Select the profession
        page.professionDropdown.click();
        page.professionDropdown.findElement(By.xpath("//*[@id=\"profession-1\"]")).click();

        // Select the programming language
        page.programmingLanguageDropdown.click();
        page.programmingLanguageDropdown.findElement(By.xpath("//*[@id=\"tool-2\"]")).click();

        // Select the Selenium command
        page.seleniumCommandDropdown.click();
        page.seleniumCommandDropdown.findElement(By.cssSelector("#selenium_commands > option:nth-child(5)")).click();

        // Click the submit button
        page.submitButton.click();

        // Assert that the page title is correct
        Assert.assertEquals(driver.getTitle(), "Selenium Practice Form");
    }

    @AfterClass
    public void tearDown() {
        // Close the browser
        driver.quit();
    }

    private class SeleniumPracticeFormPage {

        private WebDriver driver;

        private WebElement firstNameInput;
        private WebElement lastNameInput;
        private WebElement maleRadioButton;
        private WebElement oneYearExperienceRadioButton;
        private WebElement dateOfBirthInput;
        private WebElement professionDropdown;
        private WebElement programmingLanguageDropdown;
        private WebElement seleniumCommandDropdown;
        private WebElement submitButton;

        public SeleniumPracticeFormPage(WebDriver driver) {
            this.driver = driver;

            // Find the elements on the page
            firstNameInput = driver.findElement(By.name("firstname"));
            lastNameInput = driver.findElement(By.name("lastname"));
            maleRadioButton = driver.findElement(By.xpath("//*[@id=\"sex-0\"]"));
            oneYearExperienceRadioButton = driver.findElement(By.xpath("//*[@id=\"exp-0\"]"));
            dateOfBirthInput = driver.findElement(By.id("datepicker"));
            professionDropdown = driver.findElement(By.id("profession-1"));
            programmingLanguageDropdown = driver.findElement(By.id("tool-2"));
            seleniumCommandDropdown = driver.findElement(By.id("selenium_commands"));
            submitButton = driver.findElement(By.id("submit"));
        }
    }
}
