package pro.sky.course_two_questions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pro.sky.course_two_questions.domain.Question;
import pro.sky.course_two_questions.exception.InvalidArgumentException;
import pro.sky.course_two_questions.exception.QuestionNotFoundException;
import pro.sky.course_two_questions.service.JavaQuestionService;
import pro.sky.course_two_questions.service.QuestionService;

import java.util.*;

public class JavaQuestionTest {

    Question questionExpectedFirst = new Question("How many primitive type are there in java", "8");
    Question questionExpectedSecond = new Question("How do you insert comments in Java code?", "//");
    Question questionExpectedThird = new Question("Which method can be used to find the length of a string?", "length()");
    List<Question> questionList = new ArrayList<>(List.of(
            questionExpectedSecond,
            questionExpectedThird,
            questionExpectedFirst));

    public final QuestionService out = new JavaQuestionService(new Random());

    @Test
    public void shouldReturnResultOfAddWhenQuestionAdded() {
        Assertions.assertEquals(questionExpectedFirst, out.add("How many primitive type are there in java", "8"));
    }

    @Test
    public void shouldReturnResultOfAddWhenInvalidArguments() {
        Assertions.assertThrows(InvalidArgumentException.class,
                () -> out.add("How many primitive type are there in java", null));
    }

    @Test
    public void shouldReturnResultOfRemoveWhenQuestionRemoved() {
        out.add("How many primitive type are there in java", "8");
        Assertions.assertEquals(questionExpectedFirst, out.remove(new Question("How many primitive type are there in java", "8")));
    }

    @Test
    public void shouldReturnResultOfRemoveWhenInvalidArguments() {
        Assertions.assertThrows(InvalidArgumentException.class,
                () -> out.remove(new Question("How many primitive type are there in java", null)));
    }

    @Test
    public void shouldReturnResultOfRemoveWhenNotFound() {
        Assertions.assertThrows(QuestionNotFoundException.class,
                () -> out.remove(new Question("How many primitive type are there in java", "8")));
    }

    @Test
    public void shouldReturnResultOfGetAllQuestions() {
        out.add("How many primitive type are there in java", "8");
        out.add("How do you insert comments in Java code?", "//");
        out.add("Which method can be used to find the length of a string?", "length()");
        Assertions.assertIterableEquals(questionList, out.getAll());
    }

    @Test
    public void shouldReturnResultOfGetRandomQuestion() {
        out.add("How many primitive type are there in java", "8");
        out.add("How do you insert comments in Java code?", "//");
        out.add("Which method can be used to find the length of a string?", "length()");
        Question randomQuestion = out.getRandomQuestion();
        Assertions.assertTrue(questionList.contains(randomQuestion));
    }
}
