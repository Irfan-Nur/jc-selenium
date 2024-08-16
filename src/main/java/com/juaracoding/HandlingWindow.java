package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class HandlingWindow {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\irfan\\Documents\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/browser-windows");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        System.out.println("Opern Browser URL");

        //web scraping
        String txtTitle = driver.findElement(By.className("txt-center")).getText();
        System.out.println(txtTitle);
        WebElement btnNewTab = driver.findElement(By.id("tabButton"));
        btnNewTab.click();

        ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(newTab.get(1));
        String currentUrl = driver.getCurrentUrl(); //actual
        String expected = "https://demoqa.com/sample";
        System.out.println(currentUrl);

        //Assert use IF
        costumAssertEquals(currentUrl,expected);

        delay(2);
        driver.switchTo().window(newTab.get(0));
        String tabTitle = driver.getTitle(); //actual
        System.out.println(tabTitle);
        String expectedTtitle = "DEMOQA";
        //Assert
        costumAssertEquals(tabTitle, expectedTtitle);

        delay(3);

        driver.quit();
    }
    public static void delay (long detik){
        try {
            Thread.sleep(detik*1000);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }
    public static void costumAssertEquals (String actal, String expected){
        System.out.println("Test Result: ");
        if (actal.equals(expected)){
            System.out.println("Passed");
        }else {
            System.out.println("Failed");
        }

    }
}
