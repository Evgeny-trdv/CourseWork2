package pro.sky.course_two_questions.service;

import org.springframework.http.ResponseEntity;
import pro.sky.course_two_questions.domain.Question;

import java.util.Collection;


public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
