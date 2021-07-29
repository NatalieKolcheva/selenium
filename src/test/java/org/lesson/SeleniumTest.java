package org.lesson;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SeleniumTest {

    WebDriver driver;

    @Before
    public void start() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test //description = "Verify that user can successfully login with the valid username and password"
    public void test1(){
       driver.get("https://training.by/");
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       WebElement signInButton =driver.findElement(By.className("header-auth__signin"));
       signInButton.click();
       WebElement inputUserName = driver.findElement(By.id("username"));
       inputUserName.sendKeys("natalykolcheva@gmail.com");
       WebElement continueButton = driver.findElement(By.id("kc-login-next"));
       continueButton.click();
       WebElement passwordInput = driver.findElement(By.id("password"));
       passwordInput.sendKeys("Forepam1");
       WebElement  signInButtonPasswordWindow = driver.findElement(By.id("kc-login"));
       signInButtonPasswordWindow.click();
       WebElement userName = driver.findElement(By.className("user-info__name"));
       Assert.assertTrue("Username is displayed", userName.isDisplayed());

    }
    @Test //description = "Verify that user can't login with the valid username and not valid password"
    public void test2() throws InterruptedException {
        driver.get("https://training.by/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement signInButton =driver.findElement(By.className("header-auth__signin"));
        signInButton.click();
        WebElement inputUserName = driver.findElement(By.id("username"));
        inputUserName.sendKeys("natalykolcheva@gmail.com");
        WebElement continueButton = driver.findElement(By.id("kc-login-next"));
        continueButton.click();
        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys("Forepam");
        WebElement  signInButtonPasswordWindow = driver.findElement(By.id("kc-login"));
        signInButtonPasswordWindow.click();
        WebElement errorMessage = driver.findElement(By.className("error-text"));
        Thread.sleep(2000);
        Assert.assertTrue("Username is not displayed", errorMessage.isDisplayed());
    }

    @After
    public void end() {
        driver.quit();
    }

}
