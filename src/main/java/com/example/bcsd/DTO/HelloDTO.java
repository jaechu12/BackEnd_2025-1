package com.example.bcsd.DTO;

import java.util.List;

public class HelloDTO {
    private int age;
    private String name;
    private String boardName;
    private Long boardId;
    private List<String> articleTitles;


    public HelloDTO(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public HelloDTO(String name) {
        this.name = name;
    }

    public HelloDTO(String boardName, List<String> articleTitles) {
        this.boardName = boardName;
        this.articleTitles = articleTitles;
    }


    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getBoardName() {
        return boardName;
    }

    public List<String> getArticleTitles() {
        return articleTitles;
    }


}
