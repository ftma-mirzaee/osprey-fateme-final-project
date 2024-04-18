package osprey_final_project.pages;

import org.openqa.selenium.By;

public class HomePage {
    public static final By Create_Account_Button= By.linkText("Create Primary Account");

    public static final By Click_Account_Button = By.xpath("(//a[text()='Create Primary Account'])");

    public static final By Form_Title = By.xpath("//h2[text()='Create Primary Account Holder']");
}
