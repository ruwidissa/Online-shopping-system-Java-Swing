import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class CartGUI extends JFrame implements ActionListener {
    // Main container for the JFrame components.
    Container c;
    // Labels for displaying various details about selected items in the GUI.
    JLabel detailsLabel, detailsLabel2, detailsLabel3, detailsLabel4, detailsLabel5, detailsLabel6, detailsLabel7;
    // Table to display a list of items in the GUI.
    JTable table;
    JPanel detailsPanel, detailsPanel2, detailsPanel3, detailsPanel4, detailsPanel5, detailsPanel6, detailsPanel7;
    // Table model for managing the data displayed in the JTable.
    private DefaultTableModel model;

    CartGUI(Object[][] data) {
        String[] columnNames = {"Product", "Quantity", "Price"};

        // Set the size and location of the frame
        setSize(800, 680);
        setLocationRelativeTo(null);  // Center the frame

// Retrieve the content pane of the JFrame to add components to it.
        c = getContentPane();
        c.setLayout(null);

        //Creating a new default model to handle data and 'data' holds the actual data to be displayed in the table, and 'columnNames' contains the headers for each column.
        model = new DefaultTableModel(data, columnNames);
        table = new JTable(model);
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 12));

// Retrieve the TableColumnModel from the table.
        TableColumnModel columnModel = table.getColumnModel();
        table.setRowHeight(50);
// Create the table with a scroll pane
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(44, 80, 700, 205);
//Used to define cell contents to the middle
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        table.setDefaultRenderer(String.class, centerRenderer);
        for (int i = 0; i <=2; i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        // Details Panel to display the product details
        detailsPanel = new JPanel();
        detailsPanel2 = new JPanel();
        detailsPanel3 = new JPanel();
        detailsPanel4 = new JPanel();
        detailsPanel5 = new JPanel();
        detailsPanel6 = new JPanel();
        detailsPanel7 = new JPanel();

// Initialize labels and empty labels for displaying dynamic details later
        detailsLabel = new JLabel("Total ");
        detailsLabel2 = new JLabel("First Purchase Discount (10%) ");
        detailsLabel3 = new JLabel("Three Items in same Category Discount (20%)");
        detailsLabel4 = new JLabel("Final Total");
        detailsLabel5 = new JLabel("");
        detailsLabel6 = new JLabel("");
        detailsLabel7 = new JLabel("");
        detailsLabel4.setFont(new Font("Arial", Font.BOLD,13));
        detailsLabel7.setFont(new Font("Arial", Font.BOLD,13));

// Add the label to the details panel for displaying specific information about a selected item
        detailsPanel.add(detailsLabel);
        detailsPanel2.add(detailsLabel2);
        detailsPanel3.add(detailsLabel3);
        detailsPanel4.add(detailsLabel4);
        detailsPanel5.add(detailsLabel5);
        detailsPanel6.add(detailsLabel6);
        detailsPanel7.add(detailsLabel7);

//Setting boundaries for the panels
        detailsPanel.setBounds(469, 360, 50, 30);
        detailsPanel2.setBounds(325, 405, 200, 30);
        detailsPanel3.setBounds(248, 450, 265, 30);
        detailsPanel4.setBounds(430, 495, 100, 30);
        detailsPanel5.setBounds(528, 360, 100, 30);
        detailsPanel6.setBounds(528, 450, 100, 30);
        detailsPanel7.setBounds(530, 495, 100, 30);

// Add details panel to the main container 'c'. This panel is used to display detailed information about the selected product.
        c.add(detailsPanel);
        c.add(detailsPanel2);
        c.add(detailsPanel3);
        c.add(detailsPanel4);
        c.add(detailsPanel5);
        c.add(detailsPanel6);
        c.add(detailsPanel7);
        c.add(scrollPane);
        setVisible(true);

        //Calling methods to print total, discounts and the final total
        updateTotal();
        finalPrice();
        updateTotaldisc();
    }

    // Methods to print total, discounts and the final total
    private void updateTotal() {
        double total = 0;
        double totalround = 0;
        for (int i = 0; i < table.getRowCount(); i++) {
            int quantity = Integer.parseInt(model.getValueAt(i, 1).toString());
            double price = Double.parseDouble(model.getValueAt(i, 2).toString());
            total += price;
        }
        totalround = Math.round(total * 10.0) / 10.0;
        detailsLabel5.setText(totalround + " £");
    }
       private void updateTotaldisc() {
            double discount = 0;
            double discountround = 0;
            for (int i = 0; i < table.getRowCount(); i++) {
                int quantity = Integer.parseInt(model.getValueAt(i, 1).toString());
                double price = Double.parseDouble(model.getValueAt(i, 2).toString());
                if (quantity > 2)
                {
                    discount = discount + price * 0.2;
                }
            }
            discountround = Math.round(discount * 10.0) / 10.0;
            detailsLabel6.setText("-" + (discountround) + " £");
        }


    private void finalPrice() {
        double discount = 0;
        double finalPrice = 0;
        double totalPrice = 0;
        double discountround = 0;
        for (int i = 0; i < table.getRowCount(); i++) {
            int quantity = Integer.parseInt(model.getValueAt(i, 1).toString());
            double price = Double.parseDouble(model.getValueAt(i, 2).toString());
            if (quantity > 2)
            {
                discount = discount + price * 0.2;
            }
            totalPrice = totalPrice + price;
            discountround = Math.round(discount * 10.0) / 10.0;
            finalPrice = totalPrice - discountround;
        }
        detailsLabel7.setText(finalPrice + " £");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}