package com.sshop.member.service;

import com.sshop.member.service.model.Member;
import com.sshop.member.MemberId;
import org.springframework.stereotype.Service;

@Service
public class MemberQueryService {
	public Member findById(MemberId memberId) {
		// todo get from dao or repository
		return new Member(memberId, "member", "something else");
	}
}
