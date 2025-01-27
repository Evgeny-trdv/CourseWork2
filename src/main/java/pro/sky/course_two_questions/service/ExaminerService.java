package pro.sky.course_two_questions.service;

import org.springframework.http.ResponseEntity;


public interface ExaminerService {
    ResponseEntity<?> getQuestions(int amount);
}
