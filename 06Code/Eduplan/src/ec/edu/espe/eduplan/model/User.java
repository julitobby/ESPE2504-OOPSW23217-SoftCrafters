package ec.edu.espe.eduplan.model;

/**
 *
 * @author SoftCrafters
 */

public class User {
    
    //User attributes
    
    private String username;
    private String password;
    private String rol;
        
    //User constructor

    public User(String username, String password, String rol) {
        this.username = username;
        this.password = password;
        this.rol = rol;
    }
      
    //toString

    @Override
    public String toString() {
        return  username + ";" + password + ";" + rol;
    }
    
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

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    } 
}
