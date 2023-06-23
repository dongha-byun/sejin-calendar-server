package com.calendar.sejin.member.application;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@SpringBootTest
class MemberServiceTest {

    @Autowired
    MemberService memberService;

    @Test
    @DisplayName("사용자 신규 추가")
    void add_new_member() {
        // given
        MemberCreateDto memberCreateDto = new MemberCreateDto(
                "test-member", "test-member-password", "테스트 멤버", "서울시 영등포구",
                "010-1234-1234", "byunsw4@naver.com", "22년 입사"
        );

        // when
        MemberDto createdMemberDto = memberService.createMember(memberCreateDto);

        // then
        assertThat(createdMemberDto.getId()).isNotNull();
    }

    @Test
    @DisplayName("사용자 정보 조회")
    void find_test() {
        // given
        MemberCreateDto memberCreateDto = new MemberCreateDto(
                "test-member", "test-member-password", "테스트 멤버", "서울시 영등포구",
                "010-1234-1234", "byunsw4@naver.com", "22년 입사"
        );
        MemberDto createdMemberDto = memberService.createMember(memberCreateDto);

        // when
        MemberDto findMemberDto = memberService.findMember(createdMemberDto.getId());

        // then
        assertThat(findMemberDto.getId()).isEqualTo(createdMemberDto.getId());
    }

    @Test
    @DisplayName("사용자 정보 삭제")
    void delete_test() {
        // given
        MemberCreateDto memberCreateDto = new MemberCreateDto(
                "test-member", "test-member-password", "테스트 멤버", "서울시 영등포구",
                "010-1234-1234", "byunsw4@naver.com", "22년 입사"
        );
        MemberDto createdMemberDto = memberService.createMember(memberCreateDto);

        // when
        Long memberId = createdMemberDto.getId();
        memberService.deleteMember(memberId);

        // then
        assertThatIllegalArgumentException().isThrownBy(
                () -> memberService.findMember(memberId)
        );
    }
}