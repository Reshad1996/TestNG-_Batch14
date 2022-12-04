package Class04;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class implementOfListeners implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("the test case has Successfully passed"+result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("the test case has successfully failed"+result.getName());
    }
}
