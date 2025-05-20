package ec.edu.espe.eduplan.controller;

import ec.edu.espe.eduplan.model.User;

/**
 *
 * @author SoftCrafters
 */

public class TeacherController {
    
    
//Teacher Menu
    public static void showTeacherMenu(User user){
        System.out.println("_______Menu del Maestro_______");
        System.out.println("""
                           1. Crear una planificacion.
                           2. Visualizar una planificacion en especifico.
                           3. Editar una planificacion en especifico.
                           4. Visualizar todas las planificaciones.
                           -------------------------------
                           4. Cerrar Sesion.
                           """);
        
        
    }
}
