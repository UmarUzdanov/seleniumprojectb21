package com.cybertek.tests.practice;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddRemoveElementsWebElementVerificatio {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/add_remove_elements/");
        driver.manage().window().maximize();
        WebElement addButton = driver.findElement(By.xpath("//button['addElement()']"));
        addButton.click();
       // WebElement deleteDisplayed = driver.findElement(By.xpath("//button[.='Delete']"));
        WebElement deleteButton = driver.findElement(By.xpath("//button[.='Delete']"));

        if (deleteButton.isDisplayed()){
            System.out.println("Delete button is displayed. Verification Passed");
        }else{
            System.out.println("Delete button is not displayed. Verification Failed");
        }


        try{
            deleteButton.click();
            if(!deleteButton.isDisplayed()){
                System.out.println("Delete button is NOT displayed after clicking. PASS");
            }else{
                System.out.println("Delete button  is displayed after clicking. FAILED");
        }

        }catch (StaleElementReferenceException e){
            System.out.println("Stale element was thrown");
            System.out.println("It means element was deleted");
            System.out.println("Element is deleted. Delete button is not displayed");
        }
        driver.close();
    }
}
