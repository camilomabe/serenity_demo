package com.camilomabe.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class HomeUserPage {

    public static Target lblUserLogged(String user) {
        return Target.the("label user logged").located(By.xpath("//*/text()[normalize-space(.)='" + user + "']/parent::*"));
    }

}