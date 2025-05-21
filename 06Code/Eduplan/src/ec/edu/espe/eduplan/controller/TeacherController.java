package ec.edu.espe.eduplan.controller;

import util.FileManagerPlanifications;
import util.FileManagerUsers;
import ec.edu.espe.eduplan.model.*;
import ec.edu.espe.eduplan.view.*;
import java.util.*;

/**
 *
 * @author SoftCrafters
 */
public class TeacherController {
    
    public static void showTeacherMenu(User user) {
        Scanner scanner = new Scanner(System.in);
        Teacher teacher = FileManagerUsers.getTeacherByUsername(user.getUsername(), user.getPassword());
        
        boolean continuar = true;
        
        while (continuar) {
            System.out.println("\n_______Menu del Maestro " + teacher.getFirstNameTeacher() + " " + teacher.getLastNameTeacher() + "______");
            System.out.println("""
                                           1. Crear una planificacion
                                           2. Visualizar una planificacion en especifico
                                           3. Visualizar todas las planificaciones
                                           4. Cerrar sesion""");
            System.out.print("Selecciona una opcion: ");
            String input = scanner.nextLine();
            
            int option;
            try {
                option = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingresa un numero valido.");
                continue;
            }
            
            switch (option) {
                case 1:
                    Menu.showCreatePlanification(teacher);
                    break;
                    
                case 2:
                    System.out.println("______________Visualizar una Planificacion_____________");
                    System.out.print("Ingrese el ID de la planificacion que desea visualizar: ");
                    String searchId = scanner.nextLine();
                    Menu.showPlanification(searchId);
                    break;
                    
                case 3:
                    System.out.println("______________Todas las Planificaciones_____________");
                    ArrayList<Planification> planifications = FileManagerPlanifications.getPlanifications();
                    
                    int counter = 1;
                    for (Planification planification : planifications) {
                        System.out.println(counter + ". " + planification.getIdPlanification());
                        counter++;
                    }
                    System.out.print("Ingrese el ID de la planificacion que desea visualizar: ");
                    String searchId2 = scanner.nextLine();
                    Menu.showPlanification(searchId2);
                    break;
                    
                case 4:
                    System.out.println("Cerrando sesion...");
                    continuar = false;
                    break;
                    
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        }
    }
}
