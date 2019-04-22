import java.awt.*;
import java.awt.event.*;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


class SignupWindow extends Frame implements WindowListener, ActionListener
{
    private Register register;
    private Font font;
    public Button signup;
    private TextField userNameTf, passwordTf, phoneTf, emailTf;
    private Label titleLabel,usernameLabel, phoneLabel, emailLabel,passwordLabel;
    private Checkbox APlus, AMinus, ABPlus, ABMinus, BPlus, BMinus, OPlus, OMinus;
    private CheckboxGroup bloodGroups;
    private String selectedBGroup = null;
    public SignupWindow(Register r)
    {
        super("Blood Donor Sign Up");
        this.register = r;
        //Setting Window Size
        setSize(800, 400);
        //Setting Font
        font = new Font("Consolas", Font.PLAIN, 20);
        //Setting Layout As null because we wont use a layout
        setLayout(null);
        //adding Window Listener
        addWindowListener(this);

        //titlelabel
        titleLabel = new Label("Sign Up Here");
        titleLabel.setFont(new Font("Consolas", Font.BOLD, 30));
        titleLabel.setBounds(50, 68, 250, 40);

        //username label
        usernameLabel = new Label("User Name");
        usernameLabel.setFont(new Font("Consolas", Font.PLAIN, 20));
        usernameLabel.setBounds(56, 130, 150, 20);

        //username input
        userNameTf = new TextField();
        userNameTf.setBounds(58, 161, 260, 30);
        
        //password label
        passwordLabel = new Label("Password");
        passwordLabel.setFont(new Font("Consolas", Font.PLAIN, 20));
        passwordLabel.setBounds(356, 130, 150, 20);
        
        //password input
        passwordTf = new TextField();
        passwordTf.setEchoChar('*');
        passwordTf.setBounds(358, 161, 260, 30);
        
        //checkbox group 

        bloodGroups = new CheckboxGroup();

        //checkboxes 

        APlus = new Checkbox("A+", bloodGroups, false);
        APlus.setBounds(58,200, 80, 30);
        APlus.setFont(new Font("Consolas", Font.BOLD, 15));
        APlus.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {    
                selectedBGroup = APlus.getLabel();
                //System.out.println("Hit on A+");
            }
         });

        AMinus = new Checkbox("A-", bloodGroups, false);
        AMinus.setBounds(158,200, 80, 30);
        AMinus.setFont(new Font("Consolas", Font.BOLD, 15));
        AMinus.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) { 
                selectedBGroup = AMinus.getLabel();            
                //System.out.println("Hit on A-");
            }
         });


        ABPlus = new Checkbox("AB+", bloodGroups, false);
        ABPlus.setBounds(258,200, 80, 30);
        ABPlus.setFont(new Font("Consolas", Font.BOLD, 15));
        ABPlus.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                selectedBGroup = ABPlus.getLabel();             
                //System.out.println("Hit on AB+");
            }
         });

        
        ABMinus = new Checkbox("AB-", bloodGroups, false);
        ABMinus.setBounds(358,200, 80, 30);
        ABMinus.setFont(new Font("Consolas", Font.BOLD, 15));
        ABMinus.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {             
                selectedBGroup = ABMinus.getLabel();
                //System.out.println("Hit on AB-");
            }
         });

        BPlus = new Checkbox("B+", bloodGroups, false);
        BPlus.setBounds(458,200, 80, 30);
        BPlus.setFont(new Font("Consolas", Font.BOLD, 15));
        BPlus.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                selectedBGroup = BPlus.getLabel();             
               //System.out.println("Hit on B+");
            }
         });
        
        BMinus = new Checkbox("B-", bloodGroups, false);
        BMinus.setBounds(558,200, 80, 30);
        BMinus.setFont(new Font("Consolas", Font.BOLD, 15));
        BMinus.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                selectedBGroup = BMinus.getLabel();               
               //System.out.println("Hit on B-");
            }
         });
        
        OPlus = new Checkbox("O+", bloodGroups, false);
        OPlus.setBounds(58,240, 80, 30);
        OPlus.setFont(new Font("Consolas", Font.BOLD, 15));
        OPlus.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                selectedBGroup = OPlus.getLabel();             
               //System.out.println("Hit on O+");
            }
         });
        
        OMinus = new Checkbox("O-", bloodGroups, false);
        OMinus.setBounds(158,240, 80, 30);
        OMinus.setFont(new Font("Consolas", Font.BOLD, 15));
        OMinus.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {             
                selectedBGroup = OMinus.getLabel(); 
                //System.out.println("Hit on O-");
            }
         });

        //phone label
        phoneLabel = new Label("Phone");
        phoneLabel.setFont(new Font("Consolas", Font.PLAIN, 20));
        phoneLabel.setBounds(56, 280, 150, 20);
        //phone input
        phoneTf = new TextField();
        phoneTf.setFont(new Font("Consolas", Font.PLAIN, 20));
        phoneTf.setBounds(56, 310, 260, 30);
        

        //email label
        emailLabel = new Label("E-Mail");
        emailLabel.setFont(new Font("Consolas", Font.PLAIN, 20));
        emailLabel.setBounds(356, 280, 150, 20);
        //email input
        emailTf = new TextField();
        emailTf.setFont(new Font("Consolas", Font.PLAIN, 20));
        emailTf.setBounds(356, 310, 260, 30);

        //SignupButton
        signup = new Button("Sign Up");
        signup.setFont(new Font("Consolas", Font.BOLD, 12));
        signup.setBounds(637,366, 150, 30);
        signup.addActionListener(this);
        //adding Components to frame
        add(titleLabel);
        add(usernameLabel);
        add(userNameTf);
        add(passwordLabel);
        add(passwordTf);

        add(APlus);
        add(AMinus);
        add(ABPlus);
        add(ABMinus);
        add(BPlus);
        add(BMinus);
        add(OPlus);
        add(OMinus);

        add(phoneLabel);
        add(phoneTf);
        add(emailLabel);
        add(emailTf);
        add(signup);


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


    public void paint(Graphics g){
        g.drawLine(50,112,327,112);
        g.drawLine(50,114,329,114);
	}
    //Close on hitting Window Close Button
    public void windowClosing(WindowEvent we){
        System.out.println("Window is closing");
		System.exit(0);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        String command = e.getActionCommand();

        if(command.equals(signup.getLabel()))
        {
            String username = userNameTf.getText();
            String password = passwordTf.getText();
            String phone = phoneTf.getText();
            String email = emailTf.getText();
            String bgroup = selectedBGroup;
            System.out.println(username+" "+password+" "+phone+" "+email+" "+bgroup);
        }
    }


    
    public void windowActivated(WindowEvent e){}
	public void windowClosed(WindowEvent e){}
	public void windowDeactivated(WindowEvent e){}
	public void windowDeiconified(WindowEvent e){}
	public void windowIconified(WindowEvent e){}
	public void windowOpened(WindowEvent e){}
}
