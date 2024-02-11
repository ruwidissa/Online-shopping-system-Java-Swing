public class User {
    //Defining the variables
    String userName;
    String password;

    //Constructor
    public User(String userName, String password){
        this.userName = userName;
        this.password = password;

        //Defining the set and get methods
    }
    public String getUserName(){
        return userName;
    }
    public void setUserName(String userName){
        this.userName = userName;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }
}
