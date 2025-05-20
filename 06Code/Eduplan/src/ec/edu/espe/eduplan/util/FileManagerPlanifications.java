package ec.edu.espe.eduplan.util;

import ec.edu.espe.eduplan.model.Planification;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalTime;
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
                    String[] parts = row.split(";");
                    if (parts.length >= 9) {
                        String activityName = parts[0].trim();
                        String description = parts[1].trim();
                        String activityType = parts[2].trim();
                        String activityStatus = parts[3].trim();
                        LocalTime startTime = LocalTime.parse(parts[4].trim());
                        LocalTime endTime = LocalTime.parse(parts[5].trim());
                        String evaluationCriteria = parts[6].trim();
                        String responsibleTeacher = parts[7].trim();

                        // Extract academicResources
                        ArrayList<String> academicResources = new ArrayList<>();
                        if (!parts[8].trim().isEmpty()) {
                            academicResources.addAll(Arrays.asList(parts[8].trim().split(",")));
                            // Limpiar espacios
                            for (int i = 0; i < academicResources.size(); i++) {
                                academicResources.set(i, academicResources.get(i).trim());
                            }
                        }

                        // Create and return the Planification object
                        return new Planification(activityName, description, activityType, activityStatus, startTime, endTime, evaluationCriteria, responsibleTeacher, academicResources);
                    } else {
                        System.err.println("Formato incorrecto en la Actividad: " + row);
                        return null;
                    }
                }
                currentIndex++;
            }

            System.err.println("No se encontró la Actividad: " + rowIndex);
        } catch (IOException e) {
            System.err.println("Error leyendo el archivo, intenta nuevamente");
        }
        return null;
    }
    
}
