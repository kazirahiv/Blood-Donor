import register.*;
import frames.*;
public class ProjectBase{
    public static void main(String str[]){
		Register r=new Register();
        r.indexWindow =new IndexWindow(r);
        r.signupWindow = new SignupWindow(r);
        r.loginWindow = new LogInWindow(r);
        r.indexWindow.setVisible(true);
    }
}