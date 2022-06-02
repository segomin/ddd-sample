package com.sshop.member.application.service;

import com.sshop.member.domain.Member;
import com.sshop.member.domain.MemberId;
import org.springframework.stereotype.Service;

@Service
public class MemberQueryService {
	public Member findById(MemberId memberId) {
		// todo get from dao or repository
		return new Member(memberId, "member", "something else");
	}
}
