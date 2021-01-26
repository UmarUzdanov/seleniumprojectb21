package com.cybertek.tests.day6_dropdown_review_javafaker;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class DropdownTasks {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        driver =WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @Test
    public void test2_verify_state_dropdown(){

        Select stateDropdown = new Select(driver.findElement(By.xpath("//select[@id='state']")));
        stateDropdown.selectByVisibleText("Illinois");
        stateDropdown.selectByValue("VA");
        stateDropdown.selectByIndex(5);
        String expectedOption = "California";
        String actualOption = stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption,expectedOption , "Final selected option is not as expected");

    }
    @Test
    public void test3_date_dropdown_verification() throws InterruptedException {

        //We need to locate all the dropdowns to be able to select options
        Select yearDropdown = new Select(driver.findElement(By.xpath("//select[@id='year']")));
        Select monthDropdown = new Select(driver.findElement(By.xpath("//select[@id='month']")));
        Select dayDropdown = new Select(driver.findElement(By.xpath("//select[@id='day']")));

        Thread.sleep(1000);
        yearDropdown.selectByVisibleText("1922");
        monthDropdown.selectByValue("11");
        dayDropdown.selectByIndex(0);

        String expectedYear = "1922";
        String expectedMonth = "December";
        String expectedDay = "1";

        String actualYear = yearDropdown.getFirstSelectedOption().getText();
        String actualMonth = monthDropdown.getFirstSelectedOption().getText();
        String actualDay = dayDropdown.getFirstSelectedOption().getText();

        Assert.assertEquals(actualYear,expectedYear);
        Assert.assertEquals(actualMonth,expectedMonth);
        Assert.assertEquals(actualDay,expectedDay);


    }

    @Test
    public void test4_multiple_select_dropdown(){
        Select multipleSelectDropdown = new Select(driver.findElement(By.xpath("//select[@name='Languages']")));

        List<WebElement> allOptions = multipleSelectDropdown.getOptions();


        // iter short cut for:each loop
        for (WebElement each : allOptions) {
            each.click();
            System.out.println("Selected: "+each.getText());
            // Verifying that each option is selected
            Assert.assertTrue(each.isSelected(), "The option " +each.getText()+" is not selected!");
        }

        multipleSelectDropdown.deselectAll();

        for (WebElement each : allOptions) {
           // Assert.assertTrue( ! each.isSelected());
            Assert.assertFalse(each.isSelected()); //  // if expected result is false use assertFalse
        }
    }

    @Test
    public void Test5_non_select_dropdown(){

        WebElement websiteDropdown = driver.findElement(By.xpath("//a[@id='dropdownMenuLink']"));
        websiteDropdown.click();
        WebElement facebookLink = driver.findElement(By.xpath("//a[.='Facebook']"));
        facebookLink.click();

        String expectedTitle = "Facebook - Log In or Sign Up";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle, expectedTitle, "Title is not as expected!!!");



    }

    @AfterMethod
    public void tearDownMethod() throws InterruptedException {
        Thread.sleep(4000);
        driver.close();
    }
}
