package org.genericsBasics.db;

import org.genericsBasics.models.Dog;

public class DogDBWriter extends DBWriter<Dog>{
    public DogDBWriter() {
        super("dummy");
    }

    @Override
    protected String getStringVersion(Dog dog) {
        return dog.bark();
    }
}
