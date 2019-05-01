package frames;
import register.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MessageWindow extends Base implements ActionListener {
    private Register register;
    private Font font;
    public Button send, back;
    private Label titleLabel, emailLabel, messageHere, yourNameHere, notificationLabel;
    private TextArea messageText;
    private TextField yourNameText;
    private int userId;

    public MessageWindow(int userId, Register r) {
        super("Message");
        this.register = r;
        this.userId = userId;
        System.out.println("User Id Is : "+userId);
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
        notificationLabel.setBackground(new Color(110,224,44));
        notificationLabel.setVisible(false);

        // titlelabel
        titleLabel = new Label("Send Text Message");
        titleLabel.setFont(new Font("Consolas", Font.BOLD, 30));
        titleLabel.setBounds(50, 68, 300, 40);

        //message textfield
        messageText = new TextArea();
        messageText.setBounds(61, 235, 485, 115);

        //message here label
        messageHere = new Label("Message Here:");
        messageHere.setFont(new Font("Consolas", Font.PLAIN, 15));
        messageHere.setBounds(60, 211, 150, 20);


        //your name text input 
        yourNameText = new TextField();
        yourNameText.setBounds(61, 178, 300, 30);
        yourNameText.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent EVT) {
				String value = yourNameText.getText();
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

        // your name here label
        yourNameHere = new Label("Your Name Here:");
        yourNameHere.setFont(new Font("Consolas", Font.PLAIN, 15));
        yourNameHere.setBounds(61, 158, 200, 20);

        //back button 
        back = new Button("Back");
        back.setFont(new Font("Consolas", Font.BOLD, 12));
        back.setBounds(487, 380, 150, 30);
        back.addActionListener(this);


        //send button
        send = new Button("Send");
        send.setFont(new Font("Consolas", Font.BOLD, 12));
        send.setBounds(637, 380, 150, 30);
        send.addActionListener(this);

        //add components 
        add(titleLabel);
        add(back);
        add(messageText);
        add(messageHere);
        add(yourNameText);
        add(yourNameHere);
        add(send);
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
        g.drawRect(53, 152, 500, 200);
    }

    // Close on hitting Window Close Button
    public void windowClosing(WindowEvent we) {
        System.out.println("Window is closing");
        System.exit(0);
    }

    //INSERT INTO `BloodDonor`.`Message` (`userId`, `Message`) VALUES ('1', 'Mon Mejaj Valo nai');


    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.equals(back.getLabel()))
        {
            this.setVisible(false);
            register.indexWindow.setVisible(true);
        }

        if(command.equals(send.getLabel()))
        {
            String sql = "INSERT INTO `BloodDonor`.`Message` (`userId`, `Message`, `SenderName`) VALUES ('"+userId+"', '"+ messageText.getText() +"', '"+yourNameText.getText()+"');";
            if (dbfactory.updateDB(sql)) {
                notificationLabel.setBackground(Color.GREEN);
                notificationLabel.setText("Message Sent !");
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
