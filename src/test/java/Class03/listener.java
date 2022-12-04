package Class03;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class listener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("the test case has pass");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("the test case has failed");
    }
}
