package lab05;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class UVicTest {

    WebDriver browser;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/home/ishatanwar/Downloads/chromedriver");
        browser = new ChromeDriver();
        browser.manage().window().maximize();
    }

    @AfterEach
    public void cleanUp() {
        browser.quit();
    }


    // Your tests go here
    @Test
    public void UVicPageLoads() {
        browser.get("https://www.uvic.ca/");
        assertEquals("Home - University of Victoria", browser.getTitle()); //checks if title is correct
    }

    @Test
    public void UVicSearchBoxAppears() {
        browser.get("https://www.uvic.ca/");
        WebElement button = browser.findElement(By.xpath("//*[@id=\"search-btn\"]/i"));
        assertTrue(button.isEnabled()); //checks if the element present
    }
    @Test
    public void UVicSearchBarAppears() {
        browser.get("https://www.uvic.ca/");
        WebElement button = browser.findElement(By.xpath("//*[@id=\"search-btn\"]/i"));
        button.click();
        WebElement searchBar = browser.findElement(By.xpath("//*[@id=\"searchUVic\"]"));
        assertTrue(searchBar.isEnabled()); //checks if the element present
    }

    @Test
    public void UVicSearchTermAppears() {
        browser.get("https://www.uvic.ca/");
        WebElement button = browser.findElement(By.xpath("//*[@id=\"search-btn\"]"));
        button.click();
        WebElement searchBar = browser.findElement(By.xpath("//*[@id=\"searchUVic\"]"));
        searchBar.sendKeys("csc");
        assertEquals("csc", searchBar.getAttribute("value")); //Checks if we typed anything
    }

    @Test
    public void UVicSearchResultsAppear() {
        browser.get("https://www.uvic.ca/");
        WebElement button = browser.findElement(By.xpath("//*[@id=\"search-btn\"]"));
        button.click();
        WebElement inputBox = browser.findElement(By.xpath("//*[@id=\"searchUVic\"]"));
        inputBox.sendKeys("csc");
        assertEquals("csc", inputBox.getAttribute("value"));
        WebElement button2 = browser.findElement(By.xpath("//*[@id=\"searchMain\"]/div/div/form/div/button/i"));
        button2.click();
        new WebDriverWait(browser, 5).until(ExpectedConditions.titleIs("Search - University of Victoria"));
        assertEquals("Search - University of Victoria", browser.getTitle()); //checks if title is correct
    }

    @Test
    public void UVicPhoneNumberCheck() {
        browser.get("https://www.uvic.ca/");
        WebElement PhoneNumber = browser.findElement(By.xpath("/html/body/footer/div/div[3]/div/div/div[2]/div/div[1]/ul/li[1]/a"));
        assertEquals("1-250-721-7211", PhoneNumber.getText());
    }

}
