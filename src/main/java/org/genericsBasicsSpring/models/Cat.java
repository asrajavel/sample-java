package org.genericsBasicsSpring.models;

import lombok.Data;

@Data
public class Cat {
    public String meow() {
        return "im a cat";
    }
}
