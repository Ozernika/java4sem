package com.example.Prak10;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KnightConfiguration {
    @Bean
    public WeakKnight weakKnight() {
        return new WeakKnight();
    }

    @Bean
    public StrongKnight strongKnight() {
        return new StrongKnight();
    }

    @Bean
    public KingOfKnights kingOfKnights() {
        return new KingOfKnights();
    }
}

