package org.genericsBasics.handlers;

import org.genericsBasics.db.DBWriter;
import org.genericsBasics.models.Dog;

public class DogHandler extends RequestHandler<Dog> {
    public DogHandler(DBWriter<Dog> dbWriter) {
        super(dbWriter);
    }

    @Override
    protected void print(Dog dog) {
        System.out.println("some custome operation: " + dog.bark());
    }
}
