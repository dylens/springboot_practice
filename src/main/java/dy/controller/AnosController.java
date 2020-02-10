package dy.controller;

import dy.anos.MyAnotation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnosController {

    @MyAnotation(name = "dye")
    @GetMapping("/dong/{gua}")
    public String dong(@PathVariable("gua") String gua) {
        return "dong " + gua;
    }

}
