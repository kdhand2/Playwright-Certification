package steps;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.BoundingBox;
import pages.LamdaTestPages;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class lamdaTestSteps {


    String variable;
    String validationMessage;
    LamdaTestPages lamdaTestPages ;
    Page page;

    public lamdaTestSteps(Page page) {
        lamdaTestPages = new LamdaTestPages();
        this.page = page;
    }

    public void selectStageFromForm(String val) {
        page.locator("//a[contains(text(),'" + val + "')]").click();
    }

    public void validateForm(String formname) {
        String url = page.url();
        String endpoint = url.substring(47);
        assertEquals(endpoint, formname);
    }

    public void createVariable(String val) {
        variable = val;
    }

    public void enterTheValueInBox() {
        page.locator("//input[@id=\"user-message\"]").fill(variable);
    }

    public void clickGetChecked() {
        page.click("[id=\"showInput\"]");
    }

    public void validateVariable() {
        assertEquals(page.locator("[id=\"message\"]").textContent(), variable);
    }


    public void checkValueAndSelect(String defaultValue, String expectedValuew) {
        Locator slider = page.locator("//*[@id=\"slider3\"]/div/input");
        BoundingBox box = slider.boundingBox();
        double startX = box.x + box.width / 2;
        double startY = box.y + box.height / 2;
        page.mouse().move(startX, startY);
        page.mouse().down();
        page.mouse().move(startX + 215, startY);
        page.mouse().up();
    }

    public void validateRange(String expectedRange) {
        String actualRange = page.locator("[id=\"rangeSuccess\"]").textContent();
        assert actualRange.equals(expectedRange) : "Range Slider value is not set correctly, expected 95 but got " + actualRange;
    }


    public void clickOnSubmit() {
        Locator inputField = page.locator("[id=\"name\"]");
        page.locator("//button[contains(text(),\"Submit\")]").click();
        validationMessage = (String) inputField.evaluate("el => el.validationMessage");
    }

    public void validateErrorMesssage(String message) {
        assertEquals( validationMessage, message);
    }

    public void fillManditoryParams() {
        page.locator("[id=\"name\"]").fill("karthik");
        page.locator("[id=\"inputEmail4\"]").fill("karthik@mail.com");
        page.locator("[id=\"inputPassword4\"]").fill("karthik@123");
        page.locator("[id=\"company\"]").fill("lamda");
        page.locator("[id=\"websitename\"]").fill("test");
        page.locator("[id=\"inputCity\"]").fill("pyd");
        page.locator("[id=\"inputAddress1\"]").fill("pyd1");
        page.locator("[id=\"inputAddress2\"]").fill("pyd2");
        page.locator("[id=\"inputState\"]").fill("usa");
        page.locator("[name=\"country\"]").selectOption("US");
        page.locator("[id='inputZip']").fill("12321");
    }

    public void validateSucessMessage(String sucessessage) {
        assertEquals((page.locator("[class=\"success-msg hidden\"]")).textContent(), sucessessage);
    }


}