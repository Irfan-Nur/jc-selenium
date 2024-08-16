package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TextBox {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\irfan\\Documents\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/text-box");
        System.out.println("Opern Browser URL");
        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.manage().window().maximize();
        js.executeScript("window.scrollBy(0,300)");
        driver.findElement(By.id("userName")).sendKeys("Juara Coding");
        driver.findElement(By.id("userEmail")).sendKeys("Juaracoding@gmail.com");
        driver.findElement(By.id("currentAddress")).sendKeys("JL.Juara Coding no 15");
        driver.findElement(By.id("permanentAddress")).sendKeys("JL.Juara Coding no 15");
        driver.findElement(By.id("submit")).click();

        System.out.println("Search Keyword");

        //Menahan penutupan browserA
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
        System.out.println("Exit Browser");
    }
}