package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class HandlingFrame {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\irfan\\Documents\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/frames");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.body.style.zoom='80%'");
        js.executeScript("window.scrollBy(0,200)");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        System.out.println("Opern Browser URL");

        //web scraping
        String txtTitle = driver.findElement(By.className("text-center")).getText();
        System.out.println(txtTitle);

        //switch to Frames
        WebElement frame1 = driver.findElement(By.id("frame1"));
        //sampleHandling
        String txtSampleHeading = driver.findElement(By.cssSelector("#sampleHeading")).getText();
        System.out.println(txtSampleHeading);

        //default content
        driver.switchTo().defaultContent();
        delay(3);
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

