package org.genericsBasics.handlers;

import org.genericsBasics.db.DBWriter;
import org.genericsBasics.models.Request;

public abstract class RequestHandler<T> {
    private final DBWriter<T> dbWriter;

    public RequestHandler(DBWriter<T> dbWriter) {
        this.dbWriter = dbWriter;
    }

    public void handle(Request<T> request) {
        //do a lot of common things based on request.getRandomString()
        //and then do the below
        T data = request.getData();
        print(data);
        //now we want to write to db
        dbWriter.write(data);
    }

    protected void print(T data) {
        //whenever we have logic that is based on T, its not possible to have it inside a class with T,
        //so we have to delegate it to a subclass
    }
}
