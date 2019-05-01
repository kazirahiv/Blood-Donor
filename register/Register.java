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
        //searchResultWindow = null;
        loginWindow = null;
        donorRepo = new DonorRepo(20);
        donorRepo.loadDonors("SELECT * FROM BloodDonor.User;");

        //System.out.println("Donor Authentication -"+ donorRepo.checkDonorAuth("rahivjobs@gmail.com", "rahiv123"));
	}
}