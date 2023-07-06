package com.app.restaurantapp;

import com.app.restaurantapp.model.Table;
import com.app.restaurantapp.repository.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestaurantAppApplication implements CommandLineRunner {

    @Autowired
    TableRepository tableRepository;

    public static void main(String[] args) {
        SpringApplication.run(RestaurantAppApplication.class, args);
    }

    @Override
    public void run(String... args) {
        this.tableRepository.save(new Table(4,"Available",null,null,"11 AM","12 PM"));
        this.tableRepository.save(new Table(4,"Available",null,null,"11 AM","12 PM"));
        this.tableRepository.save(new Table(4,"Available",null,null,"11 AM","12 PM"));

        this.tableRepository.save(new Table(6,"Available",null,null,"12 PM","1 PM"));
        this.tableRepository.save(new Table(6,"Available",null,null,"12 PM","1 PM"));
        this.tableRepository.save(new Table(6,"Available",null,null,"12 PM","1 PM"));

        this.tableRepository.save(new Table(8,"Available",null,null,"1 PM","2 PM"));
        this.tableRepository.save(new Table(8,"Available",null,null,"1 PM","2 PM"));
        this.tableRepository.save(new Table(8,"Available",null,null,"1 PM","2 PM"));

        this.tableRepository.save(new Table(10,"Available",null,null,"2 PM","3 PM"));
        this.tableRepository.save(new Table(20,"Available",null,null,"3 PM","4 PM"));
    }
}
