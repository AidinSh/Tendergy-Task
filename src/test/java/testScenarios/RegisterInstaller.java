package testScenarios;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import testCases.RegisterInstallerTestCases;

public class RegisterInstaller {
    static ChromeDriver driver;
    RegisterInstallerTestCases registerInstallerTestCases;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        registerInstallerTestCases = new RegisterInstallerTestCases(driver);
    }

    @Test
    public void verify_Email_and_Phone_fields(){
        registerInstallerTestCases.open_register_installer_page();
        registerInstallerTestCases.registration_company_name_part("test company");
        registerInstallerTestCases.register_installer_email_verify();
        registerInstallerTestCases.register_installer_phone_verify();
    }

    @Test
    public void register_installer_successfully(){
        registerInstallerTestCases.open_register_installer_page();
        registerInstallerTestCases.registration_company_name_part("test company");
        registerInstallerTestCases.registration_contact_details_part("user@test.com", "+989352208707");
        registerInstallerTestCases.registration_address_company_address_part();
        registerInstallerTestCases.registration_set_pass_part();
    }
}
