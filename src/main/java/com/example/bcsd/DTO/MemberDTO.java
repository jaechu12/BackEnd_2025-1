package com.example.bcsd.DTO;


public class MemberDTO {
    private Long ID;
    private String name;
    private String email;
    private String password;


    public void setID(Long ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public Long getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public MemberDTO() {
        this.name = name;
        this.email = email;
        this.password = password;
    }


}
