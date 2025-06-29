package ec.edu.espe.eduplanmaven.util;

import com.mongodb.client.MongoCollection;
import org.bson.Document;

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


}
