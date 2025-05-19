package ec.edu.espe.eduplan.util;

import ec.edu.espe.eduplan.model.Activity;
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

public class FileManagerActivities {

    //Attributes

    private static final String activitiesFileName  = "ListOfAvailableActivities.csv";

    //Methods

    public void saveActivityToCSV(Activity activity) {
        try (FileWriter writer = new FileWriter(activitiesFileName , true)) {
            writer.write(activity.toString() + "\n");
            System.out.println("Actividad guardada con exito.");
        } catch (IOException e) {
            System.err.println("Error al guardar la actividad, intenta nuevamente.");
        }
    }

    public Activity getActivityByRow(int rowIndex) {
        try (BufferedReader br = new BufferedReader(new FileReader(activitiesFileName))) {
            String row;
            int currentIndex = 1;

            while ((row = br.readLine()) != null) {
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

                        // Create and return the Activity object
                        return new Activity(activityName, description, activityType, activityStatus, startTime, endTime, evaluationCriteria, responsibleTeacher, academicResources);
                    } else {
                        System.err.println("Formato incorrecto en la Actividad: " + row);
                        return null;
                    }
                }
                currentIndex++;
            }

            System.err.println("No se encontró la Actividad: " + rowIndex);
        } catch (IOException e) {
            System.err.println("Error leyendo el archivo, try again");
        }
        return null;
    }

    
}
