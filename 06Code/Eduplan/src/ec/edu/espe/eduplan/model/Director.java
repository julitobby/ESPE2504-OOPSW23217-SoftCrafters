package ec.edu.espe.eduplan.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SoftCrafters
 */
public class Director {

    private String name;
    private String lastName;
    private List<User> users;

    public Director(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
        this.users = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<User> getUsers() {
        return users;
    }

    public void loadAllUsers(String filePath) {
        List<User> loadedUsers = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(";"); 
                if (data.length == 3) { 
                    String username = data[0].trim();
                    String password = data[1].trim();
                    String rol = data[2].trim();
                    loadedUsers.add(new User(username, password, rol));
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
        this.users = loadedUsers;
    }
}
