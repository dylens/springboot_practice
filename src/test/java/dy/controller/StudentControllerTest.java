package dy.controller;

import org.hamcrest.Matchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.testng.annotations.Test;

// 仅模拟Controller层，Http请求和响应是Mock出来的，不会创建真正的链接
@WebMvcTest(controllers = {StudentController.class})
// 若Controller中没有依赖Service，则不需要扫描
@ComponentScan(basePackages = "dy")
//@ContextConfiguration(locations = {"classpath:SpringApplicationContext.xml"})
public class StudentControllerTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testStudentController() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/api/student");
        mockMvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(Matchers.hasToString("{\"name\":\"dye\",\"age\":10,\"sex\":\"女\",\"birthday\":\"1991-01-01\"}")));
    }

}
