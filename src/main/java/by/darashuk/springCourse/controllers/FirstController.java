package by.darashuk.springCourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
//@RequestMapping("/prefix")         добавляет префикс к строке запроса этого класса,теперь:

public class FirstController {          // http://localhost:8080/prefix/goodbye


    @GetMapping("/hello")                //это запрос из браузера
    public String helloPage(@RequestParam("name") String name,
                            @RequestParam("surname") String surname
            , Model model) {
        model.addAttribute("message", "request include : " + name + " " + surname);


//  public String helloPage(HttpServletRequest request){
//        String name = request.getParameter("name");              //получаем параметры из запроса
//        String surname = request.getParameter("surname");
//        System.out.println(name+" "+ surname);

        return "first/hello";           //это вызов представления - файл из views
    }

    @GetMapping("/action")
    public String calculating(@RequestParam("a") int a,
                              @RequestParam("b") int b,
                              @RequestParam("znak") String znak,
                              Model model) {

        double result;
        switch (znak) {
            case "addition":
                result = a + b;
                break;
            case "delimiter":
                result = a / (double) b;
                break;
            case "substraction":
                result = a - b;
                break;
            case "multiplication":
                result = a * b;
                break;
            default:
                result = 0;
                break;



        }
        model.addAttribute("result",result);
        return "calculator/action";
    }


    }
