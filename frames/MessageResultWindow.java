package frames;
import register.*;
import bindmodels.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MessageResultWindow extends Base implements ActionListener {
    private Register register;
    public int arrCount;
    private int totalMessages = 0;
    private Message matchedMessages[];
    private Message currentMessage;
    private TextArea messageText;
    public Button signup, back, sendEmail, sendMessage, next, previous;
    private Label titleLabel, nameLabel, phoneLabel, areaLabel, searchResultsForLabel,
                  nameValue, messageLabel, results, count, notificationLabel;


    public MessageResultWindow(Message[] matchedMessages ,Register r) {
        super("Inbox");
        this.register = r;
        this.matchedMessages = matchedMessages;

        //takes the first element in array as current Message 
        //to show inital result 
        arrCount = 0;
        currentMessage = matchedMessages[arrCount];

        //total Messages in array
        for(Message d : matchedMessages)
            {
                if(d != null)
                {
                   totalMessages++;
                }
            }
        
        // Setting Window Size
        setSize(800, 420);

        // Setting Layout As null because we wont use a layout
        setLayout(null);

        // adding Window Listener
        addWindowListener(this);


        // titlelabel
        titleLabel = new Label("Messages ");
        titleLabel.setFont(new Font("Consolas", Font.BOLD, 30));
        titleLabel.setBounds(50, 68, 250, 40);

        // name label
        nameLabel = new Label("Sender  :");
        nameLabel.setFont(new Font("Consolas", Font.BOLD, 20));
        nameLabel.setBounds(72, 175, 110, 20);

        // name value
        nameValue = new Label(currentMessage.getName());
        nameValue.setFont(new Font("Consolas", Font.PLAIN, 20));
        nameValue.setBounds(180, 175, 240, 20);

        //message label
        messageLabel = new Label("Message :");
        messageLabel.setFont(new Font("Consolas", Font.BOLD, 20));
        messageLabel.setBounds(72, 200, 110, 20);

        //message textfield
        messageText = new TextArea();
        messageText.setBounds(61, 235, 485, 115);
        messageText.setText(currentMessage.getMessage());
        messageText.setEditable(false);

        // search results for label
        searchResultsForLabel = new Label();
        searchResultsForLabel.setText("Your Messages .....");
        searchResultsForLabel.setFont(new Font("Consolas", Font.PLAIN, 18));
        searchResultsForLabel.setBounds(50, 125, 250, 18);

        //back button 
        back = new Button("Back");
        back.setFont(new Font("Consolas", Font.BOLD, 12));
        back.setBounds(630,370, 150, 30);
        back.addActionListener(this);
        
        //previous button
        previous = new Button("Previous");
        previous.setFont(new Font("Consolas", Font.BOLD, 12));
        previous.setBounds(350, 365, 100, 30);
        previous.addActionListener(this);

        //next button
        next = new Button("Next");
        next.setFont(new Font("Consolas", Font.BOLD, 12));
        next.setBounds(456, 365, 100, 30);
        next.addActionListener(this);

        //count label
        count = new Label();
        count.setText(String.valueOf(totalMessages) );
        count.setFont(new Font("Consolas", Font.PLAIN, 50));
        count.setBounds(605, 196, 60, 50);

        //results label
        results = new Label();
        results.setText("Messages Found !!");
        results.setFont(new Font("Consolas", Font.PLAIN, 13));
        results.setBounds(672, 222, 100, 13);

        // notification Label
        notificationLabel = new Label("");
        notificationLabel.setFont(new Font("Consolas", Font.PLAIN, 20));
        notificationLabel.setBounds(556, 66, 250, 20);
        notificationLabel.setBackground(new Color(110,224,44));
        notificationLabel.setVisible(false);

        //add components 
        add(titleLabel);
        add(back);
        add(searchResultsForLabel);
        add(previous);
        add(next);
        add(nameLabel);
        add(nameValue);
        add(count);
        add(results);
        add(notificationLabel);
        add(messageLabel);
        add(messageText);
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

    public void refresh()
    {
        nameValue.setText("");
        messageText.setText("");
        nameValue.setText(currentMessage.getName());
        messageText.setText(currentMessage.getMessage());
    }

    public void next()
    {
        if(arrCount + 1 < totalMessages)
        {
            notificationLabel.setVisible(false);
            arrCount++;
            currentMessage = matchedMessages[arrCount];
        }else
        {
            notificationLabel.setText("No more Message found");
            notificationLabel.setBackground(Color.RED);
            notificationLabel.setVisible(true);
        }
    }

    public void back()
    {
        if(arrCount - 1 >= 0  )
        {
            notificationLabel.setVisible(false);
            arrCount--;
            currentMessage = matchedMessages[arrCount];
        }else
        {
            notificationLabel.setText("No more Message found");
            notificationLabel.setBackground(Color.RED);
            notificationLabel.setVisible(true);
        }
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

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.equals(back.getLabel()))
        {
            this.setVisible(false);
            register.indexWindow.setVisible(true);
        }

        if (command.equals(next.getLabel()))
        {
            next();
            currentMessage.print();
            refresh();
        }

        if (command.equals(previous.getLabel()))
        {
            back();
            currentMessage.print();
            refresh();
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
