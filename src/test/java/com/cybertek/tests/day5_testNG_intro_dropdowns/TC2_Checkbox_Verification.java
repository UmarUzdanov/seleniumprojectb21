package com.cybertek.tests.day5_testNG_intro_dropdowns;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class TC2_Checkbox_Verification {
    public static void main(String[] args) {
        //1. Open Chrome browser




        WebDriver driver = WebDriverFactory.getDriver("chrome");
        //2. Go to https://www.seleniumeasy.com/test/basic-checkbox-demo.html
        driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        //3. Verify “Success – Check box is checked” message is NOT displayed.

        WebElement successMessage = driver.findElement(By.xpath("//div[@id='txtAge']"));
        //                                                       //div[@style='display: none;']
        //                                                       //div[text()='Success - Check box is checked']

        WebElement checkbox1 = driver.findElement(By.xpath("//input[@id='isAgeSelected']"));
        if ( !checkbox1.isSelected()&& !successMessage.isDisplayed()){
            System.out.println("Checkbox is not selected. Message is not displayed. Verification Passes");
        } else {
            System.out.println("Failed");
        }
        checkbox1.click();
        if ( checkbox1.isSelected()&& successMessage.isDisplayed()){
            System.out.println("Checkbox is selected. Message is displayed. Verification Passes");
        } else {
            System.out.println("Failed");
        }

        driver.close();
        //4. Click to checkbox under “Single Checkbox Demo” section
        //5. Verify “Success – Check box is checked” message is displayed.
    }
}
