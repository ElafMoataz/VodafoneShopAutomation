package Tests.stepDefs;

import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.*;

@CucumberOptions
        (
                features={"./src/test/resources/features"},
                glue={"Tests/stepDefs"}
        )
@Listeners({ExtentITestListenerClassAdapter.class})
public class TestsRunner extends AbstractTestNGCucumberTests {
//        to run tests in parallel uncomment the following code
//        @DataProvider(parallel = true)
//        public Object[][] scenarios() {
//                return super.scenarios();
//        }
        @BeforeTest
        public void openSession() {
                BaseTest.setUp();
        }

        @AfterTest
        public void endSession() {
                BaseTest.quitBrowser();
        }
}
