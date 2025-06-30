package com.example.bcsd.Repository;

import com.example.bcsd.Model.Article;
import com.example.bcsd.Model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    Member findByEmail(String email);

    Member save(Member member);
}
