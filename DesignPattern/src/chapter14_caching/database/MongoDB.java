package chapter14_caching.database;

import chapter14_caching.UserAccount;

public class MongoDB implements DBManager {

    private static final String DATABASE_NAME = "admin";
    private static final String MONGO_USER = "root";
    private static final String MONGO_PASSWORD = "rootpassword";
//    private MongoClient client;
//    private MongoDatabase db;
//
//    void setDB(MongoDatabase db) {
//        this.db = db;
//    }

    @Override
    public void connect() {
    }

    @Override
    public void disconnect() {

    }

    @Override
    public UserAccount readFromDb(String userId) {
        return null;
    }

    @Override
    public UserAccount writeToDb(UserAccount userAccount) {
        return null;
    }

    @Override
    public UserAccount updateDb(UserAccount userAccount) {
        return null;
    }

    @Override
    public UserAccount updateAndInsertDb(UserAccount userAccount) {
        return null;
    }
}
