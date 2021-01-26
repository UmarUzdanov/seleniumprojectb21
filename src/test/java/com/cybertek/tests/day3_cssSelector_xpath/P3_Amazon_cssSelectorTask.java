package com.cybertek.tests.day3_cssSelector_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P3_Amazon_cssSelectorTask {
    public static void main(String[] args) {
       WebDriver driver =  WebDriverFactory.getDriver("chrome");
       driver.get("https://www.amazon.com");
        WebElement amazonSearchBar = driver.findElement(By.cssSelector("input[id='twotabsearchtextbox']"));
        amazonSearchBar.sendKeys("apple"+ Keys.ENTER);
       //driver.close();
        String expectedInTitle = "apple";
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedInTitle)){
            System.out.println("Title contains search key. Verification PASSED");
        }else{
            System.out.println("Title does Not contain search key. Verification FAILED");
            System.out.println("actualTitle = " + actualTitle);
            System.out.println("expectedInTitle = " + expectedInTitle);
        }
    }
}
