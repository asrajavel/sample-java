package org.genericsBasicsSpring.handlers;

import org.genericsBasicsSpring.db.DBWriter;
import org.genericsBasicsSpring.models.Cat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CatHandler extends RequestHandler<Cat> {
    //The constructor parameter type can as well be CatDBWriter
    @Autowired
    public CatHandler(DBWriter<Cat> dbWriter) {
        super(dbWriter);
        System.out.println("CatHandler constructor");
    }

    @Override
    protected void print(Cat cat) {
        System.out.println("some custome operation: " + cat.meow());
    }
}
