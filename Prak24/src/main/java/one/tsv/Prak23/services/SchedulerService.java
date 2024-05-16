package one.tsv.Prak23.services;


import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import one.tsv.Prak23.models.Group;
import one.tsv.Prak23.models.Student;
import one.tsv.Prak23.repositories.GroupRepository;
import one.tsv.Prak23.repositories.StudentRepository;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.management.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.lang.management.ManagementFactory;
import java.nio.charset.StandardCharsets;
import java.util.List;

@AllArgsConstructor
@Service
@ManagedResource(objectName = "one.tsv.Prak22.service:type=SchedulerService")
public class SchedulerService {
    private final GroupRepository groupRepository;
    private final StudentRepository studentRepository;

    @ManagedOperation
    @Scheduled(cron = "0 */30 * * * *")
    public void doScheduledTask() throws IOException {
        List<Group> groups = groupRepository.findAll();
        List<Student> students = studentRepository.findAll();
        ObjectMapper objectMapper = new ObjectMapper();
        File entities = new File("src/main/resources/entities");

        // Проверяем, существует ли каталог entities
        if (!entities.exists() || !entities.isDirectory()) {
            // Если каталог не существует, создаем его
            if (!entities.mkdirs()) {
                // Если не удалось создать каталог, выводим сообщение об ошибке
                System.err.println("Не удалось создать каталог entities");
                return;
            }
        }

        File[] files = entities.listFiles();
        // Проверяем, что массив файлов не равен null
        if (files != null) {
            // Удаляем все файлы в каталоге entities
            for (File f : files) {
                if (f.isFile()) {
                    f.delete();
                }
            }
        } else {
            // Если массив файлов равен null, выводим сообщение об ошибке
            System.err.println("Массив файлов равен null");
            return;
        }

        for (Group i : groups) {
            OutputStreamWriter writer = new OutputStreamWriter(
                    new FileOutputStream("src/main/resources/entities/groups#" + i.getGroupName() + ".json"),
                    StandardCharsets.UTF_8);
            writer.write(objectMapper.writeValueAsString(i));
            writer.close();
        }
        for (Student i : students) {
            OutputStreamWriter writer = new OutputStreamWriter(
                    new FileOutputStream("src/main/resources/entities/students#" + i.getFirstName() + ".json"),
                    StandardCharsets.UTF_8);
            writer.write(objectMapper.writeValueAsString(i));
            writer.close();
        }
    }

    @Scheduled(cron = "30 * * * * *")
    public void checkJMX() throws MalformedObjectNameException, ReflectionException, InstanceNotFoundException, MBeanException, IOException {
        MBeanServerConnection connection = ManagementFactory.getPlatformMBeanServer();
        ObjectName objectName = new ObjectName("one.tsv.Prak22.service:type=SchedulerService");

        connection.invoke(objectName, "doScheduledTask", null, null);
    }
}
