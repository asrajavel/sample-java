package org.genericsBasicsSpring.db;

import org.genericsBasicsSpring.models.Dog;
import org.springframework.stereotype.Component;

@Component
public class DogDBWriter extends DBWriter<Dog> {
    public DogDBWriter() {
        super("dummy");
    }

    @Override
    protected String getStringVersion(Dog dog) {
        return dog.bark();
    }
}
