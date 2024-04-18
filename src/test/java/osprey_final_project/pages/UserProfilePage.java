package osprey_final_project.pages;

import org.openqa.selenium.By;

public class UserProfilePage {
    public static final By Profile_Btn = By.xpath("//button[@aria-label='profile']");
    public static final By Profile_Page = By.xpath("(//header[text()='Profile'])");
    public static final By User_TYPE = By.xpath("(//p[text()='CSR'])");
    public static final By FULL_NAME = By.xpath("(//p[text()='Supervisor'])");
    public static final By User_NAME = By.xpath("(//p[text()='supervisor'])");
    public static final By Log_Out = By.xpath("(//button[text()='Logout'])");
}