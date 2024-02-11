import java.util.List;
import java.util.Scanner;
import java.util.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.FileNotFoundException;
import java.io.EOFException;
import javax.swing.*;

public class WestminsterShoppingManager implements ShoppingManager {
    private List<Product> products;
    private final int MAX_PRODUCTS = 50;
    private final String FILENAME = "products.dat";

    public WestminsterShoppingManager() {
        products = new ArrayList<>();
        load();
    }
    public List<Product> getProducts() {
        return products;
    }

    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        int response = 0;

        do {
            System.out.println("Press 1 to Add a new product");
            System.out.println("Press 2 to Delete a product");
            System.out.println("Press 3 to Print the list of products");
            System.out.println("Press 4 to Save in a file");
            System.out.println("Press 5 to Open Customer GUI");
            System.out.println("Press 0 to exit");
            System.out.print("Enter your response: ");

            try {
                response = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // To clear the buffer
                continue;
            }
// Switch case to select the options
            switch (response) {
                case 1:
                    int option = 0; // Initialized to an invalid value

                    while (true) {
                        System.out.println("Enter 1 to add an electronic item and enter any other number to add a clothing item: ");
                        //Validating the input
                        if (scanner.hasNextInt()) {
                            option = scanner.nextInt();
                            break; // Exit the loop if a valid integer is entered
                        } else {
                            System.out.println("Invalid input. Please enter a number.");
                            scanner.next(); // Consume the invalid input
                        }
                    }
                    if (option == 1) {
                        System.out.print("Enter Product ID: ");
                        String productId = scanner.next();
                        System.out.print("Enter Product Name: ");
                        String productName = scanner.next();
                        System.out.print("Enter Available Items: ");
                        int availableItems = 0;
                        while (true) {
                            if (scanner.hasNextInt()) {
                                availableItems = scanner.nextInt();
                                if (availableItems > 0) {
                                    break;
                                } else {
                                    System.out.println("Please enter a number greater than 0.");
                                }
                            } else {
                                System.out.println("Invalid input. Please enter a number.");
                                scanner.next(); // Consume the invalid input
                            }
                        }
                        System.out.print("Enter Price: ");
                        double price = 0.0;
                        while (true) {
                            if (scanner.hasNextDouble()) { // Check if the next input is a double
                                price = scanner.nextDouble();
                                if (price > 0.0) {
                                    break;
                                } else {
                                    System.out.println("Please enter a positive price.");
                                }
                            } else {
                                System.out.println("Please enter a valid price.");
                                scanner.next();
                            }
                        }
                        System.out.print("Enter the brand: ");
                        String brand = scanner.next();
                        System.out.print("Enter the warranty period: ");
                        int warrantyPeriod = -1;
                        while (true) {
                            if (scanner.hasNextInt()) {
                                warrantyPeriod = scanner.nextInt();
                                if (warrantyPeriod >= 0) {
                                    break;
                                } else {
                                    System.out.println("Invalid input. Please enter a non-negative number.");
                                }
                            } else {
                                System.out.println("Invalid input. Please enter a number.");
                                scanner.next();
                            }
                        }
                        //Calling and passing the values to add product method for electronics
                        addProduct(new Electronics(productId, productName, availableItems, price, brand, warrantyPeriod));
                        break;
                    } else {
                        System.out.print("Enter Product ID: ");
                        String productId = scanner.next();
                        System.out.print("Enter Product Name: ");
                        String productName = scanner.next();
                        System.out.print("Enter Available Items: ");
                        int availableItems = 0;
                        while (true) {
                            if (scanner.hasNextInt()) {
                                availableItems = scanner.nextInt();
                                if (availableItems > 0) {
                                    break;
                                } else {
                                    System.out.println("Please enter a number greater than 0.");
                                }
                            } else {
                                System.out.println("Invalid input. Please enter a number.");
                                scanner.next(); // Consume the invalid input
                            }
                        }
                        System.out.print("Enter Price: ");
                        double price = 0.0;

                        while (true) {
                            if (scanner.hasNextDouble()) { // Check if the next input is a double
                                price = scanner.nextDouble(); // Read the double value
                                if (price > 0.0) {
                                    break; // Exit the loop if a valid positive double is entered
                                } else {
                                    System.out.println("Please enter a positive price.");
                                }
                            } else {
                                System.out.println("Please enter a valid price.");
                                scanner.next(); // Consume the invalid input
                            }
                        }
                        System.out.print("Enter the size: ");
                        String size = scanner.next();

                        System.out.print("Enter the colour: ");
                        String colour = scanner.next();
                        //Calling and passing the values to add product method for clothing
                        addProduct(new Clothing(productId, productName, availableItems, price, size, colour));
                        break;
                    }
                case 2:
                    System.out.print("Enter Product ID to delete: ");
                    String idToDelete = scanner.next();
                    //Calling and passing the value to the delete product method
                    deleteProduct(idToDelete);
                    break;
                case 3:
                    displayProducts();
                    break;
                case 4:
                    save();
                    break;
                case 5:
                    openGUI();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        } while (response != 0);
    }

    @Override
    public void addProduct(Product product) {
        if (products.size() < MAX_PRODUCTS) {
            products.add(product);
            System.out.println("Product added successfully.");
            System.out.println("");
        } else {
            System.out.println("Can't add more products. Maximum limit reached.");
        }
    }

    @Override
    public void deleteProduct(String productId, String getProductId) {
    }

    public void deleteProduct(String productId) {
        Product foundProduct = null;
        for (Product product : products) {
            if (product.getProductId().equals(productId)) {
                foundProduct = product;
                break;
            }
        }

        if (foundProduct != null) {
            // Display details before removing
            System.out.println("Deleting product: ");
            System.out.println("Product ID = " + foundProduct.getProductId() + ", Product name = " + foundProduct.getProductName() + ", Product price = " + foundProduct.getPrice());
            if (foundProduct instanceof Electronics) {
                Electronics electronics = (Electronics) foundProduct;
                System.out.println("Type: Electronics, Brand = " + electronics.getBrand() + ", Warranty Period = " + electronics.getWarrantyPeriod());
            } else if (foundProduct instanceof Clothing) {
                Clothing clothing = (Clothing) foundProduct;
                System.out.println("Type: Clothing, Size = " + clothing.getSize() + ", Colour = " + clothing.getColour());
            }

            // Remove the product
            products.remove(foundProduct);
            System.out.println("Product deleted successfully");
            System.out.println("No. of available products is " + products.size());
        } else {
            System.out.println("Product not found");
        }
    }

    @Override
    public void displayProducts() {
        if (products.isEmpty()) {
            System.out.println("No products available.");
            return;
        }
        // Sort products by Product ID in alphabetical order
        Collections.sort(products, new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {
                return p1.getProductId().compareTo(p2.getProductId());
            }
        });

        for (Product product : products) {
            System.out.println("Product ID = " + product.getProductId() + ", Product name = " + product.getProductName() + ", Product price = " + product.getPrice());
// Check if the product is an instance of the Electronics class.
            if (product instanceof Electronics) {
                Electronics electronics = (Electronics) product;
                System.out.println("Type: Electronics, Brand = " + electronics.getBrand() + ", Warranty Period = " + electronics.getWarrantyPeriod());
            } else if (product instanceof Clothing) {
                Clothing clothing = (Clothing) product;
                System.out.println("Type: Clothing, Size = " + clothing.getSize() + ", Colour = " + clothing.getColour());
            }
        }
    }

    @Override
    public void save() {
        try (FileOutputStream fileOutputStream = new FileOutputStream(FILENAME);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(products);
            System.out.println("Products saved successfully to " + FILENAME);
        } catch (IOException e) {
            System.err.println("Error occurred while saving products: " + e.getMessage());
        }
    }

    @Override
    public void load() {
        try (FileInputStream fileInputStream = new FileInputStream(FILENAME);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            Object obj = objectInputStream.readObject();
            if (obj instanceof List<?>) {
                this.products = (List<Product>) obj;
                System.out.println("Products loaded successfully from " + FILENAME);
            }
        } catch (FileNotFoundException e) {
            System.out.println("No previous saved data found. Starting with an empty product list.");
        } catch (EOFException e) {
            System.out.println("Reached end of file without finding any objects.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error occurred while loading products: " + e.getMessage());
        }
    }
// Method to open login
    public void openGUI() {
        Object[][] productData = getProductDataForTable();
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                logFrame gui = new logFrame(productData);
                gui.setTitle("Westminster Shopping Centre - Login");
                gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                gui.setVisible(true);
            }
        });
    }

// Method to open WestminsterGUI
    public void openGUI2() {
        Object[][] productData = getProductDataForTable();
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                WestminsterGUI gui = new WestminsterGUI(productData);
                gui.setTitle("Westminster Shopping Centre");
                 gui.setSize(800, 680);
                 gui.setLocation(255, 75);
                gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                gui.setVisible(true);
            }
        });
    }

//Retrieves product data formatted for use in the table
    public Object[][] getProductDataForTable() {
        Object[][] data = new Object[products.size()][6]; //'5' based on the number of columns

        for (int i = 0; i < products.size(); i++) {
            Product p = products.get(i);
            data[i][0] = p.getProductId();
            data[i][1] = p.getProductName();
            data[i][2] = p.getCategory();
            data[i][3] = p.getPrice();
            data[i][4] = p.getInfo();
            data[i][5] = p.getAvailableItems();
        }
        return data;
    }
}

