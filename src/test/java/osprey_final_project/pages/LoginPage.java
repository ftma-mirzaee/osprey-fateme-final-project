package osprey_final_project.pages;

import org.openqa.selenium.By;

public class LoginPage {
    public static final By Login_btn = By.xpath("//a[@class='chakra-button css-ez23ye']");

    public static final By User_name = By.id("username");
    public static final By Password = By.id("password");
    public static final By Customer_Portal = By.xpath("(//div[@class='css-17xejub'])[1]");
    public static final By Sign_In = By.xpath("(//button[text()='Sign In'])[1]");

    public static final By Login_Error = By.xpath("//div[@role='alert']");
}
