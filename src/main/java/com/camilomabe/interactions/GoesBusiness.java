package com.camilomabe.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

import static com.camilomabe.ui.MenuBarPage.*;

public class GoesBusiness implements Interaction {

    public static Performable letsGo() {
        return Tasks.instrumented(GoesBusiness.class);
    }

    @Override
    @Step("{0} is going to business unit")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(LINK_ORGANIZATION));
        actor.attemptsTo(Click.on(LINK_BUSINESS_UNITS));
    }
}