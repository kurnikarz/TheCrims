package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;

public class TheCrims {

//    private static final String driverOption = "webdriver.gecko.driver";
        private static final String driverOption = "webdriver.chrome.driver";
    private static final String driverPath = "E:\\TheCrims\\chromedriver\\chromedriver.exe";
//    private static final String driverPath = "E:\\TheCrims\\geckodriver\\\\geckodriver.exe";

    private String username;
    private String password;
    private WebDriver driver;
    private WebDriverWait wait;

    public TheCrims(String username, String password) {
        System.setProperty(driverOption, driverPath);
        ChromeOptions options = new ChromeOptions();
        HashMap<String, Object> images = new HashMap<String,Object>();
        HashMap<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.default_content_setting_values",images);
        options.setExperimentalOption("prefs", prefs);
//        FirefoxProfile profile = new FirefoxProfile();
//        profile.setPreference("permissions.default.image", 2);// # Image load disabled again

        this.driver = new ChromeDriver(options);
        this.wait = new WebDriverWait(driver, 20);
        driver.manage().window().maximize();

        this.username = username;
        this.password = password;
    }

    public void zaloguj() throws InterruptedException {
        driver.get("https://www.thecrims.com/");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"loginform\"]/input[1]")).sendKeys(this.username);
        driver.findElement(By.xpath("//*[@id=\"loginform\"]/input[2]")).sendKeys(this.password);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"loginform\"]/button")).click();
    }

    public void rabunek(int idRabunku, int ileRazy) throws InterruptedException {
        double loop;
        if (ileRazy == 0)
            loop = Double.POSITIVE_INFINITY;
        else
            loop = ileRazy;

        for (int i = 0; i < loop; i++) {
            try {
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"menu-robbery\"]")));
                Thread.sleep(1000);
//                driver.findElement(By.xpath("//*[@id=\"menu-robbery\"]")).click();
                driver.get(("https://www.thecrims.com/newspaper#/robberies"));
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"singlerobbery-select-robbery\"]")));
                Thread.sleep(1000);
                Select robber = new Select(driver.findElement(By.xpath("//*[@id=\"singlerobbery-select-robbery\"]")));
                robber.selectByIndex(idRabunku);
                WebElement full = driver.findElement(By.xpath("//*[@id=\"full\"]"));
                if (!full.isSelected())
                    full.click();
                Thread.sleep(1000);
                driver.findElement(By.xpath("//*[@id=\"singlerobbery-rob\"]")).click();
                try {
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[4]/div/table/tbody/tr/td[1]/div[2]/table/tbody/tr/td/div[2]/div/div[3]/div[3]/div/div/div/div")));
                } catch (Exception e) {

                }
                Thread.sleep(1000);
                this.cpaj();
            } catch (Exception e) {
                rabunek(idRabunku,ileRazy);
            }

        }
    }

    public void cpaj() throws InterruptedException {
        driver.get("https://www.thecrims.com/newspaper#/nightlife/nightclub");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"content_middle\"]/div/div[3]/div[1]")));
        Thread.sleep(1000);
        try {
//            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div[4]/div/table/tbody/tr/td[1]/div[2]/table/tbody/tr/td/div[2]/div/div[3]/div[2]/ul[2]/li[1]/div/div[2]/button")));
//            Thread.sleep(1000);
            driver.findElement(By.xpath("/html/body/div[2]/div[4]/div/table/tbody/tr/td[1]/div[2]/table/tbody/tr/td/div[2]/div/div[3]/div[2]/ul[2]/li[1]/div/div[2]/button")).click();
        } catch (Exception e) {
            try {
//                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div[4]/div/table/tbody/tr/td[1]/div[2]/table/tbody/tr/td/div[2]/div/div[3]/div[2]/ul[3]/li[1]/div/div[2]/button")));
//                Thread.sleep(1000);
                driver.findElement(By.xpath("/html/body/div[2]/div[4]/div/table/tbody/tr/td[1]/div[2]/table/tbody/tr/td/div[2]/div/div[3]/div[2]/ul[3]/li[1]/div/div[2]/button")).click();
            } catch (Exception f) {
//                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div[4]/div/table/tbody/tr/td[1]/div[2]/table/tbody/tr/td/div[2]/div/div[3]/div[2]/ul[4]/li[1]/div/div[2]/button")));
//                Thread.sleep(1000);
                driver.findElement(By.xpath("/html/body/div[2]/div[4]/div/table/tbody/tr/td[1]/div[2]/table/tbody/tr/td/div[2]/div/div[3]/div[2]/ul[4]/li[1]/div/div[2]/button")).click();
            }
        }
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div[4]/div/table/tbody/tr/td[1]/div[2]/table/tbody/tr/td/div[2]/div/div[3]/table[2]/tbody/tr/td[4]/button")));
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[2]/div[4]/div/table/tbody/tr/td[1]/div[2]/table/tbody/tr/td/div[2]/div/div[3]/table[2]/tbody/tr/td[4]/button")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[4]/div/table/tbody/tr/td[1]/div[2]/table/tbody/tr/td/div[2]/div/div[2]/div")));
        try {
            driver.findElement(By.xpath("/html/body/div[2]/div[4]/div/table/tbody/tr/td[1]/div[2]/table/tbody/tr/td/div[2]/div/div[3]/div[2]/button")).click();
        } catch (Exception e) {
            Thread.sleep(7000);
        }

    }
}
