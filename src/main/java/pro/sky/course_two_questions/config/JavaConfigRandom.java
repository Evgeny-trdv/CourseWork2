package pro.sky.course_two_questions.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Random;

@Configuration
public class JavaConfigRandom {


    @Bean
    public Random random() {
        return new Random();
    }
}
