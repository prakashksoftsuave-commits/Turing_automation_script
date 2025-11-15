package com.framework.pages.GetRepo;

import com.framework.helper.Actions;
import com.framework.helper.Waiter;
import com.framework.hooks.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GetRepoPo extends Actions {

    private static final By myTasks = By.xpath("//input[contains(@id,'only-my-tasks')]");
    private static final By inProgress = By.xpath("//button[contains(.,'In Progress')]");
    private static final WebDriver driver = DriverFactory.getDriver();

    public static int ToGetNumberOfInProgressTasks(){
        click(myTasks);
        Waiter.waitForSeconds(3);
        WebElement number = driver.findElement(inProgress);
        String text = number.getText();
        return Integer.parseInt(text);
    }



}
