package frames;
import register.*;
import entities.*;
import bindmodels.*;
import java.awt.*;
import java.awt.Rectangle;
import java.awt.event.*;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ProfileWindow extends Base implements ActionListener {
    private Register register;
    private Donor donor;
    private Font font;
    private Button signup, back, inbox;
    private TextField userNameTf, passwordTf, phoneTf, emailTf, addressTf;
    private Label titleLabel, usernameLabel, phoneLabel, emailLabel,addressLabel, passwordLabel, notificationLabel;
    private Checkbox APlus, AMinus, ABPlus, ABMinus, BPlus, BMinus, OPlus, OMinus;
    private CheckboxGroup bloodGroups;
    private String selectedBGroup = null;
    private int userMessageCount; 

    public ProfileWindow(Donor d, Register r) {
        super("User Profile");
        System.out.println("This Is Profile Window");
        this.donor = d;
        this.register = r;
        this.userMessageCount =  messageRepo.GetMessageCount(donor.getId());
        // Setting Window Size
        setSize(800, 420);
        // Setting Font
        font = new Font("Consolas", Font.PLAIN, 20);
        // Setting Layout As null because we wont use a layout
        setLayout(null);
        // adding Window Listener
        addWindowListener(this);

        
        // titlelabel
        titleLabel = new Label("Profile");
        titleLabel.setFont(new Font("Consolas", Font.BOLD, 30));
        titleLabel.setBounds(50, 68, 250, 40);

        // username label
        usernameLabel = new Label("User Name");
        usernameLabel.setFont(new Font("Consolas", Font.PLAIN, 20));
        usernameLabel.setBounds(56, 130, 150, 20);
        
        // username input
        userNameTf = new TextField(donor.name);
        userNameTf.setFont(new Font("Consolas", Font.PLAIN, 20));
        userNameTf.setBounds(58, 161, 260, 30);
        userNameTf.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent EVT) {
				String value = userNameTf.getText();
                int l = value.length();
                if(l>50)
                {
                    notificationLabel.setText("More than 50 char");
                    notificationLabel.setBackground(Color.RED);
                    notificationLabel.setVisible(true);
                }
                else
                {
                    notificationLabel.setVisible(false);
                }
			}
		});

        // password label
        passwordLabel = new Label("Password");
        passwordLabel.setFont(new Font("Consolas", Font.PLAIN, 20));
        passwordLabel.setBounds(356, 130, 150, 20);

        // password input
        passwordTf = new TextField(donor.password);
        passwordTf.setFont(new Font("Consolas", Font.PLAIN, 20));
        passwordTf.setEchoChar('*');
        passwordTf.setBounds(358, 161, 260, 30);
        passwordTf.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent EVT) {
				String value = passwordTf.getText();
                int l = value.length();
                if(l>10)
                {
                    notificationLabel.setText("More than 10 char");
                    notificationLabel.setBackground(Color.RED);
                    notificationLabel.setVisible(true);
                }
                else
                {
                    notificationLabel.setVisible(false);
                }
			}
		});

        // notification Label
        notificationLabel = new Label("");
        notificationLabel.setFont(new Font("Consolas", Font.PLAIN, 20));
        notificationLabel.setBounds(576, 46, 200, 20);
        notificationLabel.setBackground(new Color(110,224,44));
        notificationLabel.setVisible(false);

        //inbox button 
        inbox = new Button("You have ("+ userMessageCount +") Messages");
        inbox.setBounds(351, 72, 440, 40);
        inbox.setFont(new Font("Consolas", Font.PLAIN, 20));
        inbox.addActionListener(this);

        // checkbox group
        bloodGroups = new CheckboxGroup();

        // checkboxes

        APlus = new Checkbox("A+", bloodGroups, false);
        APlus.setBounds(58, 200, 80, 30);
        APlus.setFont(new Font("Consolas", Font.BOLD, 15));
        APlus.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                selectedBGroup = APlus.getLabel();
                // System.out.println("Hit on A+");
            }
        });

        AMinus = new Checkbox("A-", bloodGroups, false);
        AMinus.setBounds(158, 200, 80, 30);
        AMinus.setFont(new Font("Consolas", Font.BOLD, 15));
        AMinus.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                selectedBGroup = AMinus.getLabel();
                // System.out.println("Hit on A-");
            }
        });

        ABPlus = new Checkbox("AB+", bloodGroups, false);
        ABPlus.setBounds(258, 200, 80, 30);
        ABPlus.setFont(new Font("Consolas", Font.BOLD, 15));
        ABPlus.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                selectedBGroup = ABPlus.getLabel();
                // System.out.println("Hit on AB+");
            }
        });

        ABMinus = new Checkbox("AB-", bloodGroups, false);
        ABMinus.setBounds(358, 200, 80, 30);
        ABMinus.setFont(new Font("Consolas", Font.BOLD, 15));
        ABMinus.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                selectedBGroup = ABMinus.getLabel();
                // System.out.println("Hit on AB-");
            }
        });

        BPlus = new Checkbox("B+", bloodGroups, false);
        BPlus.setBounds(458, 200, 80, 30);
        BPlus.setFont(new Font("Consolas", Font.BOLD, 15));
        BPlus.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                selectedBGroup = BPlus.getLabel();
                // System.out.println("Hit on B+");
            }
        });

        BMinus = new Checkbox("B-", bloodGroups, false);
        BMinus.setBounds(558, 200, 80, 30);
        BMinus.setFont(new Font("Consolas", Font.BOLD, 15));
        BMinus.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                selectedBGroup = BMinus.getLabel();
                // System.out.println("Hit on B-");
            }
        });

        OPlus = new Checkbox("O+", bloodGroups, false);
        OPlus.setBounds(58, 240, 80, 30);
        OPlus.setFont(new Font("Consolas", Font.BOLD, 15));
        OPlus.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                selectedBGroup = OPlus.getLabel();
                // System.out.println("Hit on O+");
            }
        });

        OMinus = new Checkbox("O-", bloodGroups, false);
        OMinus.setBounds(158, 240, 80, 30);
        OMinus.setFont(new Font("Consolas", Font.BOLD, 15));
        OMinus.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                selectedBGroup = OMinus.getLabel();
                // System.out.println("Hit on O-");
            }
        });

        //set checkbox from user 
        if(donor.bloodGroup!= null)
        {
            if(donor.bloodGroup.equals("A+"))
            {
                APlus.setState(true);
            }
            else if(donor.bloodGroup.equals("A-"))
            {
                AMinus.setState(true);
            }
            else if(donor.bloodGroup.equals("AB+"))
            {
                ABPlus.setState(true);
            }  
            else if(donor.bloodGroup.equals("AB-"))
            {
                ABMinus.setState(true);
            }
            else if(donor.bloodGroup.equals("B+"))
            {
                BPlus.setState(true);
            }
            else if(donor.bloodGroup.equals("B-"))
            {
                BMinus.setState(true);
            }
            else if(donor.bloodGroup.equals("O+"))
            {
                OPlus.setState(true);
            }
            else if(donor.bloodGroup.equals("O-"))
            {
                OMinus.setState(true);
            }
        }
        

        // phone label
        phoneLabel = new Label("Phone");
        phoneLabel.setFont(new Font("Consolas", Font.PLAIN, 20));
        phoneLabel.setBounds(56, 310, 150, 20);

        // phone input
        phoneTf = new TextField(donor.phoneNumber);
        phoneTf.setFont(new Font("Consolas", Font.PLAIN, 20));
        phoneTf.setBounds(56, 340, 260, 30);
        phoneTf.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent EVT) {
                String value = phoneTf.getText();
                int l = value.length();
                if (EVT.getKeyChar() >= '0' && EVT.getKeyChar() <= '9') {
					phoneTf.setEditable(true);
					notificationLabel.setText("");
                }
                else if(EVT.getKeyCode()==8)
                {
                    phoneTf.setEditable(true);
                }
                else {
					phoneTf.setEditable(false);
                    notificationLabel.setText("Only numeric digits");
                    notificationLabel.setBackground(Color.RED);
                    notificationLabel.setVisible(true);
				}

                if(l>11)
                {
                    notificationLabel.setText("More than 11 char");
                    notificationLabel.setBackground(Color.RED);
                    notificationLabel.setVisible(true);
                }
                else
                {
                    notificationLabel.setVisible(false);
                }
			}
        });
        
        // email label
        emailLabel = new Label("E-Mail");
        emailLabel.setFont(new Font("Consolas", Font.PLAIN, 20));
        emailLabel.setBounds(356, 236, 150, 20);
        
        // email input
        emailTf = new TextField(donor.email);
        emailTf.setFont(new Font("Consolas", Font.PLAIN, 20));
        emailTf.setBounds(356, 260, 260, 30);
        emailTf.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent EVT) {
				String value = emailTf.getText();
                int l = value.length();
                if(l>25)
                {
                    notificationLabel.setText("More than 25 char");
                    notificationLabel.setBackground(Color.RED);
                    notificationLabel.setVisible(true);
                }
                else
                {
                    notificationLabel.setVisible(false);
                }
			}
        });
        
        // address label
        addressLabel = new Label("Address");
        addressLabel.setFont(new Font("Consolas", Font.PLAIN, 20));
        addressLabel.setBounds(356, 310, 150, 20);
        
        // address input
        addressTf = new TextField(donor.addressArea);
        addressTf.setFont(new Font("Consolas", Font.PLAIN, 20));
        addressTf.setBounds(356, 340, 260, 30);
        addressTf.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent EVT) {
				String value = addressTf.getText();
                int l = value.length();
                if(l>50)
                {
                    notificationLabel.setText("More than 50 char");
                    notificationLabel.setBackground(Color.RED);
                    notificationLabel.setVisible(true);
                }
                else
                {
                    notificationLabel.setVisible(false);
                }
			}
        });
        
        // SignupButton
        signup = new Button("Edit");
        signup.setFont(new Font("Consolas", Font.BOLD, 12));
        signup.setBounds(637, 380, 150, 30);
        signup.addActionListener(this);

        //back button 

        back = new Button("Back");
        back.setFont(new Font("Consolas", Font.BOLD, 12));
        back.setBounds(487, 380, 150, 30);
        back.addActionListener(this);

        // adding Components to frame
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
        add(back);
        add(addressLabel);
        add(addressTf);
        add(notificationLabel);

        add(inbox);
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
        //g.drawRect(562, 56, 200, 40);
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


        if (command.equals(signup.getLabel())) {
            int id = donor.id;
            String username = userNameTf.getText();
            String password = passwordTf.getText();
            String phone = phoneTf.getText();
            String email = emailTf.getText();
            String address = addressTf.getText();
            String bgroup = selectedBGroup;
            boolean validationPass = false;
            if(username.length()<=50 && password.length()<=10 && phone.length()==11 && email.length()<25 && address.length()<=50)
            {
                validationPass = true;
            }
            // System.out.println(username+" "+password+" "+phone+" "+email+" "+bgroup);          
            String editSql = "UPDATE `User` SET `Name`='"+username+"', `AddressArea`='"+address+"', `PhoneNumber`='"+phone
            +"', `Email`='"+email+"', `IsDonor`='0', `Password`='"+ password +"', `BloodGroup`='"+bgroup+"' WHERE `id`='"+id+"'; ";
            
            
            // modfied update db. will return true if database is updated with new value;
            if(validationPass)
            {
                if (dbfactory.updateDB(editSql)) {
                    //clear text inputs 
                    // userNameTf.setText("");
                    // passwordTf.setText("");
                    // phoneTf.setText("");
                    // emailTf.setText("");
                    // addressTf.setText("");
                    // bloodGroups.setSelectedCheckbox(null);
                    validationPass = false;
                    notificationLabel.setBackground(Color.GREEN);
                    notificationLabel.setText("Database Updated !");
                    notificationLabel.setVisible(true);
    
    
                    //timer to set notification for 2 seconds.
                    new java.util.Timer().schedule(new java.util.TimerTask() {
                        @Override
                        public void run() {
                            // your code here
                            notificationLabel.setVisible(false);
                        }
                    }, 2000);
                }
            }
            else
            {
                notificationLabel.setBackground(Color.RED);
                notificationLabel.setText("Validation ERROR!");
                notificationLabel.setVisible(true);
            }
            
        }
    
        if(command.equals(inbox.getLabel()))
        {
            if( userMessageCount >0 )
            {
                Message[] messages = messageRepo.GetMessages();
                for (Message m : messages) {
                    if (m != null) {
                        m.print();
                    }
                }
                if(messages !=null && register != null){
                    System.out.println("These are not null");
                    MessageResultWindow messageResult = new MessageResultWindow(messages,register);
                    this.setVisible(false);
                    messageResult.setVisible(true);
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
