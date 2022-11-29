package com.camilomabe.interactions;

import lombok.SneakyThrows;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;

import static com.camilomabe.ui.CommonTargetsPage.HOME_BUSINESS_UNITS;
import static com.camilomabe.ui.CommonTargetsPage.SEARCH_BUSINESS_UNITS;
import static com.camilomabe.utils.SessionVariables.BUSINESS_UNIT_NAME;

public class DeleteBusinessUnit implements Interaction {

    public static Performable letsGo() {
        return Tasks.instrumented(DeleteBusinessUnit.class);
    }

    @SneakyThrows
    @Override
    @Step("{0} delete business unit")
    public <T extends Actor> void performAs(T actor) {
        String unitName = actor.recall(BUSINESS_UNIT_NAME.toString());
        actor.attemptsTo(Click.on(SEARCH_BUSINESS_UNITS));
        actor.attemptsTo(Enter.theValue(unitName).into(SEARCH_BUSINESS_UNITS));
        Thread.sleep(5000);
        actor.attemptsTo(DeleteOption.letsGo());
        actor.attemptsTo(Click.on(HOME_BUSINESS_UNITS));
    }
}