package ec.edu.espe.eduplan.model;

/**
 *
 * @author SoftCrafters
 */

public class User {
    
    //User attributes
    
    private String username;
    private String password;
        
    //User constructor
    
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    //Methods
    

    // Getters y Setters
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
}
