package pro.sky.course_two_questions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseStatus;
import pro.sky.course_two_questions.domain.Question;
import pro.sky.course_two_questions.exception.InvalidArgumentException;
import pro.sky.course_two_questions.service.ExaminerServiceImpl;
import pro.sky.course_two_questions.service.QuestionService;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceTest {

    @Mock
    QuestionService questionService;

    @InjectMocks
    private ExaminerServiceImpl out;

    @BeforeEach
    public void unit() {
        Mockito.when(questionService.getAll())
                .thenReturn(List.of(
                new Question("How many primitive type are there in java", "8"),
        new Question("How do you insert comments in Java code?", "//"),
        new Question("Which method can be used to find the length of a string?", "length()")
        ));

    }

    @Test
    public void shouldReturnResultOfGetQuestions() {
                Mockito.when(questionService.getRandomQuestion())
                .thenReturn(
                        new Question("How many primitive type are there in java", "8")
                );

        List<Question> questionList = new ArrayList<>(List.of(
                new Question("How many primitive type are there in java", "8")));
        Assertions.assertEquals(questionList, out.getQuestions(1));

    }

    @Test
    public void shouldReturnResultOfGetQuestionsWhenAmountMoreSizeOfRepository() {
        Assertions.assertThrows(InvalidArgumentException.class, () -> out.getQuestions(6));
    }
}
