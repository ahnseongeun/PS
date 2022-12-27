package chapter14_caching.database;

import chapter14_caching.UserAccount;

public class VirtualDB implements DBManager{
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
