package com.example.bcsd;

import org.apache.catalina.util.Introspection;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Controller
public class HelloController {

    @GetMapping("/introduce")
    public String introduceName(@RequestParam(name = "name", required = false) String name, Model model) {
        if (name == null) {
            return "hello.html";
        }
        model.addAttribute("name", name);
        return "hello2.html";
    }

    @GetMapping("/json")
    @ResponseBody
    public IntroduceJson json() {
        IntroduceJson intro = new IntroduceJson(26, "허준기");
        return intro;
    }


    @GetMapping("/posts")
    public String posts(Model model) {
        LocalDateTime now = LocalDateTime.now();
        List<Article> articleList = List.of(
                new Article("제목0", "회원0", now, ""),
                new Article("제목1", "회원1", now, "내용입니다!!"),
                new Article("제목2", "회원2", now, "내용입니다!!내용입니다!!")
        );
        model.addAttribute("articles", articleList);
        return "posts.html";
    }

    @GetMapping("/articles")
    @ResponseBody
    public List<Article> articles() {
        LocalDateTime now = LocalDateTime.now();
        List<Article> articleList = List.of(
                new Article("제목0", "회원0", now, ""),
                new Article("제목1", "회원1", now, "내용입니다!!"),
                new Article("제목2", "회원2", now, "내용입니다!!내용입니다!!")
        );
        return articleList;
    }
}
