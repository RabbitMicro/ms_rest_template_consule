package com.example.car;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import com.example.car.entities.Car;
import com.example.car.repositories.CarRepository;

@SpringBootApplication
@EnableDiscoveryClient
public class CarApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarApplication.class, args);
    }
    @Bean
    CommandLineRunner initializeH2Database(CarRepository carRepository) {
        return args -> {
            carRepository.save(new Car(Long.parseLong("1"),"Toyota", "Corolla", "ABC123", Long.parseLong("1")));
            carRepository.save(new Car(Long.parseLong("2"),"Honda", "Civic", "XYZ789", Long.parseLong("2")));
            carRepository.save(new Car(Long.parseLong("3"),"Ford", "Focus", "LMN456", Long.parseLong("2")));
            carRepository.save(new Car(Long.parseLong("4"),"Dacia", "Duster", "MXN476", Long.parseLong("3")));
        };
    }

    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setConnectTimeout(5000);
        requestFactory.setReadTimeout(5000);
        restTemplate.setRequestFactory(requestFactory);

        return restTemplate;
    }
}
