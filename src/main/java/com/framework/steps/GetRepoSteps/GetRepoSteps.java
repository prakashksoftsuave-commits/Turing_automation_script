package com.framework.steps.GetRepoSteps;

import com.framework.Logger.Log;
import com.framework.pages.GetRepo.GetRepoPo;
import com.framework.pages.LoginPage.LoginPagePo;
import io.cucumber.java.en.Given;
import org.apache.logging.log4j.Logger;

public class GetRepoSteps {

    private static final Logger logger = Log.getLogger(GetRepoSteps.class);

    @Given("Click MyTask Toggle Button and Get InProgress Task Count")
    public void To_GetInProgress_Task_Count() {
        logger.info("To Get In progress Task Count");
        GetRepoPo.ToGetNumberOfInProgressTasks();
    }


}
