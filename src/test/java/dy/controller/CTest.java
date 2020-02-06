package dy.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dy.dto.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CTest {

    @Autowired
    private Student student;

    @Test
    public void loadStudent() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String stu = mapper.writeValueAsString(student);
        System.out.println(stu);
    }
}
