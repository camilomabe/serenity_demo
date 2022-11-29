package com.camilomabe.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class BusinessUnitsPage extends PageObject {

    public static final Target NEW_BUSINESS_UNITS = Target.the("new business units").located(By.xpath("//i[@class='fa fa-plus-circle text-green']"));
    public static final Target NAME_NEW_BUSINESS_UNITS = Target.the("name new business units").located(By.id("Serenity_Pro_Organization_BusinessUnitDialog3_Name"));
    public static final Target SAVE_BUSINESS_UNITS = Target.the("save business units").located(By.xpath("//i[@class='fa fa-check-circle text-purple']"));

}
