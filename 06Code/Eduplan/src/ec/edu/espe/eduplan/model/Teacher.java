package ec.edu.espe.eduplan.model;

/**
 *
 * @author SoftCrafters
 */

public class Teacher{
    
    //Attributes
    private String firstNameTeacher;
    private String lastNameTeacher;
    private String idTeacher;
    private User userTeacher;
    
    //Constructor

    public Teacher(User userTeacher, String firstNameTeacher, String lastNameTeacher, String IdTeacher) {
        this.firstNameTeacher = firstNameTeacher;
        this.lastNameTeacher = lastNameTeacher;
        this.idTeacher = IdTeacher;
        this.userTeacher = userTeacher;
    }
    
    
    //toString

    @Override
    public String toString() {
        return userTeacher.toString() + ";"+ firstNameTeacher + ";" + lastNameTeacher + ";" +idTeacher;
    }
    
    //Getters and Setters
    public String getIdTeacher() {
        return idTeacher;
    }
    
    public void setIdTeacher(String idTeacher) {    
        this.idTeacher = idTeacher;
    }

    public String getFirstNameTeacher() {
        return firstNameTeacher;
    }

    public void setFirstNameTeacher(String firstNameTeacher) {
        this.firstNameTeacher = firstNameTeacher;
    }

    public String getLastNameTeacher() {
        return lastNameTeacher;
    }

    public void setLastNameTeacher(String lastNameTeacher) {
        this.lastNameTeacher = lastNameTeacher;
    }

    public User getUserTeacher() {
        return userTeacher;
    }

    public void setUserTeacher(User userTeacher) {
        this.userTeacher = userTeacher;
    }

    
    
}
