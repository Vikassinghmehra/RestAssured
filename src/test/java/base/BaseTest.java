package base;

import com.aventstack.extentreports.Status;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.reflect.Method;

/**
 * @author Vikas Mehra
 * @date 26/06/21 10:52 AM
 */
public class BaseTest extends BaseHelper{

    @Parameters({"environment"})
    @BeforeSuite(alwaysRun = true)
    public void init(@Optional("TestEnvironment")String environment){
        readConfig(environment);
    }

    @BeforeMethod
    public void beforeMethod(Method method){
        test=extentReporter.createTest(method.getDeclaringClass().getSimpleName() + " | " +method.getName());
        test.assignAuthor("Vikas Mehra");
    }

    @AfterMethod
    public void tearDownMethod(ITestResult result){
        switch (result.getStatus()){
            case ITestResult.FAILURE:
                test.log(Status.FAIL,"Test Case Failed : " + result.getName());
                test.log(Status.FAIL,"Exception/Error: " + result.getThrowable());
            case ITestResult.SKIP:
                test.log(Status.SKIP, "Test Case Skipped: " + result.getName());
                break;
            case ITestResult.SUCCESS:
                test.log(Status.PASS, "Test Case Passed: " + result.getName());
                break;
        }
    }
    @AfterSuite
    public void tearDownSuite(){
        extentReporter.flush();
    }

}
