package com.camilomabe.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.thucydides.core.annotations.Step;

import static com.camilomabe.ui.HomeUserPage.lblUserLogged;
import static com.camilomabe.utils.SessionVariables.USER;

public class ValidatesUser implements Question<String> {

    public static Question<String> displayed() {
        return new ValidatesUser();
    }

    @Override
    @Step("{0} searches user logged name")
    public String answeredBy(Actor actor) {
        return lblUserLogged(actor.recall(USER.toString())).resolveFor(actor).getText();
    }
}