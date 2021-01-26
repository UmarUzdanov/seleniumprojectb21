package com.cybertek.tests.day3_cssSelector_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P2_ZeroBankVerification {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
      //  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://zero.webappsecurity.com/login.html");
        WebElement zeroBankLink = driver.findElement(By.className("brand"));

        String expectedLinkText = "Zero Bank";
        String actualLinkText = zeroBankLink.getText();

        if(actualLinkText.equals(expectedLinkText)){
            System.out.println("Link TEXT verification PASSED");
        }else{
            System.out.println("Link TEST verification FAILED");
            System.out.println("actualLinkText = " + actualLinkText);
            System.out.println("expectedLinkText = " + expectedLinkText);
        }
        String expectedInHref = "index.html";
        String actualHref = zeroBankLink.getAttribute("href");

        if (actualHref.contains(expectedInHref)){
            System.out.println("HREF verification PASSED");
        }else {

            System.out.println("HREF verification FAILED");
            System.out.println("expectedInHref = " + expectedInHref);
            System.out.println("actualHref = " + actualHref);
        }
    }
}
