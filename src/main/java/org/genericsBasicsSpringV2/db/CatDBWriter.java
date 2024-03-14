package org.genericsBasicsSpringV2.db;

import org.genericsBasicsSpringV2.models.Cat;
import org.springframework.stereotype.Component;

@Component
public class CatDBWriter extends DBWriter<Cat> {
    public CatDBWriter() {
        super("dummy");
    }

    @Override
    protected String getStringVersion(Cat cat) {
        return cat.meow();
    }
}
