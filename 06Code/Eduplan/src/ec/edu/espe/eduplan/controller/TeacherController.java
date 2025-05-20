package ec.edu.espe.eduplan.controller;

import ec.edu.espe.eduplan.model.Teacher;
import ec.edu.espe.eduplan.model.User;
import ec.edu.espe.eduplan.util.FileManagerUsers;

/**
 *
 * @author SoftCrafters
 */

public class TeacherController {
    
    
//Teacher Menu
    public static void showTeacherMenu(User user){        
        Teacher teacher = FileManagerUsers.getTeacherByUsername(user.getUsername(), user.getPassword());
        System.out.println("_______Menu del Maestro" + teacher.getFirstNameTeacher()+" "+teacher.getLastNameTeacher()+"______");
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
