import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

class logFrame extends JFrame implements ActionListener {
    //Arraylist to store user credentials
    ArrayList<User> users = new ArrayList<>();
   //Creating an object to call a method from WestminsterShoppingManager
   WestminsterShoppingManager obj1 = new WestminsterShoppingManager();
    Container c;
    JLabel label1,label2,label3, label4;
    JPanel panel1;
    JTextField user;
    JPasswordField pass;
    JButton btn,btn2;

     // Constructor for the logFrame class.
        logFrame(Object[][] productData){
        setTitle("Login");
        setSize(400,300);
        setLocation(600,250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Any component that needs to be displayed in the JFrame should be added to this container.
        c=getContentPane();
        c.setLayout(null);

        label1 = new JLabel("Username");
        label2 = new JLabel("Password");
        label3 = new JLabel("New user?");

        label1.setBounds(75,50,100,20);
        label2.setBounds(75,100,100,20);
        label3.setBounds(105,210,150,20);


        panel1 = new JPanel();
        label4 = new JLabel("");
        panel1.add(label4);
        panel1.setBounds(12, 130, 360, 30);
      // Adding labels to the container
        c.add(label1);
        c.add(label2);
        c.add(label3);
        c.add(panel1);

        user = new JTextField();
        user.setBounds(170,50,120,20);
        c.add(user);

        pass = new JPasswordField();
        pass.setBounds(170,100,120,20);
        c.add(pass);

        btn = new JButton("Enter");
        btn.setBounds(150,170,70,20);
        btn2 = new JButton("Sign Up");
        btn2.setBounds(175,210,90,20);
        c.add(btn);
        c.add(btn2);
        btn.addActionListener(this);  // Add an action listener to the button
        btn2.addActionListener(this);
        setVisible(true);
    }

    //This method is triggered whenever an action event occurs.
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn) {
            String username = user.getText();
            String password = pass.getText();

            boolean found = false;
            for (User user : users) {
                if (user.getUserName().equals(username) && user.getPassword().equals(password)) {
                    if (!found) {
                        label4.setText("");
                        String text1 = "Login successful";
                        //Calling to open the WestminsterGUI
                        obj1.openGUI2();
                        label4.setText(text1);
                        System.out.print("Login successful");
                        dispose(); // Close the login frame
                        found = true; // Prevent multiple instances
                    }
                }
            }
            if (!found) {
                label4.setText("");
                String text1 = "Invalid username or password ";
                label4.setText(text1);
                System.out.println("Invalid username or password.");
            }
        } else if (e.getSource() == btn2) {
            // Proceed with signup action
            new LoginFrame(users).setVisible(true);
        }
    }

}



