package org.genericsBasicsSpringV2.db;

import org.genericsBasicsSpringV2.models.Dog;
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
