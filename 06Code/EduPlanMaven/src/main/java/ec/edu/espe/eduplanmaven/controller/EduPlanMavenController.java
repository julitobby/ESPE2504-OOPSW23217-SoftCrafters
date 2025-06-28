package ec.edu.espe.eduplanmaven.controller;

import ec.edu.espe.eduplanmaven.view.*;

/**
 *
 * @author Softcrafters
 */
public class EduPlanMavenController {
    public static void main(String[] args) {
        SplashWindow splashWindow = new SplashWindow();
        MainMenuController mainMenuController = MainMenuController.getInstance();
        mainMenuController.showMainMenu();
        splashWindow.setVisible(true);
    }
}
