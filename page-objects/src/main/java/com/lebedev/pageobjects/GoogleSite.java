package com.lebedev.pageobjects;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import com.lebedev.pageobjects.pages.HomePage;
import lombok.Getter;

@Getter
public class GoogleSite extends WebSite {
    @JPage(url = "/")
    public static HomePage homePage;

    String qwe;
}
