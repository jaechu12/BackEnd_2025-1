package com.example.bcsd.DTO;

import com.example.bcsd.Model.Member;

import java.util.Objects;

public record MemberDTO(
            Long id,
            String name,
            String email,
            String password
    ) {
    public MemberDTO {
            Objects.requireNonNull(id);
            Objects.requireNonNull(name);
            Objects.requireNonNull(email);
            Objects.requireNonNull(password);
        }



    public static MemberDTO from(Member member) {
        if (member == null) return null;

        return new MemberDTO(
                member.getID(),
                member.getName(),
                member.getEmail(),
                member.getPassword()
        );
    }

}
