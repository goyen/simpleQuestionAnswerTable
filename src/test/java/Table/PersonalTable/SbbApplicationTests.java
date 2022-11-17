package Table.PersonalTable;

import Table.PersonalTable.sbb.question.QuestionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SbbApplicationTests {
    @Autowired
    private QuestionService questionService;

    @Test
    void testJpa() {
        for (int i = 1; i <= 300; i++) {
            String subject = String.format("It is a test data[%03d]", i);
            String content = "Empty";
            this.questionService.create(subject, content);
            
        }
    }


}
