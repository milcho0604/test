package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "hello!!");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";
    }
    @GetMapping("hello-string")
    @ResponseBody // html에 나오는 body태그가 아닌 http에 존재하는 body데이터를 직접 넣어주겠다는 의미
    public String helloString(@RequestParam("name") String name){
        return "hello"+name; // "hello spring" <- spring 부분을 내가 넣어주는 것임
    }
    @GetMapping("hello-api") // JSON방식을 이용한 것
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){ // 객체 반환하는 것이 즉, api
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }
    static class Hello{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
 }

