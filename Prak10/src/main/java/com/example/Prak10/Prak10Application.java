package com.example.Prak10;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Prak10Application {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(KnightConfiguration.class);
		Knight weakKnight = context.getBean(WeakKnight.class);
		Knight strongKnight = context.getBean(StrongKnight.class);
		Knight kingOfKnights = context.getBean(KingOfKnights.class);
		weakKnight.fight();
		strongKnight.fight();
		kingOfKnights.fight();
	}
}

