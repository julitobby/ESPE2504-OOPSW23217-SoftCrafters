package ec.edu.espe.eduplan.view;

import ec.edu.espe.eduplan.model.User;

/**
 *
 * @author SoftCrafters
 */

public class EduPlanSystem {
    public static void main(String[] args) {
        //Attributes
        Menu menu =new Menu();
        User option;
        
        //Use Methonds
        option= menu.showRegistrationMenu();
        
        System.out.println(option);
    }
}
