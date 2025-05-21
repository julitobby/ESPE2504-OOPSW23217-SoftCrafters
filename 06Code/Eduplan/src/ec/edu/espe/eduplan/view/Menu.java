package ec.edu.espe.eduplan.view;

import util.FileManagerPlanifications;
import util.FileManagerUsers;
import ec.edu.espe.eduplan.model.*;
import java.time.*;
import java.util.*;

/**
 *
 * @author SoftCrafters
 */

public class Menu {
    
    Scanner scanner = new Scanner(System.in);
    
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
        int attempts = 0;
        final int MAX_ATTEMPTS = 3;
        long lockoutTime = 0;
        
        while (user == null) {
            // Verificar si el inicio de sesión está bloqueado
            if (System.currentTimeMillis() < lockoutTime) {
                long remainingSeconds = (lockoutTime - System.currentTimeMillis()) / 1000;
                System.out.println("Demasiados intentos fallidos. Por favor espera " + remainingSeconds + " segundos...");
                try {
                    Thread.sleep(1000); // Esperar 1 segundo antes de volver a intentar
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
                
                user = FileManagerUsers.getUserbyUsername(username, password);
                
                if (user == null) {
                    attempts++;
                    System.out.println("Nombre de usuario o contrasena incorrectos. Intento " + attempts + " de " + MAX_ATTEMPTS + ".\n");
                    
                    if (attempts >= MAX_ATTEMPTS) {
                        System.out.println("Has excedido el numero maximo de intentos. Espera 60 segundos para volver a intentar.\n");
                        lockoutTime = System.currentTimeMillis() + 60 * 1000; // 60 segundos
                        attempts = 0; // Reiniciar contador después del bloqueo
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
                if (user.getRol().equals("Director")){
                    Principal principal = showDataPrincipalMenu(user);
                    FileManagerUsers.savePrincipalToCSV(principal);
                }else if (user.getRol().equals("Maestro")){
                    Teacher teacher = showDataTeacherMenu(user);
                    FileManagerUsers.saveTeacherToCSV(teacher);
                }
                System.out.println("Usuario registrado exitosamente como " + rol + "!");
                System.out.println("Dirigiendo a menu correspondiente...");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
        return user;
    }
    
    //Planification Menus
    public static void showPlanification(String searchId){
        Planification foundPlan = FileManagerPlanifications.getPlanificationById(searchId);
        if (foundPlan != null) {
            System.out.println("_____________________ INFORMACION DE LA PLANIFICACION _____________________");
            System.out.println("ID: " + foundPlan.getIdPlanification());
            System.out.println("Nivel Educacional: " + foundPlan.getEducationalLevel());
            System.out.println("Actividad: " + foundPlan.getActivityName());
            System.out.println("Grupo de Edad: " + foundPlan.getAgeGroup());
            System.out.println("Numero de Ninos: " + foundPlan.getNumberOfChildren());
            System.out.println("Tiempo Estimado: " + foundPlan.getEstimatedTime() + " minutos");
            System.out.println("Fecha: " + foundPlan.getDate());
            System.out.println("Dia de la semana: " + foundPlan.getDay());
            System.out.println("Descripcion General: " + foundPlan.getExperienceOverview());
            System.out.println("Elemento Integrador: " + foundPlan.getIntegratingElement());
            System.out.println("Eje Transversal: " + foundPlan.getTransverseAxis());
            System.out.println("Nombre del Maestro: " + foundPlan.getResponsibleTeacher() );
            System.out.println("Id del Maestro: " + foundPlan.getIdTeacher());
            System.out.println("----- Alcances -----");
            
            String scopeString = FileManagerPlanifications.getScopeLikeString(foundPlan.toString());
            //Aqui tengo los 2 primeros datos del scope en la posicion 0,1 -- en 3,4 tengo los ultimos datos
            String[] partsOfScope = FileManagerPlanifications.extractScopeParts(scopeString);
            //Aqui extraigo el tercer dato MethodologicalStrategy para obtener la clase del mismo
            String methodologicalStrategyString = partsOfScope[2];
            //Aqui tengo los 2 datos de methodologicalStrategy en pa posicion 0,1
            String[] partsOfethodologicalStrategy = FileManagerPlanifications.getStringOfMethodologicalStrategy(methodologicalStrategyString);
            System.out.println(" - Nombre del Alcance: " + partsOfScope[0]);
            System.out.println(" - Destreza: " + partsOfScope[1]);
            System.out.println(" - Recursos y Materiales:");
            System.out.println("            " + partsOfScope[3]);
            System.out.println(" - Indicadores de Evaluacion:");
            System.out.println("            " + partsOfScope[4]);
            System.out.println(" - Estrategia Metodologica");
            System.out.println("            Actividades Iniciales: " + partsOfethodologicalStrategy[0]);
            //System.out.println("            Lista de Estrategias: " + partsOfethodologicalStrategy[1] + ", " +partsOfethodologicalStrategy[2]);
        } else {
            System.out.println("No se encontro una planificacion con ese ID.");
        }
    }
    
    public static void showCreatePlanification(Teacher teacher){
        Scanner scanner = new Scanner(System.in);
        System.out.println("_________Planificacion_________");
        String idPlan = Menu.generateRandomIdPlanification();
        System.out.print("Ingrese el nivel educacional: ");
        String level = scanner.nextLine();
        
        System.out.print("Ingrese el nombre de la actividad: ");
        String activity = scanner.nextLine();
        
        System.out.print("Ingrese el grupo de edad: ");
        String ageGroup = scanner.nextLine();
        
        System.out.print("Ingrese el numero de ninos: ");
        int numChildren = Integer.parseInt(scanner.nextLine());
        
        System.out.print("Ingrese el tiempo estimado (en minutos): ");
        int estimatedTime = Integer.parseInt(scanner.nextLine());
        
        System.out.print("Ingrese la fecha (YYYY-MM-DD): ");
        LocalDate date = LocalDate.parse(scanner.nextLine());
        
        System.out.print("Ingrese el dia: ");
        String day = scanner.nextLine();
        System.out.print("Ingrese una descripcion general de la experiencia: ");
        String overview = scanner.nextLine();
        
        System.out.print("Ingrese el elemento integrador: ");
        String integrator = scanner.nextLine();
        
        System.out.print("Ingrese el eje transversal: ");
        String axis = scanner.nextLine();
        
        String teacherFullName = teacher.getFirstNameTeacher() + " " + teacher.getLastNameTeacher();
        String idTeacher = teacher.getIdTeacher();
        // Scope
        System.out.print("Ingrese el nombre del ambito: ");
        String scopeName = scanner.nextLine();
        
        System.out.print("Ingrese la destreza: ");
        String skill = scanner.nextLine();
        
        // Estrategia metodológica
        System.out.print("Ingrese la actividad inicial: ");
        String initialActivities = scanner.nextLine();
        
        //System.out.print("Ingrese las estrategias metodologicas (separadas por coma): ");
        String[] strategiesArray= new String[0];
        ArrayList<String> strategies = new ArrayList<>();
        for (String strategy : strategiesArray) {
            strategies.add(strategy.trim());
        }
        
        MethodologicalStrategy methodologicalStrategy = new MethodologicalStrategy(initialActivities, strategies);
        
        // Recursos
        System.out.print("Ingrese el material de recurso: ");
        String[] resourcesArray = scanner.nextLine().split(",");
        ArrayList<String> resources = new ArrayList<>();
        for (String resource : resourcesArray) {
            resources.add(resource.trim());
        }
        
        // Indicadores de evaluación
        System.out.print("Ingrese los indicador de evaluacion: ");
        String[] indicatorsArray = scanner.nextLine().split(",");
        ArrayList<String> indicators = new ArrayList<>();
        for (String indicator : indicatorsArray) {
            indicators.add(indicator.trim());
        }
        
        Scope scope = new Scope(scopeName, skill, resources, indicators, methodologicalStrategy);
        ArrayList<Scope> scopes = new ArrayList<>();
        scopes.add(scope);
        
        Planification plan = new Planification(idPlan, level, activity, ageGroup, numChildren, estimatedTime, date, overview, integrator, axis, teacherFullName, scopes, idTeacher,day);
        
        FileManagerPlanifications.savePlanificationToCSV(plan);
        System.out.println("El Id de su planificacion es: " + idPlan);
    }
    
    public static void showPlanificationByTeacherId(String teacherId) {
        Planification foundPlan = FileManagerPlanifications.getPlanificationByTeacherId(teacherId);
        
        if (foundPlan != null) {
            System.out.println("_____________________ INFORMACION DE LA PLANIFICACION _____________________");
            System.out.println("ID: " + foundPlan.getIdPlanification());
            System.out.println("Nivel Educacional: " + foundPlan.getEducationalLevel());
            System.out.println("Actividad: " + foundPlan.getActivityName());
            System.out.println("Grupo de Edad: " + foundPlan.getAgeGroup());
            System.out.println("Numero de Ninos: " + foundPlan.getNumberOfChildren());
            System.out.println("Tiempo Estimado: " + foundPlan.getEstimatedTime() + " minutos");
            System.out.println("Fecha: " + foundPlan.getDate());
            System.out.println("Dia de la semana: " + foundPlan.getDay());
            System.out.println("Descripcion General: " + foundPlan.getExperienceOverview());
            System.out.println("Elemento Integrador: " + foundPlan.getIntegratingElement());
            System.out.println("Eje Transversal: " + foundPlan.getTransverseAxis());
            System.out.println("Nombre del Maestro: " + foundPlan.getResponsibleTeacher());
            System.out.println("Id del Maestro: " + foundPlan.getIdTeacher());
            System.out.println("----- Alcances -----");
            
            String scopeString = FileManagerPlanifications.getScopeLikeString(foundPlan.toString());
            String[] partsOfScope = FileManagerPlanifications.extractScopeParts(scopeString);
            String methodologicalStrategyString = partsOfScope[2];
            String[] partsOfMethodologicalStrategy = FileManagerPlanifications.getStringOfMethodologicalStrategy(methodologicalStrategyString);
            
            System.out.println(" - Nombre del Alcance: " + partsOfScope[0]);
            System.out.println(" - Destreza: " + partsOfScope[1]);
            System.out.println(" - Recursos y Materiales:");
            System.out.println("            " + partsOfScope[3]);
            System.out.println(" - Indicadores de Evaluacion:");
            System.out.println("            " + partsOfScope[4]);
            System.out.println(" - Estrategia Metodologica");
            System.out.println("            Actividad Inicial: " + partsOfMethodologicalStrategy[0]);
            //System.out.println("            Lista de Estrategias: " + partsOfMethodologicalStrategy[1] + ", " + partsOfMethodologicalStrategy[2]);
        } else {
            System.out.println("No se encontro una planificacion para ese maestro.");
        }
    }
    
    
    //Data Teacher Menu
    private Teacher showDataTeacherMenu(User userTeacher){
        System.out.println("_________Datos Personales_________");
        System.out.print("Ingresa tus nombres: ");
        String firstName = scanner.nextLine();
        System.out.print("Ingresa tus apellidos: ");
        String lastName = scanner.nextLine();
        String idTeacher = generateRandomId();
        System.out.println("Tu id para esta institucion es: " + idTeacher);
        Teacher teacher = new Teacher(userTeacher, firstName,lastName,idTeacher);
        return teacher;
    }
    
    //Data Principal Menu
    private Principal showDataPrincipalMenu(User userPrincipal){
        System.out.println("_________Datos Personales del Director_________");
        System.out.print("Ingresa tu primer nombre: ");
        String firstName = scanner.nextLine();
        System.out.print("Ingresa tu primer apellido: ");
        String lastName = scanner.nextLine();
        String idPrincipal = generateRandomId().replace("PROF", "PRIN"); // Reemplaza el prefijo
        System.out.println("Tu id para esta institucion es: " + idPrincipal);
        Principal principal = new Principal(userPrincipal, firstName, lastName, idPrincipal);
        
        return principal;
    }
    
    //Id aleatory for Teacher, Principal and Planification
    public static String generateRandomId() {
        String prefix = "PROF";
        String datePart = java.time.LocalDate.now().toString().replaceAll("-", ""); // yyyyMMdd
        String randomPart = java.util.UUID.randomUUID().toString().substring(0, 6).toUpperCase(); // 6 caracteres aleatorios
        return prefix + datePart + randomPart;
    }
    
    public static String generateRandomIdPlanification() {
        String prefix = "PLAN";
        String datePart = java.time.LocalDate.now().toString().replaceAll("-", ""); // yyyyMMdd
        String randomPart = java.util.UUID.randomUUID().toString().substring(0, 6).toUpperCase(); // 6 caracteres aleatorios
        return prefix + datePart + randomPart;
    }
    
}
