package chapter7_ambassador;

public enum RemoteServiceStatus {

    FAILURE(-1);

    private final long remoteServiceStatusValue;

    RemoteServiceStatus(long remoteServiceStatusValue) {
        this.remoteServiceStatusValue = remoteServiceStatusValue;
    }

    public long getRemoteServiceStatusValue() {
        return remoteServiceStatusValue;
    }
}
