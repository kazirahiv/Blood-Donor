package frames;
import register.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class IndexWindow extends Base implements ActionListener
{
    private Register register;
    public TextField search;
    public Label titleLabel;
    public Button searchBtn, alreadyADonor, beADonor;
    private Font font;
    //Constructor to invoke the window
    public IndexWindow(Register r)
    {
        super("Blood Donor Index");
        this.register = r;
        //Setting Window Size
        setSize(800, 400);
        //Setting Font
        font = new Font("Consolas", Font.PLAIN, 20);
        //Setting Layout As null because we wont use a layout
        setLayout(null);
        //adding Window Listener
        addWindowListener(this);

        //title
        titleLabel = new Label("Search for Blood Donor");
        titleLabel.setBounds(268, 153, 250, 20);
        titleLabel.setFont(font);

        //search input 
        search = new TextField();
        search.setBounds(243, 193, 300, 30);
        search.setText("Search Here .....");
        search.setFont(new Font("Consolas", Font.PLAIN, 12));
        //SearchButton
        searchBtn = new Button("Search");
        searchBtn.setBounds(341,240, 100, 30);
        searchBtn.setFont(new Font("Consolas", Font.PLAIN, 15));

        //signupButton

        beADonor = new Button("Be A Donor");
        beADonor.setFont(new Font("Consolas", Font.BOLD, 12));
        beADonor.setBounds(528,366, 100, 30);
        beADonor.addActionListener(this);
        
        //loginButton
        alreadyADonor = new Button("Already A Donor");
        alreadyADonor.setFont(new Font("Consolas", Font.BOLD, 12));
        alreadyADonor.setBounds(637,366, 150, 30);
        alreadyADonor.addActionListener(this);

        //adding Components to frame
        add(titleLabel);
        add(search);
        add(searchBtn);
        add(beADonor);
        add(alreadyADonor);
        //Will be using this to get
        //coordinate  in window for placing components
        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int x=e.getX();
                int y=e.getY();
                System.out.println(x+","+y);
            }
        });
    }
    //Close on hitting Window Close Button
    public void windowClosing(WindowEvent we){
        System.out.println("Window is closing");
		System.exit(0);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        String command = e.getActionCommand();

        if(command.equals(beADonor.getLabel()))
        {
            this.setVisible(false);
            register.signupWindow.setVisible(true);
        }
        if(command.equals(alreadyADonor.getLabel()))
        {
            this.setVisible(false);
            register.loginWindow.setVisible(true);
        }
    }
    public void windowActivated(WindowEvent e){}
	public void windowClosed(WindowEvent e){}
	public void windowDeactivated(WindowEvent e){}
	public void windowDeiconified(WindowEvent e){}
	public void windowIconified(WindowEvent e){}
	public void windowOpened(WindowEvent e){}
}