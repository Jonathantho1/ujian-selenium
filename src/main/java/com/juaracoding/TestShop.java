package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TestShop {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","D:\\bootcamp\\chromedriver-win64\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://juice-shop.herokuapp.com/#/");
        driver.manage().window().maximize();

        //locator pop-up
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"mat-dialog-0\"]/app-welcome-banner/div/div[2]/button[2]")).click();

        //login
        driver.findElement(By.id("navbarAccount")).click();
        driver.findElement(By.id("navbarLoginButton")).click();

        //input username and password
        driver.findElement(By.id("email")).sendKeys("thoyerjoy@gmail.com");
        //email validation
        if( driver.findElement(By.id("email")).getAttribute("value").equalsIgnoreCase("thoyerjoy@gmail.com")){
            System.out.println("email status is true");
        }else {
            System.out.println("email status is false");
        }

        driver.findElement(By.id("password")).sendKeys("123456");
        //password validation
        if( driver.findElement(By.id("password")).getAttribute("value").equals("123456")){
            System.out.println("password status is true");
        }else {
            System.out.println("password status is false");
        }

        driver.findElement(By.id("loginButton")).click();
        //loginButton Validation
        if (driver.findElement(By.id("loginButton")).isEnabled()) {
            System.out.println("Login button pressed");
        }else {
            System.out.println("Login button failed");
        }

        //add product
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement addProduct =  driver.findElement(By.xpath("/html/body/app-root/div/mat-sidenav-container/mat-sidenav-content/app-search-result/div/div/div[2]/mat-grid-list/div/mat-grid-tile[2]/div/mat-card/div[2]/button"));
        addProduct.click();

        //addProduct Validation
        if(addProduct.isEnabled()){
            System.out.println("button add product pressed");
        }else {
            System.out.println("button add product failed");
        }

        delay(3);
        driver.quit();
    }

    static void delay(long sec){
        try {
            Thread.sleep(sec*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
