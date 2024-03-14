package org.genericsBasics.db;

import org.genericsBasics.models.Cat;

public class CatDBWriter extends DBWriter<Cat>{
    public CatDBWriter() {
        super("dummy");
    }

    @Override
    protected String getStringVersion(Cat cat) {
        return cat.meow();
    }
}
