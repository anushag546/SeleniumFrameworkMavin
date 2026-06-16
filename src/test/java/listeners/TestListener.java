package listeners;

import com.aventstack.extentreports.*;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.DriverManager;
import utils.ExtentManager;
import utils.ScreenshotUtil;

public class TestListener implements ITestListener {

    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {

        ExtentTest test = ExtentManager.getInstance()
                .createTest(result.getMethod().getMethodName());

        extentTest.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        ExtentTest test = extentTest.get();

        test.log(Status.PASS, "Test Passed");

        // ✅ FIX: Use DriverManager instead of BaseTest
        String path = ScreenshotUtil.takeScreenshot(
                DriverManager.getDriver(),
                result.getName()
        );

        test.pass("Screenshot")
                .addScreenCaptureFromPath(path);
    }

    @Override
    public void onTestFailure(ITestResult result) {

        ExtentTest test = extentTest.get();

        test.log(Status.FAIL, result.getThrowable());

        // ✅ FIX: Use DriverManager instead of BaseTest
        String path = ScreenshotUtil.takeScreenshot(
                DriverManager.getDriver(),
                result.getName()
        );

        test.fail("Failure Screenshot")
                .addScreenCaptureFromPath(path);
    }

    @Override
    public void onFinish(ITestContext context) {
        ExtentManager.getInstance().flush();
    }
}