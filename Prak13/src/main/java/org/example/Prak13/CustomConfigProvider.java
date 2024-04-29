package org.example.Prak13;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class CustomConfigProvider {
    @Value("${program.student.last_name}")
    private String surname;

    @Value("${program.student.name}")
    private String name;

    @Value("${program.student.group}")
    private String group;

    public String getSurname() {
        return surname;
    }

    public String getGroup() {
        return group;
    }

    public String getName() {
        return name;
    }
}

