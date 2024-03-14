package org.genericsBasicsSpringV2.db;

public abstract class DBWriter<T> {
    //The db connection is common for all
    private final String dbConnection;

    public DBWriter(String dbConnection) {
        this.dbConnection = dbConnection;
    }

    public void write(T data) {
        System.out.println("db connection established: " + dbConnection);
        String stringToWrite = getStringVersion(data);
        System.out.println("Writing to db: " + stringToWrite);
    }

    protected abstract String getStringVersion(T data);
}
