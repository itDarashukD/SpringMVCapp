package by.darashuk.springCourse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller                                    //обозначили этот класс как контроллер
public class HelloController {

    @GetMapping("/hello-world")                 //когда пользователь введет в строке hello-world-
    public String sayHello(){                         //он попадет в наш метод sayHello()
        return "hello_world";
    }
}
