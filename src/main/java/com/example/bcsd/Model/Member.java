package com.example.bcsd.Model;

import com.example.bcsd.DTO.MemberDTO;
import jakarta.persistence.*;

@Entity
@Table(name = "member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
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

    public Member(){}

    public Member(Long ID, String name, String email) {
        this.ID = ID;
        this.name = name;
        this.email = email;
    }

    public Member(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public static Member from(MemberDTO dto) {
        if (dto == null) return null;

        return new Member(
                dto.id(),
                dto.name(),
                dto.email()
        );
    }
}
