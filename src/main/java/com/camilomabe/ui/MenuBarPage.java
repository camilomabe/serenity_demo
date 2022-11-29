package com.camilomabe.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class MenuBarPage extends PageObject {

    public static final Target AVATARS_USER = Target.the("avatar's user").located(By.xpath("//i[@class='s-sidebar-band-icon fa fa-user']"));
    public static final Target LINK_ORGANIZATION = Target.the("organization").located(By.xpath("//span[contains(text(),'Organization')]"));
    public static final Target LINK_BUSINESS_UNITS = Target.the("business units").located(By.xpath("//span[contains(text(),'Business Units')]"));
    public static final Target LINK_MEETING = Target.the("meeting").located(By.xpath("//i[@class='s-sidebar-icon fa fa-comments premium-feature']"));
    public static final Target LINK_MEETINGS = Target.the("meetings").located(By.xpath("//span[contains(text(),'Meetings')]"));
    public static final Target NEW_MEETING = Target.the("new meeting").located(By.xpath("//i[@class='fa fa-plus-circle text-green']"));

}
