package Com.StepDeftn;

import Com.Browser.Hook;
import Com.Pages.GoogleSearchPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GoogleStepDeftn {
    @Given("^am on the google home page$")
    public void am_on_the_google_home_page() throws Throwable {
        Hook.setup().get("https://www.google.com/");
    }

    @When("^I enter word to be searched$")
    public void i_enter_word_to_be_searched() throws Throwable {
        GoogleSearchPage.enterSearchDetail();
    }

    @When("^I click the search button$")
    public void i_click_the_search_button() throws Throwable {
        GoogleSearchPage.clickSearchButton();
    }

    @Then("^the search result should be return$")
    public void the_search_result_should_be_return() throws Throwable {
        Hook.teardown();
    }




}
