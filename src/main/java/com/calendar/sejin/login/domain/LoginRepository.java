package com.calendar.sejin.login.domain;

import com.calendar.sejin.member.domain.Member;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByLoginId(String loginId);
}
