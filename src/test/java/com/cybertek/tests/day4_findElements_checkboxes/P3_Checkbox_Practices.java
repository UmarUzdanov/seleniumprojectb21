package com.cybertek.tests.day4_findElements_checkboxes;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class P3_Checkbox_Practices {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/checkboxes");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement checkBox1 = driver.findElement(By.xpath("//input[@type='checkbox'][1]"));
        WebElement checkBox2 = driver.findElement(By.xpath("//input[@type='checkbox'][2]"));

        if(!checkBox1.isSelected()){
            System.out.println("Checkbox #1 is NOT selected. Default value Verification Passed");
        }else{
            System.out.println("Checkbox #1 is selected. Default value Verification Failed");
        }
        if(checkBox2.isSelected()){
            System.out.println("Checkbox #2 is selected. Default value Verification Passed");
        }else{
            System.out.println("Checkbox #2 is NOT selected. Default value Verification Failed");
        }
        Thread.sleep(2000);
        checkBox1.click();
        Thread.sleep(2000);
        checkBox2.click();

        if(checkBox1.isSelected()){
            System.out.println("Checkbox #1 is selected. Verification Passed");
        }else{
            System.out.println("Checkbox #1 is NOT selected. Verification Failed");
        }
        if(!checkBox2.isSelected()){
            System.out.println("Checkbox #2 is not selected. Passed");
        }else{
            System.out.println("Failed");
        }

        driver.findElement(By.linkText("Home")).click();

        driver.navigate().back();


        checkBox1 = driver.findElement(By.xpath("//input[@type='checkbox'][1]")); // refreshing element
        checkBox1.click();
    }
}
