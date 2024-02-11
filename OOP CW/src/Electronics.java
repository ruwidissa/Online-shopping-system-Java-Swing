public class Electronics extends Product{

    //Defining variables
    private String brand;
    private int warrantyPeriod;

    //Constructors
        public Electronics(String productId, String productName, int availableItems, double price, String brand, int warrantyPeriod) {
        super(productId, productName, availableItems, price);
        this.brand = brand;
        this.warrantyPeriod = warrantyPeriod;
    }

// Set methods and get methods
    public String getBrand(){
            return brand;
    }
    public void setBrand(String brand){
            this.brand = brand;
    }
    public int getWarrantyPeriod(){
            return warrantyPeriod;
    }
    public void setWarrantyPeriod(int warrantyPeriod){
            this.warrantyPeriod = warrantyPeriod;
    }
   public String getCategory() {
       return "Electronics";
   }
    public String getInfo() {
        return "Brand: " + getBrand() + ", Warranty: " + getWarrantyPeriod() + " months";
    }
}
