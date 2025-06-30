package ec.edu.espe.eduplanmaven.util;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import ec.edu.espe.eduplanmaven.model.Planification;
import ec.edu.espe.eduplanmaven.model.Scope;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.bson.Document;
import org.bson.conversions.Bson;

public class FileManagerPlanification {

    private static FileManagerPlanification instance;
    private final MongoCollection<Document> collection;

    private FileManagerPlanification() {
        collection = MongoClientConnection.getInstance().getDatabase().getCollection("plans");
    }

    public static synchronized FileManagerPlanification getInstance() {
        if (instance == null) {
            instance = new FileManagerPlanification();
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
        Bson filter = Filters.eq("id", id);
        Document doc = collection.find(filter).first();
        return doc != null ? documentToPlanification(doc) : null;
    }

    // Buscar planificaciones por ID de profesor
    public List<Planification> findPlanificationsByTeacher(String teacherId) {
        List<Planification> result = new ArrayList<>();
        Bson filter = Filters.eq("teacherId", teacherId);
        for (Document doc : collection.find(filter)) {
            result.add(documentToPlanification(doc));
        }
        return result;
    }

    // Actualizar planificación (por ID)
    public boolean updatePlanification(Planification plan) {
        try {
            Bson filter = Filters.eq("id", plan.getIdPlanification());
            Document update = new Document("$set", planificationToDocument(plan));
            return collection.updateOne(filter, update).getModifiedCount() > 0;
        } catch (Exception e) {
            System.err.println("Error al actualizar la planificación: " + e.getMessage());
            return false;
        }
    }

    // Eliminar planificación (por ID)
    public boolean deletePlanificationById(String id) {
        Bson filter = Filters.eq("id", id);
        return collection.deleteOne(filter).getDeletedCount() > 0;
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
        List<Document> scopesDocs = new ArrayList<>();
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
        @SuppressWarnings("unchecked")
        ArrayList<Scope> scopes = (ArrayList<Scope>) doc.get("scopes");
        String idTeacher = doc.getString("idTeacher");
        Date day = doc.getDate("day");

        return new Planification(idPlanification, namePlanification, educationalLevel, activityName, ageGroup,
                numberOfChildren, estimatedTime, date, experienceOverview, integratingElement,
                responsibleTeacher, scopes, idTeacher, day
        );
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

}
