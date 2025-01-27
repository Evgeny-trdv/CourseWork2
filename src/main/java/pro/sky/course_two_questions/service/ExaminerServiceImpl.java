package pro.sky.course_two_questions.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pro.sky.course_two_questions.domain.Question;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final List<Question> questionsList;
    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
        this.questionsList = new ArrayList<>();
    }

    @Override
    public ResponseEntity<?> getQuestions(int amount) {
        if (amount > questionService.getAll().size()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        while (amount > 0) {
            Question randomQuestion = questionService.getRandomQuestion();
            if (!questionsList.contains(randomQuestion)) {
                questionsList.add(randomQuestion);
                amount--;
            }
        }
        return new ResponseEntity<>(questionsList, HttpStatus.OK);
    }
}
