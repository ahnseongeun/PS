package chapter14_caching.database;

public final class DBManagerFactory {

    private DBManagerFactory() {}

    public static DBManager initDB(final boolean isMongo) {
        if (isMongo) {
            return new MongoDB();
        } else {
            return new VirtualDB();
        }
    }
}
