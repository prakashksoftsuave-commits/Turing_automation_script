package com.framework.steps.LoginSteps;

import com.framework.Logger.Log;
import com.framework.pages.LoginPage.LoginPagePo;
import io.cucumber.java.en.Given;
import org.apache.logging.log4j.Logger;

public class LoginSteps {
    private static final Logger logger = Log.getLogger(LoginSteps.class);

    @Given("user launches the application")
    public void user_launches_the_application() {
        logger.info("user launches the application");
        LoginPagePo.launchApplication();
    }

}
