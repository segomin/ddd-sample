package com.sshop.application.model.member;

import com.sshop.domain.model.member.MemberId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
public class Member {
	@EmbeddedId
	private MemberId id;

	private String name;

	private String somethingElse;
}
