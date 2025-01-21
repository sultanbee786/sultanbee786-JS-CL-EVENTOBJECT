import static org.junit.Assert.assertEquals;

import java.io.File;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumTest {

    private WebDriver webDriver;

    @Before
    public void setUp() {
        // Set up ChromeDriver path
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");//linux_64

        // Get file
        File file = new File("src/main/EventObject.html");
        String path = "file://" + file.getAbsolutePath();

        // Create a new ChromeDriver instance
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        webDriver = new ChromeDriver(options);

        // Open the HTML file
        webDriver.get(path);
    }

    @Test
    public void testClickParagraph() {

        // Find a p tag and click it
        WebElement paragraph = webDriver.findElement(By.tagName("p"));
        paragraph.click();

        // assert that the content field was updated:
        WebElement content = webDriver.findElement(By.id("content"));

        Assert.assertEquals("[object HTMLParagraphElement]", content.getText());
    }

    @Test
    public void testClickButton() {

        // Find a button tag and click it
        WebElement button = webDriver.findElement(By.tagName("button"));
        button.click();

        // assert that the content field was updated:
        WebElement content = webDriver.findElement(By.id("content"));

        Assert.assertEquals("[object HTMLButtonElement]", content.getText());
    }

    @Test
    public void testClickHeader() {

        // Find a header tag and click it
        WebElement header = webDriver.findElement(By.tagName("h1"));
        header.click();

        // assert that the content field was updated:
        WebElement content = webDriver.findElement(By.id("content"));

        Assert.assertEquals("[object HTMLHeadingElement]", content.getText());
    }


    @Test
    public void testClickAnchor() {

        // Find anchor tag and click it
        WebElement anchor = webDriver.findElement(By.tagName("a"));
        anchor.click();

        // assert that the content field was updated:
        WebElement content = webDriver.findElement(By.id("content"));

        Assert.assertEquals("https://developer.mozilla.org/en-US/docs/Web/API/Event", content.getText());
    }




    @After
    public void tearDown() {
        // Close the browser
        webDriver.quit();
    }
}
