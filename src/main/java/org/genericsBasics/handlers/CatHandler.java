package org.genericsBasics.handlers;

import org.genericsBasics.db.DBWriter;
import org.genericsBasics.models.Cat;

public class CatHandler extends RequestHandler<Cat> {
    //The constructor parameter type can as well be CatDBWriter
    public CatHandler(DBWriter<Cat> dbWriter) {
        super(dbWriter);
    }

    @Override
    protected void print(Cat cat) {
        System.out.println("some custome operation: " + cat.meow());
    }
}
