package Com.UtilClass;


import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import java.io.File;
import java.util.Properties;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources", glue = {"Com.StepDeftn", "Com.Browser"},
        plugin = {"pretty", "html:target/cucumber", "json:target/cucumber.json",
                "com.cucumber.listener.ExtentCucumberFormatter:src/test/Reports/cucumber-extent/report.html",
                "pretty:STDOUT","html:src/test/Reports/cucumber-pretty",
                "json:src/test/Reports/cucumber-json/cucumber.json"},
        monochrome = false)


public class TestRunner {

    @AfterClass
    public static void setup()
    {
        Reporter.loadXMLConfig(new File("src/test/resources/extentReport_config.xml"));
	        Properties p = System.getProperties();
	        p.list(System.out);

        Reporter.setSystemInfo("User Name",System.getProperty("user.name"));
        Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
        Reporter.setSystemInfo("64 Bit", "Windows 10");
        Reporter.setSystemInfo("2.53.0", "Selenium");
        Reporter.setSystemInfo("3.3.9", "Maven");
        Reporter.setSystemInfo("1.8.0_121", "Java Version");
        Reporter.setTestRunnerOutput("Cucumber JUnit Test Runner");



    }

}
