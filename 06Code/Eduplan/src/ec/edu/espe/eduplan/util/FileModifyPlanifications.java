package ec.edu.espe.eduplan.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import ec.edu.espe.eduplan.model.Planification;

/**
 *
 * @author Gerald Astudillo SoftCrafters DCCO ESPE
 */
public class FileModifyPlanifications {

    private static final String PLANIFICATIONS_FILE_NAME = "src/ec/edu/espe/eduplan/files/ListOfPlanifications.csv";

    public boolean modifyPlanificationAttribute(String activityNameToFind, int columnIndex, String newValue) {
        List<String> allRows = new ArrayList<>();
        boolean isModified = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(PLANIFICATIONS_FILE_NAME))) {
            String row;

            while ((row = reader.readLine()) != null) {
                String[] parts = row.split(";");

                if (parts.length >= 11) {
                    String activityName = parts[1].trim();

                    if (activityName.equals(activityNameToFind)) {
                        parts[columnIndex] = newValue;
                        isModified = true;
                    }
                    allRows.add(String.join(";", parts));
                } else {
                    allRows.add(row);
                }
            }
        } catch (IOException e) {
            System.out.println("Error leyendo el archivo: " + e.getMessage());
            return false;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(PLANIFICATIONS_FILE_NAME))) {
            for (String updatedRow : allRows) {
                writer.write(updatedRow);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error escribiendo en el archivo: " + e.getMessage());
            return false;
        }

        return isModified;
    }
}
