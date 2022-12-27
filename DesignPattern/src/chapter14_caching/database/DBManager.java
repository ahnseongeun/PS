package chapter14_caching.database;

import chapter14_caching.UserAccount;

public interface DBManager {

    // Connect to DB
    void connect();

    // Disconnect from DB
    void disconnect();

    // Read from DB
    UserAccount readFromDb(String userId);

    // Write to DB
    UserAccount writeToDb(UserAccount userAccount);

    // Update record
    UserAccount updateDb(UserAccount userAccount);

    // Update record or Insert if not exists.
    UserAccount updateAndInsertDb(UserAccount userAccount);
}
