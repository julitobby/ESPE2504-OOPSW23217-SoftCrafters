package ec.edu.espe.eduplanmaven.util;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import ec.edu.espe.eduplanmaven.model.Planification;
import ec.edu.espe.eduplanmaven.model.Scope;
import java.time.LocalDate;
import java.time.Instant;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Calendar;
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
            return false;
        }
    }

    public List<Planification> getAllPlanifications() {
        List<Planification> result = new ArrayList<>();
        for (Document doc : collection.find()) {
            result.add(documentToPlanification(doc));
        }
        return result;
    }

    public Planification findPlanificationById(String id) {
    Bson filter = Filters.eq("idPlanification", id);
        Document doc = collection.find(filter).first();
        return doc != null ? documentToPlanification(doc) : null;
    }

    public List<Planification> findPlanificationsByTeacher(String teacherId) {
        List<Planification> result = new ArrayList<>();

        Bson filter = Filters.eq("idTeacher", teacherId);

        for (Document doc : collection.find(filter)) {
            Planification plan = documentToPlanification(doc);
            result.add(plan);
        }

        return result;
    }

    public boolean updatePlanification(Planification plan) {
        try {
            Bson filter = Filters.eq("idPlanification", plan.getIdPlanification());
            Document update = new Document("$set", planificationToDocument(plan));
            return collection.updateOne(filter, update).getModifiedCount() > 0;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean deletePlanificationById(String id) {
        Bson filter = Filters.eq("idPlanification", id);
        return collection.deleteOne(filter).getDeletedCount() > 0;
    }

    public void fixGradingDataInDatabase() {
        try {
            for (Document doc : collection.find()) {
                Document updateDoc = new Document();
                boolean needsUpdate = false;

                if (!doc.containsKey("grade")) {
                    updateDoc.append("grade", 0);
                    needsUpdate = true;
                }

                if (!doc.containsKey("isGraded")) {
                    updateDoc.append("isGraded", false);
                    needsUpdate = true;
                }

                if (doc.containsKey("weekOfMonth") || doc.containsKey("month") || doc.containsKey("year")) {
                    updateDoc.append("$unset", new Document()
                        .append("weekOfMonth", "")
                        .append("month", "")
                        .append("year", ""));
                    needsUpdate = true;
                }

                if (needsUpdate) {
                    Bson filter = Filters.eq("_id", doc.get("_id"));
                    if (updateDoc.containsKey("$unset")) {
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
                }
            }
    } catch (Exception e) {}
    }

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
            doc.append("scopes", new ArrayList<>());
        }

        doc.append("idTeacher", plan.getIdTeacher());
        doc.append("day", plan.getDay());
        
        doc.append("grade", plan.getGrade());
        doc.append("isGraded", plan.isGraded());

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
        LocalDate date = null;
        Object dateObj = doc.get("date");
        if (dateObj instanceof String s) {
            try {
                date = LocalDate.parse(s);
            } catch (Exception ex) {
                try {
                    Instant inst = Instant.parse(s);
                    date = inst.atZone(ZoneId.systemDefault()).toLocalDate();
                } catch (Exception ignored) {}
            }
        } else if (dateObj instanceof Date d) {
            date = d.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        }
        String experienceOverview = doc.getString("experienceOverview");
        String integratingElement = doc.getString("integratingElement");
        String responsibleTeacher = doc.getString("responsibleTeacher");

        ArrayList<Scope> scopes = new ArrayList<>();
        if (doc.containsKey("scopes") && doc.get("scopes") instanceof java.util.List) {
            java.util.List<?> rawScopes = (java.util.List<?>) doc.get("scopes");
            for (Object obj : rawScopes) {
                if (obj instanceof Document scopeDoc) {
                    String scopeName = scopeDoc.getString("nombreScope");
                    if (scopeName == null) scopeName = scopeDoc.getString("nameScope");

                    String skill = scopeDoc.getString("skill");

                    java.util.ArrayList<String> estrategias = new java.util.ArrayList<>();
                    Object estrategiasObj = scopeDoc.get("estrategias");
                    if (estrategiasObj instanceof java.util.List<?> list) {
                        for (Object it : list) estrategias.add(String.valueOf(it));
                    } else if (estrategiasObj instanceof String s) {
                        estrategias.add(s);
                    } else {
                        Object alt = scopeDoc.get("strategy");
                        if (alt instanceof java.util.List<?> list) {
                            for (Object it : list) estrategias.add(String.valueOf(it));
                        } else if (alt instanceof String s2) {
                            estrategias.add(s2);
                        }
                    }

                    java.util.ArrayList<String> recursos = new java.util.ArrayList<>();
                    Object recursosObj = scopeDoc.get("recursos");
                    if (recursosObj instanceof java.util.List<?> list) {
                        for (Object it : list) recursos.add(String.valueOf(it));
                    } else if (recursosObj instanceof String s) {
                        recursos.add(s);
                    }

                    java.util.ArrayList<String> indicadores = new java.util.ArrayList<>();
                    Object indicadoresObj = scopeDoc.get("indicadores");
                    if (indicadoresObj instanceof java.util.List<?> list) {
                        for (Object it : list) indicadores.add(String.valueOf(it));
                    } else if (indicadoresObj instanceof String s) {
                        indicadores.add(s);
                    } else {
                        Object alt = scopeDoc.get("indicators");
                        if (alt instanceof java.util.List<?> list2) {
                            for (Object it : list2) indicadores.add(String.valueOf(it));
                        } else if (alt instanceof String s2) {
                            indicadores.add(s2);
                        }
                    }

                    scopes.add(new Scope(scopeName != null ? scopeName : "", skill != null ? skill : "",
                            estrategias, recursos, indicadores));
                }
            }
        }

        String idTeacher = doc.getString("idTeacher");
        Date day = null;
        Object dayObj = doc.get("day");
        if (dayObj instanceof Date d) {
            day = d;
        } else if (dayObj instanceof String s) {
            try {
                LocalDate ld = LocalDate.parse(s);
                day = Date.from(ld.atStartOfDay(ZoneId.systemDefault()).toInstant());
            } catch (Exception ex) {
                try {
                    Instant inst = Instant.parse(s);
                    day = Date.from(inst);
                } catch (Exception ignored) {}
            }
        }

        Planification plan = new Planification(idPlanification, namePlanification, educationalLevel, activityName, ageGroup,
                numberOfChildren, estimatedTime, date, experienceOverview, integratingElement,
                responsibleTeacher, scopes, idTeacher, day
        );
        
        if (doc.containsKey("grade")) {
            int gradeValue = doc.getInteger("grade", 0);
            if (gradeValue >= 1 && gradeValue <= 100) {
                plan.setGrade(gradeValue);
            }
        }
        if (doc.containsKey("isGraded")) {
            plan.setGraded(doc.getBoolean("isGraded", false));
        }

        if (date != null) {
            plan.setMonth(date.getMonthValue());
            plan.setYear(date.getYear());
            plan.setWeekOfMonth(calculateWeekOfMonth(date));
        } else if (day != null) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(day);
            plan.setMonth(cal.get(Calendar.MONTH) + 1);
            plan.setYear(cal.get(Calendar.YEAR));
            plan.setWeekOfMonth(calculateWeekOfMonth(cal));
        } else {
            plan.setMonth(1);
            plan.setYear(2024);
            plan.setWeekOfMonth(1);
        }

        return plan;
    }

    private int calculateWeekOfMonth(LocalDate date) {
        int dayOfMonth = date.getDayOfMonth();
        return Math.min(4, ((dayOfMonth - 1) / 7) + 1);
    }

    private int calculateWeekOfMonth(Calendar cal) {
        int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
        return Math.min(4, ((dayOfMonth - 1) / 7) + 1);
    }

    public void resetAllGradesToPending() {
        try {
            for (Document doc : collection.find()) {
                Document updateDoc = new Document()
                    .append("isGraded", false)
                    .append("grade", 0);
                Bson filter = Filters.eq("_id", doc.get("_id"));
                Document update = new Document("$set", updateDoc);
                collection.updateOne(filter, update);
            }
        } catch (Exception e) {}
    }

}
