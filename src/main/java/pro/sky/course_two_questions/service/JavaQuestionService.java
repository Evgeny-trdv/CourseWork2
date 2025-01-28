package pro.sky.course_two_questions.service;

import org.springframework.stereotype.Service;
import pro.sky.course_two_questions.domain.Question;
import pro.sky.course_two_questions.exception.InvalidArgumentException;
import pro.sky.course_two_questions.exception.QuestionNotFoundException;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class JavaQuestionService implements QuestionService{

    private final Set<Question> questionsSet;
    private final Random random;

    public JavaQuestionService(Random random) {
        this.random = random;
        this.questionsSet = new HashSet<>();
    }

    @Override
    public Question add(String question, String answer) {
        if (question == null || answer == null) {
            throw new InvalidArgumentException("Один или более параметров отсутствует");
        }
        Question questions = new Question(question, answer);
        questionsSet.add(questions);
        return questions;
    }

    @Override
    public Question add(Question question) {
        questionsSet.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (question.getQuestion() == null || question.getAnswer() == null) {
            throw new InvalidArgumentException("Один или более параметров отсутствует");
        }
        if (!questionsSet.contains(question)) {
            throw new QuestionNotFoundException("Вопрос не найден в списке");
        }
        questionsSet.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return questionsSet.stream().
                toList();
    }

    @Override
    public Question getRandomQuestion() {
        return questionsSet.stream()
                .toList()
                .get(random.nextInt(0, questionsSet.size()));
    }
}
