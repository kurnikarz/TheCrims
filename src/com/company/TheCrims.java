package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TheCrims {

    private static final String driverOption = "webdriver.chrome.driver";
    private static final String driverPath = "E:\\TheCrims\\chromedriver\\chromedriver.exe";

    private String username;
    private String password;
    private ChromeDriver driver;
    private WebDriverWait wait;

    public TheCrims(String username, String password) {
        System.setProperty(driverOption,driverPath);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        this.driver = new ChromeDriver(options);
        this.wait = new WebDriverWait(driver,20000);
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

        for (int i=0;i<loop;i++) {
            driver.findElement(By.xpath("//*[@id=\"menu-robbery\"]")).click();
            Thread.sleep(2000);
            Select robber = new Select(driver.findElement(By.xpath("//*[@id=\"singlerobbery-select-robbery\"]")));
            robber.selectByIndex(idRabunku);
            WebElement full = driver.findElement(By.xpath("//*[@id=\"full\"]"));
            if (!full.isSelected())
                full.click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//*[@id=\"singlerobbery-rob\"]")).click();
            Thread.sleep(3000);
            this.cpaj();
        }
    }

    public void cpaj() throws InterruptedException {
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
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[2]/div[4]/div/table/tbody/tr/td[1]/div[2]/table/tbody/tr/td/div[2]/div/div[3]/div[2]/button")).click();
    }
}
