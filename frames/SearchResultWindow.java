package frames;
import register.*;
import entities.*;
import java.awt.*;
import java.awt.Rectangle;
import java.awt.event.*;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SearchResultWindow extends Base implements ActionListener {
    private Register register;
    private Font font;
    public int arrCount;
    private int totalDonors = 0;
    private Donor matchedDonors[];
    private Donor currentDonor;
    public Button signup, back, sendEmail, sendMessage, next, previous;
    private Label titleLabel, nameLabel, phoneLabel, areaLabel, searchResultsForLabel,
                  nameValue, areaValue, phoneValue, results, count, notificationLabel;


    public SearchResultWindow(Donor[] matchedDonors ,Register r) {
        super("Search Results");
        this.register = r;
        this.matchedDonors = matchedDonors;

        //takes the first element in array as current donor 
        //to show inital result 
        arrCount = 0;
        currentDonor = matchedDonors[arrCount];

        //total donors in array
        for(Donor d : matchedDonors)
            {
                if(d != null)
                {
                   totalDonors++;
                }
            }


        
        // Setting Window Size
        setSize(800, 420);

        // Setting Font
        font = new Font("Consolas", Font.PLAIN, 20);

        // Setting Layout As null because we wont use a layout
        setLayout(null);

        // adding Window Listener
        addWindowListener(this);


        // titlelabel
        titleLabel = new Label("Search Results");
        titleLabel.setFont(new Font("Consolas", Font.BOLD, 30));
        titleLabel.setBounds(50, 68, 250, 40);

        // name label
        nameLabel = new Label("Name  :");
        nameLabel.setFont(new Font("Consolas", Font.BOLD, 20));
        nameLabel.setBounds(72, 175, 90, 20);

        // name value
        nameValue = new Label(currentDonor.getName());
        nameValue.setFont(new Font("Consolas", Font.PLAIN, 20));
        nameValue.setBounds(180, 175, 240, 20);
        
        //phone label
        phoneLabel = new Label("Phone :");
        phoneLabel.setFont(new Font("Consolas", Font.BOLD, 20));
        phoneLabel.setBounds(72, 220, 90, 20);

        //phone value 
        phoneValue = new Label(currentDonor.getPhoneNumber());
        phoneValue.setFont(new Font("Consolas", Font.PLAIN, 20));
        phoneValue.setBounds(180, 220, 240, 20);

        //area label
        areaLabel = new Label("Area  :");
        areaLabel.setFont(new Font("Consolas", Font.BOLD, 20));
        areaLabel.setBounds(72, 260, 90, 20);

        //area value 
        areaValue = new Label(currentDonor.getAddressArea());
        areaValue.setFont(new Font("Consolas", Font.PLAIN, 20));
        areaValue.setBounds(180, 260, 240, 20);

        // search results for label
        searchResultsForLabel = new Label();
        searchResultsForLabel.setText("Search Results For .....");
        searchResultsForLabel.setFont(new Font("Consolas", Font.PLAIN, 18));
        searchResultsForLabel.setBounds(50, 125, 250, 18);

        //back button 
        back = new Button("Back");
        back.setFont(new Font("Consolas", Font.BOLD, 12));
        back.setBounds(630,370, 150, 30);
        back.addActionListener(this);

        //send mail button 
        sendEmail = new Button("E-Mail");
        sendEmail.setFont(new Font("Consolas", Font.BOLD, 16));
        sendEmail.setBounds(448, 174, 100, 40);


        //send Message 
        sendMessage = new Button("Message");
        sendMessage.setFont(new Font("Consolas", Font.BOLD, 16));
        sendMessage.setBounds(448, 245, 100, 40);

        //previous button
        previous = new Button("Previous");
        previous.setFont(new Font("Consolas", Font.BOLD, 12));
        previous.setBounds(350, 310, 100, 30);
        previous.addActionListener(this);

        //next button
        next = new Button("Next");
        next.setFont(new Font("Consolas", Font.BOLD, 12));
        next.setBounds(456, 310, 100, 30);
        next.addActionListener(this);

        //count label
        count = new Label();
        count.setText( String.valueOf(totalDonors));
        count.setFont(new Font("Consolas", Font.PLAIN, 50));
        count.setBounds(605, 196, 60, 50);

        //results label
        results = new Label();
        results.setText("Results Found !!");
        results.setFont(new Font("Consolas", Font.PLAIN, 13));
        results.setBounds(672, 222, 100, 13);

        // notification Label
        notificationLabel = new Label("");
        notificationLabel.setFont(new Font("Consolas", Font.PLAIN, 20));
        notificationLabel.setBounds(576, 66, 200, 20);
        notificationLabel.setBackground(new Color(110,224,44));
        notificationLabel.setVisible(false);

        //add components 
        add(titleLabel);
        add(back);
        add(searchResultsForLabel);
        add(sendEmail);
        add(sendMessage);
        add(previous);
        add(next);
        add(nameLabel);
        add(phoneLabel);
        add(areaLabel);
        add(nameValue);
        add(phoneValue);
        add(areaValue);
        add(count);
        add(results);
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

    public void refresh()
    {
        nameValue.setText("");
        areaValue.setText("");
        phoneValue.setText("");

        nameValue.setText(currentDonor.getName());
        areaValue.setText(currentDonor.getAddressArea());
        phoneValue.setText(currentDonor.getPhoneNumber());
    }

    public void next()
    {
        if(arrCount + 1 < totalDonors)
        {
            notificationLabel.setVisible(false);
            arrCount++;
            currentDonor = matchedDonors[arrCount];
        }else
        {
            notificationLabel.setText("No more donor found");
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
            currentDonor = matchedDonors[arrCount];
        }else
        {
            notificationLabel.setText("No more donor found");
            notificationLabel.setBackground(Color.RED);
            notificationLabel.setVisible(true);
        }
    }

    public void paint(Graphics g) {
        g.drawLine(50, 112, 327, 112);
        g.drawLine(50, 114, 329, 114);
        g.drawRect(53, 152, 500, 150);
        g.drawLine(443, 153, 443, 302);
        g.drawLine(443, 229, 552, 229);
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
            currentDonor.print();
            refresh();
        }

        if (command.equals(previous.getLabel()))
        {
            back();
            currentDonor.print();
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
