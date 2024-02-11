import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ShoppingCart {
    // Define a nested class to hold product details
    static class CartItem {
        String productId;
        String name;
        String category;
        double price;
        String info;
        int quantity;

        //Defining constructors
        public CartItem(String productId, String name, String category, double price, String info, int quantity) {
            this.productId = productId;
            this.name = name;
            this.category = category;
            this.price = price;
            this.info = info;
            this.quantity = quantity;
        }

        //Defining getters and setters
        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }
        public int getQuantity() {
            return this.quantity;
        }
        public double getPrice() {
            return this.price;
        }

    }
//List of CartItem objects, each representing an item in the cart
    private List<CartItem> cartItems;

    //Initializes the shopping cart with an empty list
    public ShoppingCart() {
        cartItems = new ArrayList<>();
    }

//Method to add products
    public void addProduct(String productId, String name, String category, double price, String info) {
        Optional<CartItem> existingItem = cartItems.stream()
                .filter(item -> item.productId.equals(productId))
                .findFirst();

        if (((Optional<?>) existingItem).isPresent()) {
            // If product already exists in cart, just increase the quantity
            CartItem item = existingItem.get();
            item.setQuantity(item.getQuantity() + 1);
        } else {
            // If not, add a new item with quantity 1
            CartItem newItem = new CartItem(productId, name, category, price, info, 1);
            cartItems.add(newItem);
        }
    }

    //Retrieves cart item data for use in the table 2
    public Object[][] getCartItems(){
            Object[][] cartData = new Object[cartItems.size()][];
            for (int i = 0; i < cartItems.size(); i++) {
                CartItem item = cartItems.get(i);
                cartData[i] = new Object[] {
                        item.productId+" "+ item.name +" "+ item.info,
                        item.quantity,
                        item.price * item.quantity,
                };
            }
            return cartData;
        }

// method to remove products
    public void removeProduct(String productId) {

        cartItems.removeIf(item -> item.productId.equals(productId));
    }

    //method to calculate total
    public double calculateTotal() {
        double total = 0.0;
        for (CartItem item : cartItems) {
            total += item.getPrice();
        }
        return total;
    }

}
