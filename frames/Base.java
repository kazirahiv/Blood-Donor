package frames;
import repository.*;
import java.awt.*;
import java.awt.event.*;
public abstract class Base extends Frame implements WindowListener
{
    protected DataAccess dbfactory;
    protected DonorRepo donorRepo;
    Base(String param)
    {
        super(param);
        System.out.println("This Is Base");
        dbfactory = new DataAccess("root", "abc-1234","BloodDonor");
        donorRepo = new DonorRepo(20);
    }
}