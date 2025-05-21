package ec.edu.espe.eduplan.controller;

import ec.edu.espe.eduplan.model.Principal;
import ec.edu.espe.eduplan.model.Teacher;
import ec.edu.espe.eduplan.model.User;
import ec.edu.espe.eduplan.util.FileManagerUsers;
import java.util.Scanner;

/**
 *
 * @author SoftCrafters
 */

public class PrincipalController {
    
    //Principal Menu
    public static void showPrincipalMenu(User user){
        Scanner scanner = new Scanner(System.in);
        Principal principal = FileManagerUsers.getPrincipalByUsername(user.getUsername(), user.getPassword());
        System.out.println("_______Bienvenido Director "+ principal.getFirstNamePrincipal()+" "+principal.getLastNamePrincipal() + "_____");
        System.out.println("""
                                   1. Buscar maestro y sus planificaciones.
                                   2. Visualizar planificacion en especifico.
                                   -------------------------------
                                   3. Cerrar Sesion.
                                   """);
        
        System.out.println("Ingrese la id del maestro: ");
        String idTeacher = scanner.nextLine();
        Teacher teacher = FileManagerUsers.getTeacherById(idTeacher);
        
                
                
                
                
                
                
                }
}
