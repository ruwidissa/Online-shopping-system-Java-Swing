import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class LoginFrame extends JFrame implements ActionListener {
    // Create an ArrayList to store users
    ArrayList<User> users;
    JLabel label1, label2;
    JTextField textField, textField1;
    JButton button1;

    // Constructor for the LoginFrame class.
    LoginFrame(ArrayList<User> users) {
        this.users = users;
        setTitle("Sign Up");
// Setting size location and details of the frame
        setSize(420,580);
        setLocation(592,107);
        label1 = new JLabel("Enter username and password to register");
        label1.setVerticalAlignment(JLabel.TOP);
        label2 = new JLabel("Welcome");

        textField = new JTextField();
        textField.setColumns(15);
        textField.setText("Username");
        textField1 = new JTextField();
        textField1.setColumns(15);
        textField1.setText("Password");

        button1 = new JButton("Enter");
        button1.setHorizontalAlignment(JLabel.CENTER);

// Initializing flow layout
        FlowLayout f = new FlowLayout();
        // FlowLayout.LEADING aligns the components to the leading edge of the container's orientation.
        f.setAlignment(FlowLayout.LEADING);
        f.setHgap(100);
        f.setVgap(70);
        this.setLayout(new FlowLayout());
        this.setLayout(f);
        this.add(label2);
        this.add(label1);
        this.add(textField);
        textField.addActionListener(this);   // Add an action listener to the text field
        this.add(textField1);
        button1.addActionListener(this);
        this.add(button1);

    }

    //This method is triggered whenever an action event occurs.
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button1) {
            String username = textField.getText();
            String password = textField1.getText();

            // Create a new User object
            User user = new User(username, password);

            // Add the user to the ArrayList
            users.add(user);

            // Clear the text fields
            textField.setText("");
            textField1.setText("");

           System.out.println("User registered successfully!");
        }
    }

}
