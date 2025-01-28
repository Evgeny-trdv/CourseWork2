package pro.sky.course_two_questions.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import pro.sky.course_two_questions.domain.Question;
import pro.sky.course_two_questions.exception.InvalidArgumentException;
import pro.sky.course_two_questions.service.ExaminerService;

import java.util.Collection;

@RestController
public class ExamController {

    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping("/exam/get/{amount}")
    public Collection<Question> getQuestions(@PathVariable int amount) {
        try {
            return examinerService.getQuestions(amount);
        } catch (RuntimeException e) {
            throw new InvalidArgumentException();
        }
    }
}
