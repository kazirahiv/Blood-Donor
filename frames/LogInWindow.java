package frames;
import frames.ProfileWindow;
import register.*;
import bindmodels.*;
import java.awt.*;
import java.awt.Rectangle;
import java.awt.event.*;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LogInWindow extends Base implements ActionListener {
    private Register register;
    private Font font;
    private TextField emailTf, passwordTf;
    private Button signup, back, login;
    private Label titleLabel, emailLabel, passwordLabel, notificationLabel;

    public LogInWindow(Register r) {
        super("Log In");
        this.register = r;

        // Setting Window Size
        setSize(800, 420);

        // Setting Font
        font = new Font("Consolas", Font.PLAIN, 20);

        // Setting Layout As null because we wont use a layout
        setLayout(null);

        // adding Window Listener
        addWindowListener(this);

        // notification Label
        notificationLabel = new Label("");
        notificationLabel.setFont(new Font("Consolas", Font.PLAIN, 20));
        notificationLabel.setBounds(576, 66, 200, 20);
        notificationLabel.setBackground(new Color(110, 224, 44));
        notificationLabel.setVisible(false);

        // Title Label
        titleLabel = new Label("User Log-In");
        titleLabel.setFont(new Font("Consolas", Font.BOLD, 30));
        titleLabel.setBounds(50, 68, 250, 40);

        // Email Label
        emailLabel = new Label("E-Mail Here");
        emailLabel.setFont(new Font("Consolas", Font.BOLD, 20));
        emailLabel.setBounds(50, 164, 250, 20);

        // Email Textfield
        emailTf = new TextField();
        emailTf.setFont(new Font("Consolas", Font.PLAIN, 20));
        emailTf.setBounds(54, 190, 260, 30);
        emailTf.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent EVT) {
                String value = emailTf.getText();
                int l = value.length();
                if (l > 25) {
                    notificationLabel.setText("More than 25 char");
                    notificationLabel.setBackground(Color.RED);
                    notificationLabel.setVisible(true);
                } else {
                    notificationLabel.setVisible(false);
                }
            }
        });

        // Password Label
        passwordLabel = new Label("Password Here");
        passwordLabel.setFont(new Font("Consolas", Font.BOLD, 20));
        passwordLabel.setBounds(50, 240, 250, 20);

        // password textfield
        passwordTf = new TextField();
        passwordTf.setFont(new Font("Consolas", Font.PLAIN, 20));
        passwordTf.setBounds(54, 264, 260, 30);
        passwordTf.setEchoChar('*');
        passwordTf.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent EVT) {
                String value = passwordTf.getText();
                int l = value.length();
                if (l > 10) {
                    notificationLabel.setText("More than 10 char");
                    notificationLabel.setBackground(Color.RED);
                    notificationLabel.setVisible(true);
                } else {
                    notificationLabel.setVisible(false);
                }
            }
        });

        // Back Button
        back = new Button("Back");
        back.setFont(new Font("Consolas", Font.BOLD, 12));
        back.setBounds(487, 380, 150, 30);
        back.addActionListener(this);

        // Signup Button
        login = new Button("Log In");
        login.setFont(new Font("Consolas", Font.BOLD, 12));
        login.setBounds(637, 380, 150, 30);
        login.addActionListener(this);

        // add components
        add(titleLabel);
        add(back);
        add(emailLabel);
        add(emailTf);
        add(passwordLabel);
        add(passwordTf);
        add(login);
        add(notificationLabel);

        // Will be using this to get
        // coordinate in window for placing components
        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                System.out.println(x + "," + y);
            }
        });
    }

    public void paint(Graphics g) {
        g.drawLine(50, 112, 327, 112);
        g.drawLine(50, 114, 329, 114);
        // g.drawRect(562, 56, 200, 40);
    }

    // Close on hitting Window Close Button
    public void windowClosing(WindowEvent we) {
        System.out.println("Window is closing");
        System.exit(0);
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.equals(back.getLabel()))
        {
            this.setVisible(false);
            register.indexWindow.setVisible(true);
        }

        if (command.equals(login.getLabel()))
        {
            String email = emailTf.getText();
            String password = passwordTf.getText();
            boolean validationPass = false;
            if(password.length()<=10 && email.length()<25)
            {
                validationPass = true;
            }

            if(validationPass)
            {
                System.out.println(email);
                System.out.println(password);
                try
                {
                    BindDonor donor;
                    donorRepo.loadDonors("SELECT * FROM BloodDonor.User;");
                    donor = donorRepo.checkDonorAuth(email, password);
                    if(donor.authenticated)
                    {
                        System.out.println("Authentication Successful");
                        donor.donor.print();
                        if(donor.donor == null){ System.out.println("Donor is null");}
                        donorRepo.ClearDonor();
                        ProfileWindow profile = new ProfileWindow(donor.donor, register);
                        this.setVisible(false);
                        profile.setVisible(true);
                        //register.profileWindow.setDonor(donor.donor);
                        //register.profileWindow.setVisible(true);
                        
                    }
                    else
                    {
                        notificationLabel.setText("Wrong Credentials");
                        notificationLabel.setBackground(Color.RED);
                        notificationLabel.setVisible(true);
                    }
                }
                catch(Exception ex)
                {
                    System.out.println(ex);
                }
            }
            
            
        }
    }

    public void windowActivated(WindowEvent e) {
    }

    public void windowClosed(WindowEvent e) {
    }

    public void windowDeactivated(WindowEvent e) {
    }

    public void windowDeiconified(WindowEvent e) {
    }

    public void windowIconified(WindowEvent e) {
    }

    public void windowOpened(WindowEvent e) {
    }

}
