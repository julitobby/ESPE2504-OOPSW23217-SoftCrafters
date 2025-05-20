package ec.edu.espe.eduplan.util;

import ec.edu.espe.eduplan.model.Principal;
import ec.edu.espe.eduplan.model.Teacher;
import ec.edu.espe.eduplan.model.User;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author SoftCrafters
 */

public class FileManagerUsers {
    
    //Attributes
    
    private static final String USERS_FILE_NAME  = "src/ec/edu/espe/eduplan/files/ListOfRegisteredUsers.csv";
    
    //Contructor

    public FileManagerUsers() {
    }
            
    //Methods
    
    public void saveTeacherToCSV(Teacher teacher) {
        try (FileWriter writer = new FileWriter(USERS_FILE_NAME , true)) {
            writer.write(teacher.toString() + "\n");
            System.out.println("Datos personales del maestro registrados existosamente!");
        } catch (IOException e) {
            System.err.println("Error al guardar la actividad, intenta nuevamente.");
        }
    }
    
    public void savePrincipalToCSV(Principal principal) {
        try (FileWriter writer = new FileWriter(USERS_FILE_NAME , true)) {
            writer.write(principal.toString() + "\n");
            System.out.println("Datos personales del director registrados existosamente!");
        } catch (IOException e) {
            System.err.println("Error al guardar la actividad, intenta nuevamente.");
        }
    }
    
    public User getUserbyUsername(String usernameToFind, String passwordToFind){
        try (BufferedReader reader = new BufferedReader(new FileReader(USERS_FILE_NAME))) {
            String row;
            
            while ((row = reader.readLine()) != null) {
                String[] data = row.split(";");
                
                if (data.length == 3) {
                    String username = data[0];
                    String password = data[1];
                    String rol = data[2];
                    
                    if (username.equals(usernameToFind)&&password.equals(passwordToFind)) {
                        return new User(username, password, rol);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error leyendo el archivo, intenta nuevamente");
        }
        
        return null;
    }
    
}
