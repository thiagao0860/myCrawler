package org.thiago;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.w3c.dom.Element;

public class SpiderSelenium {
    public void thisIsARobot()  {
     try{
        String chromeDriverPath = "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe" ;
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Thiago\\Desktop\\myCrawler\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless" ,"--disable-gpu", "--ignore-certificate-errors", "--silent");
        options.addArguments("window-size=600,400");

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://github.com/login?return_to=%2Fjoin%3Fref_cta%3DSign%2Bup%26ref_loc%3Dheader%2Blogged%2Bout%26ref_page%3D%252F%26source%3Dheader-home");
        WebElement note = driver.findElement(By.id("login_field"));
        note.sendKeys("thiagao0860");
        WebElement submit = driver.findElement(By.id("password"));
        submit.sendKeys("oitooito-T8");
        WebElement button = driver.findElement(By.name("commit"));
        button.click();
        System.out.println(driver.getPageSource());
        driver.quit();
     }catch (Exception e){
         e.printStackTrace();
     }
    }
}
