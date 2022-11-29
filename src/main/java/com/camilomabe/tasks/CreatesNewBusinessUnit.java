package com.camilomabe.tasks;

import com.camilomabe.interactions.GoesBusiness;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;

import static com.camilomabe.ui.BusinessUnitsPage.*;
import static com.camilomabe.ui.CommonTargetsPage.SEARCH_BUSINESS_UNITS;
import static com.camilomabe.utils.SessionVariables.BUSINESS_UNIT_NAME;

@AllArgsConstructor
public class CreatesNewBusinessUnit implements Task {

    private final String nameBusinessUnit;

    public static Performable letsGo(String nameBusinessUnit) {
        return Tasks.instrumented(CreatesNewBusinessUnit.class, nameBusinessUnit);
    }

    @Override
    @Step("{0} creates new business unit")
    public <T extends Actor> void performAs(T actor) {
        actor.remember(BUSINESS_UNIT_NAME.toString(), nameBusinessUnit);
        actor.attemptsTo(GoesBusiness.letsGo());
        actor.attemptsTo(Click.on(NEW_BUSINESS_UNITS));
        actor.attemptsTo(Enter.theValue(nameBusinessUnit).into(NAME_NEW_BUSINESS_UNITS));
        actor.attemptsTo(Click.on(SAVE_BUSINESS_UNITS));
        actor.attemptsTo(Enter.theValue(nameBusinessUnit).into(SEARCH_BUSINESS_UNITS));
    }
}