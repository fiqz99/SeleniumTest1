package TestCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class TestCase1 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\stfilip\\Downloads\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        String actual = driver.findElement(By.xpath("//span[@class='title']")).getText();
        String expected = "PRODUCTS";
        Assert.assertEquals(actual, expected, "No match!");

        boolean shoping_cart = driver.findElement(By.id("shopping_cart_container")).isDisplayed();
        Assert.assertEquals(shoping_cart, true, "No match!");

        boolean burger = driver.findElement(By.id("react-burger-menu-btn")).isDisplayed();
        Assert.assertEquals(burger, true, "No match!");

        String actual1 = driver.findElement(By.xpath("//a[@href='https://twitter.com/saucelabs']")).getText();
        Assert.assertEquals(actual1, "Twitter", "No match!");

        driver.findElement(By.id("react-burger-menu-btn")).click();
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
        driver.findElement(By.id("logout_sidebar_link")).click();

        System.out.println("Test passed");
        driver.close();
    }
}
