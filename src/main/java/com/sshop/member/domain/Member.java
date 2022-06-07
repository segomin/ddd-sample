package com.sshop.member.domain;

import com.sshop.common.domain.AggregateRoot;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
public class Member implements AggregateRoot {
	@EmbeddedId
	private MemberId id;

	private String name;

	private String somethingElse;
}
