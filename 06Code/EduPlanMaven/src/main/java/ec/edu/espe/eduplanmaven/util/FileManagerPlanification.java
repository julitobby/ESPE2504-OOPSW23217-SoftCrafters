package ec.edu.espe.eduplanmaven.util;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import ec.edu.espe.eduplanmaven.model.Planification;
import ec.edu.espe.eduplanmaven.model.Scope;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Calendar;
import org.bson.Document;
import org.bson.conversions.Bson;

public class FileManagerPlanification {

    //SRP, only do the CRUD, no more
    
    private static FileManagerPlanification instance;
    private final MongoCollection<Document> collection;

    private FileManagerPlanification() {
        collection = MongoClientConnection.getInstance().getDatabase().getCollection("plans");
    }

    public static synchronized FileManagerPlanification getInstance() {
        if (instance == null) {
            instance = new FileManagerPlanification();
            // Ejecutar corrección de datos una sola vez al inicializar
            // Comentado temporalmente para debugging
            // instance.fixGradingDataInDatabase();
        }
        return instance;
    }

    public boolean savePlanification(Planification plan) {
        try {
            Document doc = planificationToDocument(plan);
            collection.insertOne(doc);
            return true;
        } catch (Exception e) {
            System.err.println("Error al guardar la planificación: " + e.getMessage());
            return false;
        }
    }

    // Obtener todas las planificaciones
    public List<Planification> getAllPlanifications() {
        List<Planification> result = new ArrayList<>();
        for (Document doc : collection.find()) {
            result.add(documentToPlanification(doc));
        }
        return result;
    }

    // Buscar por ID de planificación
    public Planification findPlanificationById(String id) {
        Bson filter = Filters.eq("idPlanification", id); // Corregido: usar "idPlanification" en lugar de "id"
        Document doc = collection.find(filter).first();
        return doc != null ? documentToPlanification(doc) : null;
    }

    // Buscar planificaciones por ID de profesor
    public List<Planification> findPlanificationsByTeacher(String teacherId) {
        List<Planification> result = new ArrayList<>();
        
        // Buscar todas las planificaciones donde idTeacher coincida con el teacherId
        Bson filter = Filters.eq("idTeacher", teacherId);
        
        for (Document doc : collection.find(filter)) {
            Planification plan = documentToPlanification(doc);
            result.add(plan);
        }
        
        return result;
    }

    public boolean updatePlanification(Planification plan) {
        try {
            Bson filter = Filters.eq("idPlanification", plan.getIdPlanification()); // Corregido
            Document update = new Document("$set", planificationToDocument(plan));
            return collection.updateOne(filter, update).getModifiedCount() > 0;
        } catch (Exception e) {
            System.err.println("Error al actualizar la planificación: " + e.getMessage());
            return false;
        }
    }

    // Eliminar planificación (por ID)
    public boolean deletePlanificationById(String id) {
        Bson filter = Filters.eq("idPlanification", id); // Corregido
        return collection.deleteOne(filter).getDeletedCount() > 0;
    }

    // Método para limpiar y corregir datos de calificación existentes
    public void fixGradingDataInDatabase() {
        try {
            System.out.println("Iniciando corrección de datos de calificación en la base de datos...");
            
            // Obtener todos los documentos que no tienen los campos de calificación
            for (Document doc : collection.find()) {
                Document updateDoc = new Document();
                boolean needsUpdate = false;
                
                // Solo verificar y corregir los campos que realmente guardamos en BD
                // weekOfMonth, month y year se calculan automáticamente desde la fecha
                
                // Verificar y corregir grade
                if (!doc.containsKey("grade")) {
                    updateDoc.append("grade", 0);
                    needsUpdate = true;
                }
                
                // Verificar y corregir isGraded
                if (!doc.containsKey("isGraded")) {
                    updateDoc.append("isGraded", false);
                    needsUpdate = true;
                }
                
                // Limpiar campos obsoletos que ahora se calculan automáticamente
                if (doc.containsKey("weekOfMonth") || doc.containsKey("month") || doc.containsKey("year")) {
                    updateDoc.append("$unset", new Document()
                        .append("weekOfMonth", "")
                        .append("month", "")
                        .append("year", ""));
                    needsUpdate = true;
                }
                
                // Aplicar la actualización si es necesaria
                if (needsUpdate) {
                    Bson filter = Filters.eq("_id", doc.get("_id"));
                    if (updateDoc.containsKey("$unset")) {
                        // Si hay campos para eliminar, usar updateOne con $unset y $set separados
                        Document unsetDoc = (Document) updateDoc.get("$unset");
                        updateDoc.remove("$unset");
                        
                        if (!updateDoc.isEmpty()) {
                            Document update = new Document("$set", updateDoc).append("$unset", unsetDoc);
                            collection.updateOne(filter, update);
                        } else {
                            Document update = new Document("$unset", unsetDoc);
                            collection.updateOne(filter, update);
                        }
                    } else {
                        Document update = new Document("$set", updateDoc);
                        collection.updateOne(filter, update);
                    }
                    System.out.println("Corrigiendo planificación: " + doc.getString("idPlanification"));
                }
            }
            
            System.out.println("Corrección de datos completada. Los campos weekOfMonth, month y year ahora se calculan automáticamente desde la fecha.");
        } catch (Exception e) {
            System.err.println("Error al corregir datos de calificación: " + e.getMessage());
        }
    }

    // --- Conversión entre Planification y Document ---
    private Document planificationToDocument(Planification plan) {
        Document doc = new Document();
        doc.append("idPlanification", plan.getIdPlanification());
        doc.append("namePlanification", plan.getNamePlanification());
        doc.append("educationalLevel", plan.getEducationalLevel());
        doc.append("activityName", plan.getActivityName());
        doc.append("ageGroup", plan.getAgeGroup());
        doc.append("numberOfChildren", plan.getNumberOfChildren());
        doc.append("estimatedTime", plan.getEstimatedTime());
        doc.append("date", plan.getDate() != null ? plan.getDate().toString() : null);
        doc.append("experienceOverview", plan.getExperienceOverview());
        doc.append("integratingElement", plan.getIntegratingElement());
        doc.append("responsibleTeacher", plan.getResponsibleTeacher());
        if (plan.getScopes() != null) {
            ArrayList<Document> scopesList = new ArrayList<>();
            for (Scope scope : plan.getScopes()) {
                Document scopeDoc = new Document()
                        .append("nombreScope", scope.getScopeName())
                        .append("skill", scope.getSkill())
                        .append("estrategias", scope.getMethodologicalStrategy())
                        .append("recursos", scope.getResourcesAndMaterials())
                        .append("indicadores", scope.getAssessmentIndicators());
                scopesList.add(scopeDoc);
            }
            doc.append("scopes", scopesList);
        } else {
            doc.append("scopes", new ArrayList<>()); // o doc.append("scopes", null);
        }

        doc.append("idTeacher", plan.getIdTeacher());
        doc.append("day", plan.getDay());
        
        // Add grading fields
        doc.append("grade", plan.getGrade());
        doc.append("isGraded", plan.isGraded());
        
        // Los campos weekOfMonth, month y year se calculan automáticamente desde la fecha
        // No necesitamos guardarlos por separado en la base de datos
        
        return doc;

    }

    private Planification documentToPlanification(Document doc) {
        String idPlanification = doc.getString("idPlanification");
        String namePlanification = doc.getString("namePlanification");
        String educationalLevel = doc.getString("educationalLevel");
        String activityName = doc.getString("activityName");
        String ageGroup = doc.getString("ageGroup");
        int numberOfChildren = doc.getInteger("numberOfChildren", 0);
        int estimatedTime = doc.getInteger("estimatedTime", 0);
        LocalDate date = doc.getString("date") != null ? LocalDate.parse(doc.getString("date")) : null;
        String experienceOverview = doc.getString("experienceOverview");
        String integratingElement = doc.getString("integratingElement");
        String responsibleTeacher = doc.getString("responsibleTeacher");
        
        // Convertir scopes correctamente - temporalmente null para evitar errores
        ArrayList<Scope> scopes = new ArrayList<>();
        // TODO: Implementar conversión correcta de scopes cuando se conozca el constructor
        
        String idTeacher = doc.getString("idTeacher");
        Date day = doc.getDate("day");

        Planification plan = new Planification(idPlanification, namePlanification, educationalLevel, activityName, ageGroup,
                numberOfChildren, estimatedTime, date, experienceOverview, integratingElement,
                responsibleTeacher, scopes, idTeacher, day
        );
        
        // Set grading fields if they exist
        if (doc.containsKey("grade")) {
            int gradeValue = doc.getInteger("grade", 0);
            // Solo asignar la calificación si está en el rango válido
            if (gradeValue >= 1 && gradeValue <= 100) {
                plan.setGrade(gradeValue);
            }
            // Si no está en el rango válido, dejamos el valor por defecto del constructor
        }
        if (doc.containsKey("isGraded")) {
            plan.setGraded(doc.getBoolean("isGraded", false));
        }
        
        // Calcular automáticamente weekOfMonth, month y year desde la fecha
        if (date != null) {
            plan.setMonth(date.getMonthValue());
            plan.setYear(date.getYear());
            plan.setWeekOfMonth(calculateWeekOfMonth(date));
        } else if (day != null) {
            // Si no hay LocalDate pero sí hay Date, usar ese
            Calendar cal = Calendar.getInstance();
            cal.setTime(day);
            plan.setMonth(cal.get(Calendar.MONTH) + 1); // Calendar.MONTH es 0-based
            plan.setYear(cal.get(Calendar.YEAR));
            plan.setWeekOfMonth(calculateWeekOfMonth(cal));
        } else {
            // Valores por defecto si no hay fecha
            plan.setMonth(1);
            plan.setYear(2024);
            plan.setWeekOfMonth(1);
        }
        
        return plan;
    }
    
    /**
     * Calcula la semana del mes (1-4) basado en una fecha LocalDate
     */
    private int calculateWeekOfMonth(LocalDate date) {
        int dayOfMonth = date.getDayOfMonth();
        return Math.min(4, ((dayOfMonth - 1) / 7) + 1);
    }
    
    /**
     * Calcula la semana del mes (1-4) basado en un Calendar
     */
    private int calculateWeekOfMonth(Calendar cal) {
        int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
        return Math.min(4, ((dayOfMonth - 1) / 7) + 1);
    }

    private Document scopeToDocument(Scope scope) {
        Document doc = new Document();
        doc.append("nameScope", scope.getScopeName());
        doc.append("skill", scope.getSkill());
        doc.append("strategy", scope.getMethodologicalStrategy());
        doc.append("recursos", scope.getResourcesAndMaterials());
        doc.append("indicators", scope.getAssessmentIndicators());
        return doc;
    }

    /**
     * Método de utilidad para resetear el estado de calificación de todas las planificaciones
     * SOLO PARA TESTING - Marca todas las planificaciones como no calificadas
     */
    public void resetAllGradesToPending() {
        try {
            System.out.println("RESETANDO todas las calificaciones a pendiente...");
            
            for (Document doc : collection.find()) {
                Document updateDoc = new Document()
                    .append("isGraded", false)
                    .append("grade", 0);
                
                Bson filter = Filters.eq("_id", doc.get("_id"));
                Document update = new Document("$set", updateDoc);
                collection.updateOne(filter, update);
                
                System.out.println("Reset: " + doc.getString("idPlanification"));
            }
            
            System.out.println("Todas las planificaciones han sido marcadas como pendientes de calificar.");
        } catch (Exception e) {
            System.err.println("Error al resetear calificaciones: " + e.getMessage());
        }
    }

}
