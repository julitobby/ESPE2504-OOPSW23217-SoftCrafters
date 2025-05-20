package ec.edu.espe.eduplan.view;

import ec.edu.espe.eduplan.model.User;
import ec.edu.espe.eduplan.util.FileManagerUsers;
import java.util.Scanner;

/**
 *
 * @author SoftCrafters
 */

public class Menu {
    
    Scanner scanner = new Scanner(System.in);
    FileManagerUsers fileManagerUser = new FileManagerUsers();
    //Initial Menu
    public int showUserMenu() {
        System.out.println("""
                                   _________EDUPLAN_________
                                   1. Iniciar Sesion.
                                   2. Registrarse.
                                   3. Salir
                                   """);
        System.out.print("Seleccione una opcion: ");
        int option = Integer.parseInt(scanner.nextLine());
        return option;
    }
    
    //Login Menu
    public User showLoginMenu() {
    User user = null;
    int intentos = 0;
    final int MAX_INTENTOS = 3;
    long tiempoBloqueo = 0;

    while (user == null) {
        // Si está bloqueado, esperar a que pasen los 60 segundos
        if (System.currentTimeMillis() < tiempoBloqueo) {
            long segundosRestantes = (tiempoBloqueo - System.currentTimeMillis()) / 1000;
            System.out.println("Demasiados intentos fallidos. Por favor espera " + segundosRestantes + " segundos...");
            try {
                Thread.sleep(1000); // Espera de 1 segundo antes de mostrar de nuevo
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            continue;
        }

        System.out.println("_________Iniciar Sesion_________");
        System.out.println("1. Ingresar Datos");
        System.out.println("2. Regresar al menu principal");
        System.out.print("Selecciona una opcion: ");
        String option = scanner.nextLine();

        if (option.equals("2")) {
            System.out.println("Regresando al menu principal...");
            return null;
        } else if (option.equals("1")) {
            System.out.print("Ingresa tu nombre de usuario: ");
            String username = scanner.nextLine();
            System.out.print("Ingresa tu contrasena: ");
            String password = scanner.nextLine();

            user = fileManagerUser.getUserbyUsername(username, password);

            if (user == null) {
                intentos++;
                System.out.println("Nombre de usuario o contraseña incorrectos. Intento " + intentos + " de " + MAX_INTENTOS + ".\n");

                if (intentos >= MAX_INTENTOS) {
                    System.out.println("Has excedido el número máximo de intentos. Espera 60 segundos para volver a intentar.\n");
                    tiempoBloqueo = System.currentTimeMillis() + 60 * 1000; // 60 segundos
                    intentos = 0; // Reiniciar el contador tras el bloqueo
                }
            }
        } else {
            System.out.println("Opcion no valida. Por favor, selecciona 1 o 2.\n");
        }
    }

    System.out.println("Inicio de sesion exitoso. Bienvenido, " + user.getUsername() + "!");
    return user;
}
    
    
    //Registration menu
    public User showRegistrationMenu(){
        User user = null;
        while (user == null) {
            System.out.println("_________Registrarse_________");
            System.out.println("1. Ingresar Datos");
            System.out.println("2. Regresar al menu principal");
            System.out.print("Selecciona una opcion: ");
            String option = scanner.nextLine();
            
            if (option.equals("2")) {
                System.out.println("Regresando al menu principal...");
                return null;
            } else if (option.equals("1")) {
                System.out.print("Ingresa tu nombre de usuario: ");
                String username = scanner.nextLine();
                System.out.print("Ingresa tu contrasena: ");
                String password = scanner.nextLine();
                
                String rolOption = "";
                String rol = "";
                
                do {
                    System.out.println("Elije tu rol:");
                    System.out.println("1. Director\n2. Maestro");
                    System.out.print("Ingresa la opcion correspondiente a tu rol: ");
                    rolOption = scanner.nextLine();
                    
                    if (rolOption.equals("1")) {
                        rol = "Director";
                    } else if (rolOption.equals("2")) {
                        rol = "Maestro";
                    } else {
                        System.out.println("Opcion invalida. Intenta nuevamente.");
                    }
                } while (!rolOption.equals("1") && !rolOption.equals("2"));
                
                user = new User(username, password, rol);
                fileManagerUser.saveUserToCSV(user);
                System.out.println("Usuario registrado exitosamente como " + rol + "!");
            }
        }
        return user;
    }
    
    //Planification Menu
    public void showPlanificationMenu(){
        System.out.println("_______Planification______");
        System.out.println("");
    }
}
