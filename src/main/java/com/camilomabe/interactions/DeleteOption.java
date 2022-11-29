package com.camilomabe.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

import static com.camilomabe.ui.CommonTargetsPage.*;

public class DeleteOption implements Interaction {

    public static Performable letsGo() {
        return Tasks.instrumented(DeleteOption.class);
    }

    @Override
    @Step("{0} delete schedule")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(DELETE_MEETING));
        actor.attemptsTo(Click.on(ICON_DELETE));
        actor.attemptsTo(Click.on(BTN_YES));
    }
}