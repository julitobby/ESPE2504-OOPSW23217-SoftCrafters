package ec.edu.espe.eduplan.view;

import ec.edu.espe.eduplan.model.User;

/**
 *
 * @author SoftCrafters
 */

public class EduPlanSystem {
    public static void main(String[] args) {
        
        //Creating the console interface
        Menu menu =new Menu();
        
        int option = menu.showUserMenu();
        
         switch (option) {
            case 1:
                User user = menu.showLoginMenu();
                
                
                
                
                
                
                break;
            case 2:
                menu.showRegistrationMenu();
                break;
            case 3:
                System.exit(0);
                break;
            default:
                System.out.println("Opción no válida.");
        }
        
    }
}
