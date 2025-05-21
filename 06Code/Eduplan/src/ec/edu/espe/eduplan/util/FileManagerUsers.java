package ec.edu.espe.eduplan.util;

import ec.edu.espe.eduplan.model.Principal;
import ec.edu.espe.eduplan.model.Teacher;
import ec.edu.espe.eduplan.model.User;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author SoftCrafters
 */

public class FileManagerUsers {
    
    //Attributes
    
    private static final String USERS_FILE_NAME  = "src/ec/edu/espe/eduplan/files/ListOfRegisteredUsers.csv";
  
    //Methods
    
        // String que se guardara en archivo -->  username;password;rol;firstNameTeacher;lastNameTeacher;idTeacher
    
    public static void saveTeacherToCSV(Teacher teacher) {
        try (FileWriter writer = new FileWriter(USERS_FILE_NAME , true)) {
            writer.write(teacher.toString() + "\n");
            System.out.println("Datos personales del maestro registrados existosamente!");
        } catch (IOException e) {
            System.err.println("Error al guardar la actividad, intenta nuevamente.");
        }
    }
    
    public static void savePrincipalToCSV(Principal principal) {
        try (FileWriter writer = new FileWriter(USERS_FILE_NAME , true)) {
            writer.write(principal.toString() + "\n");
            System.out.println("Datos personales del director registrados existosamente!");
        } catch (IOException e) {
            System.err.println("Error al guardar la actividad, intenta nuevamente.");
        }
    }
    
    public static User getUserbyUsername(String usernameToFind, String passwordToFind){
        try (BufferedReader reader = new BufferedReader(new FileReader(USERS_FILE_NAME))) {
            String row;
            
            while ((row = reader.readLine()) != null) {
                String[] data = row.split(";");
                
                if (data.length == 6) {
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
    
    public static Teacher getTeacherByUsername(String usernameToFind, String passwordToFind) {
        try (BufferedReader reader = new BufferedReader(new FileReader(USERS_FILE_NAME))) {
            String row;
            while ((row = reader.readLine()) != null) {
                String[] data = row.split(";");
                if (data.length == 6) {
                    String username = data[0];
                    String password = data[1];
                    String rol = data[2];
                    String firstName = data[3];
                    String lastName = data[4];
                    String id = data[5];
                    
                    if (username.equals(usernameToFind) && password.equals(passwordToFind) && rol.equals("Maestro")) {
                        User user = new User(username, password, rol);
                        return new Teacher(user, firstName, lastName, id);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error leyendo el archivo de usuarios.");
        }
        return null;
    }
    
    public static Principal getPrincipalByUsername(String usernameToFind, String passwordToFind) {
    try (BufferedReader reader = new BufferedReader(new FileReader(USERS_FILE_NAME))) {
        String row;
        while ((row = reader.readLine()) != null) {
            String[] data = row.split(";");
            if (data.length == 6) {
                String username = data[0];
                String password = data[1];
                String rol = data[2];
                String firstName = data[3];
                String lastName = data[4];
                String id = data[5];

                if (username.equals(usernameToFind) && password.equals(passwordToFind) && rol.equals("Director")) {
                    User user = new User(username, password, rol);
                    return new Principal(user, firstName, lastName, id);
                }
            }
        }
    } catch (IOException e) {
        System.err.println("Error leyendo el archivo de usuarios.");
    }
    return null;
}

    public static Teacher getTeacherById(String idToFind) {
    try (BufferedReader reader = new BufferedReader(new FileReader(USERS_FILE_NAME))) {
        String row;
        while ((row = reader.readLine()) != null) {
            String[] data = row.split(";");
            if (data.length == 6) {
                String username = data[0];
                String password = data[1];
                String rol = data[2];
                String firstName = data[3];
                String lastName = data[4];
                String id = data[5];

                if (id.equals(idToFind) && rol.equals("Maestro")) {
                    User user = new User(username, password, rol);
                    return new Teacher(user, firstName, lastName, id);
                }
            }
        }
    } catch (IOException e) {
        System.err.println("Error leyendo el archivo de usuarios.");
    }
    return null;
}

    public static ArrayList<Teacher> getTeachers() {
    ArrayList<Teacher> teachers = new ArrayList<>();

    try (BufferedReader br = new BufferedReader(new FileReader(USERS_FILE_NAME))) {
        String line;

        while ((line = br.readLine()) != null) {
            String[] parts = line.split(";");

            if (parts.length == 6) {
                String username = parts[0];
                String password = parts[1];
                String role = parts[2];
                String firstName = parts[3];
                String lastName = parts[4];
                String id = parts[5];

                if (role.equalsIgnoreCase("Maestro")) {
                    User user = new User(username, password, role);
                    Teacher teacher = new Teacher(user, firstName, lastName, id);
                    teachers.add(teacher);
                }
            }
        }
    } catch (IOException e) {
        System.out.println("Error al leer el archivo: " + e.getMessage());
    }

    return teachers;
}
    
}
