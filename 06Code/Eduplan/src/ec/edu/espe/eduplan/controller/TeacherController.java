package ec.edu.espe.eduplan.controller;

import ec.edu.espe.eduplan.model.Teacher;
import ec.edu.espe.eduplan.model.User;
import ec.edu.espe.eduplan.util.FileManagerUsers;
import ec.edu.espe.eduplan.view.Menu;
import java.util.Scanner;

/**
 *
 * @author SoftCrafters
 */

public class TeacherController {
    
    
//Teacher Menu
    public static void showTeacherMenu(User user){  
        
        Scanner scanner = new Scanner(System.in);
        Teacher teacher = FileManagerUsers.getTeacherByUsername(user.getUsername(), user.getPassword());
        System.out.println("_______Menu del Maestro" + teacher.getFirstNameTeacher()+" "+teacher.getLastNameTeacher()+"______");
        System.out.println("""
                           1. Crear una planificacion.
                           2. Visualizar una planificacion en especifico.
                           3. Editar una planificacion en especifico.
                           4. Visualizar todas las planificaciones.
                           -------------------------------
                           5. Cerrar Sesion.
                           """);
        System.out.println("Elij");
        int option = Integer.parseInt(scanner.nextLine());
        switch (option){
            case 1:
                System.out.println("_________Planificacion_________");

                String idPlanification = Menu.generateRandomIdPlanification();
                System.out.print("Ingrese el nivel Educacional: ");
                String educationalLevel = scanner.nextLine();
                
                
                
                
                System.out.print("");
                
                
                
                
            case 2:
                
            case 3:
                
            
        }
      
        
        
    }
}
