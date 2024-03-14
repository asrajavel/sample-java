package org.genericsBasics.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Request<T> {
    private String randomString;
    private T data;
}
