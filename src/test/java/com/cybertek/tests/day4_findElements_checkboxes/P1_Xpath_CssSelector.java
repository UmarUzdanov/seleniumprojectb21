package com.cybertek.tests.day4_findElements_checkboxes;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P1_Xpath_CssSelector {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/forgot_password");
        WebElement homeLink = driver.findElement(By.xpath("//a[='Home']"));
        WebElement forgotPasswordHeader = driver.findElement(By.xpath("//h2[.='Forgot Password']"));
        WebElement emailLabel = driver.findElement(By.xpath("//label[.='E-mail']"));
        WebElement emailInputBox = driver.findElement(By.cssSelector("input[type='text']"));
        WebElement retrievePasswordButton = driver.findElement(By.cssSelector("button.radius"));
        WebElement poweredByCybertekSchool  =driver.findElement(By.xpath("//div[@style='text-align: center;']"));

        if(homeLink.isDisplayed() && forgotPasswordHeader.isDisplayed() && emailInputBox.isDisplayed()&& emailLabel.isDisplayed()&&retrievePasswordButton.isDisplayed()&&poweredByCybertekSchool.isDisplayed()){
            System.out.println("All web elements are displayed. Verification Passed!");
        }else{
            System.out.println("One ore more web elements are not displayed. Verification Failed!!!");
        }
    }
}
