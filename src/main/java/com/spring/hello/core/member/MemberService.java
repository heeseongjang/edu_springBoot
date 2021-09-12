package com.spring.hello.core.member;

public interface MemberService {
    void join(Member member);

    Member findMember(Long memberID);
}
