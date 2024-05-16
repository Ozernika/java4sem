package one.tsv.Prak16.controllers;

import lombok.RequiredArgsConstructor;
import one.tsv.Prak16.models.Student;
import one.tsv.Prak16.dto.StudentDto;
import one.tsv.Prak16.services.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/students")
public class StudentController {
    private StudentService service;

    @GetMapping
    @ResponseBody
    public List<StudentDto> getList() {
        return service.getAllStudents().stream().map(Student::toDto).toList();
    }

    @PostMapping(consumes="application/json")
    @ResponseBody
    public Student add(@RequestBody Student student) {
        service.addStudent(student);
        return student;
    }

    @DeleteMapping(path="/{id}")
    @ResponseBody
    public String delete(@PathVariable Long id) {
        return "Count: " + service.deleteStudentById(id);
    }
}
