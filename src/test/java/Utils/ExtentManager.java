package Utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

    public static ExtentReports extent;
    public static ExtentTest test;

    public static ExtentReports getInstance() {
        if (extent == null) {
            createInstance("test-output/extentReport.html");
        }
        return extent;
    }

    public static ExtentReports createInstance(String filePath) {
        // Cambiado a ExtentSparkReporter
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(filePath);
        sparkReporter.config().setTheme(Theme.STANDARD);
        sparkReporter.config().setDocumentTitle("Automation Test Report");
        sparkReporter.config().setReportName("Selenium Test Results");

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        extent.setSystemInfo("Host Name", "Localhost");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("User", "Irene Aguilar");
        // extent.setSystemInfo("User", System.getProperty("user.name"));
        return extent;
    }
    public static void flushReport() {

        extent.flush();
    }
    }
