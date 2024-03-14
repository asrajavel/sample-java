package org.genericsBasicsSpringV2.models;

import lombok.Data;

@Data
public class Cat {
    public String meow() {
        return "im a cat";
    }
}
