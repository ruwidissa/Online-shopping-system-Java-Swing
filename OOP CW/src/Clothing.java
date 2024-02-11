public class Clothing extends Product {

    // Defining variables
    private String size;
    private String colour;

    //Constructor
        public Clothing(String productId, String productName, int availableitems, double price, String size, String colour){
            super(productId,productName,availableitems,price);
            this.size = size;
            this.colour = colour;
        }

        // Defining set methods and get methods
    public String getSize(){
            return size;
    }
    public void setSize(String size){
            this.size = size;
    }
    public String getColour(){
            return colour;
    }
    public void setColour(String colour){
            this.colour = colour;
    }

    public String getCategory() {
        return "Clothing";
    }

    public String getInfo() {
        return "Size: " + getSize() + ", Color: " + getColour();
    }

}
