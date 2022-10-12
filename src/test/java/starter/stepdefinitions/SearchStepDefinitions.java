package starter.stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;

import java.util.ArrayList;
import java.util.Arrays;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static net.serenitybdd.rest.SerenityRest.then;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.is;

public class SearchStepDefinitions {

    @When("he calls endpoint {string}")
    public void heCallsEndpoint(String arg0) {
        SerenityRest.given().get(arg0);
    }

    @Then("he sees the results displayed for {word}")
    public void heSeesTheResultsDisplayedForApple(String fruit) {
        // The better idea will be creating a POJO class and takes a list of classes,
        // but for one test it doesn't make sense
        restAssuredThat(response -> response.statusCode(200));
        ArrayList<String> titles = new ArrayList<>(Arrays.asList(then().extract().path("title").toString().split(",")));
        assertThat(titles.stream().allMatch(n -> n.toLowerCase().contains(fruit)))
                .as("title doesn't contain world " + fruit)
                .isTrue();
    }

    @Then("he do not see the results")
    public void he_Do_Not_See_The_Results() {
        restAssuredThat(response -> response.statusCode(404));
        restAssuredThat(response -> response.body("detail.error", is(true)));
    }
}
