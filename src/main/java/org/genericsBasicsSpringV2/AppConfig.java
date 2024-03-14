package org.genericsBasicsSpringV2;

import org.genericsBasicsSpringV2.db.CatDBWriter;
import org.genericsBasicsSpringV2.db.DogDBWriter;
import org.genericsBasicsSpringV2.handlers.RequestHandler;
import org.genericsBasicsSpringV2.models.Cat;
import org.genericsBasicsSpringV2.models.Dog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public RequestHandler<Dog> dogRequestHandler(DogDBWriter dogDBWriter) {
        return new RequestHandler<Dog>(dogDBWriter);
    }

    @Bean
    public RequestHandler<Cat> catRequestHandler(CatDBWriter catDBWriter) {
        return new RequestHandler<Cat>(catDBWriter);
    }

}