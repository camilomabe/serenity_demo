package com.camilomabe.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;

import static com.camilomabe.ui.CommonTargetsPage.SEARCH_BUSINESS_UNITS;
import static com.camilomabe.ui.CommonTargetsPage.labelSearch;
import static com.camilomabe.utils.SessionVariables.MEETING_NAME_VALUE;

public class ValidatesBusinessMeeting implements Question<String> {

    public static Question<String> wasCreate() {
        return new ValidatesBusinessMeeting();
    }

    @Override
    @Step("{0} searches meeting name")
    public String answeredBy(Actor actor) {
        String meetingName = actor.recall(MEETING_NAME_VALUE.toString());
        actor.attemptsTo(Enter.theValue(meetingName).into(SEARCH_BUSINESS_UNITS));
        return labelSearch(meetingName).resolveFor(actor).getText();
    }
}