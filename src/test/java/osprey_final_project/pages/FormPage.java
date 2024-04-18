package osprey_final_project.pages;

import org.openqa.selenium.By;

public class FormPage {
    public static final By Email_Input = By.xpath("//input[@id='email']");
    public static final By First_name_input = By.id("firstName");

    public static final By Title_prefix = By.id("title");
    public static final By Last_Name_Input = By.id("lastName");
    public static final By Gender = By.id("gender");

    public static final By Marital_Status = By.id("maritalStatus");

    public static final By Date_of_Birth = By.id("dateOfBirth");
    public static final By Create_Account_Btn = By.xpath("//button[text()='Create Account']");

    public static final By Email_Add = By.cssSelector("h2:nth-child(2)");
    public static final By Error_Message =  By.cssSelector("div[role='alert']");
}
