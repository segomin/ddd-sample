package com.sshop.application.service;

import com.sshop.application.model.member.Member;
import com.sshop.domain.model.member.MemberId;
import org.springframework.stereotype.Service;

@Service
public class MemberQueryService {
	public Member findById(MemberId memberId) {
		// todo get from dao or repository
		return new Member(memberId, "member", "something else");
	}
}
