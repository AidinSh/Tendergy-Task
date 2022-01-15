package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.lang.ref.WeakReference;

public class RegisterInstallerPage {

    ChromeDriver driver;

    public RegisterInstallerPage(ChromeDriver driver){
        this.driver = driver;
    }

    public By pageTitle(){
        return By.xpath("//h3[@class='Content_motto__HdFeM']");
    }
    public By companyNameField(){
       return By.id("request-personal-details-form_company");
    }
    public By genderField(){
        return By.id("request-personal-details-form_gender");
    }
    public By titleField(){
        return By.id("request-personal-details-form_title");
    }
    public By firstNameField(){
        return By.id("request-personal-details-form_firstName");
    }
    public By lastNameField(){
        return By.id("request-personal-details-form_lastName");
    }
    public By continueButton(){
        return By.xpath("//button[@class='ant-btn ant-btn-primary Button_button__NAemG Button_blue__1ahxJ Button_icon-right__1b65a']");
    }
    public By genderTypeMale(){
        return By.xpath("//div[@title='registration.male']");
    }
    public By emailAddress(){
        return By.id("request-personal-details-form_email");
    }
    public By faxNumber(){
        return By.id("request-personal-details-form_fax");
    }
    public By mobileNumber(){
        return By.id("request-personal-details-form_mobile");
    }
    public By streetField(){
        return By.id("request-personal-details-form_street");
    }
    public By plateNumberField(){
        return By.id("request-personal-details-form_house");
    }
    public By addressField(){
        return By.id("request-personal-details-form_address2");
    }
    public By postCodeField(){
        return By.id("request-personal-details-form_postalCode");
    }
    public By cityField(){
        return By.id("request-personal-details-form_city");
    }
    public By countryField(){
        return By.id("request-personal-details-form_country");
    }
    public By countrySelectionGermany(){
        return By.xpath("//div[@title='Deutschland']");
    }
    public By passwordField(){
        return By.id("request-personal-details-form_password");
    }
    public By confirmPassField(){
        return By.id("request-personal-details-form_repeat-password");
    }
    public By termsCheckBox(){
        return By.xpath("//input[@class='ant-checkbox-input']");
    }
    public By uploadField(){
        return By.xpath("//a[@href='#']");
    }
    public By invalidEmailError(){
        return By.xpath("//div[contains(text(),'errors.validEmail')]");
    }
    public By invalidPhoneError(){
        return By.xpath("//div[contains(text(),'errors.validPhone')]");
    }
}
