package com.sshop.member.service.model;

import com.sshop.member.MemberId;
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
