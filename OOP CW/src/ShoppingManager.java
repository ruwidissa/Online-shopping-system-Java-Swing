public interface ShoppingManager {

    //Defining methods
    void addProduct(Product product);
    void deleteProduct(String productId, String getProductId);
    void displayProducts();
    void save();
    void load();

}
