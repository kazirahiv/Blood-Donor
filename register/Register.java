package register;
import frames.*;
import repository.*;
public class Register{
    public IndexWindow indexWindow;
    public SignupWindow signupWindow;
    //public SearchResultWindow searchResultWindow;
    public LogInWindow loginWindow;
    public DonorRepo donorRepo;
	public Register(){
        indexWindow = null;
        signupWindow = null;
        loginWindow = null;
        donorRepo = new DonorRepo(20);
	}
}