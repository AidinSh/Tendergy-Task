package testCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.RegisterInstallerPage;

public class RegisterInstallerTestCases {
    ChromeDriver driver;
    Utils utils;
    MainPage mainPage;
    RegisterInstallerPage registerInstallerPage;


    public RegisterInstallerTestCases(ChromeDriver driver){
        this.driver = driver;
        utils = new Utils(driver);
        mainPage = new MainPage(driver);
        registerInstallerPage = new RegisterInstallerPage(driver);
    }


    public void open_register_installer_page(){
        driver.get("https://tendergy.staging.tendergy.com/");
        driver.manage().window().fullscreen();
        utils.accept_cookie();
        mainPage.registerInstallerClick();
        Assert.assertTrue(driver.findElement(registerInstallerPage.pageTitle()).isDisplayed());
    }



    public void registration_company_name_part(String companyName){
        utils.fillSimpleInput(registerInstallerPage.companyNameField(), companyName);
        utils.selectDropBoxItem(registerInstallerPage.genderField(), registerInstallerPage.genderTypeMale());
        utils.fillSimpleInput(registerInstallerPage.titleField(), "Test Title");
        utils.fillSimpleInput(registerInstallerPage.firstNameField(), "Name");
        utils.fillSimpleInput(registerInstallerPage.lastNameField(), "Installer");
        driver.findElement(registerInstallerPage.continueButton()).click();
    }


    public void registration_contact_details_part(String email, String phoneNumber){
        utils.fillSimpleInput(registerInstallerPage.emailAddress(), email);
        utils.fillSimpleInput(registerInstallerPage.faxNumber(), "+989121234567");
        utils.fillSimpleInput(registerInstallerPage.mobileNumber(), phoneNumber);
        driver.findElement(registerInstallerPage.continueButton()).click();
    }

    public void registration_address_company_address_part(){
        utils.fillSimpleInput(registerInstallerPage.streetField(), "here");
        utils.fillSimpleInput(registerInstallerPage.plateNumberField(), "10");
        utils.fillSimpleInput(registerInstallerPage.addressField(), "there");
        utils.fillSimpleInput(registerInstallerPage.postCodeField(), "27499");
        utils.fillSimpleInput(registerInstallerPage.cityField(), "Munich");
        utils.selectDropBoxItem(registerInstallerPage.countryField(), registerInstallerPage.countrySelectionGermany());
        driver.findElement(registerInstallerPage.continueButton()).click();
    }


    public void registration_set_pass_part(){
        utils.fillSimpleInput(registerInstallerPage.passwordField(), "Aidin1234!@#$");
        utils.fillSimpleInput(registerInstallerPage.confirmPassField(), "Aidin1234!@#$");
        driver.findElement(registerInstallerPage.termsCheckBox()).click();
        driver.findElement(registerInstallerPage.continueButton()).click();
    }


    public void registration_upload_file(){
        utils.waitForElement(registerInstallerPage.uploadField());
        driver.findElement(registerInstallerPage.uploadField()).click();
        utils.fileUpload("/Users/aidin/IdeaProjects/Tendergy Task/src/test/java/resources/test_pdf.pdf");
        //driver.findElement(registerInstallerPage.uploadField()).sendKeys("/Users/aidin/IdeaProjects/Tendergy Task/src/test/java/resources/test_pdf.pdf");
    }


    public void register_installer_email_verify(){
        utils.fillSimpleInput(registerInstallerPage.emailAddress(), "invalid input");
        utils.waitForElement(registerInstallerPage.invalidEmailError());
        Assert.assertTrue(driver.findElement(registerInstallerPage.invalidEmailError()).isDisplayed());
        driver.findElement(registerInstallerPage.emailAddress()).sendKeys(Keys.COMMAND + "a");
        driver.findElement(registerInstallerPage.emailAddress()).sendKeys(Keys.BACK_SPACE);
        utils.fillSimpleInput(registerInstallerPage.emailAddress(), "user@test.com");
        try{
            Thread.sleep(2000);
        }catch (Exception e){
            e.printStackTrace();
        }
        Assert.assertFalse(driver.findElements(registerInstallerPage.invalidEmailError()).size() > 0);
    }


    public void register_installer_phone_verify(){
        utils.fillSimpleInput(registerInstallerPage.mobileNumber(), "+1234");
        utils.waitForElement(registerInstallerPage.invalidPhoneError());
        Assert.assertTrue(driver.findElement(registerInstallerPage.invalidPhoneError()).isDisplayed());
        driver.findElement(registerInstallerPage.mobileNumber()).sendKeys(Keys.COMMAND + "a");
        driver.findElement(registerInstallerPage.mobileNumber()).sendKeys(Keys.BACK_SPACE);
        utils.fillSimpleInput(registerInstallerPage.mobileNumber(), "+989352208707");
        try{
            Thread.sleep(2000);
        }catch (Exception e){
            e.printStackTrace();
        }
        Assert.assertFalse(driver.findElements(registerInstallerPage.invalidPhoneError()).size() > 0);
    }


}
