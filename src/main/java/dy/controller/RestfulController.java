package dy.controller;

import dy.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RestfulController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/home")
    public String home() {
        return "home";
    }

    @RequestMapping(value = "/api/student", method = RequestMethod.GET)
    @ResponseBody
    public String student() {
        return studentService.getStudentJson();
    }

}
