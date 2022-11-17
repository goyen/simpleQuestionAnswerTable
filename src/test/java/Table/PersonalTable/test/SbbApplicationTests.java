package Table.PersonalTable.test;


import Table.PersonalTable.sbb.answer.Answer;
import Table.PersonalTable.sbb.answer.AnswerRepository;
import Table.PersonalTable.sbb.question.Question;
import Table.PersonalTable.sbb.question.QuestionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest

@Transactional
public class SbbApplicationTests {
    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private AnswerRepository answerRepository;

    @Test

    void testJpa(){
        Question q1 = new Question();
        q1.setSubject("what is sbb");
        q1.setContent("wanna know sbb");
        q1.setCreateDate(LocalDateTime.now());
        System.out.println(q1.getSubject());
        this.questionRepository.save(q1);


        Question q2 = new Question();
        q2.setSubject("what is spring model");
        q2.setContent("is id created automatically?");
        q2.setCreateDate(LocalDateTime.now());
        System.out.println(q2);

        this.questionRepository.save(q2);
    }
    @Test
    void findAllTest(){
        List<Question> all = this.questionRepository.findAll();
        assertEquals(2, all.size());

        Question q = all.get(0);
        assertEquals("what is sbb",q.getSubject());
    }

    @Test
    void findBySubject() {
        Question q = this.questionRepository.findBySubject("what is sbb");
        System.out.println("q = " + q.getSubject());
    }
    @Test
    void findById(){
        Optional<Question> op = this.questionRepository.findById(9);
        if (op.isPresent()) {
            Question q = op.get();
            assertEquals("what is sbb", q.getSubject());
        }
    }


    @Test
    void findByLike(){
        List<Question> questionList = this.questionRepository.findBySubjectLike("sbb%");
        for (Question question : questionList) {
            System.out.println("question = " + question);
        }
    }

    @Test
    void createAnswer(){
        Optional<Question> byId = this.questionRepository.findById(9);
        assertTrue(byId.isPresent());
        Question q = byId.get();
        System.out.println("q = " + q.getSubject());

        Answer a1 = new Answer();
        a1.setContent("Yes");
        a1.setQuestion(q);
        a1.setCreateDate(LocalDateTime.now());
        this.answerRepository.save(a1);

    }

    @Test
    void findAnswer(){
        Optional<Answer> oa = answerRepository.findById(4);
        assertTrue(oa.isPresent());
        Answer a = oa.get();
        assertEquals(9,a.getQuestion().getId());
    }

    @Test
    void test(){
        Question question = new Question();
        List<Answer> answerList = question.getAnswerList();
    }

}
