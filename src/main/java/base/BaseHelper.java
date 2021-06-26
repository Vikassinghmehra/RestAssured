package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import lombok.extern.slf4j.Slf4j;
import org.testng.Reporter;

import java.io.FileReader;
import java.util.Properties;

/**
 * @author Vikas Mehra
 * @date 26/06/21 11:06 AM
 */
@Slf4j
public class BaseHelper {

    public static FileReader reader;
    public static Properties properties = new Properties();
    public static ExtentTest test;
    public static ExtentReports extentReporter= new ExtentReports();
    public static ExtentSparkReporter sparkReporter= new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/Report.html");

    public void readConfig(String environment){
        configureExtentReport();
        try{
            reader=new FileReader("src/main/resources/" +environment +".properties");
            properties.load(reader);
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    private void configureExtentReport(){
        sparkReporter.config().setDocumentTitle(" Automation Report ");
        extentReporter.attachReporter(sparkReporter);
        extentReporter.setSystemInfo("MacOS High Sierra","10.13.6");
    }

    public void reportLog(String message){
        test.log(Status.INFO,message);
        log.info("Message: " + message);
        Reporter.log(message);
    }

}
