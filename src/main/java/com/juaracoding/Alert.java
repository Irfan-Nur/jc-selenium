package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Alert {public static void main(String[] args) {

    System.setProperty("webdriver.chrome.driver","C:\\Users\\irfan\\Documents\\chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    driver.get("https://demoqa.com/alerts");
    driver.manage().window().maximize();
    JavascriptExecutor js = (JavascriptExecutor) driver;
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    System.out.println("Opern Browser URL");

    js.executeScript("window.scrollBy(0,200)");
    driver.manage().window().maximize();

    //web scraping
    String txtTitle = driver.findElement(By.className("text-center")).getText();
    System.out.println(txtTitle);

    driver.findElement(By.id("alertButton")).click();
    delay(1);
    driver.switchTo().alert().accept();
    System.out.println("alertButton");

    driver.findElement(By.id("timerAlertButton")).click();
    delay(5);
    try {
        driver.switchTo().alert().accept();
        System.out.println("Timer Alert Button");
    }catch (Exception e){
        e.printStackTrace();
    }

    //confirmButton promtButtom
    driver.findElement(By.id("confirmButton")).click();
    delay(1);
    driver.switchTo().alert().dismiss();
    System.out.println("confirmButton");

    driver.findElement(By.id("promtButton")).click();
    delay(1);
    driver.switchTo().alert().dismiss();
    driver.switchTo().alert().sendKeys("Indonesia");
    driver.switchTo().alert().accept();
    System.out.println("Promnt Button");


    driver.quit();
    System.out.println("Exit Browser");



}
    public static void delay (long detik){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
