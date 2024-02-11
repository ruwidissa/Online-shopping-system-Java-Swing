import java.io.Serializable;

public class Product implements Serializable {

// Defining the variables
        private String productId;
        private String productName;
        private int availableItems;
        private double price;

// Constructor
        public Product(String productId, String productName, int availableItems, double price) {
            this.productId = productId;
            this.productName = productName;
            this.availableItems = availableItems;
            this.price = price;
        }

// Defining the set methods and get methods
        public String getProductId() {
            return productId;
        }

        public void setProductId(String productId) {
            this.productId = productId;
        }

        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public int getAvailableItems() {
            return availableItems;
        }

        public void setAvailableItems(int availableItems) {
            this.availableItems = availableItems;
        }

    public String getCategory() {
        return "General";
    }

    public String getInfo() {
        return "";
    }

    public double getPrice() {
            return price;
        }
        public void setPrice(double price) {
            this.price = price;
        }

    }
