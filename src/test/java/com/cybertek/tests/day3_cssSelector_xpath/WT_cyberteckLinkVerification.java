package com.cybertek.tests.day3_cssSelector_xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WT_cyberteckLinkVerification {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/forgot_password");
        driver.findElement(By.name("email")).sendKeys("anything@anydomain.com");
        driver.findElement(By.id("form_submit")).click();
        String expectedInUrl = "email_sent";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedInUrl)){
            System.out.println("URL verification PASSED");
        }else {
            System.out.println("URL verification FAILED");
            System.out.println("actualUrl = " + actualUrl);
            System.out.println("expectedInUrl = " + expectedInUrl);
        }

        WebElement conformation_message = driver.findElement(By.name("confirmation_message"));

        if (conformation_message.isDisplayed()){
            System.out.println("Conformation message is displayed");
        }else{
            System.out.println("Conformation message is NOT displayed");
        }
        String expectedMessage = "Your e-mail's been sent!";
        String actualMessage = conformation_message.getText();
        
        if (actualMessage.equals(expectedMessage)){
            System.out.println("Message verification PASSED");
        }else{
            System.out.println("Message verification FAILED");
            System.out.println("expectedMessage = " + expectedMessage);
            System.out.println("actualMessage = " + actualMessage);
        }
        driver.close();
    }
}
