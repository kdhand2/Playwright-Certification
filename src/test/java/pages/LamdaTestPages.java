package pages;

import com.microsoft.playwright.Page;
import context.commonconfigs;
import io.cucumber.java.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import steps.lamdaTestSteps;

import java.io.UnsupportedEncodingException;


public class LamdaTestPages {

    commonconfigs cc = new commonconfigs();
    Page page;
    lamdaTestSteps lamdaTestSteps;

    @Before
    public void beforeAll() throws UnsupportedEncodingException {
        cc.openBrowser();
        page = cc.getPage();
        lamdaTestSteps = new lamdaTestSteps(page);
    }

    @After
    public void after(){
        cc.teardown();
    }

    @Given("Open the {string}")
    public void inChromeBrowserOpenTheSite(String url) {
        System.out.println(url);
        page.navigate(url);
    }

    @Then("Click {string} under Input Forms.")
    public void clickSimpleFormDemoUnderInputForms(String value){
        lamdaTestSteps.selectStageFromForm(value);
    }

    @Then("Validate that the URL contains {string}.")
    public void validateThatTheURLContainsSimpleFormDemo(String val) {
        lamdaTestSteps.validateForm(val);
    }

    @And("Create a variable for a string value {string}.")
    public void createAVariableForAStringValueEGWelcomeToLambdaTest(String val){
        lamdaTestSteps.createVariable(val);
    }

    @Then("Use this variable to enter values in the text box.")
    public void useThisVariableToEnterValuesInTheScenarioOneTextBox()  {
        lamdaTestSteps.enterTheValueInBox();
    }

    @And("Click Get Checked Value.")
    public void clickGetCheckedValue()  {
        lamdaTestSteps.clickGetChecked();
    }



    @Then("Click Submit button")
    public void clickSubmitButton() {
        lamdaTestSteps.clickOnSubmit();
    }


    @Then("validate error message {string}")
    public void validateErrorMessage(String message) {
        lamdaTestSteps.validateErrorMesssage(message);
    }


    @Then("Fill mandatory parameters")
    public void fillMandatoryParameters() {
        lamdaTestSteps.fillManditoryParams();
    }

    @Then("validate the success message {string}")
    public void validateTheSuccessMessage(String sucessMessage) {
        lamdaTestSteps.validateSucessMessage(sucessMessage);
    }


    @And("Validate whether the same text message is displayed in the right-hand panel")
    public void validateWhetherTheSameTextMessageIsDisplayedInTheRightHandPanelUnderTheScenarioOneSection() {
        lamdaTestSteps.validateVariable();
    }


    @And("Validate whether the range value shows {string}.")
    public void validateWhetherTheRangeValueShows(String range) {
        lamdaTestSteps.validateRange(range);
    }

    @And("check for {string} and drag the bar to make it {string}")
    public void checkForDefaultVauleAndDragTheBarToMakeIt(String defaultValue, String expectedValuew) {
        lamdaTestSteps.checkValueAndSelect(defaultValue, expectedValuew);
    }

}