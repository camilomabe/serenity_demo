package com.camilomabe.tasks;

import com.camilomabe.interactions.DeleteBusinessUnit;
import com.camilomabe.interactions.DeleteOption;
import com.camilomabe.interactions.GoesBusiness;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

import static com.camilomabe.ui.CommonTargetsPage.HOME_MEETING;

public class DeletesSchedules implements Task {

    public static Performable letsGo() {
        return Tasks.instrumented(DeletesSchedules.class);
    }

    @Override
    @Step("{0} delete schedules")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(DeleteOption.letsGo());
        actor.attemptsTo(Click.on(HOME_MEETING));
        actor.attemptsTo(GoesBusiness.letsGo());
        actor.attemptsTo(DeleteBusinessUnit.letsGo());
    }
}