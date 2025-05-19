package ec.edu.espe.eduplan.util;

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
    
    //Methods

    public void saveUserToCSV(User user) {
        try (FileWriter writer = new FileWriter(USERS_FILE_NAME , true)) {
            writer.write(user.toString() + "\n");
            System.out.println("Actividad guardada con exito.");
        } catch (IOException e) {
            System.err.println("Error al guardar la actividad, intenta nuevamente.");
        }
    }
    
    public User getUserbyUsername(String usernameToFind){
        try (BufferedReader reader = new BufferedReader(new FileReader(USERS_FILE_NAME))) {
            String row;
            
            while ((row = reader.readLine()) != null) {
                String[] data = row.split(";");
                
                if (data.length == 3) {
                    String username = data[0];
                    String password = data[1];
                    String rol = data[2];

                    if (username.equals(usernameToFind)) {
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
