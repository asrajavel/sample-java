package org.genericsBasicsSpringV2;

import lombok.extern.slf4j.Slf4j;
import org.genericsBasicsSpringV2.handlers.RequestHandler;
import org.genericsBasicsSpringV2.models.Cat;
import org.genericsBasicsSpringV2.models.Dog;
import org.genericsBasicsSpringV2.models.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class Main implements ApplicationRunner {
    /*
    in this example we don't subclass the Handler, we just use it as is,
    all the logic is only injected, favouring composition over inheritance
     */
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