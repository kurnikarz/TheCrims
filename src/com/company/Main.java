package com.company;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import java.awt.*;
import java.io.IOException;
import java.time.Duration;


public class Main {



    public static void theCrims(String username, String password) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "E:\\TheCrims\\chromedriver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        ChromeDriver driver = new ChromeDriver(options);
        WebDriverWait wait = new WebDriverWait(driver, 20000);

        driver.get("https://www.thecrims.com/");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"loginform\"]/input[1]")).sendKeys(username);
        driver.findElement(By.xpath("//*[@id=\"loginform\"]/input[2]")).sendKeys(username);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"loginform\"]/button")).click();
        Thread.sleep(3000);

        Select robber = new Select(driver.findElement(By.xpath("//*[@id=\"singlerobbery-select-robbery\"]")));
        robber.selectByIndex(12);
        driver.findElement(By.xpath("//*[@id=\"full\"]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"singlerobbery-rob\"]")).click();
        Thread.sleep(3000);

        driver.get("https://www.thecrims.com/newspaper#/nightlife/nightclub");
        Thread.sleep(3000);
        try {
            driver.findElement(By.xpath("/html/body/div[2]/div[4]/div/table/tbody/tr/td[1]/div[2]/table/tbody/tr/td/div[2]/div/div[3]/div[2]/ul[2]/li[1]/div/div[2]/button")).click();
        } catch (Exception e) {
            try {
                driver.findElement(By.xpath("/html/body/div[2]/div[4]/div/table/tbody/tr/td[1]/div[2]/table/tbody/tr/td/div[2]/div/div[3]/div[2]/ul[3]/li[1]/div/div[2]/button")).click();
            } catch (Exception f) {
                driver.findElement(By.xpath("/html/body/div[2]/div[4]/div/table/tbody/tr/td[1]/div[2]/table/tbody/tr/td/div[2]/div/div[3]/div[2]/ul[4]/li[1]/div/div[2]/button")).click();
            }
        }
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[2]/div[4]/div/table/tbody/tr/td[1]/div[2]/table/tbody/tr/td/div[2]/div/div[3]/table[2]/tbody/tr/td[4]/button")).click();
        Thread.sleep(1000);
        Thread.sleep(7000);

        for (; ; ) {
            driver.findElement(By.xpath("//*[@id=\"menu-robbery\"]")).click();
            Thread.sleep(3000);

            Select robber2 = new Select(driver.findElement(By.xpath("//*[@id=\"singlerobbery-select-robbery\"]")));
            robber2.selectByIndex(12);
            Thread.sleep(1000);
            driver.findElement(By.xpath("//*[@id=\"singlerobbery-rob\"]")).click();
            Thread.sleep(3000);

            driver.get("https://www.thecrims.com/newspaper#/nightlife/nightclub");
            Thread.sleep(3000);
            try {
                driver.findElement(By.xpath("/html/body/div[2]/div[4]/div/table/tbody/tr/td[1]/div[2]/table/tbody/tr/td/div[2]/div/div[3]/div[2]/ul[2]/li[1]/div/div[2]/button")).click();
            } catch (Exception e) {
                try {
                    try {
                        driver.findElement(By.xpath("/html/body/div[2]/div[4]/div/table/tbody/tr/td[1]/div[2]/table/tbody/tr/td/div[2]/div/div[3]/div[2]/ul[3]/li[1]/div/div[2]/button")).click();
                    } catch (Exception g) {
                        driver.findElement(By.xpath("/html/body/div[2]/div[4]/div/table/tbody/tr/td[1]/div[2]/table/tbody/tr/td/div[2]/div/div[3]/div[2]/ul[2]/li[1]/div/div[2]/button")).click();
                    }
                } catch (Exception f) {
                    driver.findElement(By.xpath("/html/body/div[2]/div[4]/div/table/tbody/tr/td[1]/div[2]/table/tbody/tr/td/div[2]/div/div[3]/div[2]/ul[4]/li[1]/div/div[2]/button")).click();
                }
            }
            Thread.sleep(2000);
            driver.findElement(By.xpath("/html/body/div[2]/div[4]/div/table/tbody/tr/td[1]/div[2]/table/tbody/tr/td/div[2]/div/div[3]/table[2]/tbody/tr/td[4]/button")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("/html/body/div[2]/div[4]/div/table/tbody/tr/td[1]/div[2]/table/tbody/tr/td/div[2]/div/div[3]/div[2]/button")).click();
            Thread.sleep(2000);
        }


    }

    public static void main(String[] args) throws InterruptedException, IOException, AWTException {
        TheCrims theCrims = new TheCrims("TestSel","4a452063b62b");
        theCrims.zaloguj();
        theCrims.rabunek(2,0);
    }
}
