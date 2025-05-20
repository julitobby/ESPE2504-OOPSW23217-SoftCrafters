package ec.edu.espe.eduplan.view;

import ec.edu.espe.eduplan.controller.PrincipalController;
import ec.edu.espe.eduplan.controller.TeacherController;
import ec.edu.espe.eduplan.model.User;

/**
 *
 * @author SoftCrafters
 */

public class EduPlanSystem {
    public static void main(String[] args) {
        Menu menu = new Menu();
        boolean exit = false;

        while (!exit) {
            int option = menu.showUserMenu();

            switch (option) {
                case 1:
                    User userLogin = menu.showLoginMenu();
                    if (userLogin != null) {
                        switch (userLogin.getRol()) {
                            case "Director":
                                PrincipalController.showPrincipalMenu(userLogin);
                                break;
                            case "Maestro":
                                TeacherController.showTeacherMenu(userLogin);
                                break;
                        }
                    }
                    break;

                case 2:
                    User userRegister = menu.showRegistrationMenu();
                    if (userRegister != null) {
                        switch (userRegister.getRol()) {
                            case "Director":
                                PrincipalController.showPrincipalMenu(userRegister);
                                break;
                            case "Maestro":
                                TeacherController.showTeacherMenu(userRegister);
                                break;
                        }
                    }
                    break;

                case 3:
                    exit = true;
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}

