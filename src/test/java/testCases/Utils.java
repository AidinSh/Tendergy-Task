package testCases;

import jdk.jshell.execution.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v85.input.Input;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.lang.model.element.Element;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class Utils {

    ChromeDriver driver;

    public Utils(ChromeDriver driver){
        this.driver = driver;
    }

    public void accept_cookie(){
        try{
            waitForElement(By.xpath("//button[@class='ant-btn ant-btn-primary ant-btn-lg ant-btn-block Button_button__NAemG Button_blue__1ahxJ']"));
            WebElement acceptButton = driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-primary ant-btn-lg ant-btn-block Button_button__NAemG Button_blue__1ahxJ']"));
            acceptButton.click();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void selectDropBoxItem(By dropDown, By selectedItem){
        driver.findElement(dropDown).click();
        driver.findElement(selectedItem).click();
    }

    public void fillSimpleInput(By elementLocator, String value){
        waitForElement(elementLocator);
        driver.findElement(elementLocator).sendKeys(value);
    }

    public void waitForElement(By locator){
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void fileUpload (String path) {
        StringSelection strSelection = new StringSelection(path);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(strSelection, null);

        Robot robot = null;
        try {
            robot = new Robot();
        }catch (Exception e){
            e.printStackTrace();
        }

        robot.delay(300);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.delay(200);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }
}
