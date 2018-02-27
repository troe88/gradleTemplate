package com.lebedev;

import com.epam.jdi.uitests.web.selenium.driver.WebDriverUtils;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.lebedev.data.DataLoader;
import com.lebedev.data.ProjectEntities;
import com.lebedev.entities.User;
import com.lebedev.pageobjects.GoogleSite;
import com.lebedev.utils.config.GlobalConfig;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;

import java.io.IOException;

import static com.epam.jdi.uitests.web.settings.WebSettings.initFromProperties;

public class Stepdefs {

    @Before
    public void before() throws IOException {
        DataLoader.get(User.class, "user_1");
        initFromProperties();
    }

    @After
    public void after() throws IOException {
        WebDriverUtils.killAllRunWebBrowsers();
    }

    @Given("^Open Portal$")
    public void openPortal() throws Throwable {
        WebSite.init(GoogleSite.class);
        GoogleSite.homePage.open();
    }

    @Given("^Search \"([^\"]*)\"$")
    public void search(String userId) throws Throwable {
        GoogleSite.homePage.search(ProjectEntities.getUser(userId));
    }
}
