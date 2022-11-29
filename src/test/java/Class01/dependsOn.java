package Class01;

import org.testng.annotations.Test;

public class dependsOn {

    @Test
    public void Login(){
        System.out.println(6/0);
    }

     // dashboard method is on run when login method pass
    @Test(dependsOnMethods = {"Login"})
    public  void DashBoardVErification(){

        System.out.println(" after login in i am verifying the dashboard page");
    }

}
