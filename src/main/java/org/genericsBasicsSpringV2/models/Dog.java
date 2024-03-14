package org.genericsBasicsSpringV2.models;

import lombok.Data;

@Data
public class Dog {
    public String bark() {
        return "im a dog";
    }
}
