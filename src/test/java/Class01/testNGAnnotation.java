package Class01;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class testNGAnnotation {

    // first test case
    @Test
    public void AfirstTestCase() {
        System.out.println("i am the first test case");
    }

    @Test
    public void BsecondTestCase() {
        System.out.println("i am the second test case");
    }

    @Test
    public void CthirdTestCase() {
        System.out.println("i am the third test case");
    }

    @Test
    public void DforthTestCase() {
        System.out.println("i am the third test case");
    }

    @BeforeMethod
    public void beforMethod() {
        System.out.println("i am befor method");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("i am after method");
    }

}
