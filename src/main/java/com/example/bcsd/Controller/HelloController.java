package com.example.bcsd.Controller;

import com.example.bcsd.DTO.ArticleDTO;
import com.example.bcsd.DTO.HelloDTO;
import com.example.bcsd.Service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class HelloController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final HelloService helloService;

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping("/introduce")
    public String Introduce(@RequestParam(name = "name", required = false) String name, Model model) {
        HelloDTO request = new HelloDTO(name);
        return helloService.introduceName(request, model);
    }

    @GetMapping("/json")
    @ResponseBody
    public HelloDTO json() {
        HelloDTO intro = new HelloDTO(26, "허준기");
        return intro;
    }


    @GetMapping("/posts")
    public String posts(@RequestParam(name = "boardId") Long boardId, Model model) {
        HelloDTO boardPosts = helloService.posts(boardId);

        model.addAttribute("boardName", boardPosts.getBoardName());
        model.addAttribute("articles", boardPosts.getArticleTitles());

        return "posts.html";
    }


    @GetMapping("/articles")
    @ResponseBody
    public List<ArticleDTO> articles(@RequestParam Long boardId) {
        return helloService.getboardId(boardId);
    }


}
