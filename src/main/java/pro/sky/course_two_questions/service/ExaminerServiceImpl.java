package pro.sky.course_two_questions.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;
import pro.sky.course_two_questions.domain.Question;
import pro.sky.course_two_questions.exception.InvalidArgumentException;

import java.util.ArrayList;
import java.util.Collection;
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
    public Collection<Question> getQuestions(int amount) throws InvalidArgumentException{
        if (amount > questionService.getAll().size()) {
            throw new InvalidArgumentException();
        }
        while (amount > 0) {
            Question randomQuestion = questionService.getRandomQuestion();
            if (!questionsList.contains(randomQuestion)) {
                questionsList.add(randomQuestion);
                amount--;
            }
        }
        return questionsList;
    }
}
