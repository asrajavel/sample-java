package org.genericsBasicsSpring.handlers;

import org.genericsBasicsSpring.db.DBWriter;
import org.genericsBasicsSpring.models.Dog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DogHandler extends RequestHandler<Dog> {
    @Autowired
    public DogHandler(DBWriter<Dog> dbWriter) {
        super(dbWriter);
    }

    @Override
    protected void print(Dog dog) {
        System.out.println("some custome operation: " + dog.bark());
    }
}
