package ec.edu.espe.eduplan.model;

/**
 *
 * @author SoftCrafters
 */

public class Principal {
    //Attributes
    private User userPrincipal;
    private String firstNamePrincipal;
    private String lastNamePrincipal;
    private String idPrincipal;
    
    //Constructor

    public Principal(User userPrincipal, String firstNamePrincipal, String lastNamePrincipal, String idPrincipal) {
        this.userPrincipal = userPrincipal;
        this.firstNamePrincipal = firstNamePrincipal;
        this.lastNamePrincipal = lastNamePrincipal;
        this.idPrincipal = idPrincipal;
    }

           
    //toString

    @Override
    public String toString() {
        return userPrincipal.toString()+";"+firstNamePrincipal + ";" + lastNamePrincipal + ";" + idPrincipal;
    }

    //Getters and Setters

    public String getIdPrincipal() {
        return idPrincipal;
    }

    public void setIdPrincipal(String idPrincipal) {
        this.idPrincipal = idPrincipal;
    }
    
    public String getFirstNamePrincipal() {
        return firstNamePrincipal;
    }

    public void setFirstNamePrincipal(String firstNamePrincipal) {
        this.firstNamePrincipal = firstNamePrincipal;
    }

    public String getLastNamePrincipal() {
        return lastNamePrincipal;
    }

    public void setLastNamePrincipal(String lastNamePrincipal) {
        this.lastNamePrincipal = lastNamePrincipal;
    }

    public User getUserPrincipal() {
        return userPrincipal;
    }

    public void setUserPrincipal(User userPrincipal) {
        this.userPrincipal = userPrincipal;
    }
    
}
