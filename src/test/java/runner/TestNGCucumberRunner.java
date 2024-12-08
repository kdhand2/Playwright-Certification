package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@CucumberOptions(
        features = "src/test/resources",
        glue = "pages",
        plugin = {"pretty", "html:target/cucumber-reports.html"}

)
public class TestNGCucumberRunner extends AbstractTestNGCucumberTests {

    @Test
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}