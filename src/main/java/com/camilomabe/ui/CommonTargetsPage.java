package com.camilomabe.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CommonTargetsPage extends PageObject {

    public static final Target SEARCH_BUSINESS_UNITS = Target.the("search by name").located(By.xpath("//*[@class='s-Serenity-QuickSearchInput s-QuickSearchInput']"));
    public static final Target ICON_DELETE = Target.the("icon delete").located(By.xpath("//div[@class='tool-button delete-button icon-tool-button']"));
    public static final Target DELETE_MEETING = Target.the("delete meeting").located(By.xpath("//div[2]/a"));
    public static final Target BTN_YES = Target.the("confirm delete").located(By.xpath("//button[contains(text(),'Yes')]"));
    public static final Target HOME_BUSINESS_UNITS = Target.the("Business Units").located(By.xpath("//div[contains(text(),'Business Units')]"));
    public static final Target HOME_MEETING = Target.the("Meetings").located(By.xpath("//div[contains(text(),'Meetings')]"));

    public static final Target labelSearch(String searchName) {
        return Target.the("search name").located(By.xpath("//a[contains(text(),'" + searchName + "')]"));
    }

}
