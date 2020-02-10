package dy.controller;

import dy.service.StudentService;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.testng.annotations.Test;

@AutoConfigureMockMvc
@WebMvcTest(controllers = {StudentController.class})
public class MockStudentServiceTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentService studentService;

    @Test
    public void testStudentController() throws Exception {
        Mockito.when(studentService.getStudentJson()).thenReturn("{\"name\":\"dye\",\"age\":10,\"sex\":\"女\",\"birthday\":\"1991-01-01\"}");

        mockMvc.perform(
                MockMvcRequestBuilders.get("/api/student")
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

    }
}
