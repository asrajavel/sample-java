package org.genericsBasics;

import lombok.extern.slf4j.Slf4j;
import org.genericsBasics.db.CatDBWriter;
import org.genericsBasics.db.DogDBWriter;
import org.genericsBasics.handlers.CatHandler;
import org.genericsBasics.handlers.DogHandler;
import org.genericsBasics.handlers.RequestHandler;
import org.genericsBasics.models.Cat;
import org.genericsBasics.models.Dog;
import org.genericsBasics.models.Request;

@Slf4j
public class Main {
    public static void main(String[] args) {
        RequestHandler<Cat> requestHandlerCat = new CatHandler(new CatDBWriter());
        RequestHandler<Dog> requestHandlerDog = new DogHandler(new DogDBWriter());

        Cat cat = new Cat();
        Dog dog = new Dog();

        System.out.println();
        requestHandlerCat.handle(new Request<>("cccccccc", cat));
        System.out.println();
        requestHandlerDog.handle(new Request<>("dddddddd", dog));
    }
}