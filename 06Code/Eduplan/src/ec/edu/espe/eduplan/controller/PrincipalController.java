package ec.edu.espe.eduplan.controller;

import ec.edu.espe.eduplan.model.*;
import ec.edu.espe.eduplan.util.*;
import ec.edu.espe.eduplan.view.*;
import java.util.*;

/**
 *
 * @author SoftCrafters
 */
public class PrincipalController {

    public static void showPrincipalMenu(User user) {
        Scanner scanner = new Scanner(System.in);
        Principal principal = FileManagerUsers.getPrincipalByUsername(user.getUsername(), user.getPassword());

        boolean continuar = true;

        while (continuar) {
            System.out.println("\n_______Bienvenido Director " + principal.getFirstNamePrincipal() + " " + principal.getLastNamePrincipal() + "_____");
            System.out.println("""
                               1. Buscar maestro y sus planificaciones
                               2. Visualizar planificacion en especifico
                               3. Cerrar sesion""");
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
                    System.out.println("________Lista de Maestros________");
                    ArrayList<Teacher> teachers = FileManagerUsers.getTeachers();

                    int counter = 1;
                    for (Teacher teacher : teachers) {
                        System.out.println(counter + " Nombre: " + teacher.getFirstNameTeacher() + " " + teacher.getLastNameTeacher());
                        System.out.println("       Id: " + teacher.getIdTeacher());
                        counter++;
                    }
                    System.out.print("Ingrese la id del maestro: ");
                    String idTeacher = scanner.nextLine();
                    Menu.showPlanificationByTeacherId(idTeacher);
                    break;

                case 2:
                    System.out.println("______________Visualizar una Planificacion_____________");
                    ArrayList<Planification> planifications = FileManagerPlanifications.getPlanifications();
                    
                    int counter1 = 1;
                    for (Planification planification : planifications) {
                        System.out.println(counter1 + ". " + planification.getIdPlanification());
                        counter1++;
                    }
                    System.out.print("Ingrese el ID de la planificacion que desea visualizar: ");
                    String searchId = scanner.nextLine();
                    Menu.showPlanification(searchId);
                    break;

                case 3:
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
