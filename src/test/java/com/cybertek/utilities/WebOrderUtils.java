package com.cybertek.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebOrderUtils {

    public static void loginToSmartBear(WebDriver driver){

        WebElement inputUserName = driver.findElement(By.id("ctl00_MainContent_username"));
        inputUserName.sendKeys("Tester");

        WebElement inputPassword = driver.findElement(By.id("ctl00_MainContent_password"));
        inputPassword.sendKeys("test");

        WebElement loginButton = driver.findElement(By.id("ctl00_MainContent_login_button"));
        loginButton.click();
    }
}
