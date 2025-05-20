package ec.edu.espe.eduplan.util;

import ec.edu.espe.eduplan.model.MethodologicalStrategy;
import ec.edu.espe.eduplan.model.Planification;
import ec.edu.espe.eduplan.model.Scope;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author SoftCrafters
 */

public class FileManagerPlanifications {
    
    //Attributes
    
    private static final String     PLANIFICATIONS_FILE_NAME  = "src/ec/edu/espe/eduplan/files/ListOfPlanifications.csv";
    
    //Methods
    
    public void saveActivityToCSV(Planification planification) {
        try (FileWriter writer = new FileWriter(PLANIFICATIONS_FILE_NAME , true)) {
            writer.write(planification.toString() + "\n");
            System.out.println("Actividad guardada con exito.");
        } catch (IOException e) {
            System.err.println("Error al guardar la actividad, intenta nuevamente.");
        }
    }
    
    public Planification getActivityByRow(int rowIndex) {
    try (BufferedReader reader = new BufferedReader(new FileReader(PLANIFICATIONS_FILE_NAME))) {
        String row;
        int currentIndex = 1;

        while ((row = reader.readLine()) != null) {
            if (currentIndex == rowIndex) {
                String[] parts = row.split(";", -1);
                if (parts.length >= 12) {
                    // Datos base de Planification
                    String idPlanification = parts[0].trim();
                    String educationalLevel = parts[1].trim();
                    String activityName = parts[2].trim();
                    String ageGroup = parts[3].trim();
                    int numberOfChildren = Integer.parseInt(parts[4].trim());
                    int estimatedTime = Integer.parseInt(parts[5].trim());
                    LocalDate date = LocalDate.parse(parts[6].trim());
                    String experienceOverview = parts[7].trim();
                    String integratingElement = parts[8].trim();
                    String transverseAxis = parts[9].trim();
                    String responsibleTeacher = parts[10].trim();

                    // Descomposición del Scope
                    String[] scopeParts = parts[11].split("/", -1);

                    // Datos del Scope
                    String scopeName = scopeParts.length > 0 ? scopeParts[0].trim() : "";
                    String skill = scopeParts.length > 1 ? scopeParts[1].trim() : "";

                    // Estrategia metodológica
                    String initialActivities = "";
                    ArrayList<String> strategies = new ArrayList<>();
                    if (scopeParts.length > 2) {
                        String[] methodologyParts = scopeParts[2].split(",", 2);
                        initialActivities = methodologyParts[0].trim();
                        if (methodologyParts.length > 1) {
                            strategies.addAll(Arrays.asList(methodologyParts[1].replaceAll("[\\[\\]]", "").split(",")));
                            strategies.replaceAll(String::trim);
                        }
                    }
                    MethodologicalStrategy strategy = new MethodologicalStrategy(initialActivities, strategies);

                    // Recursos
                    ArrayList<String> resources = new ArrayList<>();
                    if (scopeParts.length > 3) {
                        resources.addAll(Arrays.asList(scopeParts[3].replaceAll("[\\[\\]]", "").split(",")));
                        resources.replaceAll(String::trim);
                    }

                    // Indicadores
                    ArrayList<String> indicators = new ArrayList<>();
                    if (scopeParts.length > 4) {
                        indicators.addAll(Arrays.asList(scopeParts[4].replaceAll("[\\[\\]]", "").split(",")));
                        indicators.replaceAll(String::trim);
                    }

                    // Scope
                    Scope scope = new Scope(scopeName, skill, resources, indicators, strategy);
                    ArrayList<Scope> scopes = new ArrayList<>();
                    scopes.add(scope);

                    // Retornar objeto completo
                    return new Planification(idPlanification, educationalLevel, activityName, ageGroup, numberOfChildren, estimatedTime, date, experienceOverview, integratingElement, transverseAxis, responsibleTeacher, scopes);
                } else {
                    System.err.println("Formato incorrecto en la fila: " + row);
                    return null;
                }
            }
            currentIndex++;
        }

        System.err.println("No se encontró ninguna planificación en la fila: " + rowIndex);
    } catch (IOException | NumberFormatException | ArrayIndexOutOfBoundsException e) {
        System.err.println("Error al leer la planificación: " + e.getMessage());
    }

    return null;
}

    public Planification getActivityById(String idPlanification) {
    try (BufferedReader reader = new BufferedReader(new FileReader(PLANIFICATIONS_FILE_NAME))) {
        String row;

        while ((row = reader.readLine()) != null) {
            String[] parts = row.split(";");
            if (parts.length >= 12) {
                String id = parts[0].trim();
                if (id.equals(idPlanification)) {
                    // Extraer campos
                    String educationalLevel = parts[1].trim();
                    String activityName = parts[2].trim();
                    String ageGroup = parts[3].trim();
                    int numberOfChildren = Integer.parseInt(parts[4].trim());
                    int estimatedTime = Integer.parseInt(parts[5].trim());
                    LocalDate date = LocalDate.parse(parts[6].trim());
                    String experienceOverview = parts[7].trim();
                    String integratingElement = parts[8].trim();
                    String transverseAxis = parts[9].trim();
                    String responsibleTeacher = parts[10].trim();

                    // Scope (posición 11)
                    String[] scopeParts = parts[11].split("/", -1);

                    String scopeName = scopeParts[0].trim();
                    String skill = scopeParts[1].trim();

                    String[] methodologyParts = scopeParts[2].split(",", 2);
                    String initialActivities = methodologyParts[0].trim();
                    ArrayList<String> strategies = new ArrayList<>();
                    if (methodologyParts.length > 1) {
                        strategies.addAll(Arrays.asList(methodologyParts[1].replaceAll("[\\[\\]]", "").split(",")));
                        strategies.replaceAll(String::trim);
                    }
                    MethodologicalStrategy strategy = new MethodologicalStrategy(initialActivities, strategies);

                    ArrayList<String> resources = new ArrayList<>();
                    if (scopeParts.length > 3) {
                        resources.addAll(Arrays.asList(scopeParts[3].replaceAll("[\\[\\]]", "").split(",")));
                        resources.replaceAll(String::trim);
                    }

                    ArrayList<String> indicators = new ArrayList<>();
                    if (scopeParts.length > 4) {
                        indicators.addAll(Arrays.asList(scopeParts[4].replaceAll("[\\[\\]]", "").split(",")));
                        indicators.replaceAll(String::trim);
                    }

                    Scope scope = new Scope(scopeName, skill, resources, indicators, strategy);
                    ArrayList<Scope> scopes = new ArrayList<>();
                    scopes.add(scope);

                    return new Planification(id, educationalLevel, activityName, ageGroup, numberOfChildren, estimatedTime, date, experienceOverview, integratingElement, transverseAxis, responsibleTeacher, scopes);
                }
            }
        }

        System.err.println("No se encontró la planificación con ID: " + idPlanification);
    } catch (IOException | NumberFormatException | ArrayIndexOutOfBoundsException e) {
        System.err.println("Error al leer la planificación: " + e.getMessage());
    }

    return null;
}

    
}
