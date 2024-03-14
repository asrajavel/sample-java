package org.genericsBasicsSpring;

import lombok.extern.slf4j.Slf4j;
import org.genericsBasicsSpring.handlers.RequestHandler;
import org.genericsBasicsSpring.models.Cat;
import org.genericsBasicsSpring.models.Dog;
import org.genericsBasicsSpring.models.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class Main implements ApplicationRunner {
    private final RequestHandler<Cat> requestHandlerCat;
    private final RequestHandler<Dog> requestHandlerDog;

    @Autowired
    public Main(RequestHandler<Cat> requestHandlerCat, RequestHandler<Dog> requestHandlerDog) {
        this.requestHandlerCat = requestHandlerCat;
        this.requestHandlerDog = requestHandlerDog;
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(ApplicationArguments args) {
        Cat cat = new Cat();
        Dog dog = new Dog();

        System.out.println();
        requestHandlerCat.handle(new Request<>("cccccccc", cat));
        System.out.println();
        requestHandlerDog.handle(new Request<>("dddddddd", dog));
    }
}