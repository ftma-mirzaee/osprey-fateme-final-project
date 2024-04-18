package osprey_final_project.pages;

import org.openqa.selenium.By;

public class PlanPage {
    public static final By Plan_Btn = By.xpath("//a[text()='Plans']");
    public static final By Plan_Table = By.xpath("//table[@class='chakra-table css-5605sr']/tbody/tr");

    public static final By Plan_Date_Created = By.xpath("//tbody/tr[1]/td[4]");

    public static final By Plan_Expire_Date = By.xpath("//tbody/tr[1]/td[5]");
}
