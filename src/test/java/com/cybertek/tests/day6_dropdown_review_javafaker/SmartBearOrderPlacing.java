package com.cybertek.tests.day6_dropdown_review_javafaker;

import com.cybertek.utilities.WebDriverFactory;
import com.cybertek.utilities.WebOrderUtils;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SmartBearOrderPlacing {

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
    public void software_Order_Placing(){
        WebElement orderButton = driver.findElement(By.xpath("//a[.='Order']"));
        orderButton.click();
        Select productDropdown = new Select(driver.findElement(By.id("ctl00_MainContent_fmwOrder_ddlProduct")));
        productDropdown.selectByVisibleText("FamilyAlbum");
        WebElement inputQuantity = driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity"));

        //inputQuantity.clear();
        inputQuantity.sendKeys(Keys.BACK_SPACE);
        inputQuantity.sendKeys("2");

        WebElement calculateButton = driver.findElement(By.xpath("//input[@value='Calculate']"));
        calculateButton.click();



        WebElement nameInput = driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtName"));

        WebElement streetInput = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox2"));

        WebElement cityAddress = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox3"));

        WebElement zipCode = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5"));

        Faker faker = new Faker();

        nameInput.sendKeys(faker.name().fullName());
        streetInput.sendKeys(faker.address().streetAddress());
        cityAddress.sendKeys(faker.address().cityName());
        zipCode.sendKeys(faker.address().zipCode().replaceAll("-",""));

        WebElement visaRadioButton = driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_0"));
        visaRadioButton.click();

        WebElement inputCreditCard = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6"));
        inputCreditCard.sendKeys(faker.finance().creditCard().replaceAll("-",""));

        WebElement experationDate = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox1"));
        experationDate.sendKeys("01/26");

        WebElement processButton = driver.findElement(By.linkText("Process"));
        processButton.click();

        WebElement successMessage = driver.findElement(By.xpath("//div[@class='buttons_process']/strong"));

        Assert.assertTrue(successMessage.isDisplayed(), "Success message is NOT displayed!!!");


    }
}
