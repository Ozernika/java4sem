package one.tsv.Prak14.controllers;

import one.tsv.Prak14.models.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/students")
public class StudentController {
    private ArrayList<Student> students = new ArrayList<>();

    @GetMapping
    @ResponseBody
    public List<Student> getList() {
        return students.stream().toList();
    }

    @PostMapping(consumes="application/json")
    @ResponseBody
    public Student add(@RequestBody Student student) {
        int lenBefore = students.size();
        students.add(student);
        if (students.size() != lenBefore)
            return student;
        else
            return null;
    }

    @DeleteMapping(consumes="application/json")
    @ResponseBody
    public Student delete(@RequestBody Student student) {
        int lenBefore = students.size();
        students = new ArrayList<>(
                students.stream()
                        .filter((authorListItem -> !authorListItem.equals(student)))
                        .toList()
        );
        if (students.size() != lenBefore)
            return student;
        else
            return null;
    }
}
