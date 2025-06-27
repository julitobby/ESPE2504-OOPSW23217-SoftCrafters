package ec.edu.espe.eduplanmaven.util;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 *
 * @author SoftCrafters
 */
public class FileManagerPrincipal {

    public static MongoClientConnection connection = new MongoClientConnection();
    public static MongoDatabase database = connection.getDatabase();
    public static MongoCollection<Document> collection = database.getCollection("principals");

}
