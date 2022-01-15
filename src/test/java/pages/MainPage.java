package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MainPage {

    ChromeDriver driver;

    public MainPage(ChromeDriver driver){
        this.driver = driver;
    }

    public By registerInstallerButton(){
        return By.xpath("//a[@href='/installer/register']");
    }

    public void registerInstallerClick(){
        {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView();", driver.findElement(registerInstallerButton()));
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            driver.findElement(registerInstallerButton()).click();
        }
    }
}
