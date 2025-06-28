package ec.edu.espe.eduplanmaven.controller;

import ec.edu.espe.eduplanmaven.view.SplashWindow;

/**
 *
 * @author Softcrafters
 */
public class EduPlanMavenController {
    public static void main(String[] args) {
        SplashWindow splashWindow = new SplashWindow();
        MainMenuController.getInstance().showMainMenu();
        splashWindow.setVisible(true);
    }
}
