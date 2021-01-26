package com.cybertek.tests.day6_dropdown_review_javafaker;

import com.cybertek.utilities.WebDriverFactory;
import com.cybertek.utilities.WebOrderUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebOrderPractices {


    WebDriver driver;
    @BeforeMethod
    public void setupMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebOrderUtils.loginToSmartBear(driver);
    }


    @Test
    public void test1_link_verifications(){

       // getting all the links on the landing page
        List<WebElement> allLinks = driver.findElements(By.xpath("//body//a"));
        System.out.println("Number of all links on this page: "+allLinks.size());

        for (WebElement each : allLinks) {
            System.out.println("EachLink: "+each.getText());
        }

    }


    @AfterMethod
    public void tearDownMethod() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }
}
