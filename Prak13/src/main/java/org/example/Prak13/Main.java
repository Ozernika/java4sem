package org.example.Prak13;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main implements CommandLineRunner {
	private final CustomConfigProvider config;

	public Main(CustomConfigProvider config) {
		this.config = config;
	}

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(config.getName());
		System.out.println(config.getSurname());
		System.out.println(config.getGroup());
	}
}

