package com.calendar.sejin.member.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    @DisplayName("신규 사용자 등록")
    void save_test() {
        // given
        Member member = new Member(
                "test-member", "test-member-password", "테스트 멤버", "서울시 영등포구",
                "010-1111-2222", "test@test.com", "22년 입사"
        );

        // when
        Member savedMember = memberRepository.save(member);

        // then
        assertThat(savedMember).isEqualTo(member);
    }

    @Test
    @DisplayName("사용자 정보 조회")
    void find_test() {
        // given
        Member member = new Member(
                "test-member", "test-member-password", "테스트 멤버", "서울시 영등포구",
                "010-1111-2222", "test@test.com", "22년 입사"
        );
        Member savedMember = memberRepository.save(member);

        // when
        Member findMember = memberRepository.findById(savedMember.getId()).orElseThrow();

        // then
        assertThat(savedMember).isEqualTo(member);
        assertThat(savedMember).isEqualTo(findMember);
    }


    @Test
    @DisplayName("사용자 정보 삭제")
    void delete_test() {
        // given
        Member member = new Member(
                "test-member", "test-member-password", "테스트 멤버", "서울시 영등포구",
                "010-1111-2222", "test@test.com", "22년 입사"
        );
        Member savedMember = memberRepository.save(member);

        // when
        memberRepository.delete(savedMember);

        // then
        Optional<Member> optionalMember = memberRepository.findById(savedMember.getId());
        assertThat(optionalMember.isPresent()).isFalse();
    }
}