package tests.parsing;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.parsing.model.Quiz;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import static org.assertj.core.api.Assertions.assertThat;

public class ParsingJsonTest {

    ClassLoader cl = ParsingJsonTest.class.getClassLoader();
    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    @DisplayName("Чтение файла json с помощью Jackson")
    void parsingJsonWithJacksonTest() throws IOException {

        try (
                InputStream resource = cl.getResourceAsStream("quiz.json");
                InputStreamReader reader = new InputStreamReader(resource)
                ) {
            Quiz quiz = objectMapper.readValue(reader, Quiz.class);
            assertThat(quiz.quiz).isEqualTo("sport");
            assertThat(quiz.questions.q1).isEqualTo("Which one is correct team name in NBA?");
            assertThat(quiz.questions.options)
                    .contains("New York Bulls")
                    .contains("Los Angeles Kings")
                    .contains("Golden State Warriros")
                    .contains("Huston Rocket");
            assertThat(quiz.questions.answer).isEqualTo("Huston Rocket");
        }
    }
}
