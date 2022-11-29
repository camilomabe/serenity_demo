package com.camilomabe.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

import static com.camilomabe.ui.MenuBarPage.AVATARS_USER;

public class GoesAvatarSUser implements Interaction {

    public static Performable letsGo() {
        return Tasks.instrumented(GoesAvatarSUser.class);
    }

    @Override
    @Step("{0} clicks on the user's avatar")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(AVATARS_USER));
    }
}