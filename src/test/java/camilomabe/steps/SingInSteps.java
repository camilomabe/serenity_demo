package camilomabe.steps;

import com.camilomabe.interactions.DeleteBusinessUnit;
import com.camilomabe.tasks.DeletesSchedules;
import com.camilomabe.questions.ValidatesBusinessMeeting;
import com.camilomabe.questions.ValidatesBusinessUnit;
import com.camilomabe.questions.ValidatesUser;
import com.camilomabe.tasks.CreatesBusinessMeeting;
import com.camilomabe.tasks.CreatesNewBusinessUnit;
import com.camilomabe.tasks.LogIn;
import com.camilomabe.utils.NavigateTo;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.hamcrest.CoreMatchers;

import java.util.Map;

import static com.camilomabe.utils.SessionVariables.BUSINESS_UNIT_NAME;
import static com.camilomabe.utils.SessionVariables.MEETING_NAME_VALUE;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class SingInSteps {

    @Before
    public void startsPage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("^(.*) opens the browser in the home page$")
    public void opensBrowserOnHomePage(String actor) {
        theActorCalled(actor).attemptsTo(NavigateTo.theWebSideHome());
    }

    @When("^he enters his credentials, (.*) and (.*)$")
    public void entersTheCredentials(String user, String pass) {
        theActorInTheSpotlight().attemptsTo(LogIn.forLoginIn(user, pass));
    }

    @Then("^he should see the (.*) in the login home$")
    public void validatesTheTextInThePaymentForm(String user) {
        theActorInTheSpotlight().should(seeThat(ValidatesUser.displayed(), CoreMatchers.equalTo(user)));
    }

    @And("^he creates new business unit as (.*)$")
    public void createNewBusinessUnit(String businessUnit) {
        theActorInTheSpotlight().attemptsTo(CreatesNewBusinessUnit.letsGo(businessUnit));
    }

    @Then("^he should see the business unit name$")
    public void validatesBusinessUnitName() {
        theActorInTheSpotlight().should(seeThat(ValidatesBusinessUnit.wasCreate(),
                CoreMatchers.equalTo(theActorInTheSpotlight().recall(BUSINESS_UNIT_NAME.toString()))));
    }

    @And("^he should delete business unit$")
    public void deleteBusinessUnit() {
        theActorInTheSpotlight().attemptsTo(DeleteBusinessUnit.letsGo());
    }

    @And("^he schedules a business meeting$")
    public void scheduleAMeet(Map<String, String> meetingInfo) {
        theActorInTheSpotlight().attemptsTo(CreatesBusinessMeeting.letsGo(meetingInfo));
    }

    @Then("^he should see the business meeting$")
    public void validatesBusinessMeeting() {
        theActorInTheSpotlight().should(seeThat(ValidatesBusinessMeeting.wasCreate(),
                CoreMatchers.equalTo(theActorInTheSpotlight().recall(MEETING_NAME_VALUE.toString()))));
    }

    @And("^he should delete meeting and unit$")
    public void cleanSchedules() {
        theActorInTheSpotlight().attemptsTo(DeletesSchedules.letsGo());
    }
}