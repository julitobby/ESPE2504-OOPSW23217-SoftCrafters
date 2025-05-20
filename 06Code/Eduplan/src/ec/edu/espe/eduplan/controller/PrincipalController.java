package ec.edu.espe.eduplan.controller;

import ec.edu.espe.eduplan.model.User;

/**
 *
 * @author SoftCrafters
 */

public class PrincipalController {
    
 //Principal Menu
    public static void showPrincipalMenu(User user){
      System.out.println("_______Bienvenido Director "+ user.getUsername()+ "_____");
        System.out.println("""
                           1. Buscar maestro y sus planificaciones.
                           2. Visualizar planificación en especifico.
                           -------------------------------
                           3. Cerrar Sesion.
                           """);
    }
}
