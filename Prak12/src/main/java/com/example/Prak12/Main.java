package com.example.Prak12;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main implements CommandLineRunner {

    public static void main(String[] args) {
        if (args.length == 2) {
            FileService.inputFileName = args[0];
            FileService.outputFileName = args[1];
        }
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
    }
}

