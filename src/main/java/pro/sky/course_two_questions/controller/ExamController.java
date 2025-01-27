package pro.sky.course_two_questions.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import pro.sky.course_two_questions.service.ExaminerService;

@RestController
public class ExamController {

    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping("/exam/get/{amount}")
    public ResponseEntity<?> getQuestions(@PathVariable int amount) {
        return examinerService.getQuestions(amount);
    }
}
