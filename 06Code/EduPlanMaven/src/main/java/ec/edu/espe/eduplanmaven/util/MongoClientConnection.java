package ec.edu.espe.eduplanmaven.util;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class MongoClientConnection {

    private static MongoClientConnection instance;
    private final MongoClient mongoClient;
    private final MongoDatabase database;

    private MongoClientConnection() {
        String connectionString = "mongodb+srv://eduplan:eduplan@cluster0.vbzft1p.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";

        ServerApi serverApi = ServerApi.builder()
                .version(ServerApiVersion.V1)
                .build();

        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(connectionString))
                .serverApi(serverApi)
                .build();

        mongoClient = MongoClients.create(settings);
        database = mongoClient.getDatabase("EduPlanDB");
    }

    public static synchronized MongoClientConnection getInstance() {
        if (instance == null) {
            instance = new MongoClientConnection();
        }
        return instance;
    }

    public MongoDatabase getDatabase() {
        return database;
    }
}