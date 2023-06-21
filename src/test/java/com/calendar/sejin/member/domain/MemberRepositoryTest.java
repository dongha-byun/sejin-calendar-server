package com.calendar.sejin.member.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    @DisplayName("신규회원 등록")
    void save_test() {
        // given
        Member member = new Member(
                "test-member", "test-member-password", "테스트 멤버",
                "010-1111-2222", "test@test.com", "22년 입사"
        );

        // when
        Member savedMember = memberRepository.save(member);

        // then
        assertThat(savedMember).isEqualTo(member);
    }
}