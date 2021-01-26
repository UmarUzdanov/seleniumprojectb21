package com.cybertek.tests.day4_findElements_checkboxes;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class P2_MerriamWebster_Practice {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.merriam-webster.com/");
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        List<WebElement> allLinks = driver.findElements(By.xpath("//body//a"));


        int linksWithText = 0;
        int linksWithoutText = 0;

        for( WebElement eachLink : allLinks){
            String textOfEachLink = eachLink.getText();
            System.out.println(textOfEachLink);
            if(textOfEachLink.isEmpty()){
                linksWithoutText++;
            }else{
                linksWithText++;
            }
        }
        System.out.println("linksWithoutText = " + linksWithoutText);
        System.out.println("linksWithText = " + linksWithText);
        System.out.println("Total Links = "+(linksWithoutText+linksWithText));
    }
}
