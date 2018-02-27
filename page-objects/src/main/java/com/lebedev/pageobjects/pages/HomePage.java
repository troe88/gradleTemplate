package com.lebedev.pageobjects.pages;

import com.epam.jdi.uitests.web.selenium.elements.common.TextField;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.lebedev.entities.User;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;

public class HomePage extends WebPage {
    @FindBy(id = "lst-ib")
    public TextField searchFiled;

    public void search(User user) {
        searchFiled.sendKeys(user.toString() + Keys.ENTER);
    }
}
