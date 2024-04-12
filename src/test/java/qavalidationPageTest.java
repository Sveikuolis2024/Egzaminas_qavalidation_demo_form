import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class qavalidationPageTest {
    WebDriver driver;


    @BeforeEach
    void beforeTest() {
        driver = new ChromeDriver();
        driver.get("https://qavalidation.com/demo-form/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.manage().window().maximize();
    }

    @Test
    void allCorrectInputFields() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Thread.sleep(2000);
        WebElement element = driver.findElement(By.cssSelector("label[for='g4072-fullname']"));
        js.executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(By.cssSelector("#g4072-fullname")).sendKeys("New Newton");
        driver.findElement(By.cssSelector("#g4072-email")).sendKeys("new@newton.com");
        driver.findElement(By.cssSelector("#g4072-phonenumber")).sendKeys("867543210");

        WebElement dropdown = driver.findElement(By.cssSelector("#g4072-gender"));
        Select selectDropdown = new Select(dropdown);
        selectDropdown.selectByVisibleText("Male");

        driver.findElement(By.cssSelector("#g4072-yearsofexperience-1")).click();

        WebElement elementSkills = driver.findElement(By.xpath("//legend[normalize-space()='Skills']"));
        js.executeScript("arguments[0].scrollIntoView();", elementSkills);
        driver.findElement(By.xpath("//input[@id='g4072-skills-Functional testing']")).click();
        driver.findElement(By.xpath("//input[@id='g4072-skills-Automation testing']")).click();

        WebElement dropdownQATools = driver.findElement(By.id("g4072-qatools"));
        Select selectDropdownQATools = new Select(dropdownQATools);
        selectDropdownQATools.selectByVisibleText("Selenium");
    }
        @AfterEach
        void closeTest() {
            driver.quit();
        }
}
