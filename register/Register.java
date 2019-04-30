package register;
import frames.*;
import repository.*;
public class Register{
    public IndexWindow indexWindow;
    public SignupWindow signupWindow;
    //public ProfileWindow profileWindow;
    public LogInWindow loginWindow;
    public DonorRepo donorRepo;
	public Register(){
        indexWindow = null;
        signupWindow = null;
        //profileWindow = null;
        loginWindow = null;
        donorRepo = new DonorRepo(20);
        donorRepo.loadDonors("SELECT * FROM BloodDonor.User;");

        //System.out.println("Donor Authentication -"+ donorRepo.checkDonorAuth("rahivjobs@gmail.com", "rahiv123"));
	}
}