import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class WestminsterGUI extends JFrame implements ActionListener {

    // Initialize a private instance of the ShoppingCart class named 'shoppingCart'
    private ShoppingCart shoppingCart = new ShoppingCart();
    Container c;
    JLabel label1, detailsLabel, detailsLabel2, detailsLabel3, detailsLabel4, detailsLabel5, detailsLabel6, detailsLabel7, detailsLabel8, detailsLabel9, detailsLabel10, detailsLabel11, detailsLabel12, detailsLabel13;
    JComboBox<String> comboBox;
    JButton btn1, btn2;
    JTable table;
    JPanel detailsPanel, detailsPanel2, detailsPanel3, detailsPanel4, detailsPanel5, detailsPanel6, detailsPanel7, detailsPanel8, detailsPanel9, detailsPanel10, detailsPanel11, detailsPanel12, detailsPanel13;


    WestminsterGUI(Object[][] data) {
        shoppingCart = new ShoppingCart();   // Initialize a new instance of the ShoppingCart class.
        String[] categories = {"All", "Electronics", "Clothing"};
        String[] columnNames = {"Product ID", "Name", "Category", "Price(£)", "Info", "Qavailable"};

        // Set the size and location of the frame
        setSize(800, 680);
        setLocationRelativeTo(null);  // Center the frame
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        c = getContentPane();
        c.setLayout(null);

        DefaultTableModel model = new DefaultTableModel(data, columnNames);   // Create an instance of DefaultTableModel with the specified data and column names
        table = new JTable(model);  // Initialize a JTable with model as its table model

        // Changing the table header
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 12));

        //Create an instance of DefaultTableCellRenderer. This renderer refers each cell's style and alignment
       DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        table.setDefaultRenderer(String.class, centerRenderer);  // Apply the centerRenderer to all String class columns in the table.
            for (int i = 0; i <=5; i++) {
        table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        //Placing a seperator between the two areas
        JSeparator separator = new JSeparator();
        separator.setBounds(0, 366, 800, 5);

        TableColumnModel columnModel = table.getColumnModel();
        // Making the 6th column invicible
        table.getColumn("Qavailable").setMinWidth(0); // Must be set before maxWidth
        table.getColumn("Qavailable").setMaxWidth(0);
        table.getColumn("Qavailable").setWidth(0);

        //Setting the preferred width and height of the table and columns
        columnModel.getColumn(4).setPreferredWidth(165);
        table.setRowHeight(42);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(60, 130, 670, 215);

        // ComboBox for selecting product category
        label1 = new JLabel("Select Product Category");
        comboBox = new JComboBox<>(categories);
        comboBox.setBounds(250, 50, 100, 30);
        label1.setBounds(95, 48, 200, 30);

        c.add(label1);
        c.add(comboBox);
        c.add(scrollPane);
        c.add(separator);

        // Buttons for adding to shopping cart and viewing the cart
        btn1 = new JButton("Add to Shopping Cart");
        btn1.setBounds(312, 580, 180, 30);
        c.add(btn1);
        btn1.addActionListener(this);

        btn2 = new JButton("Shopping Cart");
        btn2.setBounds(550, 50, 165, 30);
        c.add(btn2);
        btn2.addActionListener(this);

        comboBox.addActionListener(this);

        // Details Panel to display the product details
        detailsPanel = new JPanel();
        detailsPanel2 = new JPanel();
        detailsPanel3 = new JPanel();
        detailsPanel4 = new JPanel();
        detailsPanel5 = new JPanel();
        detailsPanel6 = new JPanel();
        detailsPanel7 = new JPanel();
        detailsPanel8 = new JPanel();
        detailsPanel9 = new JPanel();
        detailsPanel10 = new JPanel();
        detailsPanel11 = new JPanel();
        detailsPanel12 = new JPanel();
        detailsPanel13 = new JPanel();

        // Initialize labels and empty labels for displaying dynamic details later
        detailsLabel = new JLabel("Product details will appear here when a row is selected.");
        detailsLabel2 = new JLabel("");
        detailsLabel3 = new JLabel("");
        detailsLabel4 = new JLabel("");
        detailsLabel5 = new JLabel("");
        detailsLabel6 = new JLabel("");
        detailsLabel7 = new JLabel("");
        detailsLabel8 = new JLabel("");
        detailsLabel9 = new JLabel("");
        detailsLabel10 = new JLabel("");
        detailsLabel11 = new JLabel("");
        detailsLabel12 = new JLabel("");
        detailsLabel13 = new JLabel("");

        // Add the label to the details panel for displaying specific information about a selected item
        detailsPanel.add(detailsLabel);
        detailsPanel2.add(detailsLabel2);
        detailsPanel3.add(detailsLabel3);
        detailsPanel4.add(detailsLabel4);
        detailsPanel5.add(detailsLabel5);
        detailsPanel6.add(detailsLabel6);
        detailsPanel7.add(detailsLabel7);
        detailsPanel8.add(detailsLabel8);
        detailsPanel9.add(detailsLabel9);
        detailsPanel10.add(detailsLabel10);
        detailsPanel11.add(detailsLabel11);
        detailsPanel12.add(detailsLabel12);
        detailsPanel13.add(detailsLabel13);

        //Setting boundaries for the panels
        detailsPanel.setBounds(18, 380, 360, 30);
        detailsPanel2.setBounds(48, 410, 200, 30);
        detailsPanel3.setBounds(167, 410, 100, 30);
        detailsPanel4.setBounds(34, 430, 200, 30);
        detailsPanel5.setBounds(115, 430, 200, 30);
        detailsPanel6.setBounds(44, 450, 200, 30);
        detailsPanel7.setBounds(119, 450, 200, 30);
        detailsPanel8.setBounds(33, 470, 200, 30);
        detailsPanel9.setBounds(109, 470, 200, 30);
        detailsPanel10.setBounds(29, 490, 200, 30);
        detailsPanel11.setBounds(135, 490, 250, 30);
        detailsPanel12.setBounds(34, 510, 250, 30);
        detailsPanel13.setBounds(96, 510, 250, 30);

        JTextArea detailsTextArea = new JTextArea();
        detailsTextArea.setEditable(false); // Makes it non-editable
        detailsPanel.add(detailsTextArea);

        // Add details panel to the main container 'c'. This panel is used to display detailed information about the selected product.
        c.add(detailsPanel);
        c.add(detailsPanel2);
        c.add(detailsPanel3);
        c.add(detailsPanel4);
        c.add(detailsPanel5);
        c.add(detailsPanel6);
        c.add(detailsPanel7);
        c.add(detailsPanel8);
        c.add(detailsPanel9);
        c.add(detailsPanel10);
        c.add(detailsPanel11);
        c.add(detailsPanel12);
        c.add(detailsPanel13);

        // Add selection listener to the table to display details of the selected row
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                if (!event.getValueIsAdjusting()) {
                    int viewRow = table.getSelectedRow();
                    if (viewRow < 0) {
                        // No rows are selected
                        detailsLabel.setText("Product details will appear here when a row is selected.");
                    } else {
                        // Row is selected
                        String productDetails1 = "Selected Product - Details ";
                        String productDetails2 = "Product ID: ";
                        String productDetails3 = (String) model.getValueAt(viewRow, 0);
                        String productDetails4 = "Name: ";
                        String productDetails5 = (String) model.getValueAt(viewRow, 1);
                        String productDetails6 = "Category: ";
                        String productDetails7 = (String) model.getValueAt(viewRow, 2);
                        String productDetails8 = "Price: ";
                        double productDetails9 = (Double) model.getValueAt(viewRow, 3);
                        String productDetails10 = "Info: ";
                        String productDetails11 = (String) model.getValueAt(viewRow, 4);
                        String productDetails12 = "Available Items:";
                        int productDetails13 = (int) model.getValueAt(viewRow, 5);
                        detailsLabel.setText(productDetails1);
                        detailsLabel2.setText(productDetails2);
                        detailsLabel3.setText(productDetails3);
                        detailsLabel4.setText(productDetails4);
                        detailsLabel5.setText(productDetails5);
                        detailsLabel6.setText(productDetails6);
                        detailsLabel7.setText(productDetails7);
                        detailsLabel8.setText(productDetails8);
                        detailsLabel9.setText(String.valueOf(productDetails9));
                        detailsLabel10.setText(productDetails10);
                        detailsLabel11.setText(productDetails11);
                        detailsLabel12.setText(productDetails12);
                        detailsLabel13.setText(String.valueOf(productDetails13));
                        detailsLabel.setFont(new Font("Arial", Font.BOLD,13));

                    }
                }
            }
        });

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn1) {
            int selectedRow = table.getSelectedRow();
            if (selectedRow >= 0) {
                String productId = (String) table.getValueAt(selectedRow, 0);
                String name = (String) table.getValueAt(selectedRow, 1);
                String category = (String) table.getValueAt(selectedRow, 2);
                double price = (Double) table.getValueAt(selectedRow, 3);
                String info = (String) table.getValueAt(selectedRow, 4);

                shoppingCart.addProduct(productId, name, category, price, info); // Add product to the shopping cart

                // Display a confirmation message
                JOptionPane.showMessageDialog(this, "Product added to cart: " + name);
            } else {
                JOptionPane.showMessageDialog(this, "Please select a product to add to the cart.");
            }
        }

        if (e.getSource() == btn2) {
            CartGUI cartGUI = new CartGUI(shoppingCart.getCartItems());
            cartGUI.setTitle("Shopping Cart");
        }
    }
}
